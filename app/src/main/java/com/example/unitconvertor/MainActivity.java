package com.example.unitconvertor;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
////        Spinner Unit Setting
//        Spinner firstUnit = (Spinner) findViewById(R.id.firstUnit);
//        Spinner secondUnit = findViewById(R.id.secondUnit);
//        EditText firstNum = (EditText) findViewById(R.id.firstNum);
//        EditText secondNum = findViewById(R.id.secondNum);

//        Edge To Edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onConvert(View view){
//        Get value from spinner 1
        Spinner spinner1 = (Spinner)findViewById(R.id.firstUnit);
        String firstUnit = spinner1 .getSelectedItem().toString();
        //        Get value from spinner 2
        Spinner spinner2 = findViewById(R.id.secondUnit);
        String secondUnit = spinner2.getSelectedItem().toString();
        //        Get value from EditText
        EditText firstNum = (EditText) findViewById(R.id.firstNum);
        EditText secondNum = findViewById(R.id.secondNum);

        double val1;
        double val2 = 0;
        try{
            val1 = Double.parseDouble(firstNum.getText().toString());
        }catch (Exception e){
            Toast.makeText(this, "Please Enter a Value" , Toast.LENGTH_LONG).show();
            return;
        }


        switch(firstUnit){
            case "Metre":
                switch (secondUnit){
                    case "Metre":
                        val2 = val1;
                        break;
                    case "Millimetre":
                        val2 = val1 * 1000;
                        break;
                    case "Mile":
                        val2 = val1 * 0.000621371;
                        break;
                    case "Foot":
                        val2 = val1 * 3.28084;
                        break;
                }
                break;
            case "Millimetre":
                switch (secondUnit){
                    case "Metre":
                        val2 = val1 / 1000;
                        break;
                    case "Millimetre":
                        val2 = val1;
                        break;
                    case "Mile":
                        val2 = val1 * 0.00000621371;
                        break;
                    case "Foot":
                        val2 = val1 / 304.8;
                        break;
                }
                break;
            case "Mile":
                switch (secondUnit){
                    case "Metre":
                        val2 = val1 * 1609.34;
                        break;
                    case "Millimetre":
                        val2 = val1 * 1609340;
                        break;
                    case "Mile":
                        val2 = val1;
                        break;
                    case "Foot":
                        val2 = val1 * 5280;
                        break;
                }
                break;
            case "Foot":
                switch (secondUnit){
                    case "Metre":
                        val2 = val1 / 3.28084;
                        break;
                    case "Millimetre":
                        val2 = val1 * 304.8;
                        break;
                    case "Mile":
                        val2 = val1 / 5280;
                        break;
                    case "Foot":
                        val2 = val1;
                        break;
                }
                break;
        }
//      Print the answer out
        secondNum.setText(String.valueOf(val2));

    }
}