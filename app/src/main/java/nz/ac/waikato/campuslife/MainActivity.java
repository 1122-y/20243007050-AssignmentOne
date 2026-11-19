package nz.ac.waikato.campuslife;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Entry point of the CampusLife application.
 *
 * <p>At this stage the activity only inflates the default layout; the topic
 * grid and the click handling are added in later parts of the assignment.</p>
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
