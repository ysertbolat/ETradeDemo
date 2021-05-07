package ETradeDemo.business.concretes;

import ETradeDemo.business.abstracts.UserLoginService;
import ETradeDemo.entities.concretes.User;

public class UserLoginManager implements UserLoginService {
    private UserValidationManager userValidationManager;

    public UserLoginManager(UserValidationManager userValidationManager) {
        this.userValidationManager = userValidationManager;
    }
    @Override
    public boolean login(User user) {

        if(userValidationManager.Validation(user) == false) {
            if (user.getEmail().isEmpty() && user.getPassword().isEmpty()){
                System.out.println("Hatalı giriş");
            }
            return false;
        }else{
            System.out.println("Giriş başarılı. Hoşgeldin : " + user.getFirstName());
            return true;
        }
    }

    @Override
    public boolean logout(User user) {
        return false;
    }
}
