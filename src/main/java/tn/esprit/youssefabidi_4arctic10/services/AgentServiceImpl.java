package tn.esprit.youssefabidi_4arctic10.services;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.loadtime.Agent;
import org.springframework.stereotype.Service;
import tn.esprit.youssefabidi_4arctic10.entities.*;
import tn.esprit.youssefabidi_4arctic10.repositories.IAgentsRespository;
import tn.esprit.youssefabidi_4arctic10.repositories.ICallsRepository;
import tn.esprit.youssefabidi_4arctic10.repositories.IProjectsRepository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.youssefabidi_4arctic10.entities.Agents;
import tn.esprit.youssefabidi_4arctic10.repositories.IAgentsRespository;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class AgentServiceImpl implements IAgentService {

    private final IAgentsRespository agentRepository;
    private final IProjectsRepository projectsRepository;
    private final ICallsRepository callsRepository;

    @Transactional
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

    @Override
    public List<Agents> getAvailableAgents() {
        return agentRepository.findByAvailableTrue();
    }

    @Override
    public List<Agents> getAgentsBySkill(CallSkills skill) {
        return agentRepository.findBySkillsContaining(skill);
    }

    @Override
    public List<Agents> getAvailableAgentsWithSkills(Set<CallSkills> skills) {
        return agentRepository.findByAvailableTrueAndSkillsIn(skills);
    }



    @Override
    public List<Calls> getCallsByAgent(Long idAgent) {
        return callsRepository.findCallsByAgent(idAgent);
    }

    @Override
    public List<Calls> getCallsBySkill(CallSkills skill) {
        return callsRepository.findCallsBySkill(skill);
    }

    @Override
    public List<Agents> getAgentsBySkillJPQL(CallSkills skill) {
        return agentRepository.findAgentsBySkill(skill);
    }

    @Override
    public Agents getMostCompetentAgentForCall(Long callsId) {
        return agentRepository.findMostCompetentAgentForCall(callsId);
    }

    @Override
    public List<Object[]> countCallsByStatus() {
        return callsRepository.countCallsByStatus();
    }

    @Override
    public List<Object[]> getTopActiveAgents() {
        return agentRepository.findTopActiveAgents();
    }

    @Override
    public List<Calls> getTodayCalls() {
        return callsRepository.findTodayCalls();
    }

}
