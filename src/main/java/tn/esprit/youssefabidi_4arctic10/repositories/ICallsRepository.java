package tn.esprit.youssefabidi_4arctic10.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.youssefabidi_4arctic10.entities.Calls;
import tn.esprit.youssefabidi_4arctic10.entities.*;

import java.util.List;

public interface ICallsRepository extends JpaRepository<Calls, Long> {

    long countByAssignedAiSystems(AISystems aiSystem);

    List<Calls> findByStatus(CallStatus status);

    List<Calls> findByStatusAndAssignedAgent_AgentsId(CallStatus status, long agentId);

    List<Calls> findByAssignedAgentIsNull();

    List<Calls> findByRequiredSkillsContains(CallSkills skill);

    List<Calls> findTop5ByRequiredSkillsOrderByCallsDateTimeAsc(CallSkills skill);

    boolean existsByPhoneNumber(String phoneNumber);

    long countByStatus(CallStatus status);


    @Query("SELECT c FROM Calls c WHERE c.assignedAgent.agentsId = :idAgent")
    List<Calls> findCallsByAgent(@Param("idAgent") Long idAgent);

    @Query("SELECT c FROM Calls c WHERE :skill MEMBER OF c.requiredSkills")
    List<Calls> findCallsBySkill(@Param("skill") CallSkills skill);

    @Query("SELECT c.status, COUNT(c) FROM Calls c GROUP BY c.status")
    List<Object[]> countCallsByStatus();

    @Query("SELECT c FROM Calls c WHERE FUNCTION('DATE', c.callsDateTime) = CURRENT_DATE")
    List<Calls> findTodayCalls();
}