package wgo_app.wgo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.SeekBar;
import android.widget.TextView;

public class PriceSeekBar extends SeekBar {
    private Paint paint;
    private TextView tv;
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
        paint.setTextSize(TEXT_SIZE);
        paint.setTextSize(getResources().getDimension(R.dimen.text_size));
        //need to set antialias, if not the txt is too pixelated
        paint.setAntiAlias(true);
    }

    private void initText(Context context) {
        tv = new TextView(context);
        tv.setText(String.valueOf(priceSelected));
        //tv.setTextSize(getResources().getDimension(R.dimen.text_size));
       //tv.setTextSize(TEXT_SIZE);
    }

    private int getTextWidth() {
        try{
            tv.measure(0, 0);
        }catch(Exception e){}
        return tv.getMeasuredWidth();
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

        canvas.drawText(tv.getText().toString(), this.getThumb().getBounds().exactCenterX() - getTextWidth() / 2, this.getThumb().getBounds().exactCenterY() + this.getThumb().getBounds().exactCenterY() / 4, paint);
    }
}
