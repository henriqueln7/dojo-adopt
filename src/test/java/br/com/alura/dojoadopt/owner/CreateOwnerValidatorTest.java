package br.com.alura.dojoadopt.owner;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class CreateOwnerValidatorTest {

    private OwnerRepository ownerRepository;
    private CreateOwnerValidator validator;

    @BeforeEach
    void setUp() {
        ownerRepository = Mockito.mock(OwnerRepository.class);
        validator = new CreateOwnerValidator(ownerRepository);
    }

    @Test
    @DisplayName("should reject if some owner with same cpf already exists")
    void should_reject_if_some_owner_with_same_cpf_already_exists() {
        CreateOwnerForm form = new CreateOwnerForm("Henrique", "90599305096", LocalDate.now(), BigDecimal.TEN, HomeKind.HOUSE, "https://blog.jetbrains.com/idea/2013/03/use-the-utf-8-luke-file-encodings-in-intellij-idea/");
        Errors errors = new BeanPropertyBindingResult(form, "createAnimaForm");

        when(ownerRepository.existsByCpf("90599305096")).thenReturn(true);

        validator.validate(form, errors);

        assertThat(errors.getFieldError("cpf")).extracting(DefaultMessageSourceResolvable::getCode)
                                               .isEqualTo("createOwnerForm.cpf.already.exists");
    }

    @Test
    @DisplayName("should not reject if some owner with same cpf does not exist")
    void should_not_reject_if_some_owner_with_same_cpf_does_not_exist() {
        CreateOwnerForm form = new CreateOwnerForm("Henrique", "90599305096", LocalDate.now(), BigDecimal.TEN, HomeKind.HOUSE, "https://blog.jetbrains.com/idea/2013/03/use-the-utf-8-luke-file-encodings-in-intellij-idea/");
        Errors errors = new BeanPropertyBindingResult(form, "createAnimaForm");

        when(ownerRepository.existsByCpf("90599305096")).thenReturn(false);

        validator.validate(form, errors);

        assertThat(errors.getFieldError("cpf")).isNull();
    }

}