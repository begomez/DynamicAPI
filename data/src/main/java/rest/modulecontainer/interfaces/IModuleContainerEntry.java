package rest.modulecontainer.interfaces;

import rest.modules.interfaces.IModule;

/**
 * Created by bernatgomez on 7/4/17.
 */

public interface IModuleContainerEntry {
    public <T> T getEntryData(Class<T> param);

    public <T> void setEntryData(Class<T> param, T data);
}