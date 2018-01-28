import java.util.Date;
import java.util.Iterator;
import java.util.UUID;
/**
 *The TextPost class has features which
 *every text post has.
 * @author Muhammet Selcuk Guvel
 */
public class TextPost extends Post {
/**
 * TextPost class constructor which initializes the properties of text post object.
 * @param textContent the text post's text content
 * @param longitude the longitude of posting place
 * @param latitude the latitude of posting place
 * @param userNames the tagged friends' usernames
 */
public TextPost(String textContent,double longitude,double latitude,String userNames){
		super(textContent,longitude,latitude,userNames);
	}
@Override
public Date getDate() {
	return super.getDate();
}
@Override
public UUID getID() {
	return super.getID();
}
@Override
public String getText() {
	return super.getText();
}
@Override
public void setText(String textContent) {
	super.setText(textContent);
}
	/**
	 * Obtains the names of users from the taggedFriends collection
	 * @return the tagged users' names
	 */
@Override
public String showtaggedusers() {
	Iterator <User> itr = getTaggedFriends().iterator();
	String taggedFriends="";
	while(itr.hasNext()){
		User element = itr.next();
		taggedFriends=taggedFriends+element.getName()+" ";
	}
	return taggedFriends.trim().replace(" ",", ");
}
/**
 * @return the location information
 */
@Override
public String showpostlocation() {
	return "Location: "+getLocationInfo().getLongitude() + ", "+getLocationInfo().getLatitude();	
}
/**
 * the text post's informations
 */
@Override
	public String toString() {
		return "----------------------\n" +
				super.toString() + 
			   "\n"+ showpostlocation();
			  
			   
	}

}
