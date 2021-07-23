package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу банковского сервиса
 * @author YURI TARASENKO
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение всех пользователей системы существляется в коллекции типа HashMap
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * метод должен добавить пользователя в систему
     * @param user пользователь, который добавляется в систему
     */
    public void addUser(User user) {
     users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод должен добавить новый счет к пользователю. Пользователя находим
     * по паспорту с помощ метод findByPassport.После этого мы получяем список
     * всех счетов пользователя и добавим новый счет к ним. В этом методе
     * есть проверка, что такого счета у пользователя еще нет.
     * @param passport паспорт пользователя
     * @param account счет пользователя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     * @param passport паспорт пользователя
     * @return возвращает пользователя или null, если он не найден
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }
    /*public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }*/

    /**
     * Этот метод ищет счет пользователя по реквизитам. Сначала находим пользователя.
     * Потом получаем список счетов этого пользователя и в нем находим нужный счет.
     * @param passport паспорт пользователя
     * @param requisite реквизиты пользователя
     * @return возвращает счет пользователя или null, если счет не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User a = findByPassport(passport);
        if (a != null) {
            return users.get(a)
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }
    /*public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }*/

    /**
     * Метод для перечисления денег с одного счёта на другой счёт.
     * Если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят),
     * то метод должен вернуть false
     * @param srcPassport паспорт источника
     * @param srcRequisite реквизиты источника
     * @param destPassport паспорт получателя
     * @param destRequisite реквизиты получателя
     * @param amount доступные средства на счете источника
     * @return true если перевод выполнится или false, если не возможен.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if ((srcAcc != null) && (destAcc != null) && (srcAcc.getBalance() >= amount)) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
            return true;
        }
        return false;
    }
}
