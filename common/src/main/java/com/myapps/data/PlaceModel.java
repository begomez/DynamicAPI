package com.myapps.data;

/**
 * Created by bernatgomez on 20/4/17.
 */

public class PlaceModel extends BaseModel {

    private int type;
    private String title;
    private String subtitle;
    private String descrip;

    public PlaceModel() {
        this.setType(0);
        this.setTitle("");
        this.setSubtitle("");
        this.setDescrip("");
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

}
