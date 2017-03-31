package apimodels;

/**
 * Created by bernatgomez on 23/3/17.
 */

public class ApiSessionModel extends ApiBaseModel {
    private String user;
    private String pass;


    public ApiSessionModel() {
        super();
    }

    public ApiSessionModel(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApiSessionModel)) return false;

        ApiSessionModel that = (ApiSessionModel) o;

        if (!user.equals(that.user)) return false;
        return pass.equals(that.pass);
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + pass.hashCode();
        return result;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
