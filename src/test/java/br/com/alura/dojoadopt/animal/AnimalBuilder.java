package br.com.alura.dojoadopt.animal;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AnimalBuilder {
    private String name = "Meu animalzinho";
    private BigDecimal monthlyCost = new BigDecimal("500");
    private LocalDate birthday = LocalDate.parse("2003-12-12");
    private AnimalKind animalKind = AnimalKind.CAT;
    private AnimalSize animalSize = AnimalSize.MEDIUM;
    private String photoUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Cat_November_2010-1a.jpg/1200px-Cat_November_2010-1a.jpg";

    public AnimalBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public AnimalBuilder withMonthlyCost(BigDecimal monthlyCost) {
        this.monthlyCost = monthlyCost;
        return this;
    }

    public AnimalBuilder withBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public AnimalBuilder withKind(AnimalKind kind) {
        this.animalKind = kind;
        return this;
    }

    public AnimalBuilder withSize(AnimalSize size) {
        this.animalSize = size;
        return this;
    }

    public AnimalBuilder withPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

    public Animal build() {
        return new Animal(this.name, this.monthlyCost, this.birthday, this.animalKind, this.animalSize, this.photoUrl);
    }

    public static AnimalBuilder anAnimal() {
        return new AnimalBuilder();
    }
}
