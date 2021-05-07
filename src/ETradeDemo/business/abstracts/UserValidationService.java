package ETradeDemo.business.abstracts;

import ETradeDemo.entities.concretes.User;

public interface UserValidationService {

    boolean passwordValidation(User user);

    boolean emailValidation(User user);

    boolean firstLastNameValidation(User user);

    boolean Validation(User user);
}
