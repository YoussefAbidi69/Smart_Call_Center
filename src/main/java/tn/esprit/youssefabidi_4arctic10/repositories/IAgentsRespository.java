package tn.esprit.youssefabidi_4arctic10.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.youssefabidi_4arctic10.entities.Agents;
import tn.esprit.youssefabidi_4arctic10.entities.CallSkills;

import java.util.List;
import java.util.Set;

public interface IAgentsRespository extends JpaRepository<Agents, Long> {

    List<Agents> findByAvailableTrue();

    List<Agents> findBySkillsContaining(CallSkills skill);

    List<Agents> findByAvailableTrueAndSkillsIn(Set<CallSkills> skills);


    @Query("SELECT a FROM Agents a WHERE :skill MEMBER OF a.skills")
    List<Agents> findAgentsBySkill(@Param("skill") CallSkills skill);

    @Query("""
        SELECT a FROM Agents a
        JOIN Calls c ON c.callsid = :callsId
        WHERE a.available = true
          AND EXISTS (
              SELECT s FROM Agents a2
              JOIN a2.skills s
              WHERE a2 = a AND s MEMBER OF c.requiredSkills
          )
        ORDER BY (
            SELECT COUNT(s) FROM Agents a3
            JOIN a3.skills s
            WHERE a3 = a AND s MEMBER OF c.requiredSkills
        ) DESC
        """)
    List<Agents> findMostCompetentAgentsForCall(@Param("callsId") Long callsId);

    default Agents findMostCompetentAgentForCall(Long callsId) {
        List<Agents> results = findMostCompetentAgentsForCall(callsId);
        return results.isEmpty() ? null : results.get(0);
    }

    @Query("SELECT a.name, COUNT(c) FROM Agents a JOIN a.myCalls c GROUP BY a.name HAVING COUNT(c) > 5")
    List<Object[]> findTopActiveAgents();

}