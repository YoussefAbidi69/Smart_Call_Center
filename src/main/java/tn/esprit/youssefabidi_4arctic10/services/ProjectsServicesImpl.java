package tn.esprit.youssefabidi_4arctic10.services;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.youssefabidi_4arctic10.entities.Agents;
import tn.esprit.youssefabidi_4arctic10.entities.Projects;
import tn.esprit.youssefabidi_4arctic10.repositories.IProjectsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectsServicesImpl implements IProjectsServices{

    private final IProjectsRepository projectsRepository;
    @Override
    public List<Agents> getAgents(Long idProject) {
        Projects project = projectsRepository.findById(idProject).orElseThrow(() -> new EntityNotFoundException("not found"));
        project.getProjectDetails();
        return project.getAgents().stream().toList();    }
}
