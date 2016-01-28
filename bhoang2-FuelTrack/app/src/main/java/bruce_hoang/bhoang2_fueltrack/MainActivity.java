package bruce_hoang.bhoang2_fueltrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button viewLogsButton = (Button) findViewById(R.id.view_entries);
        Button newEntryButton = (Button) findViewById(R.id.new_entry);

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
