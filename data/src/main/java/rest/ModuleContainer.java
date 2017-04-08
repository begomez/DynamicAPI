package rest;

import java.util.HashMap;
import java.util.Map;

import rest.interfaces.IModuleContainer;
import rest.interfaces.IModuleContainerEntry;

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
    public boolean registerEntry(String name, ModuleContainerEntry entry) {

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
    public boolean unregisterEntry(String name) {
        this.map.remove(name);

        return true;
    }

    @Override
    public boolean isModuleRegistered(String name) {
        return this.map.containsKey(name) && this.map.get(name) != null;
    }

    @Override
    public ModuleContainerEntry getEntryByName(String name) {
        return this.map.get(name);
    }
}
