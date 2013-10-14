package com.dnb.retete.ui.ReteteHome;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.dnb.retete.R;

/**
 * Created by DnB on 10/14/13.
 */
public class Utile {
    public static void goToSite(Context context) {
        // Opens Internet browser to show source code of this application in the GitHub
        Uri uriUrl = Uri.parse(context
                .getString(R.string.source_code_repository_link));
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        context.startActivity(launchBrowser);
    }
}
