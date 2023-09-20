package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.enums;

public enum EmployeeStatus {
    ACTIVE(1),
    IN_ACTIVE(0),
    TERMINATED(-1);

    private int value;

    EmployeeStatus(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
