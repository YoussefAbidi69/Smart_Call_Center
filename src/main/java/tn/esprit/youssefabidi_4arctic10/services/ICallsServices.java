package tn.esprit.youssefabidi_4arctic10.services;

import org.aspectj.weaver.ast.Call;
import tn.esprit.youssefabidi_4arctic10.entities.Calls;

import java.util.List;

public interface ICallsServices {
    Calls addCalls(Calls calls);
    Calls updateCalls(Calls calls) ;
    void deleteCalls (Long id);
    Calls getById (Long id);
    List<Calls> GetAllCalls();
    Calls assignToAGent(Long callsId,Long agentid);
    Calls assignToAGent(Calls calls,Long agentid );
}