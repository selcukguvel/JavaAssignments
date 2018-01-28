import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
/**
 *The Costumer class has attributes and behaviours
 *which all costumer should be able to.
 * @author Muhammet Selcuk Guvel
 */
public class Customer extends Person {
static int customerID=1;
private int currentID;
private String password;
private double balance;
private String status;
private int indexofcampaign;
private double expense;
static ArrayList<Customer> customerlist = new ArrayList<Customer>();
ArrayList<Items> shoppingcart = new ArrayList<Items>();
/**
 * Costumer class constructor which initializes the properties of customer object.
 * It also increments the customerID when the object is created.
 * It assigns status to "CLASSIC" by default.
 * @param name the customer's name
 * @param email the customer's email
 * @param birthDate the customer's birth date
 * @param balance the customer's balance
 * @param password the customer's password
 */
public Customer(String name,String email,String birthDate,double balance,String password){
	super(name,email,birthDate);
	this.balance=balance;
	this.password=password;
	currentID=customerID;
	customerID++;
	status="CLASSIC";
	customerlist.add(this);
}
/**
 * @return the information of costumer
 */
@Override
	public String toString() {
		return "Customer name: " + getName() +
			   "\tID: " + currentID +
			   "\te-mail: "+ getEmail() +
			   "\t Date of Birth: "+ getbDate() +
			   "\tStatus: " + status;
	}

/**
 * @return the customer's ID
 */
public int getCurrentID() {
	return currentID;
}
/**
 * @return the customer's status
 */
public String getStatus() {
	return status;
}
/**
 * @param changestatus represents the new status of the customer 
 */
public void setStatus(String changestatus) {
	this.status = changestatus;
}
/**
 * Checks whether the campaigns exist.
 * If exists it will display all active campaigns.
 */
public void displaycampaigns(){
	if(Campaigns.campaignlist.size()==0)
		System.out.println("No campaign has been created so far!");
	else{
		System.out.println("Active campaigns:"); 
		for(int j=0;j<Campaigns.campaignlist.size();j++){
			System.out.println(Campaigns.campaignlist.get(j));
		}
	}
}
/**
 * Adds the items to the shopping cart.
 * Checks whether the itemID exists and product is in stock.
 * @param itemID the item's ID 
 */
public void addtocart(int itemID){
	int validornot=0;
	int itemindex=0;
	for(int i=0;i<Items.itemcontainer.size();i++){
		if(Items.itemcontainer.get(i).currentID==itemID){
			validornot++;
			itemindex=i;
			break;
		}
	}
	if(validornot==0)
		System.out.println("Invalid item ID");
	else if(validornot!=0 && Items.itemcontainer.get(itemindex).getstockNumber()!=0){
		shoppingcart.add(Items.itemcontainer.get(itemindex));
		System.out.println("The item " +Items.itemcontainer.get(itemindex).getName()+ " has been successfully added to your cart.");
	}
	else if (validornot!=0 && Items.itemcontainer.get(itemindex).getstockNumber()==0)
		System.out.println("We are sorry. The item is temporarily unavailable.");			   									
}

/**
 * Empties the shopping cart.
 */
public void emptycart(){
	shoppingcart.clear();
	System.out.println("The cart has been emptied.");
	
}
/**
 * Increases the balance of the customer
 * @param loadAmount the amount of money which will increase the balance
 */
public void loadmoney(double loadAmount){
	balance+=loadAmount;
}
/**
 * Changes the password of customer
 * Checks whether the oldPassword matches with the current password
 * @param oldPassword the customer's old password
 * @param newPassword the customer's new password
 */
public void changepassword(String oldPassword,String newPassword){
	if(oldPassword.equals(password)){
		password=newPassword;
		System.out.println("The password has been successfully changed.");
	}
	else
		System.out.println("The given password does not match the current password. Please try again.");
}
/**
 * Gives an order
 * Checks whether the customerPassword matches with the current password,
 * whether the shopping cart has items,
 * whether the balance is enough to place an order,
 * the active campaigns for the each item,
 * the status of customer for the total cost , calculates the finalcost 
 * according to that status
 * @param customerPassword the customer's password
 */
public void order(String customerPassword){
	int statusrate = rateofstatus(getStatus());
	if(customerPassword.equals(password) && shoppingcart.size()!=0){
		double total=0;
		for(int i=0;i<shoppingcart.size();i++){
			if(hascampaignornot(shoppingcart.get(i))){
				int campaignrate = Campaigns.campaignlist.get(indexofcampaign).getRate();
				total+=totalresult(shoppingcart.get(i).getCost(),campaignrate);
			}
			else
				total+=shoppingcart.get(i).getCost();
		}
		double finalcost=total - total*((double)statusrate/100);
		if (balance>finalcost){
			expense+=finalcost;
			new Orders(new Date(),currentID,finalcost,shoppingcart.size());
			updatestockamount();
			shoppingcart.clear();
			System.out.println("Done! Your order will be delivered as soon as possible. Thank you!");
			if(getStatus().equals("CLASSIC") && expense<1000){
				System.out.println("You need to spend "+ (1000-expense) + " more TL to become a SILVER MEMBER.");
			}
			else if(getStatus().equals("CLASSIC") && expense>5000){
				System.out.println("Congratulations! You have been upgraded to a GOLDEN MEMBER! " +
								   "You have earned a permanent discount of 15% on all purchases.");
			}
			else if(getStatus().equals("CLASSIC") && expense>1000){
				System.out.println("Congratulations! You have been upgraded to a SILVER MEMBER! " +
						 		   "You have earned a discount of 10% on all purchases.");
				System.out.println("You need to spend "+ (5000-expense) + " more TL to become a GOLDEN MEMBER.");
			}
			else if(getStatus().equals("SILVER") && expense>5000){
				System.out.println("Congratulations! You have been upgraded to a GOLDEN MEMBER! " +
								   "You have earned a permanent discount of 15% on all purchases.");
			}
			else if(getStatus().equals("SILVER") && expense>1000){
				System.out.println("You need to spend "+ (5000-expense) + " more TL to become a GOLDEN MEMBER.");
			}
			setStatus(awardedstatus(expense));
		}
		else
			System.out.println("Order could not be placed. Insufficient funds.");
		
	}
	else if (shoppingcart.size()==0)
		System.out.println("You should add some items to your cart before order request!");
	else 
		System.out.println("Order could not be placed. Invalid password.");

}
/**
 * Updates the stock information if an item is sold.
 */
public void updatestockamount(){
	for(int i=0;i<shoppingcart.size();i++){
		shoppingcart.get(i).setstockNumber();
	}
}
/**
 * 
 * @param money the customer's final cost
 * @return "GOLDEN" if the money is at least 5000
 * @return "SILVER" if the money is at least 1000
 * @return "CLASSIC" if the money is under 1000
 */
public String awardedstatus(double money){ 
	if (money>=5000)
		return "GOLDEN";
	else if (money >=1000)
		return "SILVER";
	else
		return "CLASSIC";
}
/**
 * Gives the discount rate of customer's status
 * @param awardedstatus the customer's status
 * @return the discount rate of the customer's status
 */
public int rateofstatus(String awardedstatus){
	if(awardedstatus.equals("SILVER"))
		return 10;
	else if (awardedstatus.equals("GOLDEN"))
		return 15;
	else
		return 0;
}

/**
 * Calculates the cost after the discount
 * @param cost the cost before discount
 * @param campaignRate the rate of campaign
 * @return the cost after the discount
 */
public double totalresult(double cost,int campaignRate){
	return cost - cost*((double)campaignRate/100);
	
}
/**
 * Checks whether the campaign exists for an item
 * @param item the item object  
 * @return true if the campaign exists for an item
 */
public boolean hascampaignornot(Items item){
	for(int j=0;j<Campaigns.campaignlist.size();j++){ 
		if(item.getName().toUpperCase(Locale.ENGLISH).equals(Campaigns.campaignlist.get(j).getItemType())){
			indexofcampaign=j;
			return true;
		}
	}
	return false;
}
}

