package sptech.school.atividade2sprint3.service;

import org.springframework.stereotype.Service;
import sptech.school.atividade2sprint3.entity.Equipe;
import sptech.school.atividade2sprint3.repository.EquipeRepository;

import java.util.List;

@Service
public class EquipeService {

    final private EquipeRepository equipeRepository;

    public EquipeService(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    public List<Equipe> findAll() {
        return equipeRepository.findAll();
    }

    public Equipe create(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    public Equipe findByNome(String nome) {
        return equipeRepository.findByNome(nome);
    }

    public Equipe findByNomeDoTecnico(String nomeDoTecnico) {
        return equipeRepository.findByNomeDoTecnico(nomeDoTecnico);
    }

    public Equipe findById(Integer id) {
        return equipeRepository.findById(id).orElse(null);
    }
}
