package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Client;
import com.emysilva.fleet.management.application.model.JobTitle;
import com.emysilva.fleet.management.application.service.ClientService;
import com.emysilva.fleet.management.application.service.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class JobTitleController {
    @Autowired
    private JobTitleService jobTitleService;

    @GetMapping("/jobTitles")
    public String getJobTitles(Model model) {
        List<JobTitle> jobTitles = jobTitleService.getJobTitles();
        model.addAttribute("jobTitles", jobTitles);
        return "jobtitle";
    }

    @GetMapping("/jobTitles/findById")
    @ResponseBody
    public JobTitle getJobTitle(int id) {
        return jobTitleService.getJobTitle(id);
    }

    @PostMapping("/jobTitles/addNew")
    public String addJobTitle(JobTitle jobTitle) {
        jobTitleService.addJobTitle(jobTitle);
        return "redirect:/jobTitles";
    }

    @RequestMapping(value = "/jobTitles/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateJobTitle(JobTitle jobTitle) {
        jobTitleService.addJobTitle(jobTitle);
        return "redirect:/jobTitles";
    }

    @GetMapping("/jobTitles/delete")
    public String deleteJobTitle(int id) {
        jobTitleService.deleteJobTitle(id);
        return "redirect:/jobTitles";
    }
}
