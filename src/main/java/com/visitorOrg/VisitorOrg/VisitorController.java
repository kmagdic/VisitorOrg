package com.visitorOrg.VisitorOrg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

@Controller
public class VisitorController {

    @Autowired
    VisitorRepository visitorRepository;

    @GetMapping("/visitors")
    public String listVisitors(Model model) {

        model.addAttribute("visitors", visitorRepository.findAll());
        model.addAttribute("visitor", new Visitor());
        return "visitor_list";

    }

    @GetMapping("/addNew")
    public String addVisitor(Visitor visitor, BindingResult result) {
        if(visitor.getDateVisitEnd().before(visitor.getDateVisitStart())) {
            result.addError(new FieldError("visitor", "dateVisitStart", "Date start is after end"));
            return "visitor_list";
        }

        /*
        To check if newVisitor conficts with other reservations:
        - Loop all visitor u varijablu v
            - if currVisit.Starts >= v.visitStart && currVisit.Start <= v.visitEnd
            -
         */

        visitorRepository.save(visitor);
        return "redirect:/visitors";
    }
}
