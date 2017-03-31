package apimodels;

/**
 * Created by bernatgomez on 31/3/17.
 */

public class Sample extends ApiBaseModel {
    public Sample() {
        this.setSubject("");
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    private String subject = "";
}
