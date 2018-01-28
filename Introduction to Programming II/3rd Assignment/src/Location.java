/**
 * The Location class has a location information
 * which consists of latitude and longitude.
 * @author Muhammet Selcuk Guvel
 */
public class Location {
	private double latitude;
	private double longitude;
	/**
	 * Location class constructor which initializes the properties of location object.
	 * @param longitude the longitude information
	 * @param latitude the latitude information 
	 */
	public Location(double longitude , double latitude){
		this.longitude=longitude;
		this.latitude=latitude;
	}
	/**
	 * @return the latitude information
	 */
	public double getLatitude() {
		return latitude;
	}
	/**
	 * @return the longitude information
	 */
	public double getLongitude() {
		return longitude;
	}

	
}
