package br.com.alura.dojoadopt.owner;

import br.com.alura.dojoadopt.animal.Animal;
import br.com.alura.dojoadopt.animal.AnimalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;

@Controller
public class AdoptionController {

    private final AnimalRepository animalRepository;
    private final OwnerRepository ownerRepository;

    public AdoptionController(AnimalRepository animalRepository, OwnerRepository ownerRepository) {
        this.animalRepository = animalRepository;
        this.ownerRepository = ownerRepository;
    }

    @PostMapping("/adoptions")
    @Transactional
    public String newAdoption(NewAdoptionForm form) {
        Animal animal = animalRepository.findById(form.animalId()).orElseThrow();
        Owner owner = ownerRepository.findById(form.ownerId()).orElseThrow();

        animal.beAdoptedBy(owner);

        return "redirect:/owners/" + owner.getId() + "/adoptions/new";
    }
}
