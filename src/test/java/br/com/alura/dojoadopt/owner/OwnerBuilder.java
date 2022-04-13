package br.com.alura.dojoadopt.owner;

import br.com.alura.dojoadopt.animal.Animal;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class OwnerBuilder {
    private String name = "Novo dono";
    private String cpf = GeradorCPF.gerarCPF();
    private LocalDate birthday = LocalDate.of(2003, 3, 12);
    private BigDecimal remuneration = new BigDecimal("1000");
    private HomeKind homeKind = HomeKind.HOUSE;
    private String photoUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Cat_November_2010-1a.jpg/1200px-Cat_November_2010-1a.jpg";
    private final List<Animal> animals = new ArrayList<>();

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

    public OwnerBuilder withAnimals(Animal... animals) {
        this.animals.addAll(Arrays.stream(animals).toList());
        return this;
    }

    public Owner build() {
        Owner owner = new Owner(name, cpf, birthday, remuneration, homeKind, photoUrl);
        this.animals.forEach(animal -> animal.beAdoptedBy(owner));
        return owner;
    }

    public static OwnerBuilder anOwner() {
        return new OwnerBuilder();
    }
}

// CTRL C + CTRL V daqui: https://github.com/jrjuniorsp/GeradorValidadorCPFCNPJ/blob/master/src/com/jrmobile/service/GeradorCPF.java
class GeradorCPF {

    /**
     * Construtor private para manter o singleton
     */
    private GeradorCPF() {
        //Do nothing
    }

    /**
     * M�todo que gera um novo CPF de forma randomica
     *
     * @author jair
     * @since 10/04/2012
     *
     * @param Boolean - true formata o valor, false n�o formata
     * @return
     */
    public static String gerarCPF() {
        StringBuilder iniciais = new StringBuilder();
        Integer numero;
        for (int i = 0; i < 9; i++) {
            numero = (int) (Math.random() * 10);
            iniciais.append(numero);
        }
        return iniciais + calcDigVerif(iniciais.toString());
    }

    private static String calcDigVerif(String num) {

        Integer primDig, segDig;
        int soma = 0, peso = 10;
        for (int i = 0; i < num.length(); i++)
            soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;

        if (soma % 11 == 0 | soma % 11 == 1)
            primDig = 0;
        else
            primDig = 11 - (soma % 11);

        soma = 0;
        peso = 11;
        for (int i = 0; i < num.length(); i++)
            soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;

        soma += primDig * 2;
        if (soma % 11 == 0 | soma % 11 == 1)
            segDig = 0;
        else
            segDig = 11 - (soma % 11);

        return primDig.toString() + segDig.toString();
    }
}
