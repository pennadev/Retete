package com.dnb.retete.ui.ReteteHome;

import android.app.Activity;

import com.dnb.retete.R;
import com.dnb.retete.ui.DrawerStanga.DrawerStangaList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DnB on 10/14/13.
 */
public class DrawerList {
    public static final List<DrawerStangaList> getSlidingMenu(
            Activity activity) {

        List<DrawerStangaList> list = new ArrayList<DrawerStangaList>();

        list.add(new DrawerStangaList(R.string.list_item_angry_id,
                activity.getResources().getString(
                        R.string.list_item_angry_label), activity
                .getResources().getString(
                        R.string.list_item_angry_icon), activity
                .getResources().getString(
                        R.string.list_item_angry_count)));

        list.add(new DrawerStangaList(R.string.list_item_basic_id,
                activity.getResources().getString(
                        R.string.list_item_basic_label), activity
                .getResources().getString(
                        R.string.list_item_basic_icon), activity
                .getResources().getString(
                        R.string.list_item_basic_count)));

        list.add(new DrawerStangaList(R.string.list_item_cool_id,
                activity.getResources().getString(
                        R.string.list_item_cool_label), activity
                .getResources().getString(
                        R.string.list_item_cool_icon), activity
                .getResources().getString(
                        R.string.list_item_cool_count)));

        list.add(new DrawerStangaList(R.string.list_item_cry_id,
                activity.getResources().getString(
                        R.string.list_item_cry_label), activity
                .getResources().getString(
                        R.string.list_item_cry_icon), activity
                .getResources().getString(
                        R.string.list_item_cry_count)));

        list.add(new DrawerStangaList(R.string.list_item_err_id,
                activity.getResources().getString(
                        R.string.list_item_err_label), activity
                .getResources().getString(
                        R.string.list_item_err_icon), activity
                .getResources().getString(
                        R.string.list_item_err_count)));

        list.add(new DrawerStangaList(R.string.list_item_evil_id,
                activity.getResources().getString(
                        R.string.list_item_evil_label), activity
                .getResources().getString(
                        R.string.list_item_evil_icon), activity
                .getResources().getString(
                        R.string.list_item_evil_count)));

        list.add(new DrawerStangaList(R.string.list_item_kiss_id,
                activity.getResources().getString(
                        R.string.list_item_kiss_label), activity
                .getResources().getString(
                        R.string.list_item_kiss_icon), activity
                .getResources().getString(
                        R.string.list_item_kiss_count)));

        list.add(new DrawerStangaList(R.string.list_item_laugh_id,
                activity.getResources().getString(
                        R.string.list_item_laugh_label), activity
                .getResources().getString(
                        R.string.list_item_laugh_icon), activity
                .getResources().getString(
                        R.string.list_item_laugh_count)));

        list.add(new DrawerStangaList(R.string.list_item_shame_id,
                activity.getResources().getString(
                        R.string.list_item_shame_label), activity
                .getResources().getString(
                        R.string.list_item_shame_icon), activity
                .getResources().getString(
                        R.string.list_item_shame_count)));

        list.add(new DrawerStangaList(R.string.list_item_tongue_id,
                activity.getResources().getString(
                        R.string.list_item_tongue_label), activity
                .getResources().getString(
                        R.string.list_item_tongue_icon), activity
                .getResources().getString(
                        R.string.list_item_tongue_count)));

        list.add(new DrawerStangaList(R.string.list_item_wink_id,
                activity.getResources().getString(
                        R.string.list_item_wink_label), activity
                .getResources().getString(
                        R.string.list_item_wink_icon), activity
                .getResources().getString(
                        R.string.list_item_wink_count)));

        list.add(new DrawerStangaList(R.string.list_item_wonder_id,
                activity.getResources().getString(
                        R.string.list_item_wonder_label), activity
                .getResources().getString(
                        R.string.list_item_wonder_icon), activity
                .getResources().getString(
                        R.string.list_item_wonder_count)));

        return list;
    }
}
