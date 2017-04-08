package rest.modulecontainer;

/**
 * Created by bernatgomez on 7/4/17.
 */

public class ModuleContainerEntry {

    public Class<?> type;

    public Object data;

    public ModuleContainerEntry(Class<?> type) {
        this.type = type;
        this.data = null;
    };

    public <T>void set(Class<T> param, T data) {
        this.type = param;
        this.data = param.cast(data);
    }

    public <T>T get(Class<T> param) {
        return param.cast(data);
    }

}
