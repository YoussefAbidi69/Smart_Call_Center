package tn.esprit.youssefabidi_4arctic10.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.youssefabidi_4arctic10.entities.Agents;
import tn.esprit.youssefabidi_4arctic10.entities.CallSkills;
import tn.esprit.youssefabidi_4arctic10.entities.Calls;
import tn.esprit.youssefabidi_4arctic10.services.IAgentService;

import java.util.List;
import java.util.Set;





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

    @GetMapping("/available")
    public List<Agents> getAvailableAgents() {
        return agentService.getAvailableAgents();
    }

    @GetMapping("/bySkill/{skill}")
    public List<Agents> getAgentsBySkill(@PathVariable CallSkills skill) {
        return agentService.getAgentsBySkill(skill);
    }


    @PostMapping("/availableWithSkills")
    public List<Agents> getAvailableAgentsWithSkills(@RequestBody Set<CallSkills> skills) {
        return agentService.getAvailableAgentsWithSkills(skills);
    }






    @GetMapping("/calls/byAgent/{idAgent}")
    public List<Calls> getCallsByAgent(@PathVariable Long idAgent) {
        return agentService.getCallsByAgent(idAgent);
    }


    @GetMapping("/calls/bySkill/{skill}")
    public List<Calls> getCallsBySkill(@PathVariable CallSkills skill) {
        return agentService.getCallsBySkill(skill);
    }


    @GetMapping("/bySkillJPQL/{skill}")
    public List<Agents> getAgentsBySkillJPQL(@PathVariable CallSkills skill) {
        return agentService.getAgentsBySkillJPQL(skill);
    }


    @GetMapping("/mostCompetent/{callsId}")
    public Agents getMostCompetentAgent(@PathVariable Long callsId) {
        return agentService.getMostCompetentAgentForCall(callsId);
    }


    @GetMapping("/calls/countByStatus")
    public List<Object[]> countCallsByStatus() {
        return agentService.countCallsByStatus();
    }


    @GetMapping("/topActive")
    public List<Object[]> getTopActiveAgents() {
        return agentService.getTopActiveAgents();
    }


    @GetMapping("/calls/today")
    public List<Calls> getTodayCalls() {
        return agentService.getTodayCalls();
    }

    }
