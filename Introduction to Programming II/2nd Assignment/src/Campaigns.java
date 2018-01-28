import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 * This class contains the campaigns.
 * @author Muhammet Selcuk Guvel
 */
public class Campaigns{
private String startDate;
private String endDate;
private String itemType;
private Date sDate;
private Date eDate;
private int rate;
static ArrayList<Campaigns> campaignlist= new ArrayList<Campaigns>();	
/**
 * Campaigns class constructor which initializes the properties of campaign object.
 * @param startDate the campaign's starting date
 * @param endDate the campaign's ending date
 * @param itemType the campaign's item type
 * @param rate the campaign's discount rate
 */
Campaigns(String startDate,String endDate,String itemType,int rate){
	this.startDate=startDate;
	this.endDate=endDate;
	this.itemType=itemType;
	this.rate=rate;
	DateFormat stringtodate= new SimpleDateFormat("dd.MM.yyyy");
	try {
		sDate=stringtodate.parse(getStartDate());
		eDate=stringtodate.parse(getEndDate());
	} catch (ParseException excp) {
		excp.printStackTrace();
	}
	campaignlist.add(this);
}
/**
 * @return the campaign's string type starting date variable which will be converted 
 */
public String getStartDate() {
	return startDate;
}
/**
 * @return the campaign's string type ending date variable which will be converted 
 */
public String getEndDate() {
	return endDate;
}
/**
 * @return the campaign's item type
 */
public String getItemType() {
	return itemType;
}
/**
 * @return the campaign's discount rate
 */
public int getRate() {
	return rate;
}
/** 
 * @return the campaign's starting date which is date type variable
 */
public Date getsDate() {
	return sDate;
}
/** 
 * @return the campaign's ending date which is date type variable
 */
public Date geteDate() {
	return eDate;
}
/**
 * @return the information of campaign
 */
@Override
	public String toString() {
		return getRate() + "% sale of " + getItemType() + " until " + geteDate();
	}

}
