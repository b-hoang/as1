package bruce_hoang.bhoang2_fueltrack;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class viewLogsActivity extends MainActivity {

    private ListView entryLogListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_logs);

        entryLogListView = (ListView) findViewById(R.id.listView);
        Button cancelButton = (Button) findViewById(R.id.cancel);

//        Cancel button
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }

        });

    }

//    Taken from https://github.com/SRomansky/lonelyTwitter/blob/f15monday/app/src/main/java/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java, Jan 31, 2016
@Override
    protected void onStart() {
    // TODO Auto-generated method stub
        super.onStart();
        String[] entryLog = loadFromFile();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.list_item, entryLog);
        entryLogListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private String[] loadFromFile() {
        ArrayList<String> entryLogs = new ArrayList<String>();
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            String line = in.readLine();
            while (line != null) {
                entryLogs.add(line);
                line = in.readLine();
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return entryLogs.toArray(new String[entryLogs.size()]);
    }
}
