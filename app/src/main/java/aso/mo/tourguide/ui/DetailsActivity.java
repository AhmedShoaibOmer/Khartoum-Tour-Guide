package aso.mo.tourguide.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import aso.mo.tourguide.R;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();

        TextView title = findViewById(R.id.title_text);
        title.setText(bundle.getString("title"));
        TextView details = findViewById(R.id.details_text);
        details.setText(bundle.getString("description"));
        ImageView image = findViewById(R.id.details_image_view);
        image.setImageResource(bundle.getInt("imageResID"));
    }
}