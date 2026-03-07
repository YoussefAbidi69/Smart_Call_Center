package tn.esprit.youssefabidi_4arctic10.controllers;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Call;
import org.springframework.web.bind.annotation.*;
import tn.esprit.youssefabidi_4arctic10.entities.Calls;
import tn.esprit.youssefabidi_4arctic10.repositories.ICallsRepository;
import tn.esprit.youssefabidi_4arctic10.services.CallsServicesImpl;
import tn.esprit.youssefabidi_4arctic10.services.ICallsServices;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("calls")
public class CallsRestController {
    private final ICallsServices callsServices;

    @PostMapping("add")
    public Calls addCalls(@RequestBody Calls calls) {
        return callsServices.addCalls(calls);
    }

    @PutMapping("update")
    public Calls updateCalls(@RequestBody Calls calls) {
        return callsServices.updateCalls(calls);
    }

    @DeleteMapping("delete/{id}")
    public void deleteCalls(@PathVariable Long id) {
        callsServices.deleteCalls(id);
    }

    @GetMapping("get/{id}")
    public Calls getById(@PathVariable Long id) {
        return callsServices.getById(id);
    }

    @GetMapping("all")
    public List<Calls> getAllCalls() {
        return callsServices.GetAllCalls();
    }

    @PutMapping("assigntoagent/{callsId}/{agentid}")
    public Calls assignToAGent(@PathVariable Long callsId, @PathVariable Long agentid) {

        return callsServices.assignToAGent(callsId,agentid);
    }

    @PostMapping("assignToagent/{agentid}")
    public Calls assignToAGent(@RequestBody  Calls calls, @PathVariable  Long agentid ){
        return callsServices.assignToAGent(calls,agentid);

    }

    @PutMapping("assignCallToAISystem/{callId}/{aiSystemId}")
    public void assignCallToAISystem(@PathVariable Long callId, @PathVariable Long aiSystemId) {
        callsServices.assignCallToAISystem(callId, aiSystemId);
    }

    @GetMapping("requiresHuman/{id}")
    public boolean callRequiresHumanAgent(@PathVariable Long id) {
        Calls call = callsServices.getById(id);
        return callsServices.callRequiresHumanAgent(call);
    }

    @PutMapping("autoAssign")
    public void autoAssignCallsToAgents(@RequestBody Set<Long> callIds) {
        callsServices.autoAssignCallsToAgents(callIds);
    }

    // Q5
    @PutMapping("assignToAgents")
    public void assignCallsToAgents(@RequestBody Set<Long> callIds) {
        callsServices.assignCallsToAgents(callIds);
    }



}
