package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> accounts = new ArrayList<Account>();
        if (!users.containsKey(user.getPassport())) {
            users.put(user, accounts);
        }
    }

    public void addAccount(String passport, Account account) {
        if (findByPassport(passport) != null) {
            List<Account> accounts = users.get(findByPassport(passport));
            if (accounts.size() == 0) {
                accounts.add(account);
            } else if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        return rsl;
    }
}
