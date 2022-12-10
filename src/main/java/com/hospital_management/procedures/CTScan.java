package com.hospital_management.procedures;

public class CTScan {
    private String duration = "30min";
    private String cost = "$200";

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
