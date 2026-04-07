package tn.esprit.youssefabidi_4arctic10.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.youssefabidi_4arctic10.entities.Projects;


@Mapper(componentModel = "spring")
public interface ProjectMapper {

    @Mapping(source = "libelle", target = "projectName")
    @Mapping(source = "projectDetails.client", target = "clientName")
    @Mapping(source = "projectsId", target = "projectId")
    ProjectsDTO toDTO(Projects project);
}