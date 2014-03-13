package jdawkins.tabletop-tracker.character;

import java.text.FormatException;
import java.util.ArrayList;
import jdawkins.tabletop-tracker.*;
import jdawkins.tabletop-tracker.game.*;
import jdawkins.tabletop-tracker.items.*;

public class Character{
	/*** Properties ***/
	private GameConfig game;
	
	//General
	private String name;
	private String playerName;
	private int exp;
	private int age;
	private Gender gender;
	private int height;
	private int weight;
	
	//Items and wealth
	private Wealth wealth;
	private ArrayList<InventoryItem> inventory;
	
	//Features
	private ArrayList<Feature> features;
	
	/*** Constructors ***/
	public Character(){
		Gender(Gender.UNKNOWN);
	}
	public Character(String name){
		this(name, null);
	}
	public Character(String name, String player){
		Name(name);
		PlayerName(player);
		Gender(Gender.UNKNOWN);
	}
	
	/*** Getters and Setters ***/
	
	
	//General
	public String Name(){ return this.name; }
	public void Name(String name){
		if (name == null || name.trim().isEmpty())
			throw new StringLengthException("Character name cannot be null or empty or consist of only whitespace.");
		this.name = name.trim();
	}
	public String PlayerName(){ return this.playerName; }
	public void PlayerName(String playerName){ this.playerName = playerName; }
	public int Exp(){ return this.exp; }
	public void Exp(int exp){
		if (exp < 0)
			throw new InvalidIntegerValueException("Character experience cannot be less than 0", 0);
		this.exp = exp;
	}
	public int Age(){ return this.age; }
	public void Age(int age){
		if (age < 0)
			throw new InvalidIntegerValueException("Character age cannot be less than 0.", 0);
		this.age = age;
	}
	public Gender Gender(){ return this.gender; }
	public void Gender(Gender gender){ this.gender = gender; }
	public String GenderAbbr(){ return this.gender.Abbr(); }
	public int Height(){ return this.height; }
	public void Height(int height){
		if (height < 1)
			throw new InvalidIntegerValueException("Character height cannot be less than 1 inch.", 1);
		this.height = height;
	}
	public String HeightText(){ return Math.floor(this.height / 12) + "\"" + (this.height % 12) + "'"; }
	public void HeightText(int feet, int inches = 0){
		if (feet < 0 || inches < 0)
			throw new InvalidIntegerValueException("Neither feet nor inches in character height can be negative", 0);
		if (feet == 0 && inches == 0)
			throw new InvalidIntegerValueException("Character height cannot be less than 1 inch.", 1);
		this.height = (feet * 12) + inches;
	}
	public int Weight(){ return this.weight; }
	public void Weight(int weight){
		if (weight < 1)
			throw new InvalidIntegerValueException("Character weight cannot be less than 1 pound.", 1);
		this.weight = weight;
	}
	
	//Items and Wealth
	
	
	//Features
	
	
	/*** Methods ***/
	
}






















