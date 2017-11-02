package by.itclass.bank.commmission;

import by.itclass.bank.Currency;
import by.itclass.bank.accounts.Account;

public class AccauntCommission extends Commission<Account> {

    private final Account account;

    public AccauntCommission(Account account) {
        if(account == null){
            throw new IllegalArgumentException("Нельзя создать коммисию с пустым счетом");
        }
        this.account = account;
    }


    @Override
    public void checkCommissionMonthly() {

        Currency currency = account.getCurrency();
        switch (currency){

            case BYN:
                account.withdrow(0.01);
                break;
            case EUR:
        }

    }
}
