package sptech.school.relacionamento1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sptech.school.relacionamento1.dto.consulta.MedicoConsultaResponseDto;
import sptech.school.relacionamento1.entity.Medico;
import sptech.school.relacionamento1.repository.MedicoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor // Colocar em construtor as prioridades que são final
@RequestMapping("/medicos")
public class MedicoController {
    private final MedicoRepository repository;

    @GetMapping
    public ResponseEntity<List<MedicoConsultaResponseDto>> findAll() {
        List<Medico> all = repository.findAll();

        if (all.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<MedicoConsultaResponseDto> dtos = new ArrayList<>();

        for (Medico medico : all) {
            MedicoConsultaResponseDto medicoDto = new MedicoConsultaResponseDto();
            medicoDto.setId(medico.getId());
            medicoDto.setCrm(medico.getCrm());
            medicoDto.setNome(medico.getNome());
            medicoDto.setEspecialidade(medico.getEspecialidade());

            if (!medico.getConsultas().isEmpty()) {
                medicoDto.setConsultas(medico.getConsultas());
            }

            dtos.add(medicoDto);
        }

        return ResponseEntity.ok(dtos);
    }
}
