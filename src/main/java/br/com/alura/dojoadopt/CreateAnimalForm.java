package br.com.alura.dojoadopt;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateAnimalForm(@NotBlank @Size(max = 50) String name,
                               @Min(10) BigDecimal monthlyCost,
                               @PastOrPresent LocalDate birthday,
                               @NotNull AnimalKind animalKind,
                               @NotNull AnimalSize animalSize,
                               @NotBlank @URL String photoUrl) {
}
