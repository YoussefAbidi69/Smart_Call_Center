package tn.esprit.youssefabidi_4arctic10.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.youssefabidi_4arctic10.entities.ProjectDetails;
import tn.esprit.youssefabidi_4arctic10.services.IProjectDetailsService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("projectDetails")
public class ProjectDetailsRestController {

    private final IProjectDetailsService projectDetailsService;

    @PostMapping("/add")
    public ProjectDetails addProjectDetails(@RequestBody ProjectDetails projectDetails) {
        return projectDetailsService.addProjectDetails(projectDetails);
    }

    @PutMapping("/update")
    public ProjectDetails updateProjectDetails(@RequestBody ProjectDetails projectDetails) {
        return projectDetailsService.updateProjectDetails(projectDetails);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id) {
        projectDetailsService.deleteById(id);
    }

    @GetMapping("/get/{id}")
    public ProjectDetails getById(@PathVariable long id) {
        return projectDetailsService.getById(id);
    }

    @GetMapping("/all")
    public List<ProjectDetails> getAll() {
        return projectDetailsService.getAll();
    }
}