package br.com.alura.dojoadopt.owner;

import br.com.alura.dojoadopt.animal.Animal;
import br.com.alura.dojoadopt.animal.AnimalSize;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static javax.persistence.EnumType.STRING;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Size(max = 100)
    private String name;

    @NotBlank @CPF
    @Column(unique = true)
    private String cpf;

    @PastOrPresent @NotNull
    private LocalDate birthday;

    @NotNull @Positive
    private BigDecimal remuneration;

    @NotNull
    @Enumerated(STRING)
    private HomeKind homeKind;

    @NotBlank @URL
    private String photoUrl;

    @OneToMany(mappedBy = "owner")
    private List<Animal> animals = new ArrayList<>();

    @Deprecated
    protected Owner(){}

    public Owner(@NotBlank @Size(max = 100) String name,
                 @NotBlank String cpf,
                 @PastOrPresent @NotNull LocalDate birthday,
                 @NotNull BigDecimal remuneration,
                 @NotNull HomeKind homeKind,
                 @NotBlank @URL String photoUrl) {
        this.name = name;
        this.cpf = cpf;
        this.birthday = birthday;
        this.remuneration = remuneration;
        this.homeKind = homeKind;
        this.photoUrl = photoUrl;
    }

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getRemuneration() {
        return remuneration;
    }

    public boolean canSupport(Animal animal) {
        BigDecimal moneyAvailableToAdoptNewAnimal = this.remuneration.subtract(getMonthlyExpenses());
        return moneyAvailableToAdoptNewAnimal.compareTo(animal.getMonthlyCost()) >= 0;
    }

    public BigDecimal getMonthlyExpenses() {
        return this.animals.stream().map(Animal::getMonthlyCost).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Animal> getAnimals() {
        return Collections.unmodifiableList(animals);
    }

    public boolean hasRemunerationOver(BigDecimal bigDecimal) {
        return this.remuneration.compareTo(bigDecimal) >= 0;
    }

    public boolean livesIn(HomeKind homeKind) {
        return this.homeKind.equals(homeKind);
    }

    public boolean hasCats() {
        return this.animals.stream().anyMatch(Animal::isCat);
    }

    public boolean hasDogs() {
        return this.animals.stream().anyMatch(Animal::isDog);
    }

    public boolean hasMoreThanNDogs(int n) {
        return this.animals.stream().filter(Animal::isDog).count() >= n;
    }

    public boolean hasDogWithSize(AnimalSize... sizes) {
        List<AnimalSize> animalSizes = Arrays.stream(sizes).toList();
        return this.animals.stream()
                           .filter(Animal::isDog)
                           .anyMatch(animal -> animalSizes.stream().anyMatch(animal::hasSize));
    }

    public boolean isUnderAge() {
        return ChronoUnit.YEARS.between(this.birthday, LocalDate.now()) >= 18;
    }
}
