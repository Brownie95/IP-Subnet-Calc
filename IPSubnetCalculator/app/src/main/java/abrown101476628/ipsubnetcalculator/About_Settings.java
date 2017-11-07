package abrown101476628.ipsubnetcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

/**
 * Created by AndyA on 26/10/2017.
 */

public class About_Settings extends AppCompatActivity {

Switch DayNightt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (AppCompatDelegate.getDefaultNightMode()
                == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.ActivityTheme_Primary_Base_Dark);

        }
            super.onCreate(savedInstanceState);
            setContentView(R.layout.about_settings);



            DayNightt = (Switch) findViewById(R.id.toggleLightDark);
            DayNightt.setChecked(false);
            DayNightt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        recreate();
                    } else {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        recreate();
                    }
                }
            });

}





    public void backPage(View v) {
        startActivity(new Intent(About_Settings.this, MainActivity.class));
    }

}
