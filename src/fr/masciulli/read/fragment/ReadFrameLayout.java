package fr.masciulli.read.fragment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class ReadFrameLayout extends FrameLayout {
    public ReadFrameLayout(Context context) {
        super(context);
    }

    public ReadFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ReadFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public float getXFraction() {
        final int width = getWidth();
        if (width == 0) {
            return -9999;
        }
        return getX() / width;
    }

    public void setXFraction(float xFraction) {
        // TODO: cache width
        final int width = getWidth();
        setX((width > 0) ? (xFraction * width) : -9999);
    }
}
