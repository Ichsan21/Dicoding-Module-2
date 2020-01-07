package com.rizky92.latihanmvvm;

public class CuboidModel {
    private double width, length, height;

    public CuboidModel() {
    }

    public void save(double length, double width, double height) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    double getVolume() {
        return width * length * height;
    }

    public double getSurfaceArea() {
        double wl = width * length;
        double wh = width * height;
        double lh = length * height;

        return 2 * (wl + wh + lh);
    }

    public double getCircumference() {
        return 4 * (width + height + length);
    }
}
