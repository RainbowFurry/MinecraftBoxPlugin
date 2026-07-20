package net.rainbowfurry.boxSMP.data;

public enum BoxData {

    SIZE_1(16, 2000),
    SIZE_2(32, 2000),
    SIZE_3(48, 2000),
    SIZE_4(64, 2000);

    private final int size;
    private final double price;

    BoxData(int size, double price) {
        this.size = size;
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

}
