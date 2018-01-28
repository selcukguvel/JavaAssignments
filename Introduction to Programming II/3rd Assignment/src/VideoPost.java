import java.util.Date;
import java.util.UUID;
/**
 *The VideoPost class has features which
 *every video post has.
 * @author Muhammet Selcuk Guvel
 */
public class VideoPost extends TextPost{
private String filePath;
private int videoDuration;
/**
 * VideoPost class constructor which initializes the properties of video post object.
 * @param textContent the video post's text content
 * @param longitude the longitude of posting place
 * @param latitude the latitude of posting latitude
 * @param userNames the tagged friends' usernames
 * @param filePath the video's file path
 * @param videoDuration the length of the video
 */
public VideoPost(String textContent, double longitude, double latitude, String userNames, String filePath,int videoDuration) {
	super(textContent, longitude, latitude, userNames);
	this.filePath=filePath;
	this.videoDuration=videoDuration;
}
/**
 * @return the video's file path
 */
public String getVideofileName() {
	return filePath;
}
/**
 * @return the video's duration
 */
public int getvideoDuration() {
	return videoDuration;
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
 * @return the video post's informations
 */
@Override
public String toString() {
	return super.toString() + 
		   "\nVideo: " + filePath +
		   "\nVideo duration: " + videoDuration + " minutes" +
		   "\nFriends tagged in this post: " + showtaggedusers();
}
}
