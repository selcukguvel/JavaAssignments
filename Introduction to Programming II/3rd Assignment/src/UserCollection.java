import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/**
 * The UserCollection class keeps track of all users.
 * Adds new users to the system.
 * Removes existing users from the system.
 * Manages the user sign-in
 * Displays the users' post
 * @author Muhammet Selcuk Guvel
 */
public class UserCollection {
protected static Collection <User> userlist = new ArrayList<User>();
/**
 * Adds user to the userlist collection and the system
 * @param name the user's name
 * @param userName the user's username
 * @param password the user's password
 * @param dateofBirth the user's date of birth
 * @param graduatedSchool the school where the user is graduated from
 */
public static void addUser(String name,String userName,String password,String dateofBirth,String graduatedSchool){
	userlist.add(new User(name, userName, password, dateofBirth, graduatedSchool));
}
/**
 * Removes the user from the system according to the userID
 * Checks whether the user exists who has userID
 * @param userID the user's ID
 */
public static void removeUser(int userID){
	Iterator<User> itr = userlist.iterator();
	int userexists=0;
	while(itr.hasNext()){
		User element = itr.next();
		if(element.getuserID()==userID){
			userexists++;
			userlist.remove(element);
			System.out.println("User has been successfully removed.");
			break;
		}
	}
	if(userexists==0)
		System.out.println("No such user!");
}
/**
 * Performs an sign in action.
 * Checks whether the user exists who has userName
 * Checks whether the user has true password
 * Sets the user's connection information if everything is accurate
 * @param userName the user's userName
 * @param password the user's password
 * @return true if the user signs in
 */
public static boolean signin(String userName,String password){
	Iterator<User> itr = userlist.iterator();
	int nameExists=0;
	while(itr.hasNext()){
		User element = itr.next();
		if(element.getUserName().equals(userName))
			nameExists++;
		if(element.getUserName().equals(userName) && element.getPassword().equals(password)){
		   element.setConnectionInfo(true);
		   element.setLastloginDate();
		   System.out.println("You have successfully signed in.");
		   return true;
		}
	}
	if(nameExists==0){
		System.out.println("No such user!");
		return false;
	}
	else{
		System.out.println("Invalid username or password! Please try again.");
		return false;
	}
}
/**
 * Shows the user's posts
 * Checks whether the user exists who has userName
 * Checks whether the user has posts
 * @param userName the user's username
 */
public static void showPosts(String userName){
	Iterator<User> itr = userlist.iterator();
	int incr=0;
	while(itr.hasNext()){
		User element = itr.next();
		if(element.getUserName().equals(userName)){
			incr++;
			Iterator<Post> postitr = element.getPostslist().iterator();
			if(element.getPostslist().size()==0)
				System.out.println(userName + " does not have any posts yet.");
			else{
			System.out.println("**************");
			System.out.println(userName +"'s Posts");
			System.out.println("**************");
			while(postitr.hasNext()){
				Post postelement = postitr.next();
				System.out.println(postelement);
			}
			System.out.println("----------------------");
		}
	}
}
	if(incr==0)
		System.out.println("No such user!");
	

}
}

