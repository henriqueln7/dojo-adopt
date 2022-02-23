package br.com.alura.dojoadopt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AnimalController {

    private final AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("/animals/new")
    public String createAnimalForm(CreateAnimalForm createAnimalForm, Model model) {
        model.addAttribute("createAnimalForm", createAnimalForm);
        model.addAttribute("animalSizes", AnimalSize.values());
        model.addAttribute("animalKinds", AnimalKind.values());
        return "animals/new";
    }

    @PostMapping("/animals")
    public String createAnimal(@Valid CreateAnimalForm form, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return createAnimalForm(form, model);
        }
        Animal animal = form.toModel();
        animalRepository.save(animal);
        return "redirect:/animals/new";
    }

    @GetMapping("/animals")
    public String listAnimals(Model model) {
        List<AnimalView> animalsView = animalRepository.findAll().stream().map(AnimalView::new).toList();
        model.addAttribute("animalsView", animalsView);
        return "animals/list";
    }
}
