package apimodels;

/**
 * Created by bernatgomez on 31/3/17.
 */

public class ApiErrorModel extends ApiBaseModel {
    private int code;
    private String msg;


    public ApiErrorModel() {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
