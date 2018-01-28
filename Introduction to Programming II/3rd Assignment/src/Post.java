import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;
/**
 *The abstract Postclass has features which
 *every post has.
 * @author Muhammet Selcuk Guvel
 */
public abstract class Post implements PostInterface {
private UUID postID;
private String textContent;
private Date postoriginatedDate;
private Collection<User> taggedFriends = new ArrayList<User>();
private Location locationInfo;
/**
 * Post class constructor which initializes the properties of post object.
 * Creates a location object which has longitude and latitude properties.
 * Adds tagged friends to the taggedFriends collection.
 * @param textContent the post's text content
 * @param longitude the longitude of posting place
 * @param latitude the latitude of posting place
 * @param userNames the tagged friends' usernames which will be added to taggedFriends collection
 */
public Post(String textContent,double longitude,double latitude,String userNames){
	this.textContent=textContent;
	this.postID=UUID.randomUUID();
	postoriginatedDate=new Date();
	setLocationInfo(new Location(longitude,latitude));
	addtofriendcollection(userNames);
}
/**
 * @return the tagged users' names
 */
public abstract String showtaggedusers();
/**
 * @return the posting location
 */
public abstract String showpostlocation();
/**
 * @return the taggedFriends collection
 */
public Collection<User> getTaggedFriends() {
	return taggedFriends;
}
/**
 * Sets the taggedFriends collection
 * @param taggedFriends the taggedFriends collection which will be changed
 */
public void setTaggedFriends(Collection<User> taggedFriends) {
	this.taggedFriends = taggedFriends;
}
@Override
	public String getText() {
		return textContent;
	}
@Override
	public UUID getID() {
		return postID;
	}
@Override
	public Date getDate() {
		return postoriginatedDate;
	}
@Override
	public void setText(String textContent) {
		this.textContent=textContent;
	}
/**
 * @return the post's informations
 */
@Override
	public String toString() {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy");
		return textContent +
			   "\nDate: " + dateformat.format(postoriginatedDate);
	}
/**
 * @return the location information
 */
public Location getLocationInfo() {
	return locationInfo;
}
/**
 * Sets the location information
 * @param locationInfo the location info which will be changed
 */
public void setLocationInfo(Location locationInfo) {
	this.locationInfo = locationInfo;
}
/**
 * Splits the userNames string , finds the corresponding user object and
 * adds it to the taggedFriends collection.
 * @param userNames the usernames which will be added to the taggedFriends collection
 */
public void addtofriendcollection(String userNames){
	String [] taggedfriendsArray = userNames.split(" ");
	for(int indks=0;indks<taggedfriendsArray.length;indks++){
		Iterator<User> itr = UserCollection.userlist.iterator();
		while(itr.hasNext()){
			User element = itr.next();
			if(taggedfriendsArray[indks].equals(element.getUserName())){
				taggedFriends.add(element);
			}
		}
	}
	
}

}
