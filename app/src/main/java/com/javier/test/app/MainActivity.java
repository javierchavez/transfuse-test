package com.javier.test.app;


import org.androidtransfuse.annotations.*;
import android.widget.TextView;
import javax.inject.Inject;



@Activity(label = "@string/app_name")
@IntentFilter({
         @Intent(type = IntentType.ACTION, name = android.content.Intent.ACTION_MAIN),
         @Intent(type = IntentType.CATEGORY, name = android.content.Intent.CATEGORY_LAUNCHER)
 	    })
@Layout(R.layout.activity_main)
public class MainActivity {

    @Inject
    @View(R.id.textview)
    private TextView textView;
    
    
    @OnCreate
    public void hello() {
        textView.setText("hello");
    }
}
