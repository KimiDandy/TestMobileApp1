package com.kimi.login_register;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

public class OvalImage extends AppCompatImageView {
    public OvalImage(Context context) {
        super(context);
        init();
    }

    public OvalImage(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public OvalImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        // Set the circle_background.xml as the background
        setBackgroundResource(R.drawable.circle_background);
    }

    @Override
    public void setBackground(Drawable background) {
        // Ensure that setting a different background doesn't interfere with the circular shape
        Drawable[] layers = new Drawable[2];
        layers[0] = getResources().getDrawable(R.drawable.circle_background);
        layers[1] = background;
        LayerDrawable layerDrawable = new LayerDrawable(layers);
        super.setBackground(layerDrawable);
    }
}
