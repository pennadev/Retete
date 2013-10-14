package com.dnb.retete.ui.DrawerStanga;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dnb.retete.R;
import com.dnb.retete.ui.ReteteHome.DrawerList;

import java.util.List;

public class DrawerFragment extends ListFragment {
    protected List<DrawerStangaList> drawerList;
    private DrawerBuilder drawerBuilder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // We set here a custom layout which uses holo light theme colors.
        return inflater.inflate(R.layout.drawerlist, null);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        drawerList = DrawerList.getSlidingMenu(getActivity());
        if (drawerList == null)
            return;
        DrawerStangaListAdapter adapter = new DrawerStangaListAdapter(
            getActivity(), R.layout.drawerrow, drawerList);
            setListAdapter(adapter);
        }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        l.setSelection(position);
        DrawerStangaList item = drawerList.get(position);
        drawerBuilder.onListItemClick(item);
    }

    // We can not provide a builder as an argument inside a fragment
    // constructor, so that is why we have separate method for that.
    public void setMenuBuilder(DrawerBuilder drawerBuilder) {
        this.drawerBuilder = drawerBuilder;
    }
}
