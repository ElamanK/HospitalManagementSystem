package enums;

public enum ProceduresEnum {
    CT_SCAN("$200","30min"),
    XRAY("$250","15min"),
    ULTRASOUND("$180","10min");

    private final String cost;
    private final String duration;

    public String getCost() {
        return cost;
    }

    public String getDuration() {
        return duration;
    }

    ProceduresEnum(String cost, String duration){
        this.cost=cost;
        this.duration=duration;
    }
}
