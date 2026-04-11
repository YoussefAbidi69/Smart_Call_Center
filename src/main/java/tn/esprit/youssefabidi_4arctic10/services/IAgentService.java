package tn.esprit.youssefabidi_4arctic10.services;

import org.aspectj.weaver.loadtime.Agent;
import tn.esprit.youssefabidi_4arctic10.entities.Agents;
import tn.esprit.youssefabidi_4arctic10.entities.Agents;
import tn.esprit.youssefabidi_4arctic10.entities.CallSkills;
import tn.esprit.youssefabidi_4arctic10.entities.Calls;

import java.util.List;
import java.util.Set;

public interface IAgentService {
    Agents addAgent(Agents agent);
    Agents updateAgent(Agents agent);
    void deleteById(long agentId);
    void deleteAgent(Agents agent);
    Agents getById(long agentId);
    List<Agents> getAll();
    Agents addAndAssignToProject(Agents agent);


    List<Agents> getAvailableAgents();
    List<Agents> getAgentsBySkill(CallSkills skill);
    List<Agents> getAvailableAgentsWithSkills(Set<CallSkills> skills);


    List<Calls> getCallsByAgent(Long idAgent);
    List<Calls> getCallsBySkill(CallSkills skill);
    List<Agents> getAgentsBySkillJPQL(CallSkills skill);
    Agents getMostCompetentAgentForCall(Long callsId);
    List<Object[]> countCallsByStatus();
    List<Object[]> getTopActiveAgents();
    List<Calls> getTodayCalls();
}