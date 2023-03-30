package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс представляет собой главный сервис банка
 * * @author VLADISLAV GABRUSENOK
 *  * @version 1.0
 */
public class BankService {
    /**
     * Хранение задания осуществляется в карте HashMap
     * Данная карта содержит всех пользователей системы
     * с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод должен добавить пользователя в систему
     * @param user - пользователь банка
     */
    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<Account>());
        }
    }

    /**
     * Метод должен удалить пользователя из системы
     * @param passport - номер паспорта пользователя, которого нужно удалить
     * @return возвращает результат операции
     */
    public boolean deleteUser(String passport) {
        if (users.containsKey(findByPassport(passport))) {
            users.remove(findByPassport(passport));
            return true;
        }
        return false;
    }

    /**
     * Метод по паспорту находит пользователя и добавляет в список аккаунтов новый
     * @param passport для верификации пользователя
     * @param account новый счет пользователя
     */
    public void addAccount(String passport, Account account) {
        if (users.containsKey(findByPassport(passport))) {
            User user = findByPassport(passport);
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     *
     * @param passport идентификатор пользователя
     * @return возвращает User с passport идентичным введенному идентификатору
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }
    /**
     *
     * @param passport идентефикатор пользователя
     * @param requisite идентефикатор счета пользователя
     * Метод принимает passport, через метод findByPassport извлекаает пользователя
     * по извлеченному пользователю возвращается коллекция с account
     * @return возвращает аккаунт с реквизитами идентичными введенным
     */

    public Account findByRequisite(String passport, String requisite) {
        if (users.get(findByPassport(passport)) != null) {
            for (Account account : users.get(findByPassport(passport))) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }
    /**
     * Метод принимает пасспорт и реквизиты получателя и отправителя
     * Нахоодит из аккаунты и переводит сумму amount получателю, снимая со счета отправителя
     * @param srcPassport пасспорт отправителя
     * @param srcRequisite счет отправителя
     * @param destPassport пасспорт получателя
     * @param destRequisite счет получателя
     * @param amount сумма перевода
     * @return возвращает осуществлен перевож или нет
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = true;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
            if (srcAccount == null
            || destAccount == null
            || srcAccount.getBalance() < amount) {
                rsl = false;
        } else {
                srcAccount.setBalance(srcAccount.getBalance() - amount);
                destAccount.setBalance(destAccount.getBalance() + amount);
            }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}