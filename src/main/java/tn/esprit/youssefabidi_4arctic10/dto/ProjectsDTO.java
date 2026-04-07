package tn.esprit.youssefabidi_4arctic10.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectsDTO {
    private long projectId;
    private  String projectName;
    private  String clientName;
}