package tn.esprit.youssefabidi_4arctic10.services;

import tn.esprit.youssefabidi_4arctic10.entities.AISystems;

import java.util.List;

public interface IASystemService {
    AISystems addAISystem(AISystems system);
    AISystems updateAISystem(AISystems system);
    void deleteById(long systemId);
    void deleteAISystem(AISystems system);
    AISystems getById(long systemId);
    List<AISystems> getAll();
}
