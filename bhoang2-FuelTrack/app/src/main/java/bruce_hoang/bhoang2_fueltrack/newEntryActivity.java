package bruce_hoang.bhoang2_fueltrack;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

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
                // Taken from Konstantin Burov, http://stackoverflow.com/questions/4127725/how-can-i-remove-a-button-or-make-it-invisible-in-android, Jan 31, 2016
                // Used to hide the calculate button so you can see the fuel amount.
                v.setVisibility(View.GONE);
            }
        });

        addEntryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Taken from Matt Ball, http://stackoverflow.com/questions/7129448/how-can-i-get-the-value-of-an-android-edittext-component-as-an-integer on Jan 30, 2016
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

}
