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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);

//        Variables for date, station, fuel, etc...
        date = (EditText) findViewById(R.id.edit_date);
        station = (EditText) findViewById(R.id.edit_station);
        odometer = (EditText) findViewById(R.id.edit_odometer);
        fuelGrade = (EditText) findViewById(R.id.edit_fuel_grade);
        fuelAmount = (EditText) findViewById(R.id.edit_fuel_amount);
        fuelUnitCost = (EditText) findViewById(R.id.edit_fuel_unit_cost);
        fuelCost = (EditText) findViewById(R.id.edit_fuel_cost);

        Button cancelButton = (Button) findViewById(R.id.cancel);
//        Button newEntryButton = (Button) findViewById(R.id.new_entry);

        /*newEntryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonAddNewEntry(v);
            }
        });*/

        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }

        });

    }
    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,0);

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
