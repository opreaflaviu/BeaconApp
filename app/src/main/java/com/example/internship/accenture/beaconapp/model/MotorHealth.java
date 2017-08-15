package com.example.internship.accenture.beaconapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by oprea.flaviu on 8/14/2017.
 */

public class MotorHealth {

    @SerializedName("asset")
    private String asset;

    @SerializedName("isLive")
    private String isLive;

    @SerializedName("frequency")
    private String frequency;

    @SerializedName("health")
    private String health;

    public MotorHealth() {
    }

    public MotorHealth(String asset, String isLive, String frequency, String health) {
        this.asset = asset;
        this.isLive = isLive;
        this.frequency = frequency;
        this.health = health;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getIsLive() {
        return isLive;
    }

    public void setIsLive(String isLive) {
        this.isLive = isLive;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }
}
