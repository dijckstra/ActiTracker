package wisdm.cis.fordham.edu.actitracker;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Activity where user enters name.
 */
public class UsernameActivity extends AppCompatActivity {

    private static final String TAG = "UsernameActivity";

    private Button mNextButton;
    private EditText mUsernameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username);

        // Set default values for settings
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

        mNextButton = (Button)findViewById(R.id.next_button);
        mUsernameText = (EditText)findViewById(R.id.username_field);

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUsernameText.getText().toString().trim();

                // Check for invalid name
                if (username.length() != 0) {
                    Intent i = new Intent(UsernameActivity.this, TaskSelectionActivity.class);
                    i.putExtra("USERNAME", username);
                    startActivity(i);
                }
                // If invalid, prompt to enter name
                else {
                    Toast.makeText(getApplicationContext(), R.string.invalid_username,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}