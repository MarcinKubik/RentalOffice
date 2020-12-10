package pl.coderslab.RentalOffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.RentalOffice.entity.BorrowedEquipment;
import pl.coderslab.RentalOffice.service.BorrowedEquipmentService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CalendarController {

    private final BorrowedEquipmentService borrowedEquipmentService;

    public CalendarController(BorrowedEquipmentService borrowedEquipmentService) {
        this.borrowedEquipmentService = borrowedEquipmentService;
    }

    @GetMapping("/calendar")
    public String calendar(Model model){
        List<BorrowedEquipment> borrowedEquipmentList = borrowedEquipmentService.findStillBorrowedEquipment();
        List<BorrowedEquipment> unique = new ArrayList<>();
        List<String> names = new ArrayList<>();
        // Ustawiam aby w kalendarzu widoczne było tylko ostatnie wypożyczenie sprzętu
        for(BorrowedEquipment b : borrowedEquipmentList){
            if (names.contains(b.getEquipment().getName())){

                for(BorrowedEquipment u : unique){
                    if(u.getEquipment().getName().equals(b.getEquipment().getName())){
                        if(u.getBorrowedFrom().isBefore(b.getBorrowedFrom())){
                            u.setBorrowedFrom(b.getBorrowedFrom());
                            u.setBorrowedTo(b.getBorrowedTo());
                        }
                    }
                }
            }else {
                names.add(b.getEquipment().getName());
                unique.add(b);
            }
        }
        model.addAttribute("stillBorrowedEquipment", unique);
        return "calendar";
    }
}
