/**
 *The Cosmetic abstract class has features which
 *every cosmetic product has.This abstract class has abstract methods
 *which are no need to be implemented in this class. 
 * @author Muhammet Selcuk Guvel
 */
public abstract class Cosmetic extends Items {
int expirationYear;
int weight;
int isOrganic;
String manufacturer;
String brand;
/**
 * Cosmetic class default constructor.
 */
Cosmetic(){
	
}
/**
 * @param cost the cosmetic product's cost
 * @param manufacturer the cosmetic product's manufacturer
 * @param brand the cosmetic product's brand
 * @param isOrganic represents whether the cosmetic product is organic
 * @param expirationYear the cosmetic product's expiration year
 * @param weight the cosmetic product's weight
 */
Cosmetic(double cost,String manufacturer,String brand,int isOrganic,int expirationYear,int weight){
	super(cost);
	this.expirationYear=expirationYear;
	this.weight=weight;
	this.isOrganic=isOrganic;
	this.manufacturer=manufacturer;
	this.brand=brand;
	
}
/**
 * 
 * @param medicorganicbabysens represents the cosmetic product is organic or medicated or baby sensitive
 * @return <code>true</code> if the cosmetic product is organic or medicated
 */
public String yesorno(int medicorganicbabysens){
	if(medicorganicbabysens==0)
		return "No";
	else
		return "Yes";
}
/**
 * @return the information which is the common for all cosmetic product types
 */
@Override
public String toString() {
	return super.toString() +
			"\nManufacturer: " + manufacturer + 
			"\nBrand: " + brand +
			"\nOrganic: " + yesorno(isOrganic) + 
			"\nExpiration Date: " + expirationYear + 
			"\nWeight: " + weight + " g.";
}
}
