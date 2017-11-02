package by.itclass.bank;

public enum Metal implements Storable{

    SILVER(1.01),
    GOLD(77.3),
    PLATINUM(55.47),
    PALLADIUM(56.18);

    private double price;

    Metal(double price){
        this.price = price;
    }

    public void setPrice(double price) {
        if (price<=0) throw new IllegalArgumentException("Цена метала не может быть меньше нуля");
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

        @Override
        public int getMaxAmount() {
            return 0;
        }
}

