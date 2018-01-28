/**
 *The Perufme class has features which
 *every perfume has.
 * @author Muhammet Selcuk Guvel
 */
public class Perfume extends Cosmetic {
int lastingDuration;
static int perfumeStock;
private String type="Perfume";
/**
 * Perfume class default constructor.
 */
Perfume(){
}
/**
 * Perfume class constructor which initializes the properties of perfume object.
 * Increments the perfume stock when the perfume object is created.
 * @param cost the perfume's cost
 * @param manufacturer the perfume's manufacturer
 * @param brand the perfume's brand
 * @param isOrganic represents whether the perfume is organic
 * @param expirationYear the perfume's expiration year
 * @param weight the parfume's weight
 * @param lastingDuration the perfume's lasting duration
 */
Perfume(double cost,String manufacturer,String brand,int isOrganic,int expirationYear,int weight,int lastingDuration){
	super(cost,manufacturer,brand,isOrganic,expirationYear,weight);
	this.lastingDuration=lastingDuration;
	itemcontainer.add(this);
	perfumeStock++;
}
/**
 * @return the perfume's information
 */
@Override
public String toString() {
	return  "-----------------------" +
			"\nType: "+ getName() + super.toString() +
			"\nLasting Duration: " + lastingDuration + " min.";
		}
/**
 * @return the number of remaining perfumes in the stock
 */
@Override
public int getstockNumber() {
	return perfumeStock;
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
 * the remaining perfumes.This method
 * is called if an item is sold.
 */
@Override
public void setstockNumber() {
	perfumeStock--;
}
}
