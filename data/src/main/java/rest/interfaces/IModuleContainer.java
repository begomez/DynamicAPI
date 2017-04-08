package rest.interfaces;

import rest.ModuleContainerEntry;
import rest.exceptions.ModuleNotFoundException;

/**
 * Created by bernatgomez on 7/4/17.
 */

public interface IModuleContainer {

    public static final String MODULE_GITHUB = "github";
    public static final String MODULE_ANOTHER = "another";

    public <T extends IModule>boolean registerModule(String name, ModuleContainerEntry<T> entry);

    public boolean unregisterModule(String name);

    public boolean isModuleRegistered(String name);

    public <T extends IModule>ModuleContainerEntry<T> getModuleByName(String name) throws ModuleNotFoundException;
}
