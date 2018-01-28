/**
 *The Computer abstract class has features which
 *every computer product has.This abstract class has abstract methods
 *which are no need to be implemented in this class. 
 * @author Muhammet Selcuk Guvel
 */
public abstract class Computer extends Electronic {
private String operatingSystem;
private String cpuType;
private int ramCapacity;
private int HDDCapacity; 
/**
 * Computer class default constructor.
 */
Computer(){
	
}
/**
 * Computer class constructor which initializes the properties of computer product object.
 * @param cost the computer product's cost
 * @param manufacturer the computer product's manufacturer
 * @param brand the computer product's brand
 * @param maxVolt the computer product's maximum allowed input voltage
 * @param maxWatt the computer product's maximum power consumption
 * @param operatingSystem the computer product's operating system
 * @param cpuType the computer product's cpu type
 * @param ramCapacity the computer product's ram capacity
 * @param HDDCapacity the computer product's hdd capacity
 */
Computer(double cost,String manufacturer,String brand,int maxVolt,int maxWatt,String operatingSystem,String cpuType,int ramCapacity,int HDDCapacity){
	super(cost,maxVolt,maxWatt,manufacturer,brand);
	this.operatingSystem=operatingSystem;
	this.cpuType=cpuType;
	this.ramCapacity=ramCapacity;
	this.HDDCapacity=HDDCapacity;
}
/**
 * @return the computer product's operating system
 */
public String getOperatingSystem() {
	return operatingSystem;
}
/**
 * @return the computer product's cpu type
 */
public String getCpuType() {
	return cpuType;
}
/**
 * @return the computer product's ram capacity
 */
public int getRamCapacity() {
	return ramCapacity;
}
/**
 * @return the computer product's hdd capacity
 */
public int getHDDCapacity() {
	return HDDCapacity;
}
/**
 * @return the information which is the common for all computer product types
 */
public String toString() {
	return super.toString() +
			"\nOperating System: " + getOperatingSystem() +
			"\nCPU Type: " + getCpuType() +
			"\nRAM Capacity: " + getRamCapacity() + " GB." +
			"\nHDD Capacity: " + getHDDCapacity() + " GB." ;
}
}
