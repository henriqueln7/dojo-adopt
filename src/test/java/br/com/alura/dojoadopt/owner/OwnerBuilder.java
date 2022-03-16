package br.com.alura.dojoadopt.owner;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class OwnerBuilder {
    private String name = "Novo dono";
    private String cpf = "18851676011";
    private LocalDate birthday = LocalDate.of(2003, 3, 12);
    private BigDecimal remuneration = new BigDecimal("1000");
    private HomeKind homeKind = HomeKind.HOUSE;
    private String photoUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Cat_November_2010-1a.jpg/1200px-Cat_November_2010-1a.jpg";

    public OwnerBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public OwnerBuilder withCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public OwnerBuilder withBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public OwnerBuilder withRemuneration(BigDecimal remuneration) {
        this.remuneration = remuneration;
        return this;
    }

    public OwnerBuilder withHomeKind(HomeKind homeKind) {
        this.homeKind = homeKind;
        return this;
    }

    public OwnerBuilder withPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

    public Owner build() {
        return new Owner(name, cpf, birthday, remuneration, homeKind, photoUrl);
    }

    public static OwnerBuilder anOwner() {
        return new OwnerBuilder();
    }
}
