package com.znaji.keys;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ProductKey implements Serializable {

    private Long number;
    private String code;

    public ProductKey() {
    }

    public ProductKey(Long number, String code) {
        this.number = number;
        this.code = code;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
