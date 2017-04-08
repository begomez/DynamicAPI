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

        this.moduleContainer = new ModuleContainer();

    }

    public void fakeRegistration2() {
        IModuleContainerEntry entry = new ModuleContainerEntry(GithubModuleImpl.class);

        IModuleContainerEntry entry2 = new ModuleContainerEntry(AnotherModuleImpl.class);

        entry.set(GithubModuleImpl.class, new GithubModuleImpl(bus, retrofit));

        entry2.set(AnotherModuleImpl.class, new AnotherModuleImpl(bus, retrofit));

        this.moduleContainer.registerEntry("github", entry);

        this.moduleContainer.registerEntry("another", entry2);
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
