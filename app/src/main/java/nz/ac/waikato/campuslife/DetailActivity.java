package nz.ac.waikato.campuslife;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Shows the information page of a single topic.
 *
 * <p>The activity receives the position of the clicked topic from
 * {@link MainActivity} and uses that index to read the matching title, text
 * and icon name out of {@code arrays.xml}. Because the index is used directly
 * there is no need for any if statement or switch case.</p>
 */
public class DetailActivity extends AppCompatActivity {

    /** Intent key used to pass the topic identifier from the main screen. */
    public static final String EXTRA_TOPIC_INDEX =
            "nz.ac.waikato.campuslife.extra.TOPIC_INDEX";

    /** Short topic names for the banner, in the same order as the arrays. */
    private static final int[] TOPIC_LABELS = {
            R.string.topic_facilities,
            R.string.topic_events,
            R.string.topic_clubs,
            R.string.topic_support
    };

    /** Position of the selected topic in the arrays of arrays.xml. */
    private int topicIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        topicIndex = getIntent().getIntExtra(EXTRA_TOPIC_INDEX, 0);
        showTopic(topicIndex);
    }

    /**
     * Fills the banner and the scrolling area with the data of one topic.
     *
     * @param index position of the topic in {@code arrays.xml}
     */
    private void showTopic(int index) {
        Resources resources = getResources();
        String[] titles = resources.getStringArray(R.array.string_array_titles);
        String[] contents = resources.getStringArray(R.array.string_array_content);
        String[] iconNames = resources.getStringArray(R.array.string_array_images);

        TextView bannerTitle = findViewById(R.id.txt_detail_title);
        TextView heading = findViewById(R.id.txt_detail_heading);
        TextView content = findViewById(R.id.txt_detail_content);
        ImageView icon = findViewById(R.id.img_detail_icon);

        bannerTitle.setText(TOPIC_LABELS[index]);
        heading.setText(titles[index]);
        content.setText(contents[index]);

        // The array stores drawable names, so they are translated into ids.
        // The items are padded with spaces in arrays.xml, hence the trim().
        String iconName = iconNames[index].trim();
        //noinspection DiscouragedApi
        int iconId = resources.getIdentifier(iconName, "drawable", getPackageName());
        icon.setImageResource(iconId);
    }
}
