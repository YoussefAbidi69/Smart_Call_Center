package tn.esprit.youssefabidi_4arctic10.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Agents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long agentsId;

    private String name;
    private boolean available;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Set<CallSkills> skills;


    @OneToMany(mappedBy = "assignedAgent")
    Set<Calls> myCalls;

    @ManyToMany(mappedBy = "agents")
    Set<Projects> myProject;


}