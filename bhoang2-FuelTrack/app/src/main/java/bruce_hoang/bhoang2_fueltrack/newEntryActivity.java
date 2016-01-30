package bruce_hoang.bhoang2_fueltrack;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.google.gson.Gson;

public class newEntryActivity extends MainActivity {

    // Instantiate variables
    private EditText tDate;
    private EditText tStation;
    private EditText tOdometer;
    private EditText tFuelGrade;
    private EditText tFuelAmount;
    private EditText tFuelUnitCost;
    private EditText tFuelCost;

    entryLogList entryLogs = new entryLogList();
//    private ArrayAdapter<entryLog> adapter;

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
        tFuelCost = (EditText) findViewById(R.id.edit_fuel_cost);

        Button cancelButton = (Button) findViewById(R.id.cancel);
        Button addEntryButton = (Button) findViewById(R.id.add);

        addEntryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Taken from http://stackoverflow.com/questions/7129448/how-can-i-get-the-value-of-an-android-edittext-component-as-an-integer on Jan 30, 2016
                String date = tDate.toString();
                String station = tStation.toString();
                Double odometer = Double.parseDouble(tOdometer.getText().toString());
                String fuelGrade = tFuelGrade.toString();
                Double fuelAmount = Double.parseDouble(tFuelAmount.getText().toString());
                Double fuelUnitCost = Double.parseDouble(tFuelUnitCost.getText().toString());
                Double fuelCost = Double.parseDouble(tFuelCost.getText().toString());


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

    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME, 0);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(entryLogs, out);
            out.flush();
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
