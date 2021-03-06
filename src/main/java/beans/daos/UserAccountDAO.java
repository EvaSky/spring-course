package beans.daos;

import beans.models.UserAccount;

public interface UserAccountDAO {

    UserAccount create(UserAccount account);

    void delete(UserAccount account);

    UserAccount get(long userId);
}
