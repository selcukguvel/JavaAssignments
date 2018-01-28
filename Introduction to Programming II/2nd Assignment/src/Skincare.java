/**
 *The Skincare class has features which
 *every skincare has.
 * @author Muhammet Selcuk Guvel
 */
public class Skincare extends Cosmetic {
int babySensitive;
static int skincareStock;
private String type="SkinCare";
/**
 * Skincare class default constructor.
 */
Skincare(){
}
/**
 * Skincare class constructor which initializes the properties of skincare object.
 * Increments the skincare stock when the skincare object is created.
 * @param cost the skincare's cost
 * @param manufacturer the skincare's manufacturer
 * @param brand the skincare's brand
 * @param isOrganic represents whether the skincare is organic
 * @param expirationYear the skincare's expiration year
 * @param weight the skincare's weight
 * @param babySensitive represents whether the skincare is baby sensitive
 */
Skincare(double cost,String manufacturer,String brand,int isOrganic,int expirationYear,int weight,int babySensitive){
	super(cost,manufacturer,brand,isOrganic,expirationYear,weight);
	this.babySensitive=babySensitive;
	skincareStock++;
	itemcontainer.add(this);
}
/**
 * @return the skincare's information
 */
@Override
public String toString() {
	return  "-----------------------" +
			"\nType: "+ getName() + super.toString() +
			"\nBaby Sensitive: " + yesorno(babySensitive);
		}
/**
 * @return the number of remaining skincares in the stock
 */
@Override
public int getstockNumber() {
	return skincareStock;
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
 * the remaining skincares.This method
 * is called if an item is sold.
 */
@Override
public void setstockNumber() {
	skincareStock--;
}
}
