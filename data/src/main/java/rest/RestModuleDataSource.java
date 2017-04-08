package rest;

import com.squareup.otto.Bus;

import javax.inject.Inject;

import rest.exceptions.ModuleNotFoundException;
import rest.interfaces.IDataSource;
import rest.modulecontainer.ModuleContainer;
import rest.modulecontainer.ModuleContainerEntry;
import rest.modulecontainer.interfaces.IModuleContainer;
import rest.modulecontainer.interfaces.IModuleContainerEntry;
import rest.modules.AnotherModuleImpl;
import rest.modules.GithubModuleImpl;
import retrofit2.Retrofit;

/**
 * Created by bernatgomez on 23/3/17.
 */

public class RestModuleDataSource implements IDataSource {

    private final Bus bus;

    private Retrofit retrofit;

    private IModuleContainer moduleContainer;


////////////////////////////////////////////////////////////////////////////////////
//  CONSTRUCTOR
////////////////////////////////////////////////////////////////////////////////////

    @Inject
    public RestModuleDataSource(Bus bus, Retrofit retrofit) {
        this.bus = bus;

        this.retrofit = retrofit;

        this.createModuleContainer();
    }

////////////////////////////////////////////////////////////////////////////////////
// IDATASOURCE IMPL
////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void createModuleContainer() {
        this.moduleContainer = new ModuleContainer();
    }

    @Override
    public <T>T getModule(String name) throws ModuleNotFoundException {

        try {
            return this.getModule(name, (Class<T>) Class.forName(GithubModuleImpl.class.getName()));

        } catch (ClassNotFoundException e) {
            throw new ModuleNotFoundException(name);
        }
    }

////////////////////////////////////////////////////////////////////////////////////
// HELPERS
////////////////////////////////////////////////////////////////////////////////////

    /**
     *
     * @param target Class to registerModule
     * @param instance Instance of the previous class
     * @param name Name used to retrieve instance
     * @param <T>
     */
    private <T>void registerModule(Class<T> target, T instance, String name) {
        IModuleContainerEntry api = new ModuleContainerEntry(target);

        api.set(target, instance);

        this.moduleContainer.registerEntry(name, api);
    }

    private <T>T getModule(String name, Class<T> target) throws ModuleNotFoundException {
        return this.moduleContainer.getEntryByName(name).get(target);
    }

    public void registerGithubModule() {
        this.registerModule(GithubModuleImpl.class, new GithubModuleImpl(this.bus, this.retrofit), IModuleContainer.MODULE_GITHUB);
    }

    public void registerAnotherModule() {
        this.registerModule(AnotherModuleImpl.class, new AnotherModuleImpl(this.bus, this.retrofit), IModuleContainer.MODULE_ANOTHER);
    }

////////////////////////////////////////////////////////////////////////////////////
//  ACCESSORS
////////////////////////////////////////////////////////////////////////////////////



}
