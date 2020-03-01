package com.hfad.bitsandpizzas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity { //AppCompatActivity caused problems!!!

    public static final String EXTRA_BUILDING = "building";
    public static final String EXTRA_INFO = "info";
    public static final String EXTRA_PICID = "picId";
    public static final String EXTRA_BUILDINGID = "buildingId";
    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        int buildingId = (Integer)getIntent().getExtras().get(EXTRA_BUILDINGID);
        Building building = Building.buildings[buildingId];
        String buildingText = getResources().getString(building.getName());
        String infoText = getResources().getString(building.getInformation());
        int picId = building.getImageResourceId();
        String buildingUrlText = getResources().getString(building.getLink());

        //Populate the building name
        TextView name = findViewById(R.id.building_name);
        name.setText(buildingText);

        //Populate the building image
        ImageView photo = findViewById(R.id.photo);
        photo.setImageResource(picId);

        //Populate the building description
        TextView description = findViewById(R.id.building_info);
        description.setText(infoText);

        TextView link = findViewById(R.id.url_link);
        link.setMovementMethod(LinkMovementMethod.getInstance());
        link.setText(Html.fromHtml(buildingUrlText));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the app bar.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider =
                (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);

        int buildingId = (Integer)getIntent().getExtras().get(EXTRA_BUILDINGID);
        Building building = Building.buildings[buildingId];
        String buildingUrlText = getResources().getString(building.getUrl());

        setShareActionIntent("Check out this building! " + buildingUrlText);
        return super.onCreateOptionsMenu(menu);
    }

    private void setShareActionIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
