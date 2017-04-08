package rest;

import rest.interfaces.IModule;
import rest.interfaces.IModuleContainer;
import rest.interfaces.IModuleContainerEntry;

/**
 * Created by bernatgomez on 7/4/17.
 */

public class ModuleContainerEntry<T extends IModule> implements IModuleContainerEntry<T> {

    public T getEntry() {
        return entry;
    }

    protected T entry;

    public ModuleContainerEntry(T entry) {
        this.entry = entry;
    }


}
