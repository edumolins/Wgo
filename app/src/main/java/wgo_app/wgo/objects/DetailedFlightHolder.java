package wgo_app.wgo.objects;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DetailedFlightHolder {


	private ImageView flightLogo1;
	private ImageView flightLogo2;
	private RelativeLayout flightRow;
	private TextView flightTime1;
	private TextView flightDay1;
	private TextView flightTime2;
	private TextView flightDay2;
	private TextView flightLastCheck;
	private TextView flightPrice;

	public DetailedFlightHolder(ImageView flightLogo1, ImageView flightLogo2, RelativeLayout flightRow, TextView flightTime1, TextView flightDay1, TextView flightTime2, TextView flightDay2, TextView flightLastCheck, TextView flightPrice) {
		this.flightLogo1 = flightLogo1;
		this.flightLogo2 = flightLogo2;
		this.flightRow = flightRow;
		this.flightTime1 = flightTime1;
		this.flightDay1 = flightDay1;
		this.flightTime2 = flightTime2;
		this.flightDay2 = flightDay2;
		this.flightLastCheck = flightLastCheck;
		this.flightPrice = flightPrice;
	}

	public ImageView getFlightLogo1() {
		return flightLogo1;
	}

	public void setFlightLogo1(ImageView flightLogo1) {
		this.flightLogo1 = flightLogo1;
	}

	public ImageView getFlightLogo2() {
		return flightLogo2;
	}

	public void setFlightLogo2(ImageView flightLogo2) {
		this.flightLogo2 = flightLogo2;
	}

	public RelativeLayout getFlightRow() {
		return flightRow;
	}

	public void setFlightRow(RelativeLayout flightRow) {
		this.flightRow = flightRow;
	}

	public TextView getFlightTime1() {
		return flightTime1;
	}

	public void setFlightTime1(TextView flightTime1) {
		this.flightTime1 = flightTime1;
	}

	public TextView getFlightDay1() {
		return flightDay1;
	}

	public void setFlightDay1(TextView flightDay1) {
		this.flightDay1 = flightDay1;
	}

	public TextView getFlightTime2() {
		return flightTime2;
	}

	public void setFlightTime2(TextView flightTime2) {
		this.flightTime2 = flightTime2;
	}

	public TextView getFlightDay2() {
		return flightDay2;
	}

	public void setFlightDay2(TextView flightDay2) {
		this.flightDay2 = flightDay2;
	}

	public TextView getFlightLastCheck() {
		return flightLastCheck;
	}

	public void setFlightLastCheck(TextView flightLastCheck) {
		this.flightLastCheck = flightLastCheck;
	}

	public TextView getFlightPrice() {
		return flightPrice;
	}

	public void setFlightPrice(TextView flightPrice) {
		this.flightPrice = flightPrice;
	}
}