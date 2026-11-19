package nz.ac.waikato.campuslife;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Shows the information page of a single topic.
 *
 * <p>The activity receives the position of the clicked topic from
 * {@link MainActivity} and keeps it in {@link #topicIndex}. The content of the
 * page itself is still the placeholder text of the layout.</p>
 */
public class DetailActivity extends AppCompatActivity {

    /** Intent key used to pass the topic identifier from the main screen. */
    public static final String EXTRA_TOPIC_INDEX =
            "nz.ac.waikato.campuslife.extra.TOPIC_INDEX";

    /** Position of the selected topic in the arrays of arrays.xml. */
    private int topicIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        topicIndex = getIntent().getIntExtra(EXTRA_TOPIC_INDEX, 0);
    }
}
