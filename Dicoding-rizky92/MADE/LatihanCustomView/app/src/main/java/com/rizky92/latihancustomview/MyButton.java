package com.rizky92.latihancustomview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import static android.view.Gravity.CENTER;

public class MyButton extends AppCompatButton {
    private Drawable enableBg, disableBg;
    private int color;

    public MyButton(Context context) {
        super(context);
        init();
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackground(isEnabled() ? enableBg : disableBg);
        setTextColor(color);
        setTextSize(12.f);
        setGravity(CENTER);
        setText(isEnabled() ? "Submit" : "Isi dulu");
    }


    private void init() {
        color = ContextCompat.getColor(getContext(), android.R.color.background_light);
        enableBg = getResources().getDrawable(R.drawable.bg_button);
        disableBg = getResources().getDrawable(R.drawable.bg_button_disable);
    }
}
