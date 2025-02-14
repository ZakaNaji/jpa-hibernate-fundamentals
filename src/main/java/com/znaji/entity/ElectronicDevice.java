package com.znaji.entity;

import jakarta.persistence.Entity;

@Entity
public class ElectronicDevice extends AbstractProduct{

    private long voltage;

    public long getVoltage() {
        return voltage;
    }

    public void setVoltage(long voltage) {
        this.voltage = voltage;
    }

    @Override
    public String toString() {
        return "ElectronicDevice{" +
                "voltage=" + voltage +
                '}';
    }
}
