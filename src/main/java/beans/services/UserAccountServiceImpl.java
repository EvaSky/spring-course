package beans.services;

import beans.daos.UserAccountDAO;
import beans.daos.UserDAO;
import beans.models.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    @Qualifier("userAccountDAO")
    private UserAccountDAO accountDAO;

    @Autowired
    @Qualifier("userDAO")
    private UserDAO userDAO;

    @Override
    public UserAccount save(UserAccount account) {
        if (account == null) {
            throw new NullPointerException("Account must not be null");
        }
        return accountDAO.create(account);
    }

    @Override
    public void delete(UserAccount account) {
        if (account != null) {
            long userId = account.getUserId();
            if (userDAO.get(userId) != null) {
                accountDAO.delete(account);
            } else {
                throw new IllegalArgumentException("Invalid account");
            }
        } else {
            throw new NullPointerException("Account must not be null");
        }

    }

    @Override
    public UserAccount get(long userId) {
        return accountDAO.get(userId);
    }
}
