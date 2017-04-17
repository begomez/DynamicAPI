package rest.interfaces;


import java.util.Set;

import rest.exceptions.ModuleNotFoundException;


/**
 * Created by bernatgomez on 23/3/17.
 */
public interface IDataSource {

    /**
     *
     */
    public void createModuleContainer();

    /**
     *
     * @param name
     * @param <T>
     * @return
     * @throws ModuleNotFoundException
     */
    public <T> T getModule(String name) throws ModuleNotFoundException;

    /**
     *
     * @return
     */
    public Set<String> getAvailableModules();
}
