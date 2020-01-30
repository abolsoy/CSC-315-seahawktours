package edu.uncw.seahawktours;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class MainActivity extends Activity {

    private String state;
    private String building;

    // @ author Alex Bolsoy
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            state = savedInstanceState.getString("state");
            building = savedInstanceState.getString("building");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

    }

    public void onClickSelect(View view) {
        //Get a reference to the Spinner
        Spinner building = (Spinner) findViewById(R.id.building);
        //Get the selected item in the Spinner
        String buildingName = String.valueOf(building.getSelectedItem());


        //Intent intent = new Intent(Intent.ACTION_SEND);
        //intent.setType("text/plain");
        //intent.putExtra(Intent.EXTRA_TEXT, messageText);
        //String chooserTitle = getString(R.string.chooser);
        //Intent chosenIntent = Intent.createChooser(intent, chooserTitle);
        //startActivity(chosenIntent);
    }
}
