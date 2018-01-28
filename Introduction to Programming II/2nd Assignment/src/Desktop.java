/**
 *The Desktop class has features which
 *every desktop has.
 * @author Muhammet Selcuk Guvel
 */
public class Desktop extends Computer {
private String boxColor;
static int desktopStock;
private String type="Desktop";
/**
 * Desktop class default constructor.
 */
Desktop(){
	
}
/**
 * Desktop class constructor which initializes the properties of desktop object.
 * Increments the desktop stock when the desktop object is created.
 * @param cost the desktop's cost
 * @param manufacturer the desktop's manufacturer
 * @param brand the desktop's brand
 * @param maxVolt the desktop's maximum allowed input voltage
 * @param maxWatt the desktop's maximum power consumption
 * @param operatingSystem the desktop's operating system
 * @param cpuType the desktop's cpu type
 * @param ramCapacity the desktop's ram capacity
 * @param HDDCapacity the desktop's hdd capacity
 * @param boxColor the desktop's box color
 */
public Desktop(double cost,String manufacturer,String brand,int maxVolt,int maxWatt,
			   String operatingSystem,String cpuType,int ramCapacity,int HDDCapacity,String boxColor){
	   super(cost,manufacturer,brand,maxVolt,maxWatt,operatingSystem,cpuType,ramCapacity,HDDCapacity);
	   this.boxColor=boxColor;
	   desktopStock++;
	   itemcontainer.add(this);
	}
/**
 * @return the desktop's information
 */
@Override
	public String toString() {
		return  "-----------------------" +
				"\nType: "+ getName() + super.toString() +
				"\nBox Color: " + boxColor;
	}
/**
 * @return the number of remaining desktop in the stock
 */
@Override
	public int getstockNumber() {
		return desktopStock;
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
 * the remaining desktops.This method
 * is called if an item is sold.
 */
@Override
public void setstockNumber() {
	desktopStock--;
}
}
