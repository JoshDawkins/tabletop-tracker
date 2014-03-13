package jdawkins.tabletop-tracker.items;

import jdawkins.tabletop-tracker.*;

public class InventoryItem{
	private Item item;
	private int quantity;
	
	public InventoryItem(){}
	public InventoryItem(Item item, int qty = 1){
		if (item == null)
			throw new NullPointerException("Item of an inventory item cannot be null.");
		this.item = item;
		Quantity(qty);
	}
	
	public Item InvItem(){ return this.item; }
	public int Quantity(){ return this.quantity; }
	public void Quantity(int qty){
		if (qty < 0)
			throw new InvalidIntegerValueException("Quantity of an inventory item cannot be less than 0.", 0);
		this.quantity = qty;
	}
}