package com.cipolat.news;

import android.app.Application;
import android.support.compat.BuildConfig;
import com.facebook.stetho.Stetho;

/**
 * Created by sebastian on 23/07/17.
 */

public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();


            Stetho.initialize(
                    Stetho.newInitializerBuilder(this)
                            .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                            .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                            .build());

    }
}