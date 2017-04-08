package rest.interfaces;


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
     * @param target
     * @param instance
     * @param name
     * @param <T>
     */
    public <T> void registerModule(Class<T> target, T instance, String name);

    /**
     *
     * @param name
     * @param target
     * @param <T>
     * @return
     * @throws ModuleNotFoundException
     */
    public <T> T getModule(String name, Class<T> target) throws ModuleNotFoundException;

}