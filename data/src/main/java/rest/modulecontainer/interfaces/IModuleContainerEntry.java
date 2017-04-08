package rest.modulecontainer.interfaces;

import rest.modules.interfaces.IModule;

/**
 * Created by bernatgomez on 7/4/17.
 */

public interface IModuleContainerEntry {
    public Class<?> getType();

    public <T> T get(Class<T> param);

    public <T> void set(Class<T> param, T data);
}