package edu.uncw.seahawktours;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

    private String lastBuilding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spin = findViewById(R.id.building);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] building_names = getResources().getStringArray(R.array.building_names);
                if (i==0) {
                    // do nothing
                }
                else {
                    String building;
                    String info;
                if (i == 1) {
                        // User selects CIS Building
                        building = building_names[1];
                        info = getResources().getString(R.string.cis_info);
                    } else if (i == 2) {
                        // User selects Hoggard Hall
                        building = building_names[2];
                        info = getResources().getString(R.string.hoggard_info);
                    } else if (i == 3) {
                        // User selects Deloach
                        building = building_names[3];
                        info = getResources().getString(R.string.deloach_info);
                    } else {
                        building = "";
                        info = "";
                    }
                    onChooseBuilding(building, info);
                    lastBuilding = building;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // do not worry about this
            }
        });

        if (savedInstanceState != null) {
            lastBuilding = savedInstanceState.getString("lastBuilding");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("lastBuilding", lastBuilding);
    }

    public void onChooseBuilding(String building, String info) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_BUILDING, building);
        intent.putExtra(DetailActivity.EXTRA_INFO, info);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (lastBuilding != null) {
            TextView previous = findViewById(R.id.last_building);
            String text = "Previous Building: " + lastBuilding;
            previous.setText(text);
        }
    }
}
