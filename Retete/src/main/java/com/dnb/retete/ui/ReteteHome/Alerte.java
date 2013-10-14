package com.dnb.retete.ui.ReteteHome;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by DnB on 10/14/13.
 */
public class Alerte extends DialogFragment{
    public static Alerte newInstance(int iconResourceId,
                                                  CharSequence titleText, CharSequence messageText,
                                                  CharSequence buttonText) {
        Alerte Alerte = new Alerte();
        Bundle arguments = new Bundle();
        arguments.putInt(Constante.ALERT_DIALOG_ICON_KEY, iconResourceId);
        arguments.putCharSequence(Constante.ALERT_DIALOG_TITLE_KEY, titleText);
        arguments.putCharSequence(Constante.ALERT_DIALOG_MESSAGE_KEY,
                messageText);
        arguments
                .putCharSequence(Constante.ALERT_DIALOG_BUTTON_KEY, buttonText);
        Alerte.setArguments(arguments);
        return Alerte;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // We always create dialog from stored arguments.
        // This allows us to avoid problems on device screen rotation.
        int iconResourceId = getArguments().getInt(
                Constante.ALERT_DIALOG_ICON_KEY);
        CharSequence titleText = getArguments().getCharSequence(
                Constante.ALERT_DIALOG_TITLE_KEY);
        CharSequence messageText = getArguments().getCharSequence(
                Constante.ALERT_DIALOG_MESSAGE_KEY);
        CharSequence buttonText = getArguments().getCharSequence(
                Constante.ALERT_DIALOG_BUTTON_KEY);

        return new AlertDialog.Builder(getActivity())
                .setIcon(iconResourceId)
                .setTitle(titleText)
                .setMessage(messageText)
                .setPositiveButton(buttonText,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                            }
                        }).create();
    }
}
