package by.itclass.bank.accounts;

import by.itclass.bank.Currency;

public class CreditAccount extends Account {

    private final  int percent;

    public CreditAccount(Currency currency, int percent) {
        super(currency);
        if(percent <=0) throw  new IllegalArgumentException("Процент должет быть положительным");
        this.percent = percent;
    }

    @Override
    public void withdrow(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Неправильная сумма для снятия");
    }

    public  void  recalcMonthIncome(){
        if (this.amount < 0 ){
            this.amount -= Math.abs(percent) * this.amount / 100;
        }
    }

    @Override
    public String toString() {
        return "PercentAccount{" +
                "percent=" + percent +
                ", amount=" + amount +
                ", currency="+getCurrency()+
                '}';
    }
}
