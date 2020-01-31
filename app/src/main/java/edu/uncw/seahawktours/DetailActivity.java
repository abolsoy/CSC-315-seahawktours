package edu.uncw.seahawktours;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends Activity { //AppCompatActivity caused problems!!!

    public static final String EXTRA_BUILDING = "building";
    public static final String EXTRA_INFO = "info";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String buildingText = intent.getStringExtra(EXTRA_BUILDING);
        String infoText = intent.getStringExtra(EXTRA_INFO);
        TextView buildingView = findViewById(R.id.building_name);
        TextView infoView = findViewById(R.id.building_info);
        buildingView.setText(buildingText);
        infoView.setText(infoText);
    }
}
