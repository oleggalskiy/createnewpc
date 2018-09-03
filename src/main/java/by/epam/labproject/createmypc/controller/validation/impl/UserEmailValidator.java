package by.epam.labproject.createmypc.controller.validation.impl;

import by.epam.labproject.createmypc.controller.validation.ValidationResult;
import by.epam.labproject.createmypc.controller.validation.Validator;
import by.epam.labproject.createmypc.controller.validation.messages.Message;

public class UserEmailValidator implements Validator {

    private final String userEmail;

    public UserEmailValidator(String userEmail) {
        this.userEmail= userEmail;
    }


    @Override
    public ValidationResult validate() {
        if (userEmail == null || userEmail.equals("")) {
            return new ValidationResult(new Message(Message.EMAIL_NULL));
        }
        return ValidationResult.successResult();
    }
}
