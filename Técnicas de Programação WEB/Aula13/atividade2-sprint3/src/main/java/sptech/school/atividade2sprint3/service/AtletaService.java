package sptech.school.atividade2sprint3.service;

import org.springframework.stereotype.Service;
import sptech.school.atividade2sprint3.entity.Atleta;
import sptech.school.atividade2sprint3.repository.AtletaRepository;

import java.util.List;

@Service
public class AtletaService {
    final private AtletaRepository atletaRepository;

    public AtletaService(AtletaRepository atletaRepository) {
        this.atletaRepository = atletaRepository;
    }

    public List<Atleta> findAll() {
        return atletaRepository.findAll();
    }

    public Atleta create(Atleta atleta) {
        return atletaRepository.save(atleta);
    }

    public Atleta findByNome(String nome) {
        return atletaRepository.findByNome(nome);
    }

    public Atleta findByPosicao(String posicao) {
        return atletaRepository.findByPosicao(posicao);
    }

    public Atleta findById(Integer id) {
        return atletaRepository.findById(id).orElse(null);
    }

    public List<Atleta> findAllByOrderByIdadeAsc() {
        return atletaRepository.findAllByOrderByIdadeAsc();
    }
}
