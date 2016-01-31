package bruce_hoang.bhoang2_fueltrack;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class newEntryActivity extends MainActivity {

    // Instantiate variables
    private EditText tDate;
    private EditText tStation;
    private EditText tOdometer;
    private EditText tFuelGrade;
    private EditText tFuelAmount;
    private EditText tFuelUnitCost;
    private TextView FuelCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);

//        Get inputs for date, station, fuel, etc...
        tDate = (EditText) findViewById(R.id.edit_date);
        tStation = (EditText) findViewById(R.id.edit_station);
        tOdometer = (EditText) findViewById(R.id.edit_odometer);
        tFuelGrade = (EditText) findViewById(R.id.edit_fuel_grade);
        tFuelAmount = (EditText) findViewById(R.id.edit_fuel_amount);
        tFuelUnitCost = (EditText) findViewById(R.id.edit_fuel_unit_cost);
        FuelCost = (TextView) findViewById(R.id.fuel_cost);

        Button cancelButton = (Button) findViewById(R.id.cancel);
        Button addEntryButton = (Button) findViewById(R.id.add);
        Button calculateButton = (Button) findViewById(R.id.calculate);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Double fuelAmount = Double.parseDouble(tFuelAmount.getText().toString());
                Double fuelUnitCost = Double.parseDouble(tFuelUnitCost.getText().toString());
                Double fuelCost = fuelAmount * fuelUnitCost * 0.01;

                FuelCost.setText(DecimalFormat.getCurrencyInstance().format(fuelCost));
                v.setVisibility(View.GONE);
            }
        });

        addEntryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Taken from http://stackoverflow.com/questions/7129448/how-can-i-get-the-value-of-an-android-edittext-component-as-an-integer on Jan 30, 2016
                String date = tDate.getText().toString();
                String station = tStation.getText().toString();
                Double odometer = Double.parseDouble(tOdometer.getText().toString());
                String fuelGrade = tFuelGrade.getText().toString();
                Double fuelAmount = Double.parseDouble(tFuelAmount.getText().toString());
                Double fuelUnitCost = Double.parseDouble(tFuelUnitCost.getText().toString());
                Double fuelCost = fuelAmount * fuelUnitCost * 0.01;

                entryLog entry = new entryLog(date, station, odometer, fuelGrade, fuelAmount,
                        fuelUnitCost, fuelCost);
                entryLogs.addEntry(entry);

                saveInFile();
                finish();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

    }


    // Taken from https://github.com/SRomansky/lonelyTwitter/blob/w16Thursday/app/src/main/java/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java, Jan 31, 2016
    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_APPEND);
//            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
//            Gson gson = new Gson();
//            gson.toJson(entryLogs, out);
//            out.flush();
            fos.write(entryLogs.toString().getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

}
