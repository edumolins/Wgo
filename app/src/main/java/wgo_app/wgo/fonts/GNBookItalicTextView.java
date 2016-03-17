package wgo_app.wgo.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class GNBookItalicTextView extends TextView {

    public GNBookItalicTextView(Context context, AttributeSet attrs) {

        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/gn_book_italic.otf"));


    }

}