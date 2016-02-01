package bruce_hoang.bhoang2_fueltrack;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class MainActivity extends AppCompatActivity {

    protected static final String FILENAME = "entrylogs.txt";
    protected entryLogList entryLogs = new entryLogList();
    protected int entryIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button viewLogsButton = (Button) findViewById(R.id.view_entries);
        Button newEntryButton = (Button) findViewById(R.id.new_entry);
        Button clearLogsButton = (Button) findViewById(R.id.clear_entries);

        loadFromFile();

        newEntryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                buttonAddNewEntry(v);
            }
        });

        viewLogsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                buttonViewLogs(v);
            }
        });

        clearLogsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                clearFile();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void clearFile() {
        // Just deletes the file.
        try {
            FileOutputStream fos = openFileOutput(FILENAME, 0);
            // took from Barry, http://stackoverflow.com/questions/3554722/how-to-delete-internal-storage-file-in-android, Jan 31, 2016
            deleteFile(FILENAME);
            fos.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        } catch (IOException e){
            throw new RuntimeException();
        }
    }

    protected void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            entryLogs = (entryLogList) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Taken from https://github.com/SRomansky/lonelyTwitter/blob/w16Thursday/app/src/main/java/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java, Jan 31, 2016
    protected void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_APPEND);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(entryLogs);
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }



    public void buttonAddNewEntry(View view){
        // Starts New Entry Activity
        Intent intent = new Intent(MainActivity.this, newEntryActivity.class);
        startActivity(intent);
    }

    public void buttonViewLogs(View view){
        // Starts View Log Activity
        Intent intent = new Intent(MainActivity.this, viewLogsActivity.class);
        startActivity(intent);
    }
}
