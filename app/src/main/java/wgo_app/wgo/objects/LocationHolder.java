package wgo_app.wgo.objects;

import android.widget.TextView;

public class LocationHolder {

	private TextView locationName;
	private TextView locationCountry;

	public LocationHolder(TextView locationName, TextView locationCountry) {
		this.locationName = locationName;
		this.locationCountry = locationCountry;
	}

	public TextView getLocationCountry() {
		return locationCountry;
	}

	public void setLocationCountry(TextView locationCountry) {
		this.locationCountry = locationCountry;
	}

	public TextView getLocationName() {
		return locationName;
	}

	public void setLocationName(TextView locationName) {
		this.locationName = locationName;
	}
}