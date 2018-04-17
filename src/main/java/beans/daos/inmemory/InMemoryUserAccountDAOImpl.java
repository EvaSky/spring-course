package beans.daos.inmemory;

import beans.daos.UserAccountDAO;
import beans.models.UserAccount;

public class InMemoryUserAccountDAOImpl implements UserAccountDAO {
    @Override
    public UserAccount create(UserAccount account) {
        return null;
    }

    @Override
    public void delete(UserAccount user) {

    }

    @Override
    public UserAccount get(long userId) {
        return null;
    }
}
