package beans.daos;

import beans.models.UserAccount;

public interface UserAccountDAO {

    UserAccount create(UserAccount account);

    void delete(UserAccount user);

    UserAccount get(long userId);
}
