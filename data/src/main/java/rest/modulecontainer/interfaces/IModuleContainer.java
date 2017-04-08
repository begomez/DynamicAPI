package rest.modulecontainer.interfaces;

import rest.modulecontainer.ModuleContainerEntry;
import rest.exceptions.ModuleNotFoundException;

/**
 * Created by bernatgomez on 7/4/17.
 */

public interface IModuleContainer {
    public static final String MODULE_GITHUB = "github";


    public boolean registerEntry(String name, IModuleContainerEntry entry);

    public boolean unregisterEntry(String name);

    public boolean isModuleRegistered(String name);

    public IModuleContainerEntry getEntryByName(String name) throws ModuleNotFoundException;
}
