package com.hfad.bitsandpizzas;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BuildingFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView buildingRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_building, container, false);

        String[] buildingNames = new String[Building.buildings.length];
        for (int i = 0; i < buildingNames.length; i++) {
            buildingNames[i] = getResources().getString(Building.buildings[i].getName());
        }

        int[] buildingImages = new int[Building.buildings.length];
        for (int i = 0; i < buildingImages.length; i++) {
            buildingImages[i] = Building.buildings[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(buildingNames, buildingImages);
        buildingRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        buildingRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_BUILDINGID, position);
                getActivity().startActivity(intent);
            }
        });
        return buildingRecycler;
    }
}
