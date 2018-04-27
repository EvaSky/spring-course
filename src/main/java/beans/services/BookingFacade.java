package beans.services;

import beans.models.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class BookingFacade {

    @Autowired
    private UserAccountService accountService;

    public void deposit(double amount, UserAccount account) {
        account.setAmountMoney(account.getAmountMoney() + amount);
        accountService.save(account);
    }

    public void withdraw(double amount, UserAccount account) {
        if (account.getAmountMoney() - amount >= 0) {
            account.setAmountMoney(account.getAmountMoney() - amount);
            accountService.save(account);
        } else {
            throw new IllegalStateException("There isn't enough money in the account");
        }
    }

    public double checkBalance(UserAccount account) {
        return account.getAmountMoney();
    }
}
