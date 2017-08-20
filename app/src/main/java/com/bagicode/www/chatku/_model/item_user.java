package com.bagicode.www.chatku._model;

/**
 * Created by robbydianputra on 4/17/17.
 */

public class item_user {
    private String title;
    private int icons;

    public item_user() {
    }

    public item_user(String title, int icons) {
        this.title = title;
        this.icons = icons;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public int getIcons() {
        return icons;
    }

    public void setIcons(int icons) {
        this.icons = icons;
    }
}