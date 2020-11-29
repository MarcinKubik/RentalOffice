package pl.coderslab.RentalOffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.RentalOffice.entity.CatalogPrice;
import pl.coderslab.RentalOffice.entity.Equipment;
import pl.coderslab.RentalOffice.service.CatalogPriceService;
import pl.coderslab.RentalOffice.service.EquipmentService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {

    private final EquipmentService equipmentService;
    private final CatalogPriceService catalogPriceService;

    public EquipmentController(EquipmentService equipmentService, CatalogPriceService catalogPriceService) {
        this.equipmentService = equipmentService;
        this.catalogPriceService = catalogPriceService;
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("equipment", new Equipment());
        return "equipment/form";
    }

    @PostMapping("/form")
    public String processForm(@Valid Equipment equipment, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "equipment/form";
        }
        else{
            equipmentService.add(equipment);
            model.addAttribute("catalogPrice", new CatalogPrice());
            return "catalogPrice/form";
        }
    }


    @PostMapping("/addPrices")
    public String addPrice(@Valid CatalogPrice catalogPrice, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "catalogPrice/form";
        }
        else {
            catalogPriceService.add(catalogPrice);
            Equipment equipment = equipmentService.findLastAdded();
            equipment.setCatalogPrice(catalogPrice);
            equipmentService.update(equipment);
        }
        return "index";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Equipment> equipmentList = equipmentService.getEquipment();
        model.addAttribute("equipmentList", equipmentList);
        return "equipment/list";
    }

    @GetMapping("/borrowedList")
    public String borrowedList(Model model){
        List<Equipment> borrowedList = equipmentService.getBorrowedEquipment();
        model.addAttribute("equipmentList", borrowedList);
        return "equipment/list";
    }

    @GetMapping("/prices/{id}")
    public String pricesList(@PathVariable Long id, Model model){
        Optional<CatalogPrice> optionalCatalogPrice = catalogPriceService.get(id);
        CatalogPrice catalogPrice = optionalCatalogPrice.get();
        model.addAttribute("catalogPrice", catalogPrice);
        return "equipment/prices";
    }

}
