package com.bluapp.androidview.Menu;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;

import com.bluapp.androidview.R;

public class MenuActivity8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu8);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "Font.otf");

        for(int i = 0; i<menu.size(); i++){
            MenuItem menuItem = menu.getItem(i);
            SubMenu subMenu = menuItem.getSubMenu();
            if(subMenu != null && subMenu.size()>0){
                for(int j = 0; j < subMenu.size(); j++){
                    MenuItem subMenuItem = subMenu.getItem(j);
                    applyFont(subMenuItem, typeface);
                }
            }
            applyFont(menuItem, typeface);
        }
        return super.onCreateOptionsMenu(menu);
    }

    private void applyFont(MenuItem menuItem, Typeface font){
        SpannableString spannableString  = new SpannableString(menuItem.getTitle());
        spannableString.setSpan(new CustomTypeFace("", font), 0, spannableString.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        menuItem.setTitle(spannableString);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            //
        }

        return true;
    }

    private class CustomTypeFace extends TypefaceSpan{
        private final Typeface typeface;

        public CustomTypeFace(String family, Typeface type) {
            super(family);
            typeface = type;
        }

        @Override
        public void updateDrawState(TextPaint textPaint){
            applyCustomTypeFace(textPaint, typeface);
        }

        @Override
        public void updateMeasureState(TextPaint textPaint){
            applyCustomTypeFace(textPaint, typeface);
        }

        private void applyCustomTypeFace(Paint paint, Typeface typeface){
            int oldStyle;
            Typeface old = paint.getTypeface();
            if(old == null){
                oldStyle = 0;
            }else{
                oldStyle = old.getStyle();
            }

            int fake = oldStyle & ~typeface.getStyle();
            if((fake & Typeface.BOLD) != 0){
                paint.setFakeBoldText(true);
            }

            if((fake & Typeface.ITALIC) != 0){
                paint.setTextSkewX(-0.25f);
            }
            paint.setTypeface(typeface);
        }
    }
}
