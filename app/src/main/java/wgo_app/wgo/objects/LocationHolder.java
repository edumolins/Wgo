package wgo_app.wgo.objects;

import android.widget.TextView;

public class LocationHolder {

	private TextView locationName;

	public LocationHolder(TextView locationName) {
		this.locationName = locationName;
	}

	public TextView getLocationName() {
		return locationName;
	}

	public void setLocationName(TextView locationName) {
		this.locationName = locationName;
	}
}