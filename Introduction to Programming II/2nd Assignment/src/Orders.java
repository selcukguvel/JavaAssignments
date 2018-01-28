import java.util.ArrayList;
import java.util.Date;
/**
 * This class contains the orders.
 * @author Muhammet Selcuk Guvel
 */
public class Orders {
private Date orderDate;
private double totalCost;
private int numpurchaseditems;
private int customerID;
static ArrayList<Orders> orderlist= new ArrayList<Orders>();
/**
 * Orders class constructor which initializes the properties of order object.
 * @param orderDate the order's date
 * @param customerID the customer's ID which places an order
 * @param totalCost the total cost of the order
 * @param numpurchaseditems the number of the purchased items
 */
Orders(Date orderDate,int customerID,double totalCost,int numpurchaseditems){
	this.orderDate=orderDate;
	this.totalCost=totalCost;
	this.numpurchaseditems=numpurchaseditems;
	this.customerID=customerID;
	orderlist.add(this);
}
/**
 * @return the order history
 */
@Override
	public String toString() {
		return "Order date: " + orderDate +"\tCustomer ID: "+customerID+"\tTotal Cost: "+totalCost+"\tNumber of purchased items: "+numpurchaseditems;
		}
	}

