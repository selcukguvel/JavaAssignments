import java.util.ArrayList;
/**
 *The Items class has features which
 *every item has.
 * @author Muhammet Selcuk Guvel
 */
public abstract class Items {
static int itemId=0;
static ArrayList<Items> itemcontainer = new ArrayList<Items>();
private double cost;
protected int currentID;
/**
 * Items class default constructor.
 */
Items(){
}
/**
 * Items class constructor which initializes the properties of item object.
 * Increments the itemId when the item object is created.
 * @param cost the item's cost
 */
Items(double cost){
	this.cost=cost;
	itemId++;
	currentID=itemId;
}
/** 
 * @return the item's cost
 */
public double getCost() {
	return cost;
}
/**
 * @return the information which is the common for all item types
 */
@Override
	public String toString() {
		return "\nItem ID: " + currentID +
			   "\nPrice: " + getCost() + " $";
	}
/**
 * @return the number of items in the stock
 */
public abstract int getstockNumber();
/**
 * @return the item's type
 */
public abstract String getName();
/**
 * Sets the number of items in the stock
 */
public abstract void setstockNumber();

}


