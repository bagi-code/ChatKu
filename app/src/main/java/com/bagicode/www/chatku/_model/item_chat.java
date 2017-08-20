package com.bagicode.www.chatku._model;

/**
 * Created by robbydianputra on 4/17/17.
 */

public class item_chat {

    private boolean status;
    private String message;
    private String title;
    private String create_by;
    private String id_kategori;


    public static final String id_users = "ID_USER";

    public item_chat() {
    }

    public item_chat(boolean status, String message, String title, String create_by, String id_kategori) {
        this.status = status;
        this.message = message;
        this.title = title;
        this.create_by = create_by;
        this.id_kategori = id_kategori;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus (boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getCreateBy() {
        return create_by;
    }

    public void setCreateBy(String by) {
        this.create_by = by;
    }

    public String getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(String id_kategori) {
        this.id_kategori = id_kategori;
    }
}