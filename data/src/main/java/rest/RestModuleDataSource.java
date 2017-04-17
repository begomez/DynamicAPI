package rest;

import com.myapps.data.KeyValue;
import com.myapps.parsers.ModuleListParser;
import com.myapps.utils.LoggerUtils;
import com.squareup.otto.Bus;

import java.util.ArrayList;
import java.util.Set;

import javax.inject.Inject;

import rest.exceptions.ModuleNotFoundException;
import rest.interfaces.IDataSource;
import rest.modulecontainer.ModuleContainer;
import rest.modulecontainer.ModuleContainerEntry;
import rest.modulecontainer.interfaces.IModuleContainer;
import rest.modulecontainer.interfaces.IModuleContainerEntry;
import rest.modules.GithubModuleImpl;
import retrofit2.Retrofit;

/**
 * Created by bernatgomez on 23/3/17.
 */

public class RestModuleDataSource implements IDataSource {

    private static final String TAG = RestModuleDataSource.class.getSimpleName();

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

            // GITHUB
            if (name.equals(IModuleContainer.MODULE_GITHUB)) {
                return this.getModule(name, (Class<T>) Class.forName(GithubModuleImpl.class.getName()));

            } else {
                throw new ModuleNotFoundException(name);
            }

        } catch (ClassNotFoundException e) {
            throw new ModuleNotFoundException(name);
        }
    }

    @Override
    public Set<String> getAvailableModules() {
        return this.moduleContainer.getEntries();
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

        api.setEntryData(target, instance);

        this.moduleContainer.registerEntry(name, api);
    }

    /**
     * 
     * @param name
     * @param target
     * @param <T>
     * @return
     * @throws ModuleNotFoundException
     */
    private <T>T getModule(String name, Class<T> target) throws ModuleNotFoundException {
        return this.moduleContainer.getEntryByName(name).getEntryData(target);
    }

////////////////////////////////////////////////////////////////////////////////////
// PUBLIC API
////////////////////////////////////////////////////////////////////////////////////


    public void registerModules() {

        try {
            ArrayList<KeyValue<String, String>> modules = ModuleListParser.readModulesFile("modules.list");

            for (KeyValue<String, String> module : modules) {
                Class someClass = Class.forName(module.getValue());

                this.registerModule(
                    someClass,
                    someClass.getConstructor(Bus.class, Retrofit.class).newInstance(this.bus, this.retrofit),
                    module.getKey());
            }

        } catch (Exception e) {
            LoggerUtils.logMsg(TAG, "error : " + e.toString());

        }

    }
}
