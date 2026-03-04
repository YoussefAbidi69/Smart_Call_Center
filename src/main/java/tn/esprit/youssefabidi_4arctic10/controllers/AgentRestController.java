package tn.esprit.youssefabidi_4arctic10.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.youssefabidi_4arctic10.entities.Agents;
import tn.esprit.youssefabidi_4arctic10.services.IAgentService;

import java.util.List;



@RequiredArgsConstructor
@RestController
@RequestMapping("agents")
public class AgentRestController {
    private final IAgentService agentService;

    @PostMapping("/add")
    public Agents addAgent(@RequestBody Agents agent) {
        return agentService.addAgent(agent);
    }

    @PutMapping("/update")
    public Agents updateAgent(@RequestBody Agents agent) {
        return agentService.updateAgent(agent);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAgent(@PathVariable long id) {
        agentService.deleteById(id);
    }

    @GetMapping("/get/{id}")
    public Agents getAgentById(@PathVariable long id) {
        return agentService.getById(id);
    }

    @GetMapping("/all")
    public List<Agents> getAllAgents() {
        return agentService.getAll();
    }

    @PostMapping("addAndAssignToProject")
    public Agents addAndAssignToProject(@RequestBody  Agents agent) {
        return agentService.addAndAssignToProject(agent);
    }

    }
