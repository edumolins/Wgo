package wgo_app.wgo.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

public class GNBookEditText extends EditText {

    public GNBookEditText(Context context, AttributeSet attrs) {

        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/gn_book.otf"));

    }

}