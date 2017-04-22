package apimodels;

/**
 * Created by bernatgomez on 20/4/17.
 */

public class PlaceByName extends ApiBaseModel {

    public PlaceByName() {
        this.setIconType(0);
        this.setTitle("");
        this.setSubtitle("");
        this.setDescrip("");
    }

    public int getIconType() {
        return iconType;
    }

    public void setIconType(int iconType) {
        this.iconType = iconType;
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

    private int iconType;
    private String title;
    private String subtitle;
    private String descrip;
}
