package tn.esprit.youssefabidi_4arctic10.services;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.loadtime.Agent;
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
    public Projects addProject(Projects project) {
        return projectsRepository.save(project);
    }

    @Override
    public Projects updateProject(Projects project) {
        return projectsRepository.save(project);
    }

    @Override
    public void deleteProjectById(long id) {
        projectsRepository.deleteById(id);
    }

    @Override
    public void deleteProject(Projects project) {
        projectsRepository.delete(project);
    }

    @Override
    public Projects getProjectById(long id) {
        return projectsRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("project with id " + id + " not found"));
    }

    @Override
    public List<Projects> getAll() {
        return projectsRepository.findAll();
    }


    @Override
    public List<Agents> getAgents(Long idProject) {
        Projects project = projectsRepository.findById(idProject).orElseThrow(() -> new EntityNotFoundException("not found"));
        project.getProjectDetails();
        return project.getAgents().stream().toList();    }
}
