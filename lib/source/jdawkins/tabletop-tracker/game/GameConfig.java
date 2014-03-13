package jdawkins.tabletop-tracker.game;

import java.util.ArrayList;
import jdawkins.tabletop-tracker.*;
import jdawkins.tabletop-tracker.character.*;
import jdawkins.tabletop-tracker.items.*;

public class GameConfig{
	private String name;
	private String abbr;
	private ArrayList<FeatureConfig> characterFeatures;
	private ArrayList<WealthUnitConfig> wealthUnits;
	private ArrayList<FeatureConfig> itemFeatures;
	
	public GameConfig(){
		this.characterFeatures = new ArrayList<FeatureConfig>();
		this.wealthUnits = new ArrayList<WealthUnitConfig>();
		this.itemFeatures = new ArrayList<FeatureConfig>();
	}
	public GameConfig(String name, String abbr){
		this();
		Name(name);
		Abbr(abbr);
	}
	
	public String Name(){ return this.name; }
	public void Name(String name){
		if (name == null || name.trim().isEmpty())
			throw new StringLengthException("The name of a game configuration cannot be null or empty or consist of only whitespace.", 1);
		this.name = name;
	}
	public String Abbr(){ return this.abbr; }
	public void Abbr(String abbr){ this.abbr = abbr; }
	public FeatureConfig[] CharacterFeatures(){ return this.characterFeatures.toArray(); }
	public WealthUnitConfig[] WealthUnits(){ return this.wealthUnits.toArray(); }
	public FeatureConfig[] ItemFeatures(){ return this.itemFeatures.toArray(); }
	
	public void AddCharacterFeature(FeatureConfig feature){
		if (feature != null)
			this.characterFeatures.add(feature);
	}
	public void AddWealthUnit(WealthUnitConfig unit){
		if (unit != null)
			this.wealthUnits.add(unit);
	}
	public void AddItemFeature(FeatureConfig feature){
		if (feature != null)
			this.itemFeatures.add(feature);
	}
}