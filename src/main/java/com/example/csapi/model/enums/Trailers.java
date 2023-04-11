package com.example.csapi.model.enums;

public enum Trailers {
    FLATBED_SMALL(TrailerType.FLATBED, TrailerSize.SMALL),
    FLATBED_MEDIUM(TrailerType.FLATBED, TrailerSize.MEDIUM),
    FLATBED_LARGE(TrailerType.FLATBED, TrailerSize.LARGE),
    DRY_SMALL(TrailerType.DRY_VAN, TrailerSize.SMALL),
    DRY_MEDIUM(TrailerType.DRY_VAN, TrailerSize.MEDIUM),
    DRY_LARGE(TrailerType.DRY_VAN, TrailerSize.LARGE),
    REFRIGERATED_SMALL(TrailerType.REFRIGERATED, TrailerSize.SMALL),
    REFRIGERATED_MEDIUM(TrailerType.REFRIGERATED, TrailerSize.MEDIUM),
    REFRIGERATED_LARGE(TrailerType.REFRIGERATED, TrailerSize.LARGE),
    LOWBOY_SMALL(TrailerType.LOWBOY, TrailerSize.SMALL),
    LOWBOY_MEDIUM(TrailerType.LOWBOY, TrailerSize.MEDIUM),

    LOWBOY_LARGE(TrailerType.LOWBOY, TrailerSize.LARGE),
    STEP_DECK_SMALL(TrailerType.STEP_DECK, TrailerSize.SMALL),
    STEP_DECK_MEDIUM(TrailerType.STEP_DECK, TrailerSize.MEDIUM),
    STEP_DECK_LARGE(TrailerType.STEP_DECK, TrailerSize.LARGE),
    DOUBLE_DROP_SMALL(TrailerType.DOUBLE_DROP, TrailerSize.SMALL),
    DOUBLE_DROP_MEDIUM(TrailerType.DOUBLE_DROP, TrailerSize.MEDIUM),
    DOUBLE_DROP_LARGE(TrailerType.DOUBLE_DROP, TrailerSize.LARGE);


    ;

    private final TrailerType trailerType;
    private final TrailerSize trailerSize;

    Trailers(TrailerType trailerType, TrailerSize trailerSize) {
        this.trailerType = trailerType;
        this.trailerSize = trailerSize;
    }

    public TrailerType getTrailerType() {
        return trailerType;
    }

    public TrailerSize getTrailerSize() {
        return trailerSize;
    }
}