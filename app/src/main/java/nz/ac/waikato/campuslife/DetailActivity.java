package nz.ac.waikato.campuslife;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Shows the information page of a single topic.
 *
 * <p>At the moment the screen is filled with the placeholder texts from the
 * layout; the real content is added in a later part of the assignment.</p>
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }
}
