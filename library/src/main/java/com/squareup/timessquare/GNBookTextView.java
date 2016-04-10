package com.squareup.timessquare;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class GNBookTextView extends TextView {


    public GNBookTextView(Context context) {
        this(context, null);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/gn_book.otf"));
    }

    public GNBookTextView(Context context, AttributeSet attrs) {

        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/gn_book.otf"));

    }

}