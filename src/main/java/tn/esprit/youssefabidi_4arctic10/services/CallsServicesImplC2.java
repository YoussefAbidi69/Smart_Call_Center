package tn.esprit.youssefabidi_4arctic10.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.youssefabidi_4arctic10.entities.*;
import tn.esprit.youssefabidi_4arctic10.repositories.IAgentsRespository;
import tn.esprit.youssefabidi_4arctic10.repositories.IAiSystemsRepository;
import tn.esprit.youssefabidi_4arctic10.repositories.ICallsRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@RequiredArgsConstructor
@Service
public class CallsServicesImplC2 implements ICallsServices {
    private final IAgentsRespository agentsRespository;
    private final ICallsRepository callRepository ;
    private final IAiSystemsRepository aiSystemsRepository;

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


    // CallsServicesImpl.java
    @Override
    public void assignCallToAISystem(Long callId, Long aiSystemId) {
        Calls call = callRepository.findById(callId)
                .orElseThrow(() -> new EntityNotFoundException("Call not found"));

        AISystems aiSystem = aiSystemsRepository.findById(aiSystemId)
                .orElseThrow(() -> new EntityNotFoundException("AI System not found"));

        if (!aiSystem.isAvailable())
            throw new IllegalStateException("AI System is not available");

        long activeCallsCount = callRepository.findAll().stream()
                .filter(c -> aiSystem.equals(c.getAssignedAiSystems()))
                .filter(c -> CallStatus.IN_PROGRESS.equals(c.getStatus()))
                .count();

        if (activeCallsCount >= 2)
            throw new IllegalStateException("AI System already handling 2 calls");

        call.setAssignedAiSystems(aiSystem);
        call.setStatus(CallStatus.IN_PROGRESS);
        call.setCallsDateTime(LocalDateTime.now());
        callRepository.save(call);
    }

    @Override
    public boolean callRequiresHumanAgent(Calls call) {
        if (call.getRequiredSkills().contains(CallSkills.TECHNICAL_SUPPORT)) {
            return true;
        }
        return call.getAssignedAiSystems() == null;
    }

    @Override
    public void autoAssignCallsToAgents(Set<Long> callIds) {
        for (Long callId : callIds) {
            Calls call = callRepository.findById(callId)
                    .orElseThrow(() -> new EntityNotFoundException("calls not found"));

            if (!callRequiresHumanAgent(call)) continue;

            Agents suitable = agentsRespository.findAll().stream()
                    .filter(a -> a.getSkills() != null &&
                            a.getSkills().containsAll(call.getRequiredSkills()))
                    .findFirst().orElse(null);

            if (suitable == null) continue;

            call.setAssignedAgent(suitable);
            call.setStatus(CallStatus.IN_PROGRESS);
            callRepository.save(call);
        }
    }


    @Override
    public void assignCallsToAgents(Set<Long> callIds) {
        for (Long callId : callIds) {
            Calls call = callRepository.findById(callId)
                    .orElseThrow(() -> new EntityNotFoundException("calls not found"));

            if (!callRequiresHumanAgent(call)) continue;

            Agents suitable = agentsRespository.findAll().stream()
                    .filter(a -> a.getSkills() != null &&
                            a.getSkills().containsAll(call.getRequiredSkills()))
                    .findFirst().orElse(null);

            if (suitable == null) continue;

            suitable.setAvailable(false);
            agentsRespository.save(suitable);

            call.setAssignedAgent(suitable);
            call.setStatus(CallStatus.IN_PROGRESS);
            callRepository.save(call);
        }
    }
}
