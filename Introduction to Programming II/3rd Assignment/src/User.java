import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
/**
 * The User class has attributes and behaviours
 * which all users should be able to.
 * @author Muhammet Selcuk Guvel
 */
public class User {
static int stuserID=1;
private int userID;
private String name;
private String userName;
private String password;
private Date dateofBirth;
private String graduatedSchool;
private Date lastloginDate;
private boolean connectionInfo=false;
private Collection <User> friendslist = new ArrayList<User>();
private Collection <User> blockeduserslist = new ArrayList<User>();
private Collection <Post> postslist = new ArrayList<Post>();
/**
 * User class constructor which initializes the properties of user object.
 * It also increments the stuserID when the object is created.
 * @param name the user's name
 * @param userName the user's username
 * @param password the user's password
 * @param dateofBirth the user's date of birth
 * @param graduatedSchool the school where the user is graduated from
 */
public User(String name, String userName, String password, String dateofBirth, String graduatedSchool) {
	this.setName(name);
	this.setUserName(userName);
	this.setPassword(password);
	this.setGraduatedSchool(graduatedSchool);
	this.setDateofBirth(dateofBirth);
	userID=stuserID;
	stuserID++;
}
/**
 * @return the postslist collection
 */
public Collection<Post> getPostslist() {
	return postslist;
}
/**
 * @return the friendslist collection
 */
public Collection<User> getFriendslist() {
	return friendslist;
}
/**
 * @return the user's name
 */
public String getName() {
	return name;
}
/**
 * Sets the user's name
 * @param name the user's name which will be changed
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the user's username
 */
public String getUserName() {
	return userName;
}
/**
 * Sets the user's username
 * @param userName the user's username which will be changed
 */
public void setUserName(String userName) {
	this.userName = userName;
}
/**
 * @return user's password
 */
public String getPassword() {
	return password;
}
/**
 * Sets the user's password
 * @param password the user's password which will be changed
 */
public void setPassword(String password) {
	this.password = password;
}
/**
 * @return the user's date of birth
 */
public Date getDateofBirth() {
	return dateofBirth;
}
/**
 * Converts the user's date of birth which is the type of String to the type of Date 
 * @param dateofBirth the user's date of birth which is the type of String
 */
public void setDateofBirth(String dateofBirth) {
	DateFormat stringtodate= new SimpleDateFormat("MM/dd/yyyy");
	try {
		this.dateofBirth=stringtodate.parse(dateofBirth);
	} catch (ParseException excp) {
		excp.printStackTrace();
	}
}
/**
 * @return the school where the user is graduated from
 */
public String getGraduatedSchool() {
	return graduatedSchool;
}
/**
 * Sets the school where the user is graduated from
 * @param graduatedSchool the school where the user is graduated from which will be changed
 */
public void setGraduatedSchool(String graduatedSchool) {
	this.graduatedSchool = graduatedSchool;
}
/**
 * @return the user's last login date
 */
public Date getLastloginDate() {
	return lastloginDate;
}
/**
 * Sets the user's last login date
 */
public void setLastloginDate() {
	this.lastloginDate=new Date();
}
/**
 * @return the user's ID
 */
public int getuserID(){
	return userID;
}
/**
 * @return the user's connection information
 */
public boolean isConnectionInfo() {
	return connectionInfo;
}
/**
 * Sets the user's connection information
 * @param connectionInfo the user's connection information which will be changed
 */
public void setConnectionInfo(boolean connectionInfo) {
	this.connectionInfo = connectionInfo;
}
/**
 * Lists all users' informations
 */
public void listusers(){
	Iterator<User> itr = UserCollection.userlist.iterator();
	while(itr.hasNext()){
		User element = itr.next();
		System.out.println("Name: " +element.getName()+
							"\nUsername: " +element.getUserName()+
							"\nDate of Birth: " +element.getDateofBirth()+
							"\nSchool: " +element.getGraduatedSchool()+
		 					"\n---------------------------");			
	}
}
/**
 * Lists all friends' informations
 */
public void listfriends(){
	Iterator<User> itr = friendslist.iterator();
	while(itr.hasNext()){
		User element = itr.next();
		System.out.println("Name: " +element.getName()+
							"\nUsername: " +element.getUserName()+
							"\nDate of Birth: " +element.getDateofBirth()+
							"\nSchool: " +element.getGraduatedSchool()+
		 					"\n---------------------------");			
	}
}
/**
 * Updates the user's profile
 * @param name the user's new name information
 * @param dateofBirth the user's new date of birth information
 * @param graduatedSchool the new school information where the user is graduated from 
 */
public void updateprofile(String name,String dateofBirth,String graduatedSchool){
	this.setName(name);
	this.setDateofBirth(dateofBirth);
	this.setGraduatedSchool(graduatedSchool);
	System.out.println("Your user profile has been successfully updated.");
}
/**
 * Changes the password of the user
 * Checks whether the oldPassword matches with the current password
 * @param oldPassword the user's old password
 * @param newPassword the user's new password
 */
public void chpass(String oldPassword,String newPassword){
	if(!(oldPassword.equals(password))){
		System.out.println("Password mismatch! Please, try again.");
	}
	else
		password=newPassword;
}
/**
 * Adds friend to the friendlist collection
 * Checks whether the user exists who has userName
 * Checks whether the user is already in the friend list
 * @param userName the user's username which will be added as a friend
 */
public void addfriend(String userName){
	done:{
	Iterator<User> itr = friendslist.iterator();
	if(userexists(userName)){
		while(itr.hasNext()){
			User element = itr.next();
			if(element.getUserName().equals(userName)){
				System.out.println("This user is already in your friend list!");
				break done;
		}
	}
	friendslist.add(userobject(userName));
	System.out.println(userName + " has been successfully added to your friend list.");
}
	else
		System.out.println("No such user!");
	}
}
/**
 * Removes friend from the friendlist collection
 * Checks whether the user exists in the friendlist collection who has userName
 * @param userName the user's userName which will be removed from the friendlist collection
 */
public void removefriend(String userName){
	done:{
	Iterator<User> itr = friendslist.iterator();
	while(itr.hasNext()){
		User element = itr.next();
		if(element.getUserName().equals(userName)){
			friendslist.remove(element);
			System.out.println(userName + " has been successfully removed from your friend list.");
			break done;
		}
	}
	System.out.println("No such friend!");
}
}
/**
 * Blocks the user who has userName
 * Checks whether the user exists who has userName
 * @param userName the user's username who will be blocked
 */
public void blockuser(String userName){
	done:{
	Iterator<User> itr = UserCollection.userlist.iterator();
	while(itr.hasNext()){
		User element = itr.next();
		if(element.getUserName().equals(userName)){
			blockeduserslist.add(element);
			System.out.println(userName + " has been successfully blocked.");
			break done;
		}
	}
	System.out.println("No such user!");
}
	
}
/**
 * Unblocks the user who has userName
 * Checks whether the user exists in blockeduserslist collection who has userName
 * @param userName the user's username who will be unblocked
 */
public void unblockuser(String userName){
	done:{
	Iterator<User> itr = blockeduserslist.iterator();
	while(itr.hasNext()){
		User element = itr.next();
		if(element.getUserName().equals(userName)){
			blockeduserslist.remove(element);
			System.out.println(userName + " has been successfully unblocked.");
			break done;
		}
	}
	System.out.println("No such user in your blocked users list!");
}
}
/**
 * Shows the blocked users
 * Checks whether the user has blocked any user
 */
public void showblockedusers(){
	if(blockeduserslist.size()==0){
		System.out.println("You haven't blocked any users yet!");
	}
	else{
		Iterator<User> itr = blockeduserslist.iterator();
		while(itr.hasNext()){
			User element = itr.next();
			 System.out.println("Name: " +element.getName()+
						"\nUsername: " +element.getUserName()+
						"\nDate of Birth: " +element.getDateofBirth()+
						"\nSchool: " +element.getGraduatedSchool()+
						"\n---------------------------");		
			}
		}	
	}
/**
 * Shows the blocked friends
 * Checks whether the user has blocked any user
 * Checks the blockeduserslist collection whether has any common users with friendslist collection
 */
public void showblockedfriends(){
	if(blockeduserslist.size()==0){
		System.out.println("You haven't blocked any users yet!");
	}
	else{
		Iterator<User> itr = blockeduserslist.iterator();
		int incr=0;
		while(itr.hasNext()){
			 User element = itr.next();
			 if(friendslist.contains(element)){
				 incr++;
				 System.out.println("Name: " +element.getName()+
							"\nUsername: " +element.getUserName()+
							"\nDate of Birth: " +element.getDateofBirth()+
							"\nSchool: " +element.getGraduatedSchool()+
							"\n---------------------------");		
			}
		}
	if(incr==0)
		System.out.println("You haven't blocked any friends yet!");
}
}
/**
 * Adds text post to the postslist collection
 * Checks whether the userNames contain any foreigner
 * @param textContent the text post's text content
 * @param longitude the longitude of posting place
 * @param latitude the latitude of posting place
 * @param userNames the usernames which intended to be tagged
 */
public void addtextpost(String textContent,double longitude,double latitude,String userNames){
	String [] taggedArray = userNames.split(":");
	String taggedFriends="";
	for(int indks=0;indks<taggedArray.length;indks++){
		Iterator<User> itr = friendslist.iterator();
		int incr=0;
		while(itr.hasNext()){
			User element = itr.next();
			if(taggedArray[indks].equals(element.getUserName())){
				taggedFriends=taggedFriends+taggedArray[indks]+" ";
				incr++;
			}
		}
		if(incr==0)
			System.out.println(taggedArray[indks] + " is not your friend, and will not be tagged!");
	}
	Post tpost=new TextPost(textContent, longitude, latitude, taggedFriends);
	postslist.add(tpost);
	System.out.println("The post has been successfully added.");
}
/**
 * Adds image post to the postslist collection
 * Checks whether the userNames contain any foreigner
 * @param textContent the image post's text content
 * @param longitude the longitude of posting place
 * @param latitude the latitude of posting place
 * @param userNames the usernames which intended to be tagged
 * @param filePath the image's file path
 * @param resolution the image's resolution
 */
public void addimagepost(String textContent,double longitude,double latitude,String userNames,String filePath,String resolution){
	String [] taggedArray = userNames.split(":");
	String taggedFriends="";
	for(int indks=0;indks<taggedArray.length;indks++){
		Iterator<User> itr = friendslist.iterator();
		int incr=0;
		while(itr.hasNext()){
			User element = itr.next();
			if(taggedArray[indks].equals(element.getUserName())){
				taggedFriends=taggedFriends+taggedArray[indks]+" ";
				incr++;
			}
		}
		if(incr==0)
			System.out.println(taggedArray[indks] + " is not your friend, and will not be tagged!");
	}
	Post ipost = new ImagePost(textContent,longitude,latitude,taggedFriends,filePath,resolution);
	postslist.add(ipost);
	System.out.println("The post has been successfully added.");
}
/**
 * Adds video post to the postslist collection
 * Checks whether the userNames contain any foreigner
 * Checks whether the length of the video is less than 10 minutes
 * @param textContent the image post's text content
 * @param longitude the longitude of posting place
 * @param latitude the latitude of posting place
 * @param userNames the usernames which intended to be tagged
 * @param filePath the video's file path
 * @param videoDuration the length of the video
 */
public void addvideopost(String textContent,double longitude,double latitude,String userNames,String filePath,int videoDuration){
	if(videoDuration<=10){
		String [] taggedArray = userNames.split(":");
		String taggedFriends="";
		for(int indks=0;indks<taggedArray.length;indks++){
			Iterator<User> itr = friendslist.iterator();
			int incr=0;
			while(itr.hasNext()){
				User element = itr.next();
				if(taggedArray[indks].equals(element.getUserName())){
					taggedFriends=taggedFriends+taggedArray[indks]+" ";
					incr++;
				}
			}
		if(incr==0)
			System.out.println(taggedArray[indks] + " is not your friend, and will not be tagged!");
		}
		Post vpost = new VideoPost(textContent, longitude, latitude, taggedFriends, filePath, videoDuration);
		postslist.add(vpost);
		System.out.println("The post has been successfully added.");
	}
	else
		System.out.println("Error: Your video exceeds maximum allowed duration of 10 minutes.");
}
/**
 * Removes the last post
 * Checks whether the user has any post
 */
public void removelastpost(){
	Iterator<Post> itr = postslist.iterator();
	int postIndex=0;
	if(postslist.size()==0)
		System.out.println("Error: You don't have any posts.");
	else{
		while(itr.hasNext()){
			Post element = itr.next();
			if(postIndex==(postslist.size()-1)){
				postslist.remove(element);
				break;
			}
			postIndex++;
	}
		System.out.println("Your last post has been successfully removed.");
}
}
/**
 * Verifies the user existence as a helper method
 * @param userName the user's username which will be checked
 * @return true if the user exists who has userName
 */
public boolean userexists(String userName){
	Iterator<User> itr = UserCollection.userlist.iterator();
	while(itr.hasNext()){
		User element = itr.next();
		if(element.getUserName().equals(userName)){
			return true;
		}
	}
	return false;
}
/**
 * Finds the user object according to the userName as a helper method
 * @param userName the user's username which will be finded as an user object
 * @return the user object
 */
public User userobject(String userName){
	Iterator<User> itr = UserCollection.userlist.iterator();
	while(itr.hasNext()){
		User element = itr.next();
		if(element.getUserName().equals(userName)){
			return element;
		}
	}
	return null;
}


}


