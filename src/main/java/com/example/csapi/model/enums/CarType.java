package com.example.csapi.model.enums;

public enum CarType {
    CARGO_VAN,
    SPRINTER_VAN,
    BOX_TRUCK_HARD_SIDE(StraightTypes.SMALL_STRAIGHT),
    BOX_TRUCK_CURTAIN_SIDE(StraightTypes.SMALL_STRAIGHT),
    LARGE_STRAIGHT(StraightTypes.LARGE_STRAIGHT),
    CONESTOGA(StraightTypes.SMALL_STRAIGHT),
    TRACTOR,
    FLATBED;

    private final StraightTypes straightType;
    CarType() {
        this.straightType = null;
    }

    CarType(StraightTypes straightType) {
        this.straightType = straightType;
    }

    public StraightTypes getStraightType() {
        return straightType;
    }
}
