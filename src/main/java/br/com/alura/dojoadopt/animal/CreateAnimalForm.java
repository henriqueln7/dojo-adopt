package br.com.alura.dojoadopt.animal;

import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.springframework.format.annotation.DateTimeFormat.ISO.*;

public record CreateAnimalForm(@NotBlank @Size(max = 50) String name,
                               @Min(10) @NotNull BigDecimal monthlyCost,
                               @PastOrPresent @DateTimeFormat(iso = DATE) LocalDate birthday,
                               @NotNull AnimalKind animalKind,
                               @NotNull AnimalSize animalSize,
                               @NotBlank @URL String photoUrl) {
    public Animal toModel() {
        return new Animal(name, monthlyCost, birthday, animalKind, animalSize, photoUrl);
    }
}
