package com.hmelizarraraz.marvelheroesv2.application;

import android.app.Application;
import android.util.Log;

import com.hmelizarraraz.marvelheroesv2.application.builder.AppComponent;
import com.hmelizarraraz.marvelheroesv2.application.builder.AppContextModule;
import com.hmelizarraraz.marvelheroesv2.application.builder.DaggerAppComponent;
import com.squareup.leakcanary.LeakCanary;

import timber.log.BuildConfig;
import timber.log.Timber;

public class AppController extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeLogger();
        initAppComponent();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent
                .builder()
                .appContextModule(new AppContextModule(this))
                .build();
    }

    private void initializeLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new Timber.Tree() {
                @Override
                protected void log(int priority, String tag, String message, Throwable t) {
                    Log.d(tag, message, t);
                }
            });
        }
    }

    public static AppComponent getNetComponent() {
        return appComponent;
    }
}
