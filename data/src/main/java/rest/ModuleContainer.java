package rest;

import java.util.HashMap;
import java.util.Map;

import rest.exceptions.ModuleNotFoundException;
import rest.interfaces.IModule;
import rest.interfaces.IModuleContainer;

/**
 * Created by bernatgomez on 23/3/17.
 */

public class ModuleContainer implements IModuleContainer {

    private Map<String, ModuleContainerEntry> map;

    public ModuleContainer() {
        this.createMap();
    }
    private void createMap() {
        this.map = new HashMap<>();
    }

////////////////////////////////////////////////////////////////////////////////////
// HELPERS
////////////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////////////////////////
// IMODULE IMPL
////////////////////////////////////////////////////////////////////////////////////

    @Override
    public <T extends IModule>boolean registerModule(String name, ModuleContainerEntry<T> entry) {

        // ALREADY REG
        if (this.isModuleRegistered(name)) {
            return true;

        // NOT REG
        } else {
            this.map.put(name, entry);

            return true;
        }
    }

    @Override
    public boolean unregisterModule(String name) {
        this.map.remove(name);

        return true;
    }

    @Override
    public boolean isModuleRegistered(String name) {
        return this.map.containsKey(name) && this.map.get(name) != null;
    }

    @Override
    public <T extends IModule>ModuleContainerEntry<T> getModuleByName(String name) throws ModuleNotFoundException {

        return this.map.get(name);
        /*
        for (Map.Entry<String, T> entry : this.map.entrySet()) {
            if (entry.getKey().equals(name)) {
                return entry.getValue();
            }
        }
        throw new ModuleNotFoundException(name);
        */
    }
}
