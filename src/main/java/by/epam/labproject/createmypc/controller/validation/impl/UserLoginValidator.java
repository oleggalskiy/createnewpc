package by.epam.labproject.createmypc.controller.validation.impl;

import by.epam.labproject.createmypc.controller.validation.ValidationResult;
import by.epam.labproject.createmypc.controller.validation.Validator;
import by.epam.labproject.createmypc.controller.validation.messages.Message;

public class UserLoginValidator implements Validator {
    private final String userName;

    public UserLoginValidator(String userName) {
        this.userName= userName;
    }


    @Override
    public ValidationResult validate() {
        if (userName == null || userName.equals("")) {
            return new ValidationResult(new Message(Message.USER_NAME_NULL));
        }
        return ValidationResult.successResult();
    }
}
