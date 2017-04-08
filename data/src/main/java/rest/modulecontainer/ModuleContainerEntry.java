package rest.modulecontainer;

import rest.modulecontainer.interfaces.IModuleContainerEntry;

/**
 * Created by bernatgomez on 7/4/17.
 */

public class ModuleContainerEntry implements IModuleContainerEntry {

    public Class<?> getType() {
        return type;
    }

    public Class<?> type;

    public Object data;

    public ModuleContainerEntry(Class<?> type) {
        this.type = type;
        this.data = null;
    }

/////////////////////////////////////////////////////////////////////////////
//
/////////////////////////////////////////////////////////////////////////////

    @Override
    public <T>void set(Class<T> param, T data) {
        this.type = param;
        this.data = param.cast(data);
    }

    @Override
    public <T>T get(Class<T> param) {
        return param.cast(data);
    }

}
