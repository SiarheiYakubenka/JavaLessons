package by.itclass.bank;

public enum Currency {
    BYN(1.0),
    USD(1.97),
    EUR(2.295),
    RUR(0.033810);

    private double price;
    Currency(double price){
        this.price = price;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "price=" + price +
                '}';
    }

    public double getPrice() {
        return price;
    }
}
