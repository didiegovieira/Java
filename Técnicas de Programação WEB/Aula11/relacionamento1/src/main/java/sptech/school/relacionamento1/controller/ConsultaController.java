package sptech.school.relacionamento1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sptech.school.relacionamento1.dto.consulta.ConsultaMedicoResponseDto;
import sptech.school.relacionamento1.dto.consulta.MedicoConsultaResponseDto;
import sptech.school.relacionamento1.entity.Consulta;
import sptech.school.relacionamento1.entity.Medico;
import sptech.school.relacionamento1.repository.ConsultaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor // Colocar em construtor as prioridades que são final
@RequestMapping("/consultas")
public class ConsultaController {
    private final ConsultaRepository repository;

    @GetMapping
    public ResponseEntity<List<ConsultaMedicoResponseDto>> findAll() {
        List<Consulta> all = repository.findAll();

        if (all.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<ConsultaMedicoResponseDto> dtos = new ArrayList<>();

        for (Consulta consulta : all) {
            ConsultaMedicoResponseDto consultaDto = new ConsultaMedicoResponseDto();
            consultaDto.setId(consulta.getId());
            consultaDto.setNomePaciente(consulta.getNomePaciente());
            consultaDto.setDataHora(consulta.getDataHora());
            consultaDto.setStatus(consulta.getStatus());

            if (Objects.nonNull(consulta.getMedico())) {
                Medico medicoEntidade = consulta.getMedico();
                MedicoConsultaResponseDto medicoDto = new MedicoConsultaResponseDto();
                medicoDto.setId(medicoEntidade.getId());
                medicoDto.setCrm(medicoEntidade.getCrm());
                medicoDto.setNome(medicoEntidade.getNome());
                medicoDto.setEspecialidade(medicoEntidade.getEspecialidade());
                consultaDto.setMedico(medicoDto);
            }

            dtos.add(consultaDto);
        }

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/medicos")
    public ResponseEntity<List<Consulta>> findByName(@RequestParam String nome) {
        List<Consulta> all = repository.findByMedicoNomeContainsIgnoreCase(nome);

        if (all.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(all);
    }

    @GetMapping("/medicos/crm")
    public ResponseEntity<List<Consulta>> findByMedicoCrm(@RequestParam String codigo) {
        List<Consulta> all = repository.buscarPorCrm(codigo);

        if (all.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(all);
    }
}
