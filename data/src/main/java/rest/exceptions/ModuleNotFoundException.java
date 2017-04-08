package rest.exceptions;

import com.myapps.exceptions.BaseException;

/**
 * Created by bernatgomez on 7/4/17.
 */

public class ModuleNotFoundException extends BaseException {

    private String moduleName;


    public ModuleNotFoundException(String name) {
        super(name);

        this.moduleName = name;
    }

    @Override
    public String getMessage() {
        super.getMessage();

        return "Module not found: " + this.moduleName;
    }
}
