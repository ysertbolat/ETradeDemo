package ETradeDemo.business.abstracts;

import ETradeDemo.entities.concretes.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> getAll();
}
