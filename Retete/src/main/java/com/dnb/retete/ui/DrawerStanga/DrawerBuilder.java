package com.dnb.retete.ui.DrawerStanga;


import android.app.Activity;
import android.widget.Toast;

import com.dnb.retete.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public abstract class DrawerBuilder {
    protected Activity activity;
    protected SlidingMenu menu = null;


    public void createDrawer(Activity activity){

        this.activity = activity;
        menu = new SlidingMenu(activity);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.sliding_menu_shadow_width);
        menu.setShadowDrawable(R.drawable.sliding_menu_shadow);
        menu.setBehindOffsetRes(R.dimen.sliding_menu_offset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(activity, SlidingMenu.SLIDING_WINDOW);
        menu.setMenu(R.layout.drawerframe);

        DrawerFragment drawerFragment = new DrawerFragment();
        drawerFragment.setMenuBuilder(this);

        activity.getFragmentManager().beginTransaction()
                .replace(R.id.drawerFrame, drawerFragment)
                .commit();
    }

    public SlidingMenu getSlidingMenu() {
        return menu;
    }

    public void onListItemClick(DrawerStangaList selectedSlidingMenuListItem) {
        CharSequence text;
        switch (selectedSlidingMenuListItem.Id) {
            case R.string.list_item_angry_id:
                text = "Clicked item "
                        + selectedSlidingMenuListItem.Name
                        + ". "
                        + activity
                        .getString(R.string.toast_sliding_menu_custom_action);
                Toast.makeText(activity, text, Toast.LENGTH_LONG).show();
                break;
        }
    }


}



