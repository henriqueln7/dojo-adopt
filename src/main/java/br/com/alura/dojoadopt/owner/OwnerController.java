package br.com.alura.dojoadopt.owner;

import br.com.alura.dojoadopt.animal.AnimalRepository;
import br.com.alura.dojoadopt.animal.AnimalView;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@Controller
public class OwnerController {

    private final OwnerRepository ownerRepository;
    private final AnimalRepository animalRepository;
    private final CreateOwnerValidator createOwnerValidator;

    public OwnerController(OwnerRepository ownerRepository, AnimalRepository animalRepository, CreateOwnerValidator createOwnerValidator) {
        this.ownerRepository = ownerRepository;
        this.animalRepository = animalRepository;
        this.createOwnerValidator = createOwnerValidator;
    }

    @InitBinder("createOwnerForm")
    public void init(WebDataBinder binder) {
        binder.addValidators(createOwnerValidator);
    }

    @GetMapping("/owners/new")
    public String createOwnerForm(CreateOwnerForm form, Model model) {
        model.addAttribute("homeKinds", HomeKind.values());
        return "owners/new";
    }

    @PostMapping("/owners")
    public String createOwner(@Valid CreateOwnerForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return createOwnerForm(form, model);
        }
        Owner newOwner = form.toModel();
        ownerRepository.save(newOwner);
        return "redirect:/owners/";
    }

    @GetMapping("/owners")
    public String listOwners(Model model) {
        List<OwnerView> ownersView = ownerRepository.findAll().stream().map(OwnerView::new).toList();
        model.addAttribute("ownersView", ownersView);
        return "owners/list";
    }

    @GetMapping("/owners/{ownerId}/adoptions/new")
    public String ownerNewAdoption(@PathVariable Long ownerId, Model model) {
        Owner owner = ownerRepository.findById(ownerId)
                                     .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        model.addAttribute("owner", new OwnerView(owner));
        model.addAttribute("animalsThatCanBeAdopted", animalRepository.allThatCanBeAdopted().stream().map(AnimalView::new).toList());

        return "adoptions/new";
    }

    @GetMapping("/owners/{ownerId}")
    public String ownerProfile(@PathVariable Long ownerId, Model model) {
        Owner owner = ownerRepository.findById(ownerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        OwnerProfileView ownerProfileView = new OwnerProfileView(owner);
        model.addAttribute("ownerProfile", ownerProfileView);
        return "owners/profile";
    }
}
