package ETradeDemo.business.concretes;

import ETradeDemo.business.abstracts.UserService;
import ETradeDemo.dataAccess.abstracts.UserDao;
import ETradeDemo.entities.concretes.User;

import java.util.List;

public class UserManager implements UserService {
    private UserDao userDao;
    private UserValidationManager userValidationManager;

    public UserManager(UserDao userDao, UserValidationManager userValidationManager){
        this.userDao = userDao;
        this.userValidationManager = userValidationManager;
    }

    @Override
    public void add(User user) {
        if (userValidationManager.Validation(user) == false)
        {
            System.out.println("Hatalı giriş");
            return;
        }else{
            this.userDao.add(user);
        }
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
