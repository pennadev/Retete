package com.dnb.retete.ui.DrawerStanga;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dnb.retete.R;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by DnB on 10/14/13.
 */
public class DrawerStangaListAdapter extends ArrayAdapter<DrawerStangaList> {
    private Context context;
    private int rowViewResourceId;
    private List<DrawerStangaList> drawerStangaItemList = new ArrayList<DrawerStangaList>();

    private ImageView drawerStangaItemICOANA;
    private TextView drawerStangaItemNUME;
    private TextView drawerStangaItemCOUNT;

    public DrawerStangaListAdapter(Context context, int rowViewResourceId,
                                  List<DrawerStangaList> objects) {
        super(context, rowViewResourceId, objects);
        this.context = context;
        this.rowViewResourceId = rowViewResourceId;
        this.drawerStangaItemList = objects;
    }

    public int getCount() {
        return this.drawerStangaItemList.size();
    }

    public DrawerStangaList getItem(int index) {
        return this.drawerStangaItemList.get(index);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(rowViewResourceId, parent,
                    false);
        }

        DrawerStangaList slidingMenuListItem = getItem(position);

        drawerStangaItemICOANA = (ImageView) row.findViewById(R.id.row_icon);
        drawerStangaItemNUME = (TextView) row.findViewById(R.id.row_title);
        drawerStangaItemCOUNT = (TextView) row.findViewById(R.id.row_count);

        drawerStangaItemNUME.setText(slidingMenuListItem.Name);
        drawerStangaItemCOUNT.setText(slidingMenuListItem.Count);

        int imageResource = context.getResources().getIdentifier(
                slidingMenuListItem.IconResourceId, null,
                context.getPackageName());

        drawerStangaItemICOANA.setImageResource(imageResource);

        return row;
    }
}

