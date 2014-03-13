package jdawkins.tabletop-tracker.items;

import java.util.ArrayList;
import jdawkins.tabletop-tracker.*;

public class Wealth{
	private int base;
	private ArrayList<WealthUnitConfig> units;
	private WealthUnitConfigComparator comp;
	
	public Wealth(){ this(0); }
	public Wealth(int baseVal){
		BaseValue(baseVal);
		this.units = new ArrayList<WealthUnitConfig>();
		this.comp = new WealthUnitConfigComparator();
	}
	
	public int BaseValue(){ return this.base; }
	public void BaseValue(int val){
		if (val < 0)
			throw new InvalidIntegerValueException("Wealth base value cannot be less than 0.", 0);
		this.base = val;
	}
	public WealthUnitConfig[] Units(){ return units.toArray(); }
	
	public void AddUnit(WealthUnitConfig unit){
		for (WealthUnitConfig c : this.units){
			if (unit.Name() == c.Name())
				throw new RuntimeException("A unit with the given name already exists on this wealth object.");
			if (unit.Abbr() == c.Abbr())
				throw new RuntimeException("A unit with the given abbreviation already exists on this wealth object.");
			if (unit.BaseValuePerUnit() == c.BaseValuePerUnit())
				throw new RuntimeException("A unit with the given base value per unit already exists on this wealth object.");
		}
		
		this.units.add(unit);
		Collections.sort(this.units, this.comp);
	}
	public int AddToBaseValue(int val){
		if (val + BaseValue() < 0 || Integer.MAX_VALUE - val < BaseValue())
			throw new InvalidIntegerValueException("Cannot add a value to a wealth object's base value which would cause it to be less than 0 or more than Integer.MAX_VALUE.", -1 * BaseValue(), Integer.MAX_VALUE - BaseValue());
		BaseValue(BaseValue() + val);
		return BaseValue();
	}
	public void AddValue(Wealth val){ AddToBaseValue(val.BaseValue()); }
	public void AddValue(WealthUnit val){ AddToBaseValue(val.BaseValue()); }
	public WealthUnit[] ToUnits(){
		int val = BaseValue();
		ArrayList<WealthUnit> results = new ArrayList<WealthUnitConfig>();
		
		Collections.sort(this.units, Collections.reverseOrder(this.comp));
		for(WealthUnitConfig unit : this.units){
			if (val < unit.BaseValuePerUnit())
				continue;
			results.add(new WealthUnit(unit, val/unit.BaseValuePerUnit()));
			val -= val/unit.BaseValuePerUnit();
		}
		Collections.sort(this.units, this.comp);
		
		return results.toArray();
	}
}