package com.mobpro.hslu.itengebs.helloeve.controls;


import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by gebs on 5/18/17.
 */

public class PacificoTextInputLayout extends android.support.design.widget.TextInputLayout {
    public PacificoTextInputLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Pacifico-Regular.ttf"));

    }
}
