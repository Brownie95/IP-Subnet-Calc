package abrown101476628.ipsubnetcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by AndyA on 26/10/2017.
 */

public class Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode()
                == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.ActivityTheme_Primary_Base_Dark);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
    }

    public void backPage(View v) {
        startActivity(new Intent(Calculator.this, MainActivity.class));
    }

    public void myClickHandler(View v) {

        int decimalValue4;
        int decimalValue3;
        int decimalValue2;
        int decimalValue1;

        String binaryValue4;
        String binaryValue2;
        String binaryValue3;
        String binaryValue1;

        EditText octet4Data = (EditText) findViewById(R.id.octet4);
        EditText octet3Data = (EditText) findViewById(R.id.octet3);
        EditText octet2Data = (EditText) findViewById(R.id.octet2);
        EditText octet1Data = (EditText) findViewById(R.id.octet1);

        TextView binaryOutput =  (TextView) findViewById(R.id.outputTextView);

        decimalValue4 = Integer.parseInt(octet4Data.getText().toString());
        decimalValue3 = Integer.parseInt(octet3Data.getText().toString());
        decimalValue2 = Integer.parseInt(octet2Data.getText().toString());
        decimalValue1 = Integer.parseInt(octet1Data.getText().toString());

        binaryValue4 = Integer.toBinaryString(decimalValue4);
        binaryValue3 = Integer.toBinaryString(decimalValue3);
        binaryValue2 = Integer.toBinaryString(decimalValue2);
        binaryValue1 = Integer.toBinaryString(decimalValue1);

        binaryValue4 = String.format("%8s", Integer.toBinaryString(decimalValue4)).replace(" ", "0");
        binaryValue3 = String.format("%8s", Integer.toBinaryString(decimalValue3)).replace(" ", "0");
        binaryValue2 = String.format("%8s", Integer.toBinaryString(decimalValue2)).replace(" ", "0");
        binaryValue1 = String.format("%8s", Integer.toBinaryString(decimalValue1)).replace(" ", "0");

        binaryOutput.setText("Binary: " + binaryValue4 + "." + binaryValue3  + "." + binaryValue2  + "." + binaryValue1);
    }
}
