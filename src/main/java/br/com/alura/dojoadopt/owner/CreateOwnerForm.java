package br.com.alura.dojoadopt.owner;

import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateOwnerForm(
        @NotBlank @Size(max = 100) String name,
        @NotBlank @CPF String cpf,
        @PastOrPresent @NotNull LocalDate birthday,
        @NotNull @PositiveOrZero BigDecimal remuneration,
        @NotNull HomeKind homeKind,
        @NotBlank @URL String photoUrl
) {
    public Owner toModel() {
        return new Owner(name, cpf, birthday, remuneration, homeKind, photoUrl);
    }
}
