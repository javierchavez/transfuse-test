package javier.gradletransfuse;


import android.widget.TextView;

import org.androidtransfuse.annotations.*;
import org.androidtransfuse.annotations.Intent;
import org.androidtransfuse.annotations.IntentFilter;

import javax.inject.Inject;


@Activity(label = "@string/app_name")
@Layout(R.layout.activity_main)
@IntentFilter({
        @Intent(type = IntentType.ACTION, name = android.content.Intent.ACTION_MAIN),
        @Intent(type = IntentType.CATEGORY, name = android.content.Intent.CATEGORY_LAUNCHER)
})
public class HelloWorld {

    @Inject
    @View(R.id.welcome_text)
    TextView textView;


    @OnCreate
    public void sayHello() {
        textView.setText(R.string.hello);
    }
}
