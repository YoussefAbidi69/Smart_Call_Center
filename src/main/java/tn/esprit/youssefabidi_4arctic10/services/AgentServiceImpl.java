package tn.esprit.youssefabidi_4arctic10.services;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.loadtime.Agent;
import org.springframework.stereotype.Service;
import tn.esprit.youssefabidi_4arctic10.entities.Agents;
import tn.esprit.youssefabidi_4arctic10.entities.Projects;
import tn.esprit.youssefabidi_4arctic10.repositories.IAgentsRespository;
import tn.esprit.youssefabidi_4arctic10.repositories.IProjectsRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AgentServiceImpl implements IAgentService {

    private final IAgentsRespository agentRepository;
    private final IProjectsRepository projectsRepository;
    @Override
    public Agents addAgent(Agents agent) {
        return agentRepository.save(agent);
    }

    @Override
    public Agents updateAgent(Agents agent) {
        return agentRepository.save(agent);
    }

    @Override
    public void deleteById(long agentId) {
        agentRepository.deleteById(agentId);
    }

    @Override
    public void deleteAgent(Agents agent) {
        agentRepository.delete(agent);

    }

    @Override
    public Agents getById(long agentId) {
        return agentRepository.findById(agentId).orElseThrow(()-> new EntityNotFoundException("Calls with id " + agentId + " not found"));
    }

    @Override
    public List<Agents> getAll() {
        return agentRepository.findAll();
    }

    @Override
    public Agents addAndAssignToProject(Agents agent) {
        Agents newAgents = agentRepository.save(agent);
        for(Projects aProject : agent.getMyProject())
        {
            aProject.getAgents().add(newAgents);
            projectsRepository.save(aProject);
        }
        return newAgents;
    }
}
