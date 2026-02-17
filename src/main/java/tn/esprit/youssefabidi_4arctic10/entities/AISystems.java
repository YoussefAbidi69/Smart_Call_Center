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
public class AISystems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long aiSystemsId;

    private String type;
    private boolean available;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Set<CallSkills> skills;

    @OneToMany(mappedBy = "assignedAiSystems")
    Set<Calls> myCalls;
}