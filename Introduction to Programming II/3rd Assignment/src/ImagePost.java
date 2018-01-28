import java.util.Date;
import java.util.UUID;
/**
 *The ImagePost class has features which
 *every image post has.
 * @author Muhammet Selcuk Guvel
 */
public class ImagePost extends TextPost {
private String filePath;
private String resolution;
/**
 * ImagePost class constructor which initializes the properties of image post object.
 * @param textContent the image post's text content
 * @param longitude the longitude of posting place
 * @param latitude the latitude of posting place
 * @param userNames the tagged friends' usernames
 * @param filePath the image's file path
 * @param resolution the image's resolution
 */
public ImagePost(String textContent, double longitude, double latitude, String userNames, String filePath,String resolution) {
	super(textContent,longitude,latitude,userNames);
	this.filePath=filePath;
	this.resolution=resolution;
}
/**
 * @return the date of the image post
 */
@Override
	public Date getDate() {
		return super.getDate();
	}
/**
 * @return the UUID of the image post
 */
@Override
	public UUID getID() {
		return super.getID();
	}
/**
 * @return the image post's text content
 */
@Override
	public String getText() {
		return super.getText();
	}
@Override
	public String showpostlocation() {
		return super.showpostlocation();
	}
@Override
	public String showtaggedusers() {
		return super.showtaggedusers();
	}
@Override
	public void setText(String textContent) {
		super.setText(textContent);
	}
/**
 * @return the image post's informations
 */
@Override
public String toString() {
	return super.toString() + 
		   "\nImage: " + filePath +
		   "\nImage resolution: " + resolution +
		   "\nFriends tagged in this post: " + showtaggedusers();
}
}
