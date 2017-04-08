package rest;

import com.squareup.otto.Bus;

import javax.inject.Inject;

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

////////////////////////////////////////////////////////////////////////////////////
// PUBLIC API
////////////////////////////////////////////////////////////////////////////////////

    public void registerGithubModule() {
        this.register(GithubModuleImpl.class, new GithubModuleImpl(this.bus, this.retrofit), IModuleContainer.MODULE_GITHUB);

        /*
        IModuleContainerEntry githubApi = new ModuleContainerEntry(GithubModuleImpl.class);

        githubApi.set(GithubModuleImpl.class, new GithubModuleImpl(this.bus, this.retrofit));

        this.moduleContainer.registerEntry(IModuleContainer.MODULE_GITHUB, githubApi);
        */
    }

    public void registerAnotherModule() {
        this.register(AnotherModuleImpl.class, new AnotherModuleImpl(this.bus, this.retrofit), IModuleContainer.MODULE_ANOTHER);

        /*
        IModuleContainerEntry anotherApi = new ModuleContainerEntry(AnotherModuleImpl.class);

        anotherApi.set(AnotherModuleImpl.class, new AnotherModuleImpl(this.bus, this.retrofit));

        this.moduleContainer.registerEntry(IModuleContainer.MODULE_ANOTHER, anotherApi);
        */
    }

    /**
     *
     * @param target Class to register
     * @param instance Instance of the previous class
     * @param name Name used to retrieve instance
     * @param <T>
     */
    private <T>void register(Class<T> target, T instance, String name) {
        IModuleContainerEntry api = new ModuleContainerEntry(target);

        api.set(target, instance);

        this.moduleContainer.registerEntry(name, api);
    }


    public void sampleCall() {
        try {

            this.moduleContainer.getEntryByName("github").get(GithubModuleImpl.class).sampleCall("status:open");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



////////////////////////////////////////////////////////////////////////////////////
//  ACCESSORS
////////////////////////////////////////////////////////////////////////////////////



}
