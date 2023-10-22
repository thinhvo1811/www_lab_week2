package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.enums;

public enum UserType {
    CUSTOMER(0),
    EMPLOYEE(1);

    private int value;

    UserType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
