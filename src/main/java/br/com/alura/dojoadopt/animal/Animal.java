package br.com.alura.dojoadopt.animal;

import br.com.alura.dojoadopt.owner.Owner;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static javax.persistence.EnumType.STRING;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Size(max = 50)
    private String name;
    @NotNull @Min(10)
    private BigDecimal monthlyCost;
    @PastOrPresent
    private LocalDate birthday;
    @NotNull
    @Enumerated(STRING)
    private AnimalKind animalKind;
    @NotNull
    @Enumerated(STRING)
    private AnimalSize animalSize;
    @NotBlank @URL
    private String photoUrl;

    @ManyToOne
    @Nullable
    private Owner owner;

    @FutureOrPresent
    @Nullable
    private LocalDateTime adoptedAt;

    @Deprecated
    protected Animal(){}

    public Animal(@NotBlank @Size(max = 50) String name,
                  @Min(10) BigDecimal monthlyCost,
                  @PastOrPresent LocalDate birthday,
                  @NotNull AnimalKind animalKind,
                  @NotNull AnimalSize animalSize,
                  @NotBlank @URL String photoUrl) {
        this.name = name;
        this.monthlyCost = monthlyCost;
        this.birthday = birthday;
        this.animalKind = animalKind;
        this.animalSize = animalSize;
        this.photoUrl = photoUrl;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public AnimalKind getAnimalKind() {
        return animalKind;
    }

    public AnimalSize getAnimalSize() {
        return animalSize;
    }

    public int getAgeInYears() {
        return (int) ChronoUnit.YEARS.between(this.birthday, LocalDate.now());
    }

    public BigDecimal getMonthlyCost() {
        return monthlyCost;
    }

    public boolean beAdoptedBy(Owner owner) {
        Assert.isNull(this.owner, "Animal já foi adotado");
        Assert.notNull(owner, "Owner é nulo grrrr");

        if (!owner.canSupport(this)) {
            return false;
        }

        this.owner = owner;
        this.adoptedAt = LocalDateTime.now();
        return true;
    }
}
