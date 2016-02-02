package wgo_app.wgo.objects;

public class ObjLocation {

	private int locationId;
	private String locationName;
	private String locationCountry;

	public ObjLocation(int id, String name, String country){

		this.locationId = id;
		this.locationName = name;
		this.locationCountry = country;
	}

	public String getLocationCountry() {
		return locationCountry;
	}

	public void setLocationCountry(String locationCountry) {
		this.locationCountry = locationCountry;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
}