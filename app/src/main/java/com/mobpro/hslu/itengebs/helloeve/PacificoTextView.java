package com.mobpro.hslu.itengebs.helloeve;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by gebs on 5/18/17.
 */

public class PacificoTextView extends android.support.v7.widget.AppCompatTextView {
    public PacificoTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/Pacifico-Regular.ttf"));

    }
}
