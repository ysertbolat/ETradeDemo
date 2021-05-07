package ETradeDemo.business.abstracts;

import ETradeDemo.entities.concretes.User;

public interface UserLoginService {
    boolean login(User user);
    boolean logout(User user);
}
