package bruce_hoang.bhoang2_fueltrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class viewLogsActivity extends MainActivity {

    private TextView Date;
    private TextView Station;
    private TextView Odometer;
    private TextView FuelGrade;
    private TextView FuelAmount;
    private TextView FuelUnitCost;
    private TextView FuelCost;
    private TextView logNumber;
    protected ArrayAdapter<entryLog> adapter;
    protected entryLog entryLog = new entryLog();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_logs);

        Date = (TextView) findViewById(R.id.display_date);
        Station = (TextView) findViewById(R.id.display_station);
        Odometer = (TextView) findViewById(R.id.display_odometer);
        FuelGrade = (TextView) findViewById(R.id.display_fuel_grade);
        FuelAmount = (TextView) findViewById(R.id.display_fuel_amount);
        FuelUnitCost = (TextView) findViewById(R.id.display_fuel_unit_cost);
        FuelCost = (TextView) findViewById(R.id.display_fuel_cost);
        logNumber = (TextView) findViewById(R.id.log_number);

        Button cancelButton = (Button) findViewById(R.id.cancel);
        Button editButton = (Button) findViewById(R.id.edit);
        Button previousButton = (Button) findViewById(R.id.previous);
        Button nextButton = (Button) findViewById(R.id.next);


//        Cancel button
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

//        Edit button
        editButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonEditLog(v);
            }
        });

//        Previous button
        previousButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (entryIndex > 0) {
                    entryLog = entryLogs.getEntry(entryIndex - 1);
                    displayLogInfo();
                    startActivity(getIntent());
                    displayLogInfo();
                }
            }
        });
//        Next button
        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (entryIndex+1 < (entryLogs.getCount())) {
                    entryLog = entryLogs.getEntry(entryIndex + 1);
                    displayLogInfo();
                    startActivity(getIntent());
                    finish();
                }
            }
        });
    }


//    Taken from https://github.com/SRomansky/lonelyTwitter/blob/f15monday/app/src/main/java/ca/
// ualberta/cs/lonelytwitter/LonelyTwitterActivity.java, Jan 31, 2016
    @Override
    protected void onStart() {
    // TODO Auto-generated method stub
        super.onStart();
        loadFromFile();

        if (entryLogs.getCount() > 0) {
            entryLog = entryLogs.getEntry(entryIndex);
            displayLogInfo();
        }
    }

    private void displayLogInfo(){
        // Decimal Formats
        // Taken from Javin Paul, http://javarevisited.blogspot.ca/2012/03/how-to-format-decimal-
        // number-in-java.html, Jan 31, 2016
        DecimalFormat df1 = new DecimalFormat("#0.0");
        DecimalFormat df3 = new DecimalFormat("#0.000");

        Date.setText(entryLog.getDate());
        Station.setText(entryLog.getStation());
        Odometer.setText(df1.format(entryLog.getFuelCost()));
        FuelGrade.setText(entryLog.getFuelGrade());
        FuelAmount.setText(df3.format(entryLog.getFuelAmount()));
        FuelUnitCost.setText(df1.format(entryLog.getFuelUnitCost()));
        FuelCost.setText(DecimalFormat.getCurrencyInstance().format(entryLog.getFuelCost()));
        logNumber.setText("Entry Log #" + (entryIndex+1) + " of " + entryLogs.getCount());

    }

    public void buttonEditLog(View view){
        // Starts View Log Activity
        Intent intent = new Intent(viewLogsActivity.this, editEntryActivity.class);
        startActivity(intent);
    }
}
