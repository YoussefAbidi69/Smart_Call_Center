package tn.esprit.youssefabidi_4arctic10.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.youssefabidi_4arctic10.entities.AISystems;
import tn.esprit.youssefabidi_4arctic10.repositories.IAiSystemsRepository;

import java.util.List;
@RequiredArgsConstructor
@Service
public class IASystemImpl implements IASystemService{

    private final IAiSystemsRepository systemRepository;

    @Override
    public AISystems addAISystem(AISystems system) {
        return systemRepository.save(system);
    }

    @Override
    public AISystems updateAISystem(AISystems system) {
        return systemRepository.save(system);
    }

    @Override
    public void deleteById(long systemId) {
        systemRepository.deleteById(systemId);
    }

    @Override
    public void deleteAISystem(AISystems system) {
        systemRepository.delete(system);
    }

    @Override
    public AISystems getById(long systemId) {
        return systemRepository.findById(systemId).orElseThrow(()-> new EntityNotFoundException("Calls with id " + systemId + " not found"));
    }

    @Override
    public List<AISystems> getAll() {
        return systemRepository.findAll();
    }
}
