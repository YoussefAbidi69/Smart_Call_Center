package tn.esprit.youssefabidi_4arctic10.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.youssefabidi_4arctic10.entities.Agents;
import tn.esprit.youssefabidi_4arctic10.entities.CallStatus;
import tn.esprit.youssefabidi_4arctic10.entities.Calls;
import tn.esprit.youssefabidi_4arctic10.repositories.IAgentsRespository;
import tn.esprit.youssefabidi_4arctic10.repositories.ICallsRepository;

import java.time.LocalDateTime;
import java.util.List;


@RequiredArgsConstructor
@Service
public class CallsServicesImplC2 implements ICallsServices {
    private final IAgentsRespository agentsRespository;
    private final ICallsRepository callRepository ;
    @Override
    public Calls addCalls(Calls calls) {


        return callRepository.save(calls);
    }

    @Override
    public Calls updateCalls(Calls calls) {
        return callRepository.save(calls);
    }

    @Override
    public void deleteCalls(Long id) {
        callRepository.deleteById(id);
    }

    @Override
    public Calls getById(Long id) {
        return callRepository.findById(id).orElseThrow(()->new EntityNotFoundException("calls not found"));
    }

    @Override
    public List<Calls> GetAllCalls() {
        return callRepository.findAll();
    }

    @Override
    public Calls assignToAGent(Long callsId, Long agentid) {
        Calls calls  = callRepository.findById(callsId).orElseThrow(()->new EntityNotFoundException("calls not found"));
        Agents agent = agentsRespository.findById(agentid).orElse(null);
        calls.setAssignedAgent(agent); //affectation
        return callRepository.save(calls) ;
    }

    @Override
    public Calls assignToAGent(Calls calls, Long agentid) {
        Agents agent = agentsRespository.findById(agentid).orElse(null);
        calls.setAssignedAgent(agent);   // affectation
        return callRepository.save(calls);

    }
}
