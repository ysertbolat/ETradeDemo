package ETradeDemo;

import ETradeDemo.business.abstracts.UserLoginService;
import ETradeDemo.business.abstracts.UserService;
import ETradeDemo.business.concretes.UserLoginManager;
import ETradeDemo.business.concretes.UserManager;
import ETradeDemo.business.concretes.UserValidationManager;
import ETradeDemo.core.abstracts.GoogleAuthService;
import ETradeDemo.core.adapters.GoogleAuthManagerAdapter;
import ETradeDemo.dataAccess.abstracts.UserDao;
import ETradeDemo.dataAccess.concretes.HibernateUserDao;
import ETradeDemo.entities.concretes.User;

public class Main {

    public static void main(String[] args) {
        User user1 = new User(1,"yusuf","sertbolat","y.sertbolat@gmail.com","1234567");

        UserDao userDao = new HibernateUserDao();
        UserValidationManager userValidationManager = new UserValidationManager(userDao);
        UserService userService = new UserManager(userDao, userValidationManager);
        UserLoginService userLoginService = new UserLoginManager(userValidationManager);

        GoogleAuthService googleAuthService = new GoogleAuthManagerAdapter();

        userValidationManager.Validation(user1);
        userDao.add(user1);
        userLoginService.login(user1);
        userService.add(user1);
        googleAuthService.send("y.sertbolat@gmail.com", "Hello World");

    }
}
