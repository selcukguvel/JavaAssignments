/**
 *The SmartPhone class has features which
 *every smartphone has.
 * @author Muhammet Selcuk Guvel
 */
public class SmartPhone extends Electronic {
String screentype;
static int smartphoneStock;
private String type="SmartPhone";
/**
 * SmartPhone class default constructor.
 */
public SmartPhone() {
}
/**
 *SmartPhone class constructor which initializes the properties of smartphone object.
 *Increments the smartphone stock when the smartphone object is created.
 * @param cost the smartphone's cost
 * @param manufacturer the smartphone's manufacturer
 * @param brand the smartphone's brand
 * @param maxVolt the smartphone's maximum allowed input voltage
 * @param maxWatt the smartphone's maximum power consumption
 * @param screentype the smartphone's screen type
 */
public SmartPhone(double cost,String manufacturer,String brand,int maxVolt,int maxWatt,String screentype){
	super(cost,maxVolt,maxWatt,manufacturer,brand);
	this.screentype=screentype;
	itemcontainer.add(this);
	smartphoneStock++;
}
/**
 * @return the smartphone's information
 */
@Override
public String toString() {
	return  "-----------------------" +
			"\nType: "+ getName() + super.toString() +
			"\nScreen Type: " + screentype;
}
/**
 * @return the number of remaining smartphones in the stock
 */
@Override
public int getstockNumber() {
	return smartphoneStock;
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
 * the remaining smartphones.This method
 * is called if an item is sold.
 */
@Override
public void setstockNumber() {
	smartphoneStock--;
}
}
