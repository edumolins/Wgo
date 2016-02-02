package wgo_app.wgo.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

public class GNLightEditText extends EditText {

    public GNLightEditText(Context context, AttributeSet attrs) {

        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/gn_light.otf"));

    }

}