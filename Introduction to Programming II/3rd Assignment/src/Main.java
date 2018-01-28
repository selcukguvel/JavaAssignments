import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
/**
 * This program is a mini-facebook application.
 * The instantiated users can perform some actions which are given with commands file.
 * The program displays all outputs according to the actions.
 * @author Muhammet Selcuk Guvel
 */
public class Main {
	private static User userinthesystem;
	/**
	 * Reads the user input file in order to instantiate the users.
	 * According to the commands input file it performs an intended action.
	 * When it tries to perform the actions , checks whether there is a signed user in the system.
	 * @param args Unused
	 */
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(new File(args[0]));
			while(scan.hasNextLine()){
				String line = scan.nextLine();
				String [] array = line.split("\t");
				UserCollection.addUser(array[0],array[1],array[2],array[3],array[4]);
			   }
			scan.close();
		}
		catch (FileNotFoundException ex) {
			System.out.println("No File Found!");
			return;
		}
	
	
	try {
		
		Scanner scan = new Scanner(new File(args[1]));
		while(scan.hasNextLine()){
			String line = scan.nextLine();
			String [] array2 = line.split("\t");
			if (array2[0].equals("ADDUSER")){
				System.out.println("-----------------------");
				System.out.println("Command: " + line);
				UserCollection.addUser(array2[1], array2[2], array2[3], array2[4], array2[5]);
				System.out.println(array2[1]+" has been successfully added.");
			}
			else if (array2[0].equals("REMOVEUSER")){
				System.out.println("-----------------------");
				System.out.println("Command: " + line);
				UserCollection.removeUser(Integer.valueOf(array2[1]));	
			}
			else if (array2[0].equals("SIGNIN")){
				System.out.println("-----------------------");
				System.out.println("Command: " + line);
				if(UserCollection.signin(array2[1],array2[2])){
					userinthesystem=userobject(array2[1],array2[2]);
				}
			}
			else if (array2[0].equals("SIGNOUT")){
				System.out.println("-----------------------");
				System.out.println("Command: " + line);
				userinthesystem.setConnectionInfo(false);
				System.out.println("You have successfully signed out.");
			}
			else if (array2[0].equals("UPDATEPROFILE")){
				System.out.println("-----------------------");
				System.out.println("Command: " + line);
				if(userinthesystem.isConnectionInfo())
					userinthesystem.updateprofile(array2[1],array2[2],array2[3]);
				else
					System.out.println("Error: Please sign in and try again.");
			}
			else if (array2[0].equals("CHPASS")){
				System.out.println("-----------------------");
				System.out.println("Command: " + line);
				if(userinthesystem.isConnectionInfo())
					userinthesystem.chpass(array2[1],array2[2]);
				else
					System.out.println("Error: Please sign in and try again.");
			}
			else if (array2[0].equals("ADDFRIEND")){
				System.out.println("-----------------------");
				System.out.println("Command: " + line);
				if(userinthesystem.isConnectionInfo())
					userinthesystem.addfriend(array2[1]);
				else
					System.out.println("Error: Please sign in and try again.");
			}
			else if (array2[0].equals("LISTUSERS")){
				System.out.println("-----------------------");
				System.out.println("Command: " + line);
				if(userinthesystem.isConnectionInfo())
					userinthesystem.listusers();
				else
					System.out.println("Error: Please sign in and try again.");
			}
			else if (array2[0].equals("REMOVEFRIEND")){
				System.out.println("-----------------------");
				System.out.println("Command: " + line);
				if(userinthesystem.isConnectionInfo())
					userinthesystem.removefriend(array2[1]);
				else
					System.out.println("Error: Please sign in and try again.");
			}
			else if (array2[0].equals("LISTFRIENDS")){
				System.out.println("-----------------------");
				System.out.println("Command: " + line);
				if(userinthesystem.isConnectionInfo())
					userinthesystem.listfriends();
				else
					System.out.println("Error: Please sign in and try again.");
			}
			else if (array2[0].equals("BLOCK")){
				System.out.println("-----------------------");
				System.out.println("Command: " + line);
				if(userinthesystem.isConnectionInfo())
					userinthesystem.blockuser(array2[1]);
				else
					System.out.println("Error: Please sign in and try again.");
			}
			else if (array2[0].equals("UNBLOCK")){
				System.out.println("-----------------------");
				System.out.println("Command: " + line);
				if(userinthesystem.isConnectionInfo())
					userinthesystem.unblockuser(array2[1]);
				else
					System.out.println("Error: Please sign in and try again.");
			}
			else if (array2[0].equals("SHOWBLOCKEDUSERS")){
				System.out.println("-----------------------");
				System.out.println("Command: " + line);
				if(userinthesystem.isConnectionInfo())
					userinthesystem.showblockedusers();
				else
					System.out.println("Error: Please sign in and try again.");
			}
			else if (array2[0].equals("SHOWBLOCKEDFRIENDS")){
				System.out.println("-----------------------");
				System.out.println("Command: " + line);
				if(userinthesystem.isConnectionInfo())
					userinthesystem.showblockedfriends();
				else
					System.out.println("Error: Please sign in and try again.");
			}
			else if (array2[0].equals("ADDPOST-TEXT")){
				System.out.println("-----------------------");
				System.out.println("Command: " + line);
				if(userinthesystem.isConnectionInfo())
					userinthesystem.addtextpost(array2[1],Double.valueOf(array2[2]),Double.valueOf(array2[3]),array2[4]);
				else
					System.out.println("Error: Please sign in and try again.");
			}
			else if (array2[0].equals("ADDPOST-IMAGE")){
				System.out.println("-----------------------");
				System.out.println("Command: " + line);
				if(userinthesystem.isConnectionInfo())
					userinthesystem.addimagepost(array2[1],Double.valueOf(array2[2]),
																		Double.valueOf(array2[3]),array2[4],array2[5],array2[6]);
				else
					System.out.println("Error: Please sign in and try again.");
			}
			else if (array2[0].equals("ADDPOST-VIDEO")){
				System.out.println("-----------------------");
				System.out.println("Command: " + line);
				if(userinthesystem.isConnectionInfo())
					userinthesystem.addvideopost(array2[1],Double.valueOf(array2[2]),
																		Double.valueOf(array2[3]),array2[4],array2[5],
																		Integer.valueOf(array2[6]));
				else
					System.out.println("Error: Please sign in and try again.");
			}
			else if (array2[0].equals("REMOVELASTPOST")){
				System.out.println("-----------------------");
				System.out.println("Command: " + line);
				if(userinthesystem.isConnectionInfo())
					userinthesystem.removelastpost();
				else
					System.out.println("Error: Please sign in and try again.");
			}
			else if (array2[0].equals("SHOWPOSTS")){
				System.out.println("-----------------------");
				System.out.println("Command: " + line);
				if(userinthesystem.isConnectionInfo())
					UserCollection.showPosts(array2[1]);
				else
					System.out.println("Error: Please sign in and try again.");
			}
			
	}
	scan.close();
}
	catch (FileNotFoundException ex) {
		System.out.println("No File Found!");
		return;
	}
}
	/**
	 * Finds the user object which has the specific username and password.
	 * @param userName the user's username
	 * @param password the user's password
	 * @return the user object
	 */
	public static User userobject(String userName,String password){
		Iterator<User> itr = UserCollection.userlist.iterator();
		while(itr.hasNext()){
			User element = itr.next();
			if(element.getUserName().equals(userName) && element.getPassword().equals(password)){
			   return element;
			}
	}
		return null;
}
	
}
	
