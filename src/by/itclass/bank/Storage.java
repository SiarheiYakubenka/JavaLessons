package by.itclass.bank;

import by.itclass.bank.accounts.NotEnoughMoneyExeption;

public class Storage {

    private Storable value;
    private  int amount;

    public Storage(Storable value) {

        if (value == null)
            throw new IllegalArgumentException("Необходимо указать непустое содержание для ячейки");
        this.value = value;
    }

    public int getAmount() {
        return amount;
    }

    public Storable getValue() {
        return value;
    }

    public void  wuthdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("");
        }
        if (this.amount < amount) {
            throw new NotEnoughMoneyExeption();
        }
        this.amount -= amount;
    }

    public void  deposit (int amount){
        if (amount <= 0){
            throw new IllegalArgumentException();
        }
        if (value.getMaxAmount() != 0){

        }
    }
}
