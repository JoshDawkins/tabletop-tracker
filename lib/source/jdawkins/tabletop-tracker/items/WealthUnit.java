package jdawkins.tabletop-tracker.items;

import jdawkins.tabletop-tracker.*;

public class WealthUnit{
	private WealthUnitConfig config;
	private int value;
	
	public WealthUnit(WealthUnitConfig config, int value){
		if (config == null)
			throw new NullPointerException("Config passed to wealth unit constructor cannot be null.");
		if (value < 0)
			throw new InvalidIntegerValueException("Value of a wealth unit cannot be less than 0.", 0);
		this.config = config;
		this.value = value;
	}
	
	public WealthUnitConfig Config(){ return this.config; }
	public int Value(){ return this.value; }
	
	public int BaseValue(){ return Value() * Config().BaseValuePerUnit(); }
}