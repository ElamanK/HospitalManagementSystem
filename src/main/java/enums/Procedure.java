package enums;

public enum Procedure {
    CT_SCAN("$200", "30min", "CT_SCAN"),
    XRAY("$250", "15min", "XRAY"),
    ULTRASOUND("$180", "10min", "ULTRASOUND");

    private final String cost;
    private final String duration;
    private final String procedureName;

    Procedure(String cost, String duration, String procedureName) {
        this.cost = cost;
        this.duration = duration;
        this.procedureName = procedureName;
    }

    public String getCost() {
        return cost;
    }
    public String getDuration() {
        return duration;
    }
    public String getProcedureName() {
        return procedureName;
    }
    public static Procedure getProcedureByName(String procedureName) {
        if (procedureName.equalsIgnoreCase(Procedure.CT_SCAN.getProcedureName())) {
            return CT_SCAN;
        } else if (procedureName.equalsIgnoreCase(Procedure.XRAY.getProcedureName())) {
            return XRAY;
        } else if (procedureName.equalsIgnoreCase(Procedure.ULTRASOUND.getProcedureName())) {
            return ULTRASOUND;
        }
        return null;
    }

}

