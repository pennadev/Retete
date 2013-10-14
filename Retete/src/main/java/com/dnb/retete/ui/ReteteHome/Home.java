package com.dnb.retete.ui.ReteteHome;


import android.app.ActionBar;
import android.app.DialogFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.dnb.retete.R;
import com.dnb.retete.ui.DrawerStanga.DrawerBuilder;
import com.dnb.retete.ui.DrawerStanga.DrawerBuilderSelect;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by DnB on 10/14/13.
 */
public class Home extends SherlockFragmentActivity {

    private DrawerBuilder drawerBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createDrawerStanga();


        if (enableHomeIconActionBack() || enableHomeIconActionSlidingMenu()) {
            ActionBar actionBar = getActionBar();
            if (actionBar != null)
                actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu. This adds items to the action bar if it is present.
        getSupportMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (enableHomeIconActionSlidingMenu() && setSlidingMenu() != null) {
                    drawerBuilder.getSlidingMenu().toggle();
                } else if (enableHomeIconActionBack()) {
                    onCustomBackPressed();
                }
                return true;
            default:
            case R.id.goToWebsite:
                // When you press GitHub icon in the ActionBar
                Utile.goToSite(this);
                return true;
            case R.id.menu_about:
                // When you press information icon in the ActionBar
                DialogFragment dialogFragment = Alerte.newInstance(
                        R.drawable.ic_dialog_about,
                        getString(R.string.dialog_about_title),
                        Html.fromHtml(getString(R.string.dialog_about_message)),
                        getString(R.string.dialog_about_button_text));
                dialogFragment.show(getFragmentManager(),
                        Constante.DIALOG_FRAGMENT_TAG);
                break;
            case R.id.action_mail:
                // When you press email icon in the ActionBar
                final Intent email = new Intent(
                        android.content.Intent.ACTION_SENDTO);
                String uriText = null;
                try {
                    uriText = "mailto:"
                            + getString(R.string.contact_email)
                            + "?subject="
                            + URLEncoder.encode(
                            getString(R.string.contact_email_subject),
                            "UTF-8");
                } catch (UnsupportedEncodingException error1) {
                    Toast.makeText(this, R.string.toast_unsupported_encoding,
                            Toast.LENGTH_SHORT).show();
                    break;
                }

                email.setData(Uri.parse(uriText));
                try {
                    startActivity(email);
                } catch (Exception error2) {
                    Toast.makeText(this, R.string.toast_contact_no_email,
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    // We need to override default behavior of a device back button press if we
    // want to toggle sliding menu.
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                onCustomBackPressed();
                return true;
            default:
                return super.onKeyDown(keyCode, event);
        }
    }

    // If sliding menu is showing, we need to hide it on the first back button
    // press.
    private void onCustomBackPressed() {
        if (setSlidingMenu() != null
                && drawerBuilder.getSlidingMenu().isMenuShowing()) {
            drawerBuilder.getSlidingMenu().toggle();
        } else {
            this.onBackPressed();
        }
    }

    private void createDrawerStanga() {
        // If nothing is set, than sliding menu wont be created.
        if (setSlidingMenu() != null) {
            Class<?> builder = setSlidingMenu();
            try {
                // We use our made base builder to create a sliding menu.
                drawerBuilder = (DrawerBuilder) builder.newInstance();
                drawerBuilder.createDrawer(this);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public Class<?> setSlidingMenu() {
        // By default it is set not to create a sliding menu.
        return DrawerBuilderSelect.class;
    }

    /**
     * Sets activity home icon to have up icon and on press act as device back
     * button press.
     *
     * @return Activation state.
     */
    public boolean enableHomeIconActionBack() {
        return false;
    }

    /**
     * Sets activity home icon to be as a sliding menu invoke icon and on press
     * call toggle command for the sliding menu.
     *
     * @return Activation state.
     */
    public boolean enableHomeIconActionSlidingMenu() {
        return true;
    }
}
