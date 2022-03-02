package br.com.alura.dojoadopt.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CreateOwnerValidator implements Validator {

    private final OwnerRepository ownerRepository;

    public CreateOwnerValidator(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return CreateOwnerForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        CreateOwnerForm form = (CreateOwnerForm) target;

        if (ownerRepository.existsByCpf(form.cpf())) {
            errors.rejectValue("cpf", "createOwnerForm.cpf.already.exists");
        }
    }
}
