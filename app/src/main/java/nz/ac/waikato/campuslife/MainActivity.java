package nz.ac.waikato.campuslife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Entry point of the CampusLife application.
 *
 * <p>The home screen shows a banner and four topic tiles. Clicking a tile
 * confirms the click with a Toast and opens the {@link DetailActivity} for
 * that topic.</p>
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // The index identifies the topic for the detail screen. It is also the
        // position of the topic inside the arrays stored in arrays.xml.
        bindTopic(R.id.btn_facilities, R.string.topic_facilities, 0);
        bindTopic(R.id.btn_events, R.string.topic_events, 1);
        bindTopic(R.id.btn_clubs, R.string.topic_clubs, 2);
        bindTopic(R.id.btn_support, R.string.topic_support, 3);
    }

    /**
     * Wires one topic tile so that pressing it opens the detail screen.
     *
     * @param buttonId   id of the tile's ImageButton
     * @param labelId    string resource with the name of the topic
     * @param topicIndex unique identifier of the topic
     */
    private void bindTopic(int buttonId, int labelId, int topicIndex) {
        View button = findViewById(buttonId);
        button.setOnClickListener(view -> {
            Toast.makeText(
                    MainActivity.this,
                    getString(R.string.toast_topic_clicked, getString(labelId)),
                    Toast.LENGTH_SHORT).show();
            openTopic(topicIndex);
        });
    }

    /** Starts the detail screen for the given topic. */
    private void openTopic(int topicIndex) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_TOPIC_INDEX, topicIndex);
        startActivity(intent);
    }
}
