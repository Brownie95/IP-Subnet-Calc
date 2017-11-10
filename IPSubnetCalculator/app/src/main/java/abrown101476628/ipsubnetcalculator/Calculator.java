package abrown101476628.ipsubnetcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.text.InputFilter;
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


        //Limit input fields to max value of 255
        EditText oct1 = (EditText) findViewById(R.id.octet1);
        EditText oct2 = (EditText) findViewById(R.id.octet2);
        EditText oct3 = (EditText) findViewById(R.id.octet3);
        EditText oct4 = (EditText) findViewById(R.id.octet4);
        EditText suboct1 = (EditText) findViewById(R.id.octetSubnet1);
        EditText suboct2 = (EditText) findViewById(R.id.octetSubnet2);
        EditText suboct3 = (EditText) findViewById(R.id.octetSubnet3);
        EditText suboct4 = (EditText) findViewById(R.id.octetSubnet4);

        oct1.setFilters(new InputFilter[]{ new inputFilterMinMax("0", "255")});
        oct2.setFilters(new InputFilter[]{ new inputFilterMinMax("0", "255")});
        oct3.setFilters(new InputFilter[]{ new inputFilterMinMax("0", "255")});
        oct4.setFilters(new InputFilter[]{ new inputFilterMinMax("0", "255")});
        suboct1.setFilters(new InputFilter[]{ new inputFilterMinMax("0", "255")});
        suboct2.setFilters(new InputFilter[]{ new inputFilterMinMax("0", "255")});
        suboct3.setFilters(new InputFilter[]{ new inputFilterMinMax("0", "255")});
        suboct4.setFilters(new InputFilter[]{ new inputFilterMinMax("0", "255")});

    }

    public void backPage(View v) {
        startActivity(new Intent(Calculator.this, MainActivity.class));
    }

    public void myClickHandler(View v) {
        EditText octet4Data, octet3Data, octet2Data, octet1Data, subOctet4Data, subOctet3Data, subOctet2Data, subOctet1Data;
        TextView outputResult;

        int ipValue4;
        int ipValue3;
        int ipValue2;
        int ipValue1;

        int subnetValue4;
        int subnetValue3;
        int subnetValue2;
        int subnetValue1;

        int oct4Result;
        int oct3Result;
        int oct2Result;
        int oct1Result;

        String binaryValue4;
        String binaryValue2;
        String binaryValue3;
        String binaryValue1;

        String binaryOct4Result;
        String binaryOct3Result;
        String binaryOct2Result;
        String binaryOct1Result;


        //Ip Octets
        octet4Data = (EditText) findViewById(R.id.octet4);
        octet3Data = (EditText) findViewById(R.id.octet3);
        octet2Data = (EditText) findViewById(R.id.octet2);
        octet1Data = (EditText) findViewById(R.id.octet1);

        //Subnet octets
        subOctet4Data = (EditText) findViewById(R.id.octetSubnet4);
        subOctet3Data = (EditText) findViewById(R.id.octetSubnet3);
        subOctet2Data = (EditText) findViewById(R.id.octetSubnet2);
        subOctet1Data = (EditText) findViewById(R.id.octetSubnet1);

        outputResult =  (TextView) findViewById(R.id.outputTextView);


        ipValue4 = Integer.parseInt(octet4Data.getText().toString());
        ipValue3 = Integer.parseInt(octet3Data.getText().toString());
        ipValue2 = Integer.parseInt(octet2Data.getText().toString());
        ipValue1 = Integer.parseInt(octet1Data.getText().toString());

        subnetValue4 = Integer.parseInt(subOctet4Data.getText().toString());
        subnetValue3 = Integer.parseInt(subOctet3Data.getText().toString());
        subnetValue2 = Integer.parseInt(subOctet2Data.getText().toString());
        subnetValue1 = Integer.parseInt(subOctet1Data.getText().toString());

        binaryValue4 = String.format("%8s", Integer.toBinaryString(ipValue4)).replace(" ", "0");
        binaryValue3 = String.format("%8s", Integer.toBinaryString(ipValue3)).replace(" ", "0");
        binaryValue2 = String.format("%8s", Integer.toBinaryString(ipValue2)).replace(" ", "0");
        binaryValue1 = String.format("%8s", Integer.toBinaryString(ipValue1)).replace(" ", "0");

        oct4Result = ipValue4 & subnetValue4;
        oct3Result = ipValue3 & subnetValue3;
        oct2Result = ipValue2 & subnetValue2;
        oct1Result = ipValue1 & subnetValue1;

        binaryOct4Result = String.format("%8s", Integer.toBinaryString(oct4Result)).replace(" ", "0");
        binaryOct3Result = String.format("%8s", Integer.toBinaryString(oct3Result)).replace(" ", "0");
        binaryOct2Result = String.format("%8s", Integer.toBinaryString(oct2Result)).replace(" ", "0");
        binaryOct1Result = String.format("%8s", Integer.toBinaryString(oct1Result)).replace(" ", "0");
        
        outputResult.setText("Binary: " + binaryValue4 + "." + binaryValue3  + "." + binaryValue2  + "." + binaryValue1 + "\n"
                + "Mask: " + binaryOct4Result + "." + binaryOct3Result + "." + binaryOct2Result + "." + binaryOct1Result + "\n"
        + "Network Address: " + "\n" + "Broadcast Address: " + "\n" +  "First Useable Address: "
                        + "\n" + "Last Useable Address: " + "\n" + "Ip Class: "
                 );
    }
}
