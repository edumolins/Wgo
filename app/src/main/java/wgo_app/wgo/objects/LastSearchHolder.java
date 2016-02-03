package wgo_app.wgo.objects;

import android.widget.Button;
import android.widget.TextView;

public class LastSearchHolder {


	private TextView originText;
	private TextView destinationText;
	private TextView numberWeekendsText;
	private TextView priceText;
	private TextView durationText;
	private TextView editText;
	private TextView deleteText;
	private Button showButton;

	public LastSearchHolder(TextView originText, TextView destinationText, TextView numberWeekendsText, TextView priceText, TextView durationText, TextView editText, TextView deleteText, Button showButton) {
		this.originText = originText;
		this.destinationText = destinationText;
		this.numberWeekendsText = numberWeekendsText;
		this.priceText = priceText;
		this.durationText = durationText;
		this.editText = editText;
		this.deleteText = deleteText;
		this.showButton = showButton;
	}

	public TextView getOriginText() {
		return originText;
	}

	public void setOriginText(TextView originText) {
		this.originText = originText;
	}

	public TextView getDestinationText() {
		return destinationText;
	}

	public void setDestinationText(TextView destinationText) {
		this.destinationText = destinationText;
	}

	public TextView getNumberWeekendsText() {
		return numberWeekendsText;
	}

	public void setNumberWeekendsText(TextView numberWeekendsText) {
		this.numberWeekendsText = numberWeekendsText;
	}

	public TextView getPriceText() {
		return priceText;
	}

	public void setPriceText(TextView priceText) {
		this.priceText = priceText;
	}

	public TextView getDurationText() {
		return durationText;
	}

	public void setDurationText(TextView durationText) {
		this.durationText = durationText;
	}

	public TextView getEditText() {
		return editText;
	}

	public void setEditText(TextView editText) {
		this.editText = editText;
	}

	public TextView getDeleteText() {
		return deleteText;
	}

	public void setDeleteText(TextView deleteText) {
		this.deleteText = deleteText;
	}

	public Button getShowButton() {
		return showButton;
	}

	public void setShowButton(Button showButton) {
		this.showButton = showButton;
	}
}