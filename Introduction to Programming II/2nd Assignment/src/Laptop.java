/**
 *The Laptop class has features which
 *every laptop has.
 * @author Muhammet Selcuk Guvel
 */
public class Laptop extends Computer {
int hdmisupport;
boolean hdmiyesorno;
static int laptopStock;
private String type="Laptop";
/**
 * Laptop class default constructor.
 */
Laptop(){
	
}
/**
 *Laptop class constructor which initializes the properties of laptop object.
 *Increments the laptop stock when the laptop object is created.
 * @param cost the laptop's cost
 * @param manufacturer the laptop's manufacturer
 * @param brand the laptop's brand
 * @param maxVolt the laptop's maximum allowed input voltage
 * @param maxWatt the laptop's maximum power consumption
 * @param operatingSystem the laptop's operating system
 * @param cpuType the laptop's cpu type
 * @param ramCapacity the laptop's ram capacity
 * @param HDDCapacity the laptop's hdd capacity
 * @param hdmisupport represents that the laptop has hdmi support or not
 */
public Laptop(double cost,String manufacturer,String brand,int maxVolt,int maxWatt,
		   String operatingSystem,String cpuType,int ramCapacity,int HDDCapacity,int hdmisupport){
		super(cost,manufacturer,brand,maxVolt,maxWatt,operatingSystem,cpuType,ramCapacity,HDDCapacity);
		this.hdmisupport=hdmisupport;
		laptopStock++;
		itemcontainer.add(this);
		
}
/**
 * Checks whether the laptop has hdmi support
 * @return <code>Yes</code> If the laptop has hdmi support
 */
public String yesorno(){
	if (hdmisupport==0)
		return "No";
	else
		return "Yes";
}
/**
 * @return the laptop's information
 */
@Override
public String toString() {
	return  "-----------------------" +
			"\nType: "+ getName() + super.toString() +
			"\nHDMI support: " + yesorno();
}
/**
 * @return the number of remaining laptops in the stock
 */
@Override
public int getstockNumber() {
	return laptopStock;
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
 * the remaining laptops.This method
 * is called if an item is sold.
 */
@Override
public void setstockNumber() {
	laptopStock--;
}
}
