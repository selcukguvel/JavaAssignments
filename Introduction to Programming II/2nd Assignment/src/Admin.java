import java.util.ArrayList;
/**
 *The Admin class has methods which perform the different
 *kinds of actions.Most of these methods are specific to the admins.
 * @author Muhammet Selcuk Guvel
 */
public class Admin extends Employee {
String password;
static ArrayList<Admin> adminlist= new ArrayList<Admin>();
/**
 * Admin class constructor which initializes the properties of admin object.
 * @param name the admin's name
 * @param email the admin's email
 * @param birthDate the admin's birthdate
 * @param salary the admin's salary
 * @param password the admin's password
 */
public Admin(String name,String email,String birthDate,double salary,String password){
	super(name,email,birthDate,salary);
	this.password=password;
	adminlist.add(this);
}
/**
 * Creates a new customer according to
 * the parameters.
 * @param customername the customer's name
 * @param customeremail the customer's email
 * @param customerdateofbirth the customer's birthdate
 * @param initialbalance the customer's initialbalance
 * @param password the costumer's password
 */
public void addcustomer(String customername,String customeremail,String customerdateofbirth,
							   double initialbalance,String password){
		new Customer(customername,customeremail,customerdateofbirth,initialbalance,password);
}
/**
 * Controls the customerID
 * and prints the corresponding customer's information
 * on the screen.
 * @param customerID the customer's id
 */
public void showcustomer(int customerID){
	int indexofcustomer=0;
	for(int i=0;i<Customer.customerlist.size();i++){
		if(Customer.customerlist.get(i).getCurrentID()==customerID)
			indexofcustomer=i;
	}
	System.out.println(Customer.customerlist.get(indexofcustomer));
}
/**
 * Prints the all customer's informations
 * on the screen.
 */
public void showcustomers(){
	for(int i=0;i<Customer.customerlist.size();i++){
		System.out.println(Customer.customerlist.get(i));
	}
}

/**
 * Prints the admin's personaldata
 * on the screen with the help of displaypersonaldata method
 * which is overridden from the Person class.
 * @return the admin's personaldata
 */

@Override
public String toString() {
	String comesfromperson = super.toString();
	int firstindex = comesfromperson.indexOf("\n");
	int lastindex  = comesfromperson.lastIndexOf("\n");
	String resultstring = "----------- Admin info -----------\n"+"Admin " + comesfromperson.substring(0,firstindex+1) + "Admin "+
						  comesfromperson.substring(firstindex+1,lastindex+1) + "Admin " +
						  comesfromperson.substring(lastindex+1);
	return resultstring;
	
}
/**
 * Creates new admin object according to
 * the parameters.
 * @param name the admin's name
 * @param email the admin's email
 * @param birthDate the admin's birthdate
 * @param salary the admin's salary
 * @param password the admin's password
 */
public void addadmin(String name,String email,String birthDate,double salary,String password){
		new Admin(name,email,birthDate,salary,password);
}
/**
 * Creates new technician object according to 
 * the parameters.
 * @param name the technician's name
 * @param email the technician's email
 * @param birthDate the technician's birthdate
 * @param salary the technician's salary
 * @param isSeniorTechnician represents the technician's seniority
 */

public void addtech(String name,String email,String birthDate,double salary,int isSeniorTechnician){
		new Technician(name,email,birthDate,salary,isSeniorTechnician);
}
/**
 * Creates the campaign according to the 
 * given parameters.
 * @param startDate	the campaign's starting date
 * @param endDate the campaign's ending date
 * @param itemType the campaign's itemtype
 * @param rate the campaign's discount rate
 */

public void createcampaign(String startDate,String endDate,String itemType,int rate){
	int k=0;
	for(int i=0;i<Campaigns.campaignlist.size();i++){
		if(Campaigns.campaignlist.get(i).getItemType().equals(itemType)){
			k++;
			break;
		}
	}
	if(k==0 && rate<50)
		new Campaigns(startDate,endDate,itemType,rate);
	else if (rate>50)
		System.out.println("Campaign was not created. Discount rate exceeds maximum rate of 50%.");
}

}