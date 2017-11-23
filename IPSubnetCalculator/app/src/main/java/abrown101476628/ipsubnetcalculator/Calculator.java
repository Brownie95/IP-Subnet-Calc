package abrown101476628.ipsubnetcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.text.InputFilter;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        //Scrolling
        TextView scrollable = (TextView) findViewById(R.id.outputTextView);

        //Enabling scrolling on TextView.
        scrollable.setMovementMethod(new ScrollingMovementMethod());

        //Limit input fields to max value of 255
        EditText oct1 = (EditText) findViewById(R.id.octet1);
        EditText oct2 = (EditText) findViewById(R.id.octet2);
        EditText oct3 = (EditText) findViewById(R.id.octet3);
        EditText oct4 = (EditText) findViewById(R.id.octet4);
        EditText suboct1 = (EditText) findViewById(R.id.octetSubnet1);
        EditText suboct2 = (EditText) findViewById(R.id.octetSubnet2);
        EditText suboct3 = (EditText) findViewById(R.id.octetSubnet3);
        EditText suboct4 = (EditText) findViewById(R.id.octetSubnet4);

        oct1.setFilters(new InputFilter[]{new inputFilterMinMax("0", "255")});
        oct2.setFilters(new InputFilter[]{new inputFilterMinMax("0", "255")});
        oct3.setFilters(new InputFilter[]{new inputFilterMinMax("0", "255")});
        oct4.setFilters(new InputFilter[]{new inputFilterMinMax("0", "255")});
        suboct1.setFilters(new InputFilter[]{new inputFilterMinMax("0", "255")});
        suboct2.setFilters(new InputFilter[]{new inputFilterMinMax("0", "255")});
        suboct3.setFilters(new InputFilter[]{new inputFilterMinMax("0", "255")});
        suboct4.setFilters(new InputFilter[]{new inputFilterMinMax("0", "255")});
    }


    public void backPage(View v) {
        startActivity(new Intent(Calculator.this, MainActivity.class));
    }

    public void myClickHandler(View v) {
        EditText octet4Data, octet3Data, octet2Data, octet1Data, subOctet4Data, subOctet3Data, subOctet2Data, subOctet1Data;
        TextView outputResult;

        //IP Octet values
        int ipValue4;
        int ipValue3;
        int ipValue2;
        int ipValue1;

        //Subnet Octet Values
        int subnetValue4;
        int subnetValue3;
        int subnetValue2;
        int subnetValue1;

        //Declared Integers for Network Address ANDing
        int network4Result;
        int network3Result;
        int network2Result;
        int network1Result;

        //Declared Integer for First Usable Address
        int firstUsable;

        //broadcast Integer
        int broadcastResult3;
        int broadcastResult2;
        int broadcastResult1;

        //Declared Integer for Last Usable Address
        int lastUsable;

        //Strings for Binary converted IP Octets
        String binaryValue4;
        String binaryValue2;
        String binaryValue3;
        String binaryValue1;

        //Strings for Binary converted Subnet Octets
        String binaryOct4Result;
        String binaryOct3Result;
        String binaryOct2Result;
        String binaryOct1Result;

        //Declared String for the ip Class
        String ipClass;

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

        outputResult = (TextView) findViewById(R.id.outputTextView);

        if(octet4Data.getText().toString()== "") {
            Toast.makeText(this, "You must enter numbers in all Fields ", Toast.LENGTH_SHORT).show();
            return;
        }
        if(octet3Data.getText().toString()== "") {
            Toast.makeText(this, "You must enter numbers in all Fields ", Toast.LENGTH_SHORT).show();
            return;
        }
        if(octet2Data.getText().toString()== "") {
            Toast.makeText(this, "You must enter numbers in all Fields ", Toast.LENGTH_SHORT).show();
            return;
        }
        if(octet1Data.getText().toString()== "") {
            Toast.makeText(this, "You must enter numbers in all Fields ", Toast.LENGTH_SHORT).show();
            return;
        }

        //Passes ip octet Integers into String values
        ipValue4 = Integer.parseInt(octet4Data.getText().toString());
        ipValue3 = Integer.parseInt(octet3Data.getText().toString());
        ipValue2 = Integer.parseInt(octet2Data.getText().toString());
        ipValue1 = Integer.parseInt(octet1Data.getText().toString());

        //Passes subnet octet Integers into String values
        subnetValue4 = Integer.parseInt(subOctet4Data.getText().toString());
        subnetValue3 = Integer.parseInt(subOctet3Data.getText().toString());
        subnetValue2 = Integer.parseInt(subOctet2Data.getText().toString());
        subnetValue1 = Integer.parseInt(subOctet1Data.getText().toString());

        //Converts ip value to Binary
        binaryValue4 = String.format("%8s", Integer.toBinaryString(ipValue4)).replace(" ", "0");
        binaryValue3 = String.format("%8s", Integer.toBinaryString(ipValue3)).replace(" ", "0");
        binaryValue2 = String.format("%8s", Integer.toBinaryString(ipValue2)).replace(" ", "0");
        binaryValue1 = String.format("%8s", Integer.toBinaryString(ipValue1)).replace(" ", "0");

        //Converts subnet value to Binary
        binaryOct4Result = String.format("%8s", Integer.toBinaryString(subnetValue4)).replace(" ", "0");
        binaryOct3Result = String.format("%8s", Integer.toBinaryString(subnetValue3)).replace(" ", "0");
        binaryOct2Result = String.format("%8s", Integer.toBinaryString(subnetValue2)).replace(" ", "0");
        binaryOct1Result = String.format("%8s", Integer.toBinaryString(subnetValue1)).replace(" ", "0");

        //ANDing for Network Address
        network4Result = ipValue4 & subnetValue4;
        network3Result = ipValue3 & subnetValue3;
        network2Result = ipValue2 & subnetValue2;
        network1Result = ipValue1 & subnetValue1;

        //Broadcast Address
        String invertedSubnet1 = binaryOct1Result;
        String invertedSubnet2 = binaryOct2Result;
        String invertedSubnet3 = binaryOct3Result;

        invertedSubnet1 = invertedSubnet1.replaceAll("0", "x").replaceAll("1", "0").replaceAll("x", "1");
        invertedSubnet2 = invertedSubnet2.replaceAll("0", "x").replaceAll("1", "0").replaceAll("x", "1");
        invertedSubnet3 = invertedSubnet3.replaceAll("0", "x").replaceAll("1", "0").replaceAll("x", "1");

        int inverted1 = Integer.parseInt(invertedSubnet1, 2);
        int inverted2 = Integer.parseInt(invertedSubnet2, 2);
        int inverted3 = Integer.parseInt(invertedSubnet3, 2);

        if (subnetValue3 <= 254) {
            broadcastResult3 = ipValue3 | inverted3;
        } else
            broadcastResult3 = network3Result;

        if (subnetValue2 <=254) {
            broadcastResult2 = ipValue2 | inverted2;
        } else
            broadcastResult2 = network2Result;

            broadcastResult1 = ipValue1 | inverted1;


        //First Usable Address
        firstUsable = network1Result + 1;

        //Last Usable Address
        lastUsable = broadcastResult1 - 1;

        //Checking IP Class
        ipClass = "";

        if (network3Result <= 11111110) {
            ipClass = "A";
        } else if (network2Result <= 11111110){
            ipClass = "B";
        } else if (network1Result >= 00000000) {
            ipClass = "C";
        }

        
        outputResult.setText("Binary IP" + "\n" + binaryValue4 + "." + binaryValue3  + "." + binaryValue2  + "." + binaryValue1
                + "\n\n" + "Binary Mask" + "\n" + binaryOct4Result + "." + binaryOct3Result + "." + binaryOct2Result + "." + binaryOct1Result
                + "\n" + "\n" + "Network Address" + "\n" + network4Result + "." + network3Result + "." + network2Result + "." + network1Result +
                "\n\n" + "Broadcast Address" + "\n" + network4Result + "." + broadcastResult3 + "." + broadcastResult2+ "." + broadcastResult1 + "\n\n" +
                "First Usable Address" + "\n"  + network4Result + "." + network3Result + "." + network2Result + "." + firstUsable + "\n\n" +
                "Last Usable Address" + "\n" + network4Result + "." + broadcastResult3 + "." + broadcastResult2 + "." + lastUsable + "\n\n" +
                "Ip Class" + "\n" + ipClass);
    }
}
