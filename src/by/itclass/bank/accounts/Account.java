package by.itclass.bank.accounts;

import by.itclass.bank.Currency;

public abstract class Account {

    protected  double amount;
    private final Currency currency;

    public Account (Currency currency){
        this.currency = currency;
        this.amount = 0.0;
    }

    public  void  deposit(double amount){
        if (amount <= 0) {
            throw  new IllegalArgumentException("Сумма должна быть больше 0");
        }
        this.amount += amount;
    }

    public abstract void withdrow(double amount);

    public void transfer(Account account, double amount){
        if(account == null) throw new IllegalArgumentException("Счет не может быть пустым");
        this.withdrow(amount);
        double resultAmount = amount * this.currency.getPrice() / account.currency.getPrice();
        this.deposit(resultAmount);
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }
}
