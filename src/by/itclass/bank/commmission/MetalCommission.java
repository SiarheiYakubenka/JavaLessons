package by.itclass.bank.commmission;

import by.itclass.bank.Metal;
import by.itclass.bank.Share;
import by.itclass.bank.Storage;
import by.itclass.bank.accounts.Account;

public class MetalCommission extends  Commission<Storage> {


    private  final Storage storage;
    private Account account;

    public  MetalCommission(Storage storage, Account account){
        if (storage != null || storage.getValue().getClass() != Metal.class){
            throw new IllegalArgumentException("Хранилище не должно отсутствовать или хранить что-то кроме металла");
        }
        if (account == null) {
            throw new IllegalArgumentException("Обслуживающий счет не должен отсутствовать");
        }
        this.storage = storage;
        this.account = account;
    }

    @Override
    public void checkCommissionMonthly() {
        Share share =(Share)storage.getValue();
        double sum = storage.getAmount() * share.getPrice();
        account.withdrow(Math.ceil(sum/50) * 0.1);

    }
}
