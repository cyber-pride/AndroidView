package com.bluapp.androidview.Button;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.bluapp.androidview.R;

public class ButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
    }

    public void closeKeyboard(View v){
        try {
            InputMethodManager editTextInput = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            editTextInput.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }catch (Exception e){
            Log.e("AndroidView", "closeKeyboard: "+e);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();inflater.inflate(R.menu.button_option, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.action_textimageButton:
                startActivity(new Intent(ButtonActivity.this, TextIconButtonActivity.class));
                return true;
            case R.id.action_buttonClicked:
                startActivity(new Intent(ButtonActivity.this, StartActivityButtonActivity.class));
                return true;
            case R.id.action_xmlbuttonClicked:
                startActivity(new Intent(ButtonActivity.this, XmlButtonClickActivity.class));
                return true;
            case R.id.action_disablebackpressButton:
                startActivity(new Intent(ButtonActivity.this, DisableOnBackPressActivity.class));
                return true;
            case R.id.action_changefabColor:
                startActivity(new Intent(ButtonActivity.this, ChangeFabColorActivity.class));
                return true;
            case R.id.action_alertDialogOnButton:
                startActivity(new Intent(ButtonActivity.this, AlertDialogButtonActivity.class));
                return true;
            case R.id.action_centerButtonprogra:
                startActivity(new Intent(ButtonActivity.this, ProgrammaticallyCenterButtonActivity.class));
                return true;
            case R.id.action_materialeffectButton:
                startActivity(new Intent(ButtonActivity.this, MaterialEffectButtonActivity.class));
                return true;
            case R.id.action_circleButton:
                startActivity(new Intent(ButtonActivity.this, CircleButtonActivity.class));
                return true;
            case R.id.action_fabProgrammatically:
                startActivity(new Intent(ButtonActivity.this, ProgrammaticallyFabActivity.class));
                return true;
            case R.id.action_onbackpressExitButton:
                startActivity(new Intent(ButtonActivity.this, OnBackPressTwiceExistActivity.class));
                return true;
            case R.id.action_lowercaseButton:
                startActivity(new Intent(ButtonActivity.this, LowecaseTextButtonActivity.class));
                return true;
            case R.id.action_disableAndroidButton:
                startActivity(new Intent(ButtonActivity.this, DisableButtonActivity.class));
                return true;
            case R.id.action_custombuttonState:
                startActivity(new Intent(ButtonActivity.this, CustomButtonStateActivity.class));
                return true;
            case R.id.action_prograMarginButton:
                startActivity(new Intent(ButtonActivity.this, ProgrammaticallyMarginBtnActivity.class));
                return true;
            case R.id.action_getbuttonText:
                startActivity(new Intent(ButtonActivity.this, GetBtnTextActivity.class));
                return true;
            case R.id.action_disableDoubleClickingButton:
                startActivity(new Intent(ButtonActivity.this, DisableDoubleClickingButtonActivity.class));
                return true;
            case R.id.action_dynamicallyButton:
                startActivity(new Intent(ButtonActivity.this, DynamicButtonActivity.class));
                return true;
            case R.id.action_soundButton:
                startActivity(new Intent(ButtonActivity.this, SoundButtonActivity.class));
                return true;
            case R.id.action_prograButtonTint:
                startActivity(new Intent(ButtonActivity.this, ProgrammaticallyBtnTintActivity.class));
                return true;
            case R.id.action_toolbarButton:
                startActivity(new Intent(ButtonActivity.this, ToolbarBtnActivity.class));
                return true;
            case R.id.action_buttonStyle:
                startActivity(new Intent(ButtonActivity.this, BtnStyleActivity.class));
                return true;
            case R.id.action_refreshActivityButton:
                startActivity(new Intent(ButtonActivity.this, RefreshBtnActivity.class));
                return true;
            case R.id.action_displayBackbutton:
                startActivity(new Intent(ButtonActivity.this, DisplayBackBtnActivity.class));
                return true;
            case R.id.action_animateButton:
                startActivity(new Intent(ButtonActivity.this, AnimateBtnActivity.class));
                return true;
            case R.id.action_updatetextButton:
                startActivity(new Intent(ButtonActivity.this, UpdateBtnTextActivity.class));
                return true;
        }

        return true;
    }

}
