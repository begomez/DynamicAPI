package rest;

import com.squareup.otto.Bus;

import javax.inject.Inject;

import rest.exceptions.ModuleNotFoundException;
import rest.interfaces.IDataSource;
import rest.interfaces.IModule;
import rest.interfaces.IModuleContainer;
import retrofit2.Retrofit;

/**
 * Created by bernatgomez on 23/3/17.
 */

public class RestModuleDataSource implements IDataSource {

    private final Bus bus;

    private Retrofit retrofit;

    private GithubModuleImpl github;

    private ModuleContainer moduleContainer;


////////////////////////////////////////////////////////////////////////////////////
//  CONSTRUCTOR
////////////////////////////////////////////////////////////////////////////////////

    @Inject
    public RestModuleDataSource(Bus bus, Retrofit retrofit) {
        this.bus = bus;

        this.retrofit = retrofit;

        this.github = new GithubModuleImpl(bus, retrofit);

        this.moduleContainer = new ModuleContainer();

        this.fakeRegistration();
    }

    public void fakeRegistration() {
        this.moduleContainer.registerModule(IModuleContainer.MODULE_GITHUB, new ModuleContainerEntry(new GithubModuleImpl(bus, retrofit)));
        this.moduleContainer.registerModule(IModuleContainer.MODULE_ANOTHER, new ModuleContainerEntry(new AnotherModuleImpl(bus, retrofit)));
    }

    public void sampleCall() {
        //this.getModuleContainer().getModuleByName(IModuleContainer.MODULE_GITHUB).getEntry().getEntry()
        this.github.sampleCall("status:open");
    }



////////////////////////////////////////////////////////////////////////////////////
//  ACCESSORS
////////////////////////////////////////////////////////////////////////////////////

    public ModuleContainer getModuleContainer() {
        return moduleContainer;
    }

    public void setModuleContainer(ModuleContainer moduleContainer) {
        this.moduleContainer = moduleContainer;
    }



}
