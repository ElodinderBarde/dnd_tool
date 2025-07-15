package ch.Elodin.DnD_Tool.controller.world;

import ch.Elodin.DnD_Tool.repository.world.LocationRepository;
import ch.Elodin.DnD_Tool.controller.GenericController;
import ch.Elodin.DnD_Tool.model.world.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/cities")
    public List<CityDTO> getCities() {
        return locationRepository.findAll().stream()
                .filter(loc -> loc.getCityID() != null)
                .map(loc -> new CityDTO(loc.getId(), loc.getCityID().getCity_name()))
                .toList();
    }

    // Inneres DTO oder eigene Datei
    public record CityDTO(int id, String city_name) {}
}
