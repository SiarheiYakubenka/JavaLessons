package by.itclass.bank.accounts;

import by.itclass.bank.Currency;

public class DebetAccount extends Account {

    public DebetAccount(Currency currency) {
        super(currency);
    }

    @Override
    public void withdrow(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма для снятия должна быть больше 0");
        }
        if (this.amount < amount){
            throw new NotEnoughMoneyExeption();
        }
        this.amount-=amount;
    }

    @Override
    public String toString() {
        return "DebetAccount{" +
                "amount=" + amount +
                ", currency="+getCurrency()+
                '}';
    }
}
