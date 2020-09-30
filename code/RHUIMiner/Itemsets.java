import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Itemsets {

/** We store the itemsets in a list named "levels".
	 Position i in "levels" contains the list of itemsets of size i */
	private final List<List<Itemset>> levels = new ArrayList<List<Itemset>>(); 
	/** the total number of itemsets **/
	private int itemsetsCount = 0;
	/** a name that we give to these itemsets (e.g. "frequent itemsets") */
	private String name;

	/**
	 * Constructor
	 * @param name the name of these itemsets
	 */
	public Itemsets(String name) {
		this.name = name;
		levels.add(new ArrayList<Itemset>()); // We create an empty level 0 by
												// default.
	}

	
	public void printItemsets() {
		System.out.println(" ------- " + name + " -------");
		int patternCount = 0;
		int levelCount = 0;
		// for each level (a level is a set of itemsets having the same number of items)
		for (List<Itemset> level : levels) {
			// print how many items are contained in this level
			System.out.println("  L" + levelCount + " ");
			// for each itemset0S
			for (Itemset itemset : level) {
				Arrays.sort(itemset.getItems());
				// print the itemset
				System.out.print("  pattern " + patternCount + ":  " +itemset.toString());
//				itemset.print();
				// print the support of this itemset
				System.out.print("Utility :  "
						+ itemset.getUtility());
				patternCount++;
				System.out.println(" ");
			}
			levelCount++;
		}
		System.out.println(" --------------------------------");
	}


	public void addItemset(Itemset itemset, int k) {
		while (levels.size() <= k) {
			levels.add(new ArrayList<Itemset>());
		}
		levels.get(k).add(itemset);
		itemsetsCount++;
	}

	
	public List<List<Itemset>> getLevels() {
		return levels;
	}

	public int getItemsetsCount() {
		return itemsetsCount;
	}

	
	public void setName(String newName) {
		name = newName;
	}
	
	
	public void decreaseItemsetCount() {
		itemsetsCount--;
	}    
}
