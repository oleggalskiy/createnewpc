package by.epam.labproject.createmypc.controller.validation;

import java.util.ArrayList;
import java.util.List;

public class CompositeValidator implements Validator {

    private final List<Validator> validators = new ArrayList<Validator>();

    public void add(Validator validator) {
        validators.add(validator);
    }

    public void remove(Validator validator) {
        validators.remove(validator);
    }

    @Override
    public ValidationResult validate() {
        ValidationResult result = ValidationResult.successResult();
        for (Validator validator: validators) {
                    result.merge(validator.validate());}
        return result;
    }
}
