package br.com.alura.dojoadopt.owner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class OwnerController {

    private final OwnerRepository ownerRepository;

    public OwnerController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
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
        return "redirect:/owners/new";
    }
}
