package com.example.controllers;


import com.example.model.Owner;
import com.example.services.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("owners")
@Slf4j
public class OwnerController {

    public static final String OWNERS_CREATE_OR_UPDATE_OWNER = "owners/createOrUpdateOwner";
    private final OwnerService ownerService;


    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

    @GetMapping({"/find"})
    public ModelAndView findOwners() {
        ModelAndView mav = new ModelAndView("owners/findOwners");
        mav.addObject("owner", new Owner());
        return mav;
    }

    @GetMapping("")
    public String findAllByLastNameLike(Owner owner, BindingResult result, Model model) {
        // allow parameterless GET request for /owners to return all records
        log.info(result.getModel().toString());
        if (owner.getLastName() == null) {
            owner.setLastName(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        List<Owner> results = ownerService.findAllByLastName("%" + owner.getLastName() +"%");

        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (results.size() == 1) {
            // 1 owner found
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            // multiple owners found
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }


    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(this.ownerService.findById(ownerId));
        return mav;
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable long ownerId, Model model) {
        model.addAttribute(ownerService.findById(ownerId));
        return OWNERS_CREATE_OR_UPDATE_OWNER;
    }

    @PostMapping("/{ownerId}/edit")
    public String updateExistingOwner(@Valid Owner owner, BindingResult result, @PathVariable("ownerId") Long ownerId) {
        if (result.hasErrors()) {
            return OWNERS_CREATE_OR_UPDATE_OWNER;
        }
        owner.setId(ownerId);
        Owner saved = ownerService.save(owner);
        return "redirect:/owners/" + saved.getId();
    }


    @GetMapping("/new")
    public String initCreateOwner(Model model) {
        model.addAttribute("owner", new Owner());
        return OWNERS_CREATE_OR_UPDATE_OWNER;
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid Owner owner, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "owners/createOrUpdateOwner";
        }
        owner = ownerService.save(owner);
        return "redirect:/owners/" + owner.getId();
    }
}
