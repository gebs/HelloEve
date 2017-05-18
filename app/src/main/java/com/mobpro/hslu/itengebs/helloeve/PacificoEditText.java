package com.mobpro.hslu.itengebs.helloeve;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by gebs on 5/18/17.
 */

public class PacificoEditText extends android.support.v7.widget.AppCompatEditText {
    public PacificoEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/Pacifico-Regular.ttf"));
    }
}
