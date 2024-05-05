package mvc.hiber.boot.utils;

import mvc.hiber.boot.dao.UserDAO;
import mvc.hiber.boot.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    private final UserDAO userDAO;

    @Autowired
    public UserValidator(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        if (userDAO.getUserByName(user.getName()).isPresent()) {
            errors.rejectValue("name", "400", "Пользователь с таким именем уже существует");
        }
    }
}
