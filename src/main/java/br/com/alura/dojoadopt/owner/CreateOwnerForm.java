package br.com.alura.dojoadopt.owner;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateOwnerForm(@NotBlank @Size(max = 100) String name, @NotBlank String cpf, @PastOrPresent @NotNull LocalDate birthday, @NotNull BigDecimal remuneration, @NotNull HousingKind housingKind) {
}
