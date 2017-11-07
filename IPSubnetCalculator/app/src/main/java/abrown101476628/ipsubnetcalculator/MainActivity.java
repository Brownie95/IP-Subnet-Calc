package abrown101476628.ipsubnetcalculator;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (AppCompatDelegate.getDefaultNightMode()
                == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.ActivityTheme_Primary_Base_Dark);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreference = getSharedPreferences("switch", MODE_PRIVATE);
        boolean isChecked = sharedPreference.getBoolean("status", false);
        if (isChecked) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    public void toVLSMPage(View v) {
        startActivity(new Intent(MainActivity.this, Calculator.class));
    }

    public void toHelpPage(View v) {
        startActivity(new Intent(MainActivity.this, Help.class));
    }

    public void toAboutPage(View v) {
        startActivity(new Intent(MainActivity.this, About_Settings.class));
    }
}

