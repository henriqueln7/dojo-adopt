package br.com.alura.dojoadopt;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CreateAnimalValidator implements Validator {

    private final AnimalRepository animalRepository;

    public CreateAnimalValidator(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return CreateAnimalForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        CreateAnimalForm form = (CreateAnimalForm) target;

        if (animalRepository.existsByNameAndAnimalKind(form.name(), form.animalKind())) {
            errors.reject("createAnimalForm.name.and.type.already.exists");
        }

    }
}
