/**
 *The Electronic abstract class has features which
 *every electronic product has.This abstract class has abstract methods
 *which are no need to be implemented in this class. 
 * @author Muhammet Selcuk Guvel
 */
public abstract class Electronic extends Items {
private int maxVolt; 
private int maxWatt; 
private String manufacturer;
private String brand;
/**
 * Electronic class default constructor.
 */
Electronic(){
	
}
/**
 * Electronic class constructor which initializes the properties of electronic product object.
 * @param cost the electronic product's cost
 * @param maxVolt the electronic product's maximum allowed input voltage
 * @param maxWatt the electronic product's maximum power consumption
 * @param manufacturer the electronic product's manufacturer
 * @param brand the electronic product's brand
 */
Electronic(double cost,int maxVolt,int maxWatt,String manufacturer,String brand){
	super(cost);
	this.maxVolt=maxVolt;
	this.maxWatt=maxWatt;
	this.manufacturer=manufacturer;
	this.brand=brand;
}
/**
 * @return the electronic product's manufacturer
 */
public String getManufacturer() {
	return manufacturer;
}
/**
 * @return the electronic product's maximum allowed input voltage
 */
public int getMaxVolt() {
	return maxVolt;
}
/**
 * @return the electronic product's maximum power consumption
 */
public int getMaxWatt() {
	return maxWatt;
}
/**
 * @return the electronic product's brand
 */
public String getBrand() {
	return brand;
}
/**
 * @return the information which is the common for all electronic product types
 */
@Override
public String toString() {
	return super.toString() +
			"\nManufacturer: " + getManufacturer() + 
			"\nBrand: " + getBrand() + 
			"\nMax Volt: " + getMaxVolt() + " V." +
			"\nMax Watt: " + getMaxWatt() + " W." ;
}
}
