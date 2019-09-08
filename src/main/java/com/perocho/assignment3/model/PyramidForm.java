package com.perocho.assignment3.model;

import java.io.Serializable;

public class PyramidForm implements Serializable {
    private int baseN = 0;
    private double baseSide = 0;
    private double height = 0;

    public PyramidForm() {
    }

    public int getBaseN() {
        return baseN;
    }

    public double getBaseSide() {
        return baseSide;
    }

    public double getHeight() {
        return height;
    }
    // TODO: refactor. Being unused
    public void setBaseN(int baseN) {
        this.baseN = baseN;
    }
    // TODO: refactor. pyramid form method being unused.
    public void setBaseSide(double baseSide) {
        this.baseSide = baseSide;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBaseArea() {
        return ((baseN * (baseSide * baseSide)) / (4 * Math.tan(Math.PI / baseN)));
    }

    public double getVolume() {
        return getBaseArea() / (height * 3);
    }
}
