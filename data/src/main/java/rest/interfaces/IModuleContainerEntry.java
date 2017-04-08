package rest.interfaces;

/**
 * Created by bernatgomez on 7/4/17.
 */

public interface IModuleContainerEntry<T extends IModule> {
    public T getEntry();

    public void setEntry(T entry);
}
