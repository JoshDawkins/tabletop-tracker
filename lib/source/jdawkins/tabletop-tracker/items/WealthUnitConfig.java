package jdawkins.tabletop-tracker.items;

public class WealthUnitConfig{
	private String name;
	private String abbr;
	private int baseValuePerUnit;
	
	public WealthUnitConfig(){}
	public WealthUnitConfig(String name, String abbr, int baseValuePerUnit){
		if (name == null || name.trim().isEmpty())
			throw new StringLengthException("Name of a wealth unit config cannot be null or empty or consist of only whitespace.");
		if (abbr == null || abbr.trim().isEmpty())
			throw new StringLengthException("Abbreviation of a wealth unit config cannot be null or empty or consist of only whitespace.");
		if (baseValuePerUnit < 1)
			throw new InvalidIntegerValueException("Base value per unit of a wealth unit config cannot be less than 1.", 1);
		
		this.name = name.trim();
		this.abbr = abbr.trim();
		this.baseValuePerUnit = baseValuePerUnit;
	}
	
	public String Name(){ return this.name; }
	public String Abbr(){ return this.abbr; }
	public int BaseValuePerUnit(){ return this.baseValuePerUnit; }
}