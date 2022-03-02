package br.com.alura.dojoadopt.animal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AnimalController {

    private final AnimalRepository animalRepository;
    private final CreateAnimalValidator createAnimalValidator;

    public AnimalController(AnimalRepository animalRepository,
                            CreateAnimalValidator createAnimalValidator) {
        this.animalRepository = animalRepository;
        this.createAnimalValidator = createAnimalValidator;
    }

    @InitBinder("createAnimalForm")
    public void init(WebDataBinder binder) {
        binder.addValidators(createAnimalValidator);
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
        return "redirect:/animals/";
    }

    @GetMapping("/animals")
    public String listAnimals(Model model) {
        List<AnimalView> animalsView = animalRepository.findAll().stream().map(AnimalView::new).toList();
        model.addAttribute("animalsView", animalsView);
        return "animals/list";
    }
}
