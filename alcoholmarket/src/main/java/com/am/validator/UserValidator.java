package com.am.validator;

import com.am.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (StringUtils.isEmpty(user.getName())) {
            errors.rejectValue("name", "invalid name");
        }
        if (StringUtils.isEmpty(user.getPassword())) {
            errors.rejectValue("password", "invalid password");
        }
        if (StringUtils.isEmpty(user.getMail())) {
            errors.rejectValue("mail", "invalid mail");
        }
        if (StringUtils.isEmpty(user.getPhone())) {
            errors.rejectValue("phone", "invalid phone");
        }
    }
}
