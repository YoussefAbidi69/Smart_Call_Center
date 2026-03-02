package tn.esprit.youssefabidi_4arctic10.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.youssefabidi_4arctic10.entities.AISystems;
import tn.esprit.youssefabidi_4arctic10.services.IASystemService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("aiSystems")
public class AISystemsRestController {

    private final IASystemService systemService;

    @PostMapping("/add")
    public AISystems addSystem(@RequestBody AISystems system) {
        return systemService.addAISystem(system);
    }

    @PutMapping("/update")
    public AISystems updateSystem(@RequestBody AISystems system) {
        return systemService.updateAISystem(system);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSystem(@PathVariable long id) {
        systemService.deleteById(id);
    }

    @GetMapping("/get/{id}")
    public AISystems getSystemById(@PathVariable long id) {
        return systemService.getById(id);
    }

    @GetMapping("/all")
    public List<AISystems> getAllSystems() {
        return systemService.getAll();
    }
}