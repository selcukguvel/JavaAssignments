/**
 *The Book class has features which
 *every book has.
 * @author Muhammet Selcuk Guvel
 */
public class Book extends OfficeSupplies {
private String publisherName;
private String author;
private int pageNumber; 
static int bookStock;
private String type="Book";
/**
 * Book class default constructor.
 */
Book(){
	
}
/**
 *Book class constructor which initializes the properties of book object.
 *Increments the book stock when the book object is created.
 * @param cost the book's cost
 * @param releaseDate the book's release date
 * @param coverTitle the book's cover title
 * @param publisherName the book's publisher name
 * @param author the book's author name
 * @param pageNumber the book's page number
 */
Book(double cost,String releaseDate,String coverTitle,String publisherName,String author,int pageNumber){
	super(cost,releaseDate,coverTitle);
	this.publisherName=publisherName;
	this.author=author;
	this.pageNumber=pageNumber;
	bookStock++;
	itemcontainer.add(this);
}
/**
 * @return the book's information
 */
@Override
public String toString() {
	return  "-----------------------" +
			"\nType: "+getName() + super.toString() +
			"\nPublisher: " + publisherName +
			"\nAuthor: " + (author).replace(",",", ") +
			" \nPage: " + pageNumber +" pages";
		}
/**
 * @return the number of remaining books in the stock
 */
@Override
public int getstockNumber() {
	return bookStock;
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
		bookStock--;
	}
}

