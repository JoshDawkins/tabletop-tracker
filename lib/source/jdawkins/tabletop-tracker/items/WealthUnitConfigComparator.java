package jdawkins.tabletop-tracker.items;

import java.util.Comparator;

public class WealthUnitConfigComparator implements Comparator<WealthUnitConfig>{
	public int compare(WealthUnitConfig o1, WealthUnitConfig o2){
		if (o1.BaseValuePerUnit() < o2.BaseValuePerUnit())
			return -1;
		else if (o1.BaseValuePerUnit() == o2.BaseValuePerUnit())
			return 0;
		else
			return 1;
	}
}