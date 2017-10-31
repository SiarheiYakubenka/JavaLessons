package by.itclass.bank.accounts;

import by.itclass.bank.Currency;

public class PercentAccount extends  Account {

    private final  int percent;

    public PercentAccount(Currency currency, int percent) {
        super(currency);
        if (percent <= 0) throw new IllegalArgumentException("");
        this.percent = percent;
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
        return "PercentAccount{" +
                "percent=" + percent +
                ", amount=" + amount +
                ", currency="+getCurrency()+
                '}';
    }

    public  void  recalcMonthIncome(){
        if (this.amount > 0 ){
            this.amount += percent * this.amount / 100;
        }
    }
}
