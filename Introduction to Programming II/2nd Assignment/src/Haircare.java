/**
 *The Haircare class has features which
 *every haircare has.
 * @author Muhammet Selcuk Guvel
 */
public class Haircare extends Cosmetic {
int isMedicated;
static int haircareStock;
private String type="HairCare";
/**
 * Haircare class default constructor.
 */
Haircare(){
	
}
/**
 * Haircare class constructor which initializes the properties of haircare object.
 * Increments the haircare stock when the haircare object is created.
 * @param cost the haircare's cost
 * @param manufacturer the haircare's manufacturer
 * @param brand the haircare's brand
 * @param isOrganic represents whether the haircare is organic
 * @param expirationYear the haircare's expiration year
 * @param weight the haircare's weight
 * @param isMedicated represents whether the haircare is medicated
 */
Haircare(double cost,String manufacturer,String brand,int isOrganic,int expirationYear,int weight,int isMedicated){
	super(cost,manufacturer,brand,isOrganic,expirationYear,weight);
	this.isMedicated=isMedicated;
	itemcontainer.add(this);
	haircareStock++;
}
/**
 * @return the haircare's information
 */
@Override
public String toString() {
	return  "-----------------------" +
			"\nType: "+ getName() + super.toString() +
			"\nMedicated: " + yesorno(isMedicated);
		}
/**
 * @return the number of remaining haircares in the stock
 */
@Override
public int getstockNumber() {
	return haircareStock;
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
 * the remaining haircares.This method
 * is called if an item is sold.
 */
@Override
public void setstockNumber() {
	haircareStock--;
}
}

