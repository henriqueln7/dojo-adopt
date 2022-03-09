package br.com.alura.dojoadopt.owner;

import javax.validation.constraints.NotNull;

public record NewAdoptionForm(@NotNull Long ownerId, @NotNull Long animalId) {
}
