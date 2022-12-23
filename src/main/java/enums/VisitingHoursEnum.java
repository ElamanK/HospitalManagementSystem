package enums;

public enum VisitingHoursEnum {
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

    VisitingHoursEnum(String workingHour){
    this.workingHour=workingHour;
    }

}
