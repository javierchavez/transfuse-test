# Reproducing errors



### General Manifest

###### Error case 1

You will see multiple application tags, resulting in a non runnable, but installable application.

```xml
Manifest.xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">


    <application
        android:fullBackupContent="true"
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:theme="@style/AppTheme">
    </application>

</manifest>
```



```gradle
// gradle.build
android.applicationVariants.all { variant ->
    variant.outputs.each { output ->
        output.processResources.manifestFile = file('src/main/AndroidManifest.xml')
        apt {
            arguments {
                androidManifestFile output.processResources.manifestFile
            }
        }
    }
}

```

###### Error case 2

Manifest is not changed at the project level so you will need to look in ```build/```

```xml
Manifest.xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">
</manifest>
```

```gradle
gradle.build
apt {
    arguments {
        androidManifestFile variant.outputs[0]?.processResources?.manifestFile
    }
}
```

###### Something to note about.

We can disable *Manifest Merge* by adding:

```gradle
android.applicationVariants.all { variant ->
    variant.processResources.manifestFile = file('src/main/AndroidManifest.xml')
    variant.processManifest.enabled=false
}
```

The caveat is that values in the Gradle build will be ignored. Well, any place-holders defined in gradle and used in manifest will be ignored.

```gradle
defaultConfig {
    applicationId "javier.gradletransfuse"
    minSdkVersion 22
    targetSdkVersion 23
    versionCode 1
    versionName "1.0"
}
```

You will **not** be able to run the application unless you specify with ```@UsesSdk(min = 22, target = 23)``` annotation



