package tn.esprit.youssefabidi_4arctic10.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Calls {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long callsid;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private CallStatus status;
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Set<CallSkills> requiredSkills;

    LocalDateTime callsDateTime;

    @ManyToOne
    Agents assignedAgent;

    @ManyToOne
    AISystems assignedAiSystems;
}
