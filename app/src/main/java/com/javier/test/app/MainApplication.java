package com.javier.test.app;

import org.androidtransfuse.annotations.*;
import android.content.res.Configuration;


@Application(label = "@string/app_name", icon = "@drawable/ic_launcher")
public class MainApplication {
    private boolean onCreate;
    private boolean onLowMemory;
    private boolean onTerminate;
    private Configuration config;

    @OnCreate
    public void onCreate() {
        onCreate = true;
    }

    @OnLowMemory
    public void onLowMemory() {
        onLowMemory = true;
    }

    @OnTerminate
    public void onTerminate() {
        onTerminate = true;
    }

    @OnConfigurationChanged
    public void onConfigurationChanged(Configuration config) {
        this.config = config;
    }
    public boolean isOnCreate() {
        return onCreate;
    }

    public boolean isOnLowMemory() {
        return onLowMemory;
    }

    public boolean isOnTerminate() {
        return onTerminate;
    }
    public Configuration getOnConfigurationChanged() {
        return config;
    }
}
