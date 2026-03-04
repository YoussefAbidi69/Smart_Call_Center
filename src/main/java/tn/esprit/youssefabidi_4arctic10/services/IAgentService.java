package tn.esprit.youssefabidi_4arctic10.services;

import org.aspectj.weaver.loadtime.Agent;
import tn.esprit.youssefabidi_4arctic10.entities.Agents;

import java.util.List;

public interface IAgentService {
    Agents addAgent(Agents agent);
    Agents updateAgent(Agents agent);
    void deleteById(long agentId);
    void deleteAgent(Agents agent);
    Agents getById(long agentId);
    List<Agents> getAll();
    Agents addAndAssignToProject(Agents agent);
}