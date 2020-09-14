package com.emysilva.fleet.management.application.service;

import com.emysilva.fleet.management.application.exception.NoSuchDataException;
import com.emysilva.fleet.management.application.model.Location;
import com.emysilva.fleet.management.application.model.State;
import com.emysilva.fleet.management.application.repository.LocationRepository;
import com.emysilva.fleet.management.application.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    public void addLocation(Location location) {
        locationRepository.save(location);
    }

    public Location getLocation(int id) {
        return locationRepository.findById(id).orElseThrow(() -> new NoSuchDataException("location with id: " + id + "not found"));
    }

    public void deleteLocation(int id) {
        Location locationToDelete = locationRepository.findById(id).orElseThrow(() -> new NoSuchDataException("location with id: " + id + "not found"));
        locationRepository.delete(locationToDelete);
    }
}
