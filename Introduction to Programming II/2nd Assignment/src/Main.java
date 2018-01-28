import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
* The HUBBM Bazaar is an online shopping application.
* This program obtains the shopping datas from the input texts.
* According to these texts it collects the datas and prints the 
* output on the screen.
* @author Muhammet Selcuk Guvel
*/
public class Main {
	
	static int adminindex;
	static int techindex;
	static int customerindex;
	/**
	* Reads the input files.
	* According to these files , it creates objects for 
	* an intended type of data.It uses these objects in order to
	* calls the required methods.
	*@param args Unused
	*/
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(new File(args[0]));
			while(scan.hasNextLine()){
				String line = scan.nextLine();
				String [] array1 = line.split("\t");
				if (array1[0].equals("ADMIN")){
					new Admin(array1[1], array1[2], array1[3], Double.valueOf(array1[4]), array1[5]);
				}
				else if (array1[0].equals("CUSTOMER")){
					new Customer(array1[1], array1[2], array1[3], Double.valueOf(array1[4]), array1[5]);
				}
				else if (array1[0].equals("TECH")){
					new Technician(array1[1], array1[2], array1[3], Double.valueOf(array1[4]), Integer.valueOf(array1[5]));
				}
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
				if (array2[0].equals("DESKTOP")){
					new Desktop(Integer.valueOf(array2[1]), array2[2], array2[3], Integer.valueOf(array2[4]),
							    Integer.valueOf(array2[5]),array2[6],array2[7],Integer.valueOf(array2[8]),Integer.valueOf(array2[9]),array2[10]);
				}
				else if (array2[0].equals("LAPTOP")){
					new Laptop(Integer.valueOf(array2[1]), array2[2], array2[3], Integer.valueOf(array2[4]),
							   Integer.valueOf(array2[5]),array2[6],array2[7],Integer.valueOf(array2[8]),
							   Integer.valueOf(array2[9]),Integer.valueOf(array2[10]));
				}
				else if (array2[0].equals("TABLET")){
					new Tablet(Integer.valueOf(array2[1]), array2[2], array2[3], Integer.valueOf(array2[4]),
							   Integer.valueOf(array2[5]),array2[6],array2[7],Integer.valueOf(array2[8]),
							   Integer.valueOf(array2[9]),Integer.valueOf(array2[10]));
				}
				
				else if (array2[0].equals("TV")){
					new Tv(Integer.valueOf(array2[1]), array2[2], array2[3], Integer.valueOf(array2[4]),Integer.valueOf(array2[5]),Integer.valueOf(array2[6]));  
				}
				
				else if (array2[0].equals("SMARTPHONE")){
					new SmartPhone(Integer.valueOf(array2[1]), array2[2], array2[3], Integer.valueOf(array2[4]),Integer.valueOf(array2[5]),array2[6]);
				}
				
				else if (array2[0].equals("BOOK")){
					new Book(Integer.valueOf(array2[1]), array2[2], array2[3], array2[4], array2[5],Integer.valueOf(array2[6]));
				}
				
				else if (array2[0].equals("CDDVD")){
					new Cddvd(Integer.valueOf(array2[1]), array2[2], array2[3],array2[4], array2[5]);
				}
				
				else if (array2[0].equals("HAIRCARE")){
					new Haircare(Integer.valueOf(array2[1]) , array2[2], array2[3], Integer.valueOf(array2[4]), 
								   Integer.valueOf(array2[5]),Integer.valueOf(array2[6]),Integer.valueOf(array2[7]));
				}
				else if (array2[0].equals("SKINCARE")){
					new Skincare(Integer.valueOf(array2[1]) , array2[2], array2[3], Integer.valueOf(array2[4]), 
							     Integer.valueOf(array2[5]),Integer.valueOf(array2[6]),Integer.valueOf(array2[7]));
				}
				else if (array2[0].equals("PERFUME")){
					new Perfume(Integer.valueOf(array2[1]) , array2[2], array2[3], Integer.valueOf(array2[4]), 
							    Integer.valueOf(array2[5]),Integer.valueOf(array2[6]),Integer.valueOf(array2[7]));
				}
			}
			scan.close();
		}
		catch (FileNotFoundException ex) {
			System.out.println("No File Found!");
			return;
		}

		try {
			
			Scanner scan = new Scanner(new File(args[2]));
			while(scan.hasNextLine()){
				String line = scan.nextLine();
				String [] array3 = line.split("\t");
				if (array3[0].equals("ADDCUSTOMER")){
					System.out.println();
					System.out.println("COMMAND TEXT: <" + line+">");
					System.out.println();
					if(adminornot(array3[1])) 
						Admin.adminlist.get(adminindex).addcustomer(array3[2], array3[3], array3[4], Double.valueOf(array3[5]), array3[6]);
					else
						System.out.println("No admin person named "+array3[1]+" exists!");
				}
				else if (array3[0].equals("SHOWCUSTOMER")){
					System.out.println();
					System.out.println("COMMAND TEXT: <" + line+">");
					System.out.println();
					if(adminornot(array3[1]))
						Admin.adminlist.get(adminindex).showcustomer(Integer.valueOf(array3[2]));
					else
						System.out.println("No admin person named "+array3[1]+" exists!");
				}
				else if (array3[0].equals("SHOWCUSTOMERS")){
					System.out.println();
					System.out.println("COMMAND TEXT: <" + line+">");
					System.out.println();
					if(adminornot(array3[1]))
						Admin.adminlist.get(adminindex).showcustomers();
					else
						System.out.println("No admin person named "+array3[1]+" exists!");
				}
				else if (array3[0].equals("SHOWADMININFO")){
					System.out.println();
					System.out.println("COMMAND TEXT: <" + line+">");
					System.out.println();
					if(adminornot(array3[1]))
						System.out.println(Admin.adminlist.get(adminindex));
					else
						System.out.println("No admin person named "+array3[1]+" exists!");
				}
				else if (array3[0].equals("ADDADMIN")){
					System.out.println();
					System.out.println("COMMAND TEXT: <" + line+">");
					System.out.println();
					if(adminornot(array3[1]))
						Admin.adminlist.get(adminindex).addadmin(array3[2], array3[3], array3[4], Double.valueOf(array3[5]), array3[6]);
					else
						System.out.println("No admin person named "+array3[1]+" exists!");
				}
				else if (array3[0].equals("ADDTECH")){
					System.out.println();
					System.out.println("COMMAND TEXT: <" + line+">");
					System.out.println();
					if(adminornot(array3[1]))
						Admin.adminlist.get(adminindex).addtech(array3[2], array3[3], array3[4], Double.valueOf(array3[5]), Integer.valueOf(array3[6]));
					else
						System.out.println("No admin person named "+array3[1]+" exists!");
				}
				else if (array3[0].equals("LISTITEM")){
					System.out.println();
					System.out.println("COMMAND TEXT: <" + line+">");
					System.out.println();
					if(adminornot(array3[1]))
						Admin.adminlist.get(adminindex).listitem();
					else if(techornot(array3[1]))
						Technician.techlist.get(techindex).listitem();
					else
						System.out.println("No admin or technician person named " + array3[1] + " exists!");
				}
				else if (array3[0].equals("DISPITEMSOF")){
					System.out.println();
					System.out.println("COMMAND TEXT: <" + line+">");
					System.out.println();
					if(techornot(array3[1]))
						Technician.techlist.get(techindex).displayspecificitems(array3[2]);
					else
						System.out.println("No technician person named "+array3[1]+" exists!");
				}
				else if (array3[0].equals("SHOWVIP")){
					System.out.println();
					System.out.println("COMMAND TEXT: <" + line+">");
					System.out.println();
					if(adminornot(array3[1]))
						Admin.adminlist.get(adminindex).showvip();
					else if(techornot(array3[1]))
						Technician.techlist.get(techindex).showvip();
					else
						System.out.println("No admin or technician person named " + array3[1] + " exists!");
				}
				else if (array3[0].equals("CREATECAMPAIGN")){
					System.out.println();
					System.out.println("COMMAND TEXT: <" + line+">");
					System.out.println();
					if(adminornot(array3[1]))
						Admin.adminlist.get(adminindex).createcampaign(array3[2], array3[3], array3[4], Integer.valueOf(array3[5]));
					else
						System.out.println("No admin person named "+array3[1]+" exists!");
				}
				else if (array3[0].equals("SHOWCAMPAIGNS")){
					System.out.println();
					System.out.println("COMMAND TEXT: <" + line+">");
					System.out.println();
					if(customerornot(Integer.valueOf(array3[1])))
						Customer.customerlist.get(customerindex).displaycampaigns();
					else
						System.out.println("No customer with ID number " + Integer.valueOf(array3[1]) + " exists!");
				}
				else if (array3[0].equals("SHOWITEMSLOWONSTOCK") && array3.length==2){
					System.out.println();
					System.out.println("COMMAND TEXT: <" + line+">");
					System.out.println();
					if(adminornot(array3[1]))
						Admin.adminlist.get(adminindex).showitemslowonstock();
					else if(techornot(array3[1]))
						Technician.techlist.get(techindex).showitemslowonstock();
					else
						System.out.println("No admin or technician person named " + array3[1] + " exists!");
				}
				else if (array3[0].equals("SHOWITEMSLOWONSTOCK") && array3.length==3){
					System.out.println();
					System.out.println("COMMAND TEXT: <" + line+">");
					System.out.println();
					if(adminornot(array3[1]))
						Admin.adminlist.get(adminindex).showitemslowonstock(Integer.valueOf(array3[2]));
					else if(techornot(array3[1]))
						Technician.techlist.get(techindex).showitemslowonstock(Integer.valueOf(array3[2]));
					else
						System.out.println("No admin or technician person named " + array3[1] + " exists!");
				}
				else if(array3[0].equals("ADDITEM")){
					System.out.println();
					System.out.println("COMMAND TEXT: <" + line+">");
					System.out.println();
					if(techornot(array3[1]))
						Technician.techlist.get(techindex).addnewitem(array3[2]);
					else
						System.out.println("No technician person named "+array3[1]+" exists!");
				}
				else if (array3[0].equals("ADDTOCART")){
					System.out.println();
					System.out.println("COMMAND TEXT: <" + line+">");
					System.out.println();
					if (customerornot(Integer.valueOf(array3[1])))
						Customer.customerlist.get(customerindex).addtocart(Integer.valueOf(array3[2]));
					else
						System.out.println("No customer with ID number " +array3[1]+" exists!");
				}
				else if (array3[0].equals("EMPTYCART")){
					System.out.println();
					System.out.println("COMMAND TEXT: <" + line+">");
					System.out.println();
					if (customerornot(Integer.valueOf(array3[1])))
						Customer.customerlist.get(customerindex).emptycart();
					else
						System.out.println("No customer with ID number " +array3[1]+" exists!");
				}
				else if (array3[0].equals("DEPOSITMONEY")){
					System.out.println();
					System.out.println("COMMAND TEXT: <" + line+">");
					System.out.println();
					if (customerornot(Integer.valueOf(array3[1])))
						Customer.customerlist.get(customerindex).loadmoney(Double.valueOf(array3[2]));
					else
						System.out.println("No customer with ID number " +array3[1]+" exists!");
				}
				else if (array3[0].equals("CHPASS")){
					System.out.println();
					System.out.println("COMMAND TEXT: <" + line+">");
					System.out.println();
					if (customerornot(Integer.valueOf(array3[1])))
						Customer.customerlist.get(customerindex).changepassword(array3[2],array3[3]);
					else
						System.out.println("No customer with ID number " +array3[1]+" exists!");
				}
				else if (array3[0].equals("ORDER")){
					System.out.println();
					System.out.println("COMMAND TEXT: <" + line+">");
					System.out.println();
					if (customerornot(Integer.valueOf(array3[1])))
						Customer.customerlist.get(customerindex).order(array3[2]);
					else
						System.out.println("No customer with ID number " +array3[1]+" exists!");
			}
				else if (array3[0].equals("SHOWORDERS")){
					System.out.println();
					System.out.println("COMMAND TEXT: <" + line+">");
					System.out.println();
					if(techornot(array3[1]))
						Technician.techlist.get(techindex).showorders(array3[1]);
					else
						System.out.println("No technician person named "+array3[1]+" exists!");
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
 * Checks whether this adminName exists
 * in adminlist.If it exists,it also saves
 * the index of the admin object in the arraylist. 
 * @param adminName the admin's name
 * @return true if the adminName exists
 */
public static boolean adminornot(String adminName){
	for(int i=0;i<Admin.adminlist.size();i++){
		if(Admin.adminlist.get(i).getName().equals(adminName)){
			adminindex=i;
			return true;
		}
	}
	return false;
}

/** 
 * Checks whether this techName exists
 * in techlist.If it exists,it also saves
 * the index of the tech object in the arraylist. 
 * @param techName the technician's name
 * @return true if the techName exists
 */
public static boolean techornot(String techName){
	for(int j=0;j<Technician.techlist.size();j++){
		if(Technician.techlist.get(j).getName().equals(techName)){
			techindex=j;
			return true;
		}
	}
	return false;
}
/**
 * Checks whether the customer 
 * has this customer number.
 * If it has , it also saves
 * the index of the customer object in the arraylist. 
 * @param customerID the customer's ID
 * @return true if the customerID exists
 */
public static boolean customerornot(int customerID){
	for(int k=0;k<Customer.customerlist.size();k++){
		if(Customer.customerlist.get(k).getCurrentID()==customerID){
			customerindex=k;
			return true;
		}
	}
	return false;
}
}