package wgo_app.wgo;


import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class SeekBarHint extends SeekBar {
        public SeekBarHint (Context context) {
            super(context);
        }

        public SeekBarHint (Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
        }

        public SeekBarHint (Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        protected void onDraw(Canvas c) {
            super.onDraw(c);
           // int thumb_x = ( (double)this.getProgress()/this.getMax() ) * (double)this.getWidth();
           // int middle = this.getHeight()/2;
           // c.drawText("1");
            // your drawing code here, ie Canvas.drawText();
        }
}
