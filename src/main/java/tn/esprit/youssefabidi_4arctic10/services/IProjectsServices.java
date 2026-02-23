package tn.esprit.youssefabidi_4arctic10.services;

import tn.esprit.youssefabidi_4arctic10.entities.Agents;
import tn.esprit.youssefabidi_4arctic10.entities.Projects;

import java.util.List;

public interface IProjectsServices {
    List<Agents> getAgents(Long idProject);
    Projects addProject(Projects project);
    Projects updateProject(Projects project);
    void deleteProjectById(long id);
    void deleteProject(Projects project);
    Projects getProjectById(long id);
    List<Projects> getAll();
}