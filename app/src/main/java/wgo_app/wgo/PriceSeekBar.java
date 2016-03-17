package wgo_app.wgo;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.SeekBar;

import wgo_app.wgo.fonts.GNLightTextView;

public class PriceSeekBar extends SeekBar {
    private Paint paint;
    private GNLightTextView tv;
    private static final int TEXT_SIZE = 50;
    private int priceSelected = 10;
    private static final String TAG = PriceSeekBar.class.getName();

    public PriceSeekBar(Context context) {
        super(context);
        initPaint();
        initText(context);
    }

    public PriceSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        initText(context);
    }

    public PriceSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initPaint();
        initText(context);
    }

    private void initPaint() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(getResources().getDimension(R.dimen.text_size));
        //paint.setTextSize(TEXT_SIZE);

        //need to set antialias, if not the txt is too pixelated
        paint.setAntiAlias(true);
    }

    private void initText(Context context) {
        tv = new GNLightTextView(context, null);
        tv.setText(String.valueOf(priceSelected));
        //tv.setTextSize(TEXT_SIZE);
        tv.setTextSize(getResources().getDimension(R.dimen.text_size));
    }

    private int getTextWidth() {
        try {
            tv.measure(0, 0);
        }catch (Exception e){

        }
        return tv.getMeasuredWidth();
    }

    private int getTextHeight() {
        try {
            tv.measure(0, 0);
        }catch (Exception e){

        }
        return tv.getMeasuredHeight();
    }

    public void setPriceSelected(Context context, int priceSelected) {
        initPaint();
        initText(context);
        this.priceSelected = priceSelected;
        tv.setText(String.valueOf(priceSelected));
    }

    public String getPriceSelected() {
        return tv.getText().toString();
    }

    @Override
    protected synchronized void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawText(tv.getText().toString(), this.getThumb().getBounds().exactCenterX() - getTextWidth() / 4, this.getThumb().getBounds().exactCenterY() + this.getThumb().getBounds().exactCenterY() / 2, paint);
        canvas.drawText(tv.getText().toString(), this.getThumb().getBounds().exactCenterX() - getTextWidth() / 4 ,  this.getThumb().getBounds().exactCenterY() + this.getThumb().getBounds().exactCenterY() / 4, paint);
        int i = 0;
    }
}
