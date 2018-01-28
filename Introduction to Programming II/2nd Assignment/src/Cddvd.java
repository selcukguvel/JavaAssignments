/**
 *The Cddvd class has features which
 *every cd and dvd have.
 * @author Muhammet Selcuk Guvel
 */
public class Cddvd extends OfficeSupplies {
String composerName;
String songs;
static int cddvdStock;
private String type="CDDVD";
/**
 * Cddvd class default constructor.
 */
Cddvd(){	
}
/**
 * Cddvd class constructor which initializes the properties of cddvd object.
 * Increments the cddvd stock when the cddvd object is created.
 * @param cost the cost of cddvd
 * @param releaseDate the release date of cddvd
 * @param coverTitle the cover title of cddvd
 * @param composerName the composer name of cddvd
 * @param songs the song names of cddvd
 */
Cddvd(double cost,String releaseDate,String coverTitle,String composerName,String songs){
	super(cost,releaseDate,coverTitle);
	this.composerName=composerName;
	this.songs=songs;
	cddvdStock++;
	itemcontainer.add(this);
}
/**
 * @return the cddvd's information
 */
@Override
public String toString() {
	return  "-----------------------" +
			"\nType: "+getName() + super.toString() +
			"\nSongs: " + (songs).replace(",",", ") +
			" \nComposer: " + composerName;
		}
/**
 * @return the number of remaining cddvd in the stock
 */
@Override
public int getstockNumber() {
	return cddvdStock;
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
 * the remaining books.This method
 * is called if an item is sold.
 */
@Override
public void setstockNumber() {
	cddvdStock--;
}
}
