package br.com.alura.dojoadopt.owner;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class NewAdoptionValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return NewAdoptionForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        NewAdoptionForm form = (NewAdoptionForm) target;


    }
}
