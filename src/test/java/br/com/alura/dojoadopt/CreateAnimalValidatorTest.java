package br.com.alura.dojoadopt;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.math.BigDecimal;
import java.time.LocalDate;

import static br.com.alura.dojoadopt.AnimalKind.*;
import static br.com.alura.dojoadopt.AnimalSize.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreateAnimalValidatorTest {

    private AnimalRepository animalRepository;
    private CreateAnimalValidator validator;

    @BeforeEach
    void setUp() {
        animalRepository = mock(AnimalRepository.class);
        validator = new CreateAnimalValidator(animalRepository);
    }

    @Test
    @DisplayName("should reject when an animal with same name and type already exists")
    void should_reject_when_an_animal_with_same_name_and_type_already_exists() {
        CreateAnimalForm form = new CreateAnimalForm("Osvaldo Pinto", BigDecimal.TEN, LocalDate.now(), FISH, MEDIUM, "https://s2.static.brasilescola.uol.com.br/be/2020/12/peixe.jpg");
        Errors errors = new BeanPropertyBindingResult(form, "createAnimaForm");

        when(animalRepository.existsByNameAndAnimalKind("Osvaldo Pinto", FISH)).thenReturn(true);

        validator.validate(form, errors);

        assertThat(errors.getGlobalErrors()).extracting(DefaultMessageSourceResolvable::getCode).containsExactly("createAnimalForm.name.and.type.already.exists");
    }

    @Test
    @DisplayName("should not reject when an animal with same name and type does not exist")
    void should_not_reject_when_an_animal_with_same_name_and_type_does_not_exist() {
        CreateAnimalForm form = new CreateAnimalForm("Osvaldo Pinto", BigDecimal.TEN, LocalDate.now(), FISH, MEDIUM, "https://s2.static.brasilescola.uol.com.br/be/2020/12/peixe.jpg");
        Errors errors = new BeanPropertyBindingResult(form, "createAnimaForm");

        when(animalRepository.existsByNameAndAnimalKind("Osvaldo Pinto", FISH)).thenReturn(false);

        validator.validate(form, errors);

        assertThat(errors.getGlobalErrors()).isEmpty();
    }
}