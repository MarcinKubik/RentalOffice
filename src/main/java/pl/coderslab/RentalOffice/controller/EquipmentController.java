package pl.coderslab.RentalOffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.RentalOffice.entity.BorrowedEquipment;
import pl.coderslab.RentalOffice.entity.CatalogPrice;
import pl.coderslab.RentalOffice.entity.Equipment;
import pl.coderslab.RentalOffice.repository.BorrowedEquipmentRepository;
import pl.coderslab.RentalOffice.service.BorrowedEquipmentService;
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
    private final BorrowedEquipmentService borrowedEquipmentService;

    public EquipmentController(EquipmentService equipmentService, CatalogPriceService catalogPriceService, BorrowedEquipmentService borrowedEquipmentService) {
        this.equipmentService = equipmentService;
        this.catalogPriceService = catalogPriceService;
        this.borrowedEquipmentService = borrowedEquipmentService;
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
        return "equipment/borrowedEquipmentList";
    }

    @GetMapping("/prices/{id}")
    public String pricesList(@PathVariable Long id, Model model){
        Optional<CatalogPrice> optionalCatalogPrice = catalogPriceService.get(id);
        CatalogPrice catalogPrice = optionalCatalogPrice.orElse(null);
        if(catalogPrice == null){
            return "equipment/problem";
        }
        model.addAttribute("catalogPrice", catalogPrice);
        return "equipment/prices";
    }

    @GetMapping("/editPrices/{id}")
    public String editPrices(@PathVariable Long id, Model model){
        Optional<CatalogPrice> optionalCatalogPrice = catalogPriceService.get(id);
        CatalogPrice catalogPrice = optionalCatalogPrice.orElse(null);
        if(catalogPrice == null){
            return "equipment/problem";
        }
        model.addAttribute("catalogPrice", catalogPrice);
        return "catalogPrice/form";
    }

    @GetMapping("/return/{id}")
    public String returnEquipment(@PathVariable Long id, Model model){
        Optional<Equipment> optionalEquipment = equipmentService.get(id);
        Equipment equipment = optionalEquipment.orElse(null);
        if(equipment == null){
            return "equipment/problem";
        }
        equipment.setAvailable(true);
        equipmentService.update(equipment);
        return "redirect:/equipment/borrowedList";
    }

    @GetMapping("/delete/{id}")
    public String deleteEquipment(@PathVariable Long id, Model model){
        Optional<Equipment> optionalEquipment = equipmentService.get(id);
        Equipment equipment = optionalEquipment.orElse(null);
        if(equipment == null){
            return "equipment/problem";
        }
        if(equipment.getAvailable()){
            List<BorrowedEquipment> borrowedEquipmentList = borrowedEquipmentService.findByEquipmentId(id);
            for(BorrowedEquipment b : borrowedEquipmentList){
                borrowedEquipmentService.delete(b.getId());
            }
            equipmentService.delete(id);
            return "redirect:/equipment/list";
        }else {
            return "equipment/deleteNotPossible";
        }
    }
}
