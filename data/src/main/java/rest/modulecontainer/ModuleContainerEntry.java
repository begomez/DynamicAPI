package rest.modulecontainer;

import rest.modulecontainer.interfaces.IModuleContainerEntry;

/**
 * Created by bernatgomez on 7/4/17.
 */

public class ModuleContainerEntry implements IModuleContainerEntry {

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
    public <T>void setEntryData(Class<T> param, T data) {
        this.type = param;
        this.data = param.cast(data);
    }

    @Override
    public <T>T getEntryData(Class<T> param) {
        return param.cast(this.data);
    }

}
