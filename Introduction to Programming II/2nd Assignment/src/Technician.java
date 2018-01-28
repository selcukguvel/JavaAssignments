import java.util.ArrayList;
/**
 *The Technician class has methods which perform the different
 *kinds of actions.These methods are specific to the technicians.
 * @author Muhammet Selcuk Guvel
 */
import java.util.Locale;
public class Technician extends Employee {
int senior; 
static ArrayList<Technician> techlist = new ArrayList<Technician>();
/**
 * Technician class constructor which initializes the properties of technician object.
 * @param name the technician's name
 * @param email the technician's email
 * @param birthDate the technician's birth date
 * @param salary the technician's salary
 * @param isSeniorTechnician represents the technician's seniority 
 */
public Technician(String name,String email,String birthDate,double salary,int isSeniorTechnician){
	super(name,email,birthDate,salary);
	this.senior=isSeniorTechnician;
	techlist.add(this);
}
/**
 * Splits the itemtypes which is String data variable
 * Contains the newitem's informations in itemarray
 * Displays the items' information according to the indexes of the itemarray
 * @param itemtypes The item types which will be displayed on the screen
 */
public void displayspecificitems(String itemtypes){ // "book'a pages ekle!!!!!!!!!"
	 String [] itemarray = itemtypes.split(":");
	 for(int i=0;i<itemarray.length;i++){
		 for(int j=0;j<Items.itemcontainer.size();j++){
				if(itemarray[i].equals(Items.itemcontainer.get(j).getName().toUpperCase(Locale.ENGLISH)))
						System.out.println(Items.itemcontainer.get(j));
		}
	 }
}
/**
 * Splits the newitem which is String data variable
 * Contains the newitem's informations in itemsarray
 * Creates an object which is the type of itemsarray's first index
 * @param newitem the item object's information which will be created
 */
public void addnewitem(String newitem){
	String [] itemsarray = newitem.split(":");
	if (itemsarray[0].equals("DESKTOP")){
		new Desktop(Integer.valueOf(itemsarray[1]), itemsarray[2], itemsarray[3], Integer.valueOf(itemsarray[4]),
				    Integer.valueOf(itemsarray[5]),itemsarray[6],itemsarray[7],Integer.valueOf(itemsarray[8]),Integer.valueOf(itemsarray[9]),
				    itemsarray[10]);
	}
	else if (itemsarray[0].equals("LAPTOP")){
		new Laptop(Integer.valueOf(itemsarray[1]), itemsarray[2], itemsarray[3], Integer.valueOf(itemsarray[4]),
				   Integer.valueOf(itemsarray[5]),itemsarray[6],itemsarray[7],Integer.valueOf(itemsarray[8]),
				   Integer.valueOf(itemsarray[9]),Integer.valueOf(itemsarray[10]));
	}
	else if (itemsarray[0].equals("TABLET")){
		new Tablet(Integer.valueOf(itemsarray[1]), itemsarray[2], itemsarray[3], Integer.valueOf(itemsarray[4]),
				   Integer.valueOf(itemsarray[5]),itemsarray[6],itemsarray[7],Integer.valueOf(itemsarray[8]),
				   Integer.valueOf(itemsarray[9]),Integer.valueOf(itemsarray[10]));
	}
	
	else if (itemsarray[0].equals("TV")){
		new Tv(Integer.valueOf(itemsarray[1]), itemsarray[2], itemsarray[3], Integer.valueOf(itemsarray[4]),Integer.valueOf(itemsarray[5]),
			   Integer.valueOf(itemsarray[6]));  
	}
	
	else if (itemsarray[0].equals("SMARTPHONE")){
		new SmartPhone(Integer.valueOf(itemsarray[1]), itemsarray[2], itemsarray[3], Integer.valueOf(itemsarray[4]),Integer.valueOf(itemsarray[5]),
				itemsarray[6]);
	}
	
	else if (itemsarray[0].equals("BOOK")){
		new Book(Integer.valueOf(itemsarray[1]), itemsarray[2], itemsarray[3], itemsarray[4], itemsarray[5],Integer.valueOf(itemsarray[6]));
	}
	
	else if (itemsarray[0].equals("CDDVD")){
		new Cddvd(Integer.valueOf(itemsarray[1]), itemsarray[2], itemsarray[3],itemsarray[4], itemsarray[5]);
	}
	
	else if (itemsarray[0].equals("HAIRCARE")){
		new Haircare(Integer.valueOf(itemsarray[1]) , itemsarray[2], itemsarray[3], Integer.valueOf(itemsarray[4]), 
					   Integer.valueOf(itemsarray[5]),Integer.valueOf(itemsarray[6]),Integer.valueOf(itemsarray[7]));
	}
	else if (itemsarray[0].equals("SKINCARE")){
		new Skincare(Integer.valueOf(itemsarray[1]) , itemsarray[2], itemsarray[3], Integer.valueOf(itemsarray[4]), 
				     Integer.valueOf(itemsarray[5]),Integer.valueOf(itemsarray[6]),Integer.valueOf(itemsarray[7]));
	}
	else if (itemsarray[0].equals("PERFUME")){
		new Perfume(Integer.valueOf(itemsarray[1]) , itemsarray[2], itemsarray[3], Integer.valueOf(itemsarray[4]), 
				    Integer.valueOf(itemsarray[5]),Integer.valueOf(itemsarray[6]),Integer.valueOf(itemsarray[7]));
	}
}
	
/**
 * Displays the orders requested so far
 * if the technician has any right
 * @param techName the technician's name who will displays the orders
 */
public void showorders(String techName){
	if(senior==1){
		System.out.println("Order History:");
		for(int i=0;i<Orders.orderlist.size();i++)
			System.out.println(Orders.orderlist.get(i));
	}
	else
		System.out.println(techName +" is not authorized to display orders!");
}


}
