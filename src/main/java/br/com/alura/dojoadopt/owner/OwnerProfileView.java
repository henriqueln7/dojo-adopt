package br.com.alura.dojoadopt.owner;

import br.com.alura.dojoadopt.animal.Animal;

import java.math.BigDecimal;
import java.util.List;

public record OwnerProfileView(String name,
                               String cpf,
                               BigDecimal remuneration,
                               BigDecimal monthlyExpenses,
                               String photoUrl,
                               List<AdoptedAnimalView> adoptedAnimals) {
    public OwnerProfileView(Owner owner) {
        this(owner.getName(),
             owner.getCpf(),
             owner.getRemuneration(),
             owner.getMonthlyExpenses(),
             owner.getPhotoUrl(),
             owner.getAnimals().stream().map(AdoptedAnimalView::new).toList());
    }

    public record AdoptedAnimalView(String photoUrl, String name) {
        public AdoptedAnimalView(Animal animal) {
            this(animal.getPhotoUrl(), animal.getName());
        }
    }
}
