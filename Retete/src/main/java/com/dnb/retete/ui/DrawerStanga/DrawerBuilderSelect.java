package com.dnb.retete.ui.DrawerStanga;

import android.widget.Toast;

import com.dnb.retete.R;

/**
 * Created by DnB on 10/14/13.
 */
public class DrawerBuilderSelect extends DrawerBuilder {

    @Override
    public void onListItemClick(DrawerStangaList selectedDrawer) {
        switch (selectedDrawer.Id) {
            case R.string.list_item_angry_id:
                menu.toggle();

                CharSequence text = "Clicked item �"
                        + activity.getString(R.string.list_item_angry_label)
                        + "�. "
                        + activity.getString(R.string.toast_sliding_menu_toggle);
                Toast.makeText(activity, text, Toast.LENGTH_LONG).show();

                return;
        }
        super.onListItemClick(selectedDrawer);
    }
}
