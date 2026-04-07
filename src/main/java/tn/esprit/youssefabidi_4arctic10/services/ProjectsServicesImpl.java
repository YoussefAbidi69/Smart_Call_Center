package tn.esprit.youssefabidi_4arctic10.services;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.loadtime.Agent;
import org.springframework.stereotype.Service;
import tn.esprit.youssefabidi_4arctic10.entities.Agents;
import tn.esprit.youssefabidi_4arctic10.entities.Projects;
import tn.esprit.youssefabidi_4arctic10.repositories.IAgentsRespository;
import tn.esprit.youssefabidi_4arctic10.repositories.IProjectsRepository;
import tn.esprit.youssefabidi_4arctic10.dto.ProjectsDTO;
import tn.esprit.youssefabidi_4arctic10.dto.ProjectMapper;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectsServicesImpl implements IProjectsServices{

    private final IProjectsRepository projectsRepository;
    private final IAgentsRespository agentsRespository;
    private final ProjectMapper projectMapper;



    @Override
    public Projects addProject(Projects project) {
        project.setProjectsId(0);
        if (project.getProjectDetails() != null) {
            project.getProjectDetails().setDetailsId(0);
        }
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
    public Projects assignToagent(Long projctId, Long agentId) {
        Projects project = projectsRepository.findById(projctId).orElseThrow(()->new EntityNotFoundException("calls not found"));
        Agents agent  =  agentsRespository.findById(agentId).orElse(null);
        //affectation
        project.getAgents().add(agent);
        return projectsRepository.save(project);
    }


    @Override
    public List<Agents> getAgents(Long idProject) {
        Projects project = projectsRepository.findById(idProject).orElseThrow(() -> new EntityNotFoundException("not found"));
        project.getProjectDetails();
        return project.getAgents().stream().toList();    }



    @Override
    public ProjectsDTO findProjectDTO(long id) {
        Projects project = projectsRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("project with id " + id + " not found"));
        return projectMapper.toDTO(project);
    }

    @Override
    public ProjectsDTO getProjectDTO(Projects project) {
        ProjectsDTO projectsDTO = new ProjectsDTO();
        projectsDTO.setProjectId(project.getProjectsId());
        projectsDTO.setProjectName(project.getLibelle());
        projectsDTO.setClientName(project.getProjectDetails().getClient());
        return projectsDTO;
    }
}
