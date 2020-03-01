package com.hfad.bitsandpizzas;

import android.app.Activity;

public class Building extends Activity {

    private int buildingName;
    private int buildingInfo;
    private int imageResourceId;
    private int buildingLink;
    private int buildingUrl;

    // buildings is an array of Buildings
    public static final Building[] buildings = {
            new Building(R.string.cis, R.string.cis_info, R.drawable.cisbuilding, R.string.cis_link, R.string.cis_url),
            new Building(R.string.hoggard, R.string.hoggard_info, R.drawable.hoggardhall, R.string.hoggard_link, R.string.hoggard_url),
            new Building(R.string.deloach, R.string.deloach_info, R.drawable.deloachhall, R.string.deloach_link, R.string.deloach_url),
            new Building(R.string.bear, R.string.bear_info, R.drawable.bearhall, R.string.bear_link, R.string.bear_url),
            new Building(R.string.dobo, R.string.dobo_info, R.drawable.dobohall, R.string.dobo_link, R.string.dobo_url)
    };

    // each building has a name, information, and an image resource
    private Building(int buildingName, int buildingInfo, int imageResourceId, int buildingLink, int buildingUrl) {
        this.buildingName = buildingName;
        this.buildingInfo = buildingInfo;
        this.imageResourceId = imageResourceId;
        this.buildingLink = buildingLink;
        this.buildingUrl = buildingUrl;
    }

    public int getUrl() { return buildingUrl; }

    public int getInformation() {
        return buildingInfo;
    }

    public int getName() {
        return buildingName;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public int getLink() { return buildingLink; }

    public String toString() {
        return getResources().getString(this.buildingName);
    }
}
