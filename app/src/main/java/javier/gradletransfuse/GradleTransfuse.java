package javier.gradletransfuse;


import android.content.res.Configuration;
import org.androidtransfuse.annotations.*;

// For some reason the style is not being properly displayed.
@Application(label = "@string/app_name", icon = "@mipmap/ic_launcher", theme = "@style/AppTheme")
public class GradleTransfuse {
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