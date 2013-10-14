package com.dnb.retete.ui.DrawerStanga;

/**
 * Created by DnB on 10/14/13.
 */
public class DrawerStangaList {
    public int Id;
    public String Name;
    public String IconResourceId;
    public String Count;

    public DrawerStangaList() {
    }

    public DrawerStangaList(int id, String name, String iconResourceId, String count) {
        this.Id = id;
        this.Name = name;
        this.IconResourceId = iconResourceId;
        this.Count = count;
    }
}

