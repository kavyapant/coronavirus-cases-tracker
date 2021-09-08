package dev.project.coronavirustracker.controllers;

import dev.project.coronavirustracker.models.LocationStats;
import dev.project.coronavirustracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    CoronaVirusDataService coronavirusDataService;

    @GetMapping("/")
    public String home(Model model)
    {
        List<LocationStats> allStats =coronavirusDataService.getAllStats();
        model.addAttribute("locationStats",coronavirusDataService.getAllStats());
        int totalCases= allStats.stream().mapToInt(stat->stat.getLatestTotalCases()).sum();
        int totalNewCases=allStats.stream().mapToInt(stat->stat.getDiffFromPrevDay()).sum();
        model.addAttribute("totalNewCases",totalNewCases);
        model.addAttribute("totalReportedCases",totalCases);

        return "home";
    }

}

