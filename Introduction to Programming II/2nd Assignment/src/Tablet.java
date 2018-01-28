/**
 *The Tablet class has features which
 *every tablet has.
 * @author Muhammet Selcuk Guvel
 */
public class Tablet extends Computer {
int dimensions;
static int tabletStock;
private String type="Tablet";
/**
 * Tablet class default constructor.
 */
public Tablet() {
	
}
/**
 * Tablet class constructor which initializes the properties of tablet object.
 * Increments the tablet stock when the tablet object is created.
 * @param cost the tablet's cost
 * @param manufacturer the tablet's manufacturer
 * @param brand the tablet's brand
 * @param maxVolt the tablet's maximum allowed input voltage
 * @param maxWatt the tablet's maximum power consumption
 * @param operatingSystem the tablet's operating system
 * @param cpuType the tablet's cpu type
 * @param ramCapacity the tablet's ram capacity 
 * @param HDDCapacity the tablet's hdd capacity
 * @param dimensions the tablet's dimensions
 */
public Tablet(double cost,String manufacturer,String brand,int maxVolt,int maxWatt,
		   	  String operatingSystem,String cpuType,int ramCapacity,int HDDCapacity,int dimensions){
		super(cost,manufacturer,brand,maxVolt,maxWatt,operatingSystem,cpuType,ramCapacity,HDDCapacity);
		this.dimensions=dimensions;
		tabletStock++;
		itemcontainer.add(this);
}
/**
 * @return the tablet's information
 */
@Override
public String toString() {
	return  "-----------------------" +
			"\nType: "+ getName() + super.toString() +
			"\nDimension: " + dimensions + " in.";
}
/**
 * @return the number of remaining tablets in the stock
 */
@Override
public int getstockNumber() {
	return tabletStock;
}
/**
 * @return the type of the Class
 */
@Override
public String getName() {
	return type;
}
/**
 * Decreases the number of 
 * the remaining tablets.This method
 * is called if an item is sold.
 */
@Override
public void setstockNumber() {
	tabletStock--;
}
}
