package abrown101476628.ipsubnetcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;

/**
 * Created by AndyA on 26/10/2017.
 */

public class Help extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode()
                == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.ActivityTheme_Primary_Base_Dark);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
    }

    public void backPage(View v) {
        startActivity(new Intent(Help.this, MainActivity.class));
    }
}
