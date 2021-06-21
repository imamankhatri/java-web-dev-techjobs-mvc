package org.launchcode.javawebdevtechjobsmvc.controllers;

import static org.launchcode.javawebdevtechjobsmvc.controllers.ListController.columnChoices;

import org.launchcode.javawebdevtechjobsmvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.

    @RequestMapping(value = "results", method = RequestMethod.POST)
    public String displaySearchResults(Model model, String searchType, String searchTerm) {
        model.addAttribute("columns", columnChoices);
        if (searchTerm.equals("all")) {
            model.addAttribute("jobs", JobData.findAll());
        } else {
            model.addAttribute("jobs", JobData.findByColumnAndValue(searchType, searchTerm));
        }
        return "search";
    }
}
