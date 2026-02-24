package tn.esprit.youssefabidi_4arctic10.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.youssefabidi_4arctic10.entities.Agents;
import tn.esprit.youssefabidi_4arctic10.entities.Projects;
import tn.esprit.youssefabidi_4arctic10.services.IProjectsServices;
import tn.esprit.youssefabidi_4arctic10.services.ProjectsServicesImpl;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("projects")
public class ProjectRestController {
    private  final IProjectsServices projectsServices;


    @PostMapping("add")
    public Projects addProject(@RequestBody Projects project) {
        return projectsServices.addProject(project);
    }


}
