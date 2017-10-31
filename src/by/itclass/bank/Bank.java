package by.itclass.bank;

import by.itclass.bank.Client;
import by.itclass.bank.Currency;
import by.itclass.bank.Storage;
import by.itclass.bank.accounts.Account;
import by.itclass.bank.accounts.DebetAccount;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Bank {

    private Set<Client> clients;
    private Map<Long, Account> accounts;
    private Map<Long, Storage> storages;

    private Map<Client, Set<Long>> clientAccount;
    private Map<Client, Set<Long>> clientStorages;

    private Long accountId;
    private Long storageId;

    public Bank(){
        clients = new HashSet<>();
        accounts = new HashMap<>();
        storages = new HashMap<>();
        clientAccount = new HashMap<>();
        clientStorages = new HashMap<>();
    }



    public void registerClient(String name, String surname, String passpotNumber){
        Client client = new Client(name, surname, passpotNumber);
        clients.add(client);
        clientAccount.put(client, new HashSet<>());
        clientStorages.put(client, new HashSet<>());
    }

    public Long askForNewDebitAccount(Client client, Currency currency){
        if (client == null) throw new IllegalArgumentException();
        DebetAccount account = new DebetAccount(currency);
        accounts.put(accountId, account);
        clientAccount.get(client).add(accountId);
        long temp = accountId;
        accountId++;
        return temp;
    }


}
