package com.hospital_management.procedures;

public class UltraSound {
    private String duration = "10min";
    private String cost = "$180";

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
