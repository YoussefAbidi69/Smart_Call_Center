package tn.esprit.youssefabidi_4arctic10.entities;



import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projectsId;

    private String libelle;
    private LocalDate startDate;
    private LocalDate endDate;



    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private ProjectDetails projectDetails;

    @ManyToMany(fetch = FetchType.EAGER)
    Set<Agents> agents;
}