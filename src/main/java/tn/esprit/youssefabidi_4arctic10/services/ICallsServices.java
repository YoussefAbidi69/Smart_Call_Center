package tn.esprit.youssefabidi_4arctic10.services;

import org.aspectj.weaver.ast.Call;
import tn.esprit.youssefabidi_4arctic10.entities.Calls;

import java.util.List;
import java.util.Set;

public interface ICallsServices {
    Calls addCalls(Calls calls);
    Calls updateCalls(Calls calls) ;
    void deleteCalls (Long id);
    Calls getById (Long id);
    List<Calls> GetAllCalls();
    Calls assignToAGent(Long callsId,Long agentid);
    Calls assignToAGent(Calls calls,Long agentid );

    void assignCallToAISystem(Long callId, Long aiSystemId);
    boolean callRequiresHumanAgent(Calls call);
    void autoAssignCallsToAgents(Set<Long> callIds);
    void assignCallsToAgents(Set<Long> callIds);

}