package com.bluapp.androidview.EditText;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.bluapp.androidview.R;

public class EditTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();inflater.inflate(R.menu.edittext_option, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.action_edittextcursorcolor:
                startActivity(new Intent(EditTextActivity.this, EditTextCursorColorActivity.class));
                return true;
            case R.id.action_edittextcursoronend:
                startActivity(new Intent(EditTextActivity.this, EditTextCursorOnEndActivity.class));
                return true;
            case R.id.action_limittextofedittext:
                startActivity(new Intent(EditTextActivity.this, LimitTextOfEditTextActivity.class));
                return true;
            case R.id.action_hideedittextunderlineborder:
                startActivity(new Intent(EditTextActivity.this, HideEditTextUnderlineBorderActivity.class));
                return true;
            case R.id.action_edittextunderlinebordercolor:
                startActivity(new Intent(EditTextActivity.this, EditTextUnderlineBorderColorActivity.class));
                return true;
            case R.id.action_edittextunderlineborder:
                startActivity(new Intent(EditTextActivity.this, EditTextUnderlineBorderActivity.class));
                return true;
            case R.id.action_edittextcapfirstletter:
                startActivity(new Intent(EditTextActivity.this, EditTextCapFirstLetterActivity.class));
                return true;
            case R.id.action_textcolorofedittext:
                startActivity(new Intent(EditTextActivity.this, TextColorOfEditTextActivity.class));
                return true;
            case R.id.action_edittextbackgroundcolor:
                startActivity(new Intent(EditTextActivity.this, EditTextBackgroundColorActivity.class));
                return true;
            case R.id.action_edittextsingleline:
                startActivity(new Intent(EditTextActivity.this, EditTextSingleLineActivity.class));
                return true;
            case R.id.action_edittexthint:
                startActivity(new Intent(EditTextActivity.this, EditTextHintActivity.class));
                return true;
            case R.id.action_edittexthintcolor:
                startActivity(new Intent(EditTextActivity.this, EditTextHintColorActivity.class));
                return true;
            case R.id.action_edittextsetfocus:
                startActivity(new Intent(EditTextActivity.this, EditTextSetFocusActivity.class));
                return true;
            case R.id.action_edittextdatepicker:
                startActivity(new Intent(EditTextActivity.this, EditTextDatePickerActivity.class));
                return true;
            case R.id.action_programinputtype:
                startActivity(new Intent(EditTextActivity.this, ProgrammaticallyInputTypeActivity.class));
                return true;
            case R.id.action_multilineedittext:
                startActivity(new Intent(EditTextActivity.this, MultiLineEditTextActivity.class));
                return true;
            case R.id.action_programdisableedittext:
                startActivity(new Intent(EditTextActivity.this, ProgrammaticallyDisableEditTextActivity.class));
                return true;
            case R.id.action_edittextinputvalue:
                startActivity(new Intent(EditTextActivity.this, EditTextGetInputValueActivity.class));
                return true;
            case R.id.action_edittextprogrammatically:
                startActivity(new Intent(EditTextActivity.this, EditTextProgrammaticallyActivity.class));
                return true;
            case R.id.action_validateedittext:
                startActivity(new Intent(EditTextActivity.this, ValidateEditTextActivity.class));
                return true;
            case R.id.action_copyedittext:
                startActivity(new Intent(EditTextActivity.this, CopyEditTextActivity.class));
                return true;
            case R.id.action_clearedittext:
                startActivity(new Intent(EditTextActivity.this, ClearEditTextActivity.class));
                return true;
            case R.id.action_alertdialogedittext:
                startActivity(new Intent(EditTextActivity.this, AlertDialogEditTextActivity.class));
                return true;
            case R.id.action_roundedcorneredittext:
                startActivity(new Intent(EditTextActivity.this, RoundedCornerEditTextActivity.class));
                return true;
            case R.id.action_shadowedittext:
                startActivity(new Intent(EditTextActivity.this, ShadowEditTextActivity.class));
                return true;
            case R.id.action_disableedittext:
                startActivity(new Intent(EditTextActivity.this, DisableEditTextActivity.class));
                return true;
            case R.id.action_disablesuggestionedittext:
                startActivity(new Intent(EditTextActivity.this, DisableSuggestionEditTextActivity.class));
                return true;
            case R.id.action_onclickedittext:
                startActivity(new Intent(EditTextActivity.this, OnClickEditTextActivity.class));
                return true;
            case R.id.action_textwatcheredittext:
                startActivity(new Intent(EditTextActivity.this, TextWatcherEditTextActivity.class));
                return true;
            case R.id.action_onfocuschangelistneredittext:
                startActivity(new Intent(EditTextActivity.this, OnFocusChangeListnerEditTextActivity.class));
                return true;
            case R.id.action_oneditoractionlistneredittext:
                startActivity(new Intent(EditTextActivity.this, OnEditorActionListnerEditTextActivity.class));
                return true;
            case R.id.action_disableedittextcursor:
                startActivity(new Intent(EditTextActivity.this, DisableEditTextCursorActivity.class));
                return true;
            case R.id.action_emptyedittextcheck:
                startActivity(new Intent(EditTextActivity.this, EmptyEditTextCheckActivity.class));
                return true;
            case R.id.action_edittextwithicon:
                startActivity(new Intent(EditTextActivity.this, EditTextWithIconActivity.class));
                return true;
            case R.id.action_edittextdrawableclick:
                startActivity(new Intent(EditTextActivity.this, EditTextDrawableClickActivity.class));
                return true;
            case R.id.action_numericedittext:
                startActivity(new Intent(EditTextActivity.this, NumericEditTextActivity.class));
                return true;
            case R.id.action_getedittextint:
                startActivity(new Intent(EditTextActivity.this, GetEditTextIntActivity.class));
                return true;
            case R.id.action_floatinglabelcolor:
                startActivity(new Intent(EditTextActivity.this, FloatingLabelColorActivity.class));
                return true;
            case R.id.action_disableanimate:
                startActivity(new Intent(EditTextActivity.this, DisableAnimateActivity.class));
                return true;
            case R.id.action_lefticon:
                startActivity(new Intent(EditTextActivity.this, LeftIconActivity.class));
                return true;
            case R.id.action_programmaticallyaccent:
                startActivity(new Intent(EditTextActivity.this, ProgrammaticallyAccentActivity.class));
                return true;
            case R.id.action_aligntextinputlayouterror:
                startActivity(new Intent(EditTextActivity.this, AlignTextInputLayoutErrorActivity.class));
                return true;
            case R.id.action_asteriskredtextinputlayout:
                startActivity(new Intent(EditTextActivity.this, AsteriskRedTextInputLayoutActivity.class));
                return true;
        }

        return true;
    }

}
