/**
 *The Tv class has features which
 *every tv has.
 * @author Muhammet Selcuk Guvel
 */
public class Tv extends Electronic {
int screensize;
static int tvStock;
private String type="TV";
/**
 * Tv class default constructor.
 */
public Tv() {
	
}
/**
 * Tv class constructor which initializes the properties of tv object.
 * Increments the tv stock when the tv object is created.
 * @param cost the tv's cost
 * @param manufacturer the tv's manufacturer
 * @param brand the tv's brand
 * @param maxVolt the tv's maximum allowed input voltage
 * @param maxWatt the tv's maximum power consumption
 * @param screensize the tv's screensize
 */
public Tv(double cost,String manufacturer,String brand,int maxVolt,int maxWatt,int screensize){
	super(cost,maxVolt,maxWatt,manufacturer,brand);
	this.screensize=screensize;
	tvStock++;
	itemcontainer.add(this);
}
/**
 * @return the tv's information
 */
@Override
public String toString() {
	return  "-----------------------" +
			"\nType: "+ getName() + super.toString() +
			"\nScreen size: " + screensize +"\"";
}
/**
 * @return the number of remaining tvs in the stock
 */
@Override
public int getstockNumber() {
	return tvStock;
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
 * the remaining tvs.This method
 * is called if an item is sold.
 */
@Override
public void setstockNumber() {
	tvStock--;
}
}
