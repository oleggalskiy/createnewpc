package by.epam.labproject.createmypc.controller.validation.impl;

import by.epam.labproject.createmypc.controller.validation.ValidationResult;
import by.epam.labproject.createmypc.controller.validation.Validator;
import by.epam.labproject.createmypc.controller.validation.messages.Message;

public class UserPasswordValidator implements Validator {
    private final String password;

    public UserPasswordValidator(String password) {
        this.password= password;
    }



    @Override
    public ValidationResult validate() {
        if (password == null || password.equals("")) {
            return new ValidationResult(new Message(Message.PASSWORD_NULL));
        }
        return ValidationResult.successResult();
    }
}
