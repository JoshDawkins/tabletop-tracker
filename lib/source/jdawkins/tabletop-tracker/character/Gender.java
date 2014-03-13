package jdawkins.tabletop-tracker.character;

public enum Gender{
	UNKNOWN("U"),
	MALE("M"),
	FEMALE("F");
	
	private final String abbr;
	public String Abbr(){ return abbr; }
	
	public Gender(String abbr){
		this.abbr = abbr;
	}
}