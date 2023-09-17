package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.enums;

public enum ProductStatus {
    ACTIVE(1),
    DEACTIVE(0),
    DELETED(-1);

    private int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
