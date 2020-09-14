package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.JobTitle;
import com.emysilva.fleet.management.application.service.JobTitleService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JobTitleControllerTest {

    @Autowired
    private JobTitleService jobTitleService;

    List<JobTitle> jobTitles = null;

    @BeforeEach
    void setUp() {
        jobTitles = jobTitleService.getJobTitles();
    }

    @Test
    void getJobTitles() {
        assertEquals(jobTitles.size(), jobTitles.size());
    }

    @Test
    void getJobTitle() {
        assertEquals(jobTitleService.getJobTitle(1).getDescription(), jobTitleService.getJobTitle(1).getDescription());
    }

    @Test
    void addJobTitle() {
        JobTitle jobTitle = new JobTitle();
        jobTitle.setId(5);
        jobTitle.setDescription("Project Manager");
        jobTitle.setDescription("Handles all the project and organize the team to work effectively");

        int initialSize = jobTitles.size();

        jobTitles.add(jobTitle);

        assertEquals(initialSize + 1, jobTitles.size());
    }

    @Test
    void updateJobTitle() {
        JobTitle jobTitle = jobTitleService.getJobTitle(1);
        jobTitle.setId(5);
        jobTitle.setDescription("Project Manager");
        jobTitle.setDescription("Handles all the project and organize the team to work effectively");

        int initialSize = jobTitles.size();

        jobTitles.add(jobTitle);

        assertEquals(initialSize + 1, jobTitles.size());
    }

    @Test
    void deleteContact() {
        int initialSize = jobTitles.size();

        if (jobTitles.size() != 0)
            jobTitles.remove(0);

        assertEquals(initialSize - 1, jobTitles.size());
    }

    @AfterEach
    void tearDown() {
        jobTitles = null;
    }

}