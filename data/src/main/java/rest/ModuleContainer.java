package rest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bernatgomez on 23/3/17.
 */

public class ModuleContainer {

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

    public boolean unregisterEntry(String name) {
        this.map.remove(name);

        return true;
    }

    public boolean isModuleRegistered(String name) {
        return this.map.containsKey(name) && this.map.get(name) != null;
    }

    public ModuleContainerEntry getEntryByName(String name) {

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
