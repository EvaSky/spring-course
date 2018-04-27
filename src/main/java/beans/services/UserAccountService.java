package beans.services;

import beans.models.UserAccount;

public interface UserAccountService {

    UserAccount save(UserAccount account);

    void delete(UserAccount account);

    UserAccount get(long userId);
}
