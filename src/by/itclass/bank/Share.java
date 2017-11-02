package by.itclass.bank;

public class Share implements Storable {

    private  final  String company;
    private double price;

    public Share(String company, double price) {
        if (company == null || company.isEmpty()) throw new IllegalArgumentException();
        this.company = company;
        this.price = price;
    }


    public double getPrice() {
        return price;
    }

    @Override
    public int getMaxAmount() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Share share = (Share) o;

        return company.equals(share.company);
    }

    @Override
    public String toString() {
        return "Share{" +
                "company='" + company + '\'' +
                ", price=" + price +
                '}';
    }
}
