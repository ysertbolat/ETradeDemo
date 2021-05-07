package ETradeDemo.business.concretes;

import ETradeDemo.business.abstracts.UserValidationService;
import ETradeDemo.dataAccess.abstracts.UserDao;
import ETradeDemo.entities.concretes.User;
import ETradeDemo.utils.Validations;

import java.util.regex.Pattern;

public class UserValidationManager implements UserValidationService {
    private UserDao userDao;
    public UserValidationManager(UserDao userDao)
    {
        this.userDao = userDao;
    }

    @Override
    public boolean passwordValidation(User user) {
        if (user.getPassword().length() < 6){
            System.out.println("Şifre 6 karakterden fazla olmalıdır.");
            return false;
        }else{
            return true;
        }

    }

    @Override
    public boolean emailValidation(User user) {
        String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(user.getEmail()).find();
    }

    @Override
    public boolean firstLastNameValidation(User user) {
        if(user.getFirstName().length() < 2 && user.getLastName().length() < 2){
            System.out.println("Ad-Soyad en az 2 karakterden oluşmalıdır.");
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean Validation(User user) {
        boolean validation = Validations.run(passwordValidation(user), emailValidation(user),
                firstLastNameValidation(user));

        return validation;
    }
}
