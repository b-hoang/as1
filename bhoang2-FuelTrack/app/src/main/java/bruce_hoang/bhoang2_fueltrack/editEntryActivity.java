package bruce_hoang.bhoang2_fueltrack;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Created by Bruce-PC on 1/31/2016.
 * This Activity is for editing an entry log. You can change the values to any of the fields
 * and then it saves the log.
 */
public class editEntryActivity extends viewLogsActivity {

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
        setContentView(R.layout.activity_edit_entry);

//        Get inputs for date, station, fuel, etc...
        tDate = (EditText) findViewById(R.id.edit_date);
        tStation = (EditText) findViewById(R.id.edit_station);
        tOdometer = (EditText) findViewById(R.id.edit_odometer);
        tFuelGrade = (EditText) findViewById(R.id.edit_fuel_grade);
        tFuelAmount = (EditText) findViewById(R.id.edit_fuel_amount);
        tFuelUnitCost = (EditText) findViewById(R.id.edit_fuel_unit_cost);
        FuelCost = (TextView) findViewById(R.id.fuel_cost);

        Button cancelButton = (Button) findViewById(R.id.cancel);
        Button saveEntryButton = (Button) findViewById(R.id.save);
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

        saveEntryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Sets the TextView with its corresponding numbers/strings
                // Taken from Matt Ball, http://stackoverflow.com/questions/7129448/how-can-i-get-the-value-of-an-android-edittext-component-as-an-integer on Jan 30, 2016
                String date = tDate.getText().toString();
                String station = tStation.getText().toString();
                Double odometer = Double.parseDouble(tOdometer.getText().toString());
                String fuelGrade = tFuelGrade.getText().toString();
                Double fuelAmount = Double.parseDouble(tFuelAmount.getText().toString());
                Double fuelUnitCost = Double.parseDouble(tFuelUnitCost.getText().toString());
                Double fuelCost = fuelAmount * fuelUnitCost * 0.01;

                entryLog.setDate(date);
                entryLog.setStation(station);
                entryLog.setOdometer(odometer);
                entryLog.setFuelGrade(fuelGrade);
                entryLog.setFuelAmount(fuelAmount);
                entryLog.setFuelUnitCost(fuelUnitCost);
                entryLog.setFuelCost(fuelCost);

                entryLogs.setEntry(entryIndex, entryLog);
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

    protected void onStart() {
        super.onStart();
        loadFromFile();

        if (entryLogs.getCount() > 0) {
            entryLog = entryLogs.getEntry(entryIndex);
            displayLogInfo();
        }
    }

    private void displayLogInfo(){
        // Decimal Formats
        // Taken from Javin Paul, http://javarevisited.blogspot.ca/2012/03/how-to-format-decimal-number-in-java.html, Jan 31, 2016
        DecimalFormat df1 = new DecimalFormat("#0.0");
        DecimalFormat df3 = new DecimalFormat("#0.000");

        tDate.setText(entryLog.getDate(),TextView.BufferType.EDITABLE);
        tStation.setText(entryLog.getStation(),TextView.BufferType.EDITABLE);
        tOdometer.setText(df1.format(entryLog.getFuelCost()),TextView.BufferType.EDITABLE);
        tFuelGrade.setText(entryLog.getFuelGrade(),TextView.BufferType.EDITABLE);
        tFuelAmount.setText(df3.format(entryLog.getFuelAmount()),TextView.BufferType.EDITABLE);
        tFuelUnitCost.setText(df1.format(entryLog.getFuelUnitCost()), TextView.BufferType.EDITABLE);
        FuelCost.setText(DecimalFormat.getCurrencyInstance().format(entryLog.getFuelCost()), TextView.BufferType.EDITABLE);
    }

}
