package bruce_hoang.bhoang2_fueltrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class newEntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);

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

}
