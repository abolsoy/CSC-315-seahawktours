package edu.uncw.seahawktours;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class MainActivity extends Activity {

    private String screen_state;
    private String building_state;

    // @ author Alex Bolsoy
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spin = findViewById(R.id.building);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // do something with spinner item
                // automatically selects first item in spinner - get around this
                String[] building_names = getResources().getStringArray(R.array.building_names);
                if (i==0) {
                    // do nothing
                }
                else {
                    String building;
                    String info;
                if (i == 1) {
                        building = building_names[1];
                        info = getResources().getString(R.string.cis_info);
                    } else if (i == 2) {
                        building = building_names[2];
                        info = getResources().getString(R.string.hoggard_info);
                    } else if (i == 3) {
                        building = building_names[3];
                        info = getResources().getString(R.string.deloach_info);
                    } else {
                        building = "";
                        info = "";
                    }
                    onChooseBuilding(building, info);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // do not need to worry about this
            }
        });

        if (savedInstanceState != null) {
            screen_state = savedInstanceState.getString("state");
            building_state = savedInstanceState.getString("building");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

    }

    public void onChooseBuilding(String building, String info) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_BUILDING, building);
        intent.putExtra(DetailActivity.EXTRA_INFO, info);
        startActivity(intent);
    }

    public void onClickSelect(View view) {
        //Get a reference to the Spinner
        Spinner building = (Spinner) findViewById(R.id.building);
        //Get the selected item in the Spinner
        String buildingName = String.valueOf(building.getSelectedItem());

        // Returns string with info that I need
        getResources().getString(R.string.cis_info);

        //building.onItemSelectedListener();
        // first item in list is automatically selected - first item in spinner blank

    }
}
