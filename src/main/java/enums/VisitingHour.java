package enums;

public enum VisitingHour {
    SUNDAY("closed"),
    MONDAY("9-5"),
    TUESDAY("9-5"),
    WEDNESDAY("9-5"),
    THURSDAY("9-5"),
    FRIDAY("9-5"),
    SATURDAY("9-3");

    private final String workingHour;
    public String getWorkingHour() {
        return workingHour;
    }
    VisitingHour(String workingHour){
    this.workingHour=workingHour;
    }

}
