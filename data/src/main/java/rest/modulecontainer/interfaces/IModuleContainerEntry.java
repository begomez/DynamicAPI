package rest.modulecontainer.interfaces;

import rest.modules.interfaces.IModule;

/**
 * Created by bernatgomez on 7/4/17.
 */

public interface IModuleContainerEntry<T extends IModule> {
    public T getEntry();

    public void setEntry(T entry);
}
