/**
 *The OfficeSupplies abstract class has features which
 *every office supplies product has.This abstract class has abstract methods
 *which are no need to be implemented in this class. 
 * @author Muhammet Selcuk Guvel
 */
public abstract class OfficeSupplies extends Items {
private String releaseDate;
private String coverTitle;
/**
 * OfficeSupplies class default constructor.
 */
public OfficeSupplies() {
	
}
/**
 * OfficeSupplies class constructor which initializes the properties of office supplies product object.
 * @param cost the office supplies product's cost
 * @param releaseDate the office supplies product's release date
 * @param coverTitle the office supplies product's cover title
 */
OfficeSupplies(double cost,String releaseDate,String coverTitle){
	super(cost);
	this.releaseDate=releaseDate;
	this.coverTitle=coverTitle;
}
/**
 * @return the information which is the common for all office supplies product types
 */
@Override
public String toString() {
	return super.toString() +
			"\nRelease Date: " + releaseDate + 
			"\nTitle: " + coverTitle;
}
}
