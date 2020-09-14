package com.emysilva.fleet.management.application.service;

import com.emysilva.fleet.management.application.exception.NoSuchDataException;
import com.emysilva.fleet.management.application.model.JobTitle;
import com.emysilva.fleet.management.application.model.Location;
import com.emysilva.fleet.management.application.repository.JobTitleRepository;
import com.emysilva.fleet.management.application.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleService {
    @Autowired
    private JobTitleRepository jobTitleRepository;

    public List<JobTitle> getJobTitles() {
        return jobTitleRepository.findAll();
    }

    public void addJobTitle(JobTitle jobTitle) {
        jobTitleRepository.save(jobTitle);
    }

    public JobTitle getJobTitle(int id) {
        return jobTitleRepository.findById(id).orElseThrow(() -> new NoSuchDataException("job title with id: " + id + "not found"));
    }

    public void deleteJobTitle(int id) {
        JobTitle jobTitleToDelete = jobTitleRepository.findById(id).orElseThrow(() -> new NoSuchDataException("job title with id: " + id + "not found"));
        jobTitleRepository.delete(jobTitleToDelete);
    }
}
