package beans.daos.db;

import beans.daos.AbstractDAO;
import beans.daos.UserAccountDAO;
import beans.models.UserAccount;
import org.springframework.stereotype.Repository;

@Repository(value = "userAccountDAO")
public class UserAccountDAOImpl extends AbstractDAO implements UserAccountDAO {

    @Override
    public UserAccount create(UserAccount account) {
        getCurrentSession().saveOrUpdate(account);
        return account;
    }

    @Override
    public void delete(UserAccount userAccount) {
        getCurrentSession().delete(userAccount);
    }

    @Override
    public UserAccount get(long userId) {
        return getCurrentSession().get(UserAccount.class, userId);
    }
}
