package nz.ac.waikato.campuslife;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Entry point of the CampusLife application.
 *
 * <p>The home screen shows a banner and four topic tiles. Each tile is an
 * {@code ImageButton}; clicking a tile gives the user a short confirmation
 * message.</p>
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // The portrait and the landscape layout share the same button ids, so
        // the listeners below work in both orientations.
        bindTopic(R.id.btn_facilities, R.string.topic_facilities);
        bindTopic(R.id.btn_events, R.string.topic_events);
        bindTopic(R.id.btn_clubs, R.string.topic_clubs);
        bindTopic(R.id.btn_support, R.string.topic_support);
    }

    /**
     * Wires one topic tile so that pressing it shows a short message.
     *
     * @param buttonId id of the tile's ImageButton
     * @param labelId  string resource with the name of the topic
     */
    private void bindTopic(int buttonId, int labelId) {
        View button = findViewById(buttonId);
        button.setOnClickListener(view -> Toast.makeText(
                MainActivity.this,
                getString(R.string.toast_topic_clicked, getString(labelId)),
                Toast.LENGTH_SHORT).show());
    }
}
