package tn.esprit.youssefabidi_4arctic10.services;

import tn.esprit.youssefabidi_4arctic10.entities.Agents;

import java.util.List;

public interface IProjectsServices {
    List<Agents> getAgents(Long idProject);
}