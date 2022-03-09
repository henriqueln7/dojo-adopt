package br.com.alura.dojoadopt.owner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class OwnerController {

    private final OwnerRepository ownerRepository;
    private final CreateOwnerValidator createOwnerValidator;

    public OwnerController(OwnerRepository ownerRepository,
                           CreateOwnerValidator createOwnerValidator) {
        this.ownerRepository = ownerRepository;
        this.createOwnerValidator = createOwnerValidator;
    }

    @InitBinder
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
}
