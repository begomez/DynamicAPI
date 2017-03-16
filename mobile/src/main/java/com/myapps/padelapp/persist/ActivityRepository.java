package com.myapps.padelapp.persist;

import android.app.Activity;

import com.myapps.padelapp.persist.interfaces.IRepository;
import com.myapps.padelapp.utils.AndroidLoggerUtils;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by bernatgomez on 9/3/17.
 */

public class ActivityRepository implements IRepository {

    private static final String TAG = ActivityRepository.class.getSimpleName();

    private static ActivityRepository instance = null;

    private ArrayList<WeakReference<Activity>> list = null;

    private ActivityRepository() {
        this.init();
    }

    private void init() {
        this.list = new ArrayList<WeakReference<Activity>>();
    }

    public boolean add(Activity activ) {
        try {

            this.list.add(new WeakReference<Activity>(activ));

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean remove(Activity activ) {
        try {
            for (Iterator<WeakReference<Activity>> it = this.list.iterator(); it.hasNext(); ) {
                Activity current = it.next().get();

                if (this.isValidActiv(current)) {
                    if (current.getClass() == activ.getClass()) {
                        it.remove();

                        return true;
                    }
                }
            }

            return false;

        } catch (Exception e) {
            return false;
        }
    }

    public void dump() {
        for (WeakReference<Activity> ref : this.list) {
            Activity activ = ref.get();

            if (this.isValidActiv(activ)) {
                AndroidLoggerUtils.logMsg(TAG, activ.getClass().getSimpleName());
            }
        }
    }

    public boolean isValidActiv(Activity activ) {
        return activ != null;
    }

    public boolean isForeground() {
        return this.list.size() > 0;
    }

    public static ActivityRepository getInstance() {
        if (ActivityRepository.instance == null) {
            ActivityRepository.instance = new ActivityRepository();
        }

        return ActivityRepository.instance;
    }

/////////////////////////////////////////////////////////////////////////////////////////
// IREPOSITORY
/////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void cleanUp() {
        this.list.clear();
    }
}
