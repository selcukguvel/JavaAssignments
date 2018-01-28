/**
 *The Employee class has attributes and behaviours
 *which are common for both Admin and Technician classes.
 * @author Muhammet Selcuk Guvel
 */
public class Employee extends Person {
private static Items [] objectarray = {new Book(),new Cddvd(),new Desktop(),new Laptop(),
			   		  new Tablet(),new Tv(),new SmartPhone(),new Haircare(),new Perfume(),new Skincare()};
double salary;
/**
 * Creates a new Employee according to
 * the parameters.
 * @param name the employee's name
 * @param email the employee's email
 * @param birthDate the employee's birth date
 * @param salary the employee's salary
 */
Employee(String name,String email,String birthDate,double salary){
	super(name,email,birthDate);
	this.salary=salary;
}
/**
 * Lists the items which exist.
 */
public void listitem(){
	for(int i=0;i<Items.itemcontainer.size();i++){
		System.out.println(Items.itemcontainer.get(i));
	}
}
/**
 * Shows the items which are low on stock.
 */
public void showitemslowonstock(){
		for(int i=0;i<objectarray.length;i++){
			System.out.println(objectarray[i].getName() +" : " + objectarray[i].getstockNumber());
		}
	}
/**
 * Shows the items which exists that much
 * copies below the maxStockAmount
 * @param maxStockAmount represents an upper limit for an amount of items which will be displayed
 */
public void showitemslowonstock(int maxStockAmount){
		for(int j=0;j<objectarray.length;j++){
			if(objectarray[j].getstockNumber()<maxStockAmount){
				System.out.println(objectarray[j].getName()+" : "+objectarray[j].getstockNumber());
			}
		}
	}

/**
 * Shows the customers which have "GOLDEN" status
 */
public void showvip(){
	for(int i=0;i<Customer.customerlist.size();i++){
		if(Customer.customerlist.get(i).getStatus().equals("GOLDEN"))
			System.out.println(Customer.customerlist.get(i).toString());
			}
		}

}




