import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *The Person class has features which
 *every person has.
 * @author Muhammet Selcuk Guvel
 */
public class Person {
private String name;
private String email;
private String birthDate;
private Date bDate;
/**
 * Person class default constructor.
 */
Person(){
	
}
/**
 * Person class constructor which initializes the properties of person object.
 * Converts string type birthDate to the date type variable.
 * @param name the person's name
 * @param email the person's email
 * @param birthDate the person's birth date
 */
Person(String name,String email,String birthDate){
	this.name=name;
	this.email=email;
	this.birthDate=birthDate;
	DateFormat stringtodate= new SimpleDateFormat("dd.MM.yyyy");
	try {
		bDate = stringtodate.parse(getBirthDate());
	} catch (ParseException excp) {
		excp.printStackTrace();
	}
}
/**
 * @return the person's name
 */
public String getName() {
	return name;
}
/**
 * @return the person's email
 */
public String getEmail() {
	return email;
}
/**
 * @return the person's string type birth date variable which will be converted  
 */
public String getBirthDate(){
	return birthDate;
}
/**
 * @return the information of person
 */
@Override
public String toString(){
	return "name: "+getName() +
		   "\n" + "e-mail: "+getEmail() +
		   "\n" + "date of birth: "+getbDate();
}
/**
 * @return the person's birth date which is date type variable
 */
public Date getbDate(){
	return bDate;
}

}
