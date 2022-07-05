package com.demo.mediscreenwebapp.model;

public enum RiskLevel {
    NONE("None"),
    BORDERLINE("Borderline"),
    DANGER("Danger"),
    EARLY_ONSET("Early Onset");

    private final String displayValue;

    RiskLevel(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
