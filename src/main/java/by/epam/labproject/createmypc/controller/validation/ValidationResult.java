package by.epam.labproject.createmypc.controller.validation;

import by.epam.labproject.createmypc.controller.validation.messages.Message;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {

    private final List<Message> resultMessages = new ArrayList<Message>();

    private ValidationResult() {
    }

    public ValidationResult(Message errorMessage) {
        resultMessages.add(errorMessage);
    }

    public static ValidationResult successResult() {
        return new ValidationResult();
    }

    public List<Message> getResultMessages() {
       return resultMessages;
    }

    public boolean isSucceed() {
        return resultMessages.isEmpty();
    }

    public void addError(Message errorMessage) {
        if(!resultMessages.contains(errorMessage))
        resultMessages.add(errorMessage);
    }


    public void merge(ValidationResult result) {
        resultMessages.addAll(result.resultMessages);
    }
}
