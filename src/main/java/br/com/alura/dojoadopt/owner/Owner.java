package br.com.alura.dojoadopt.owner;

import br.com.alura.dojoadopt.animal.Animal;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import static javax.persistence.EnumType.*;

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

    public boolean canSupport(Animal animal) {
        //TODO Aqui não teria que ver para todos os animais? :thinking:
        return this.remuneration.compareTo(animal.getMonthlyCost()) >= 0;
    }
}
