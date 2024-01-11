package sptech.school.atividade2sprint3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.atividade2sprint3.controller.dto.equipe.EquipeCreateRequestDTO;
import sptech.school.atividade2sprint3.controller.dto.equipe.EquipeResponseDTO;
import sptech.school.atividade2sprint3.controller.dto.equipe.EquipeSimpleResponseDTO;
import sptech.school.atividade2sprint3.controller.dto.equipe.mapper.EquipeMapper;
import sptech.school.atividade2sprint3.entity.Equipe;
import sptech.school.atividade2sprint3.service.EquipeService;

import java.util.List;

@RestController
@RequestMapping("/equipes")
public class EquipeController {
    final private EquipeService equipeService;

    public EquipeController(EquipeService equipeService) {
        this.equipeService = equipeService;
    }

    @GetMapping
    public ResponseEntity<List<EquipeResponseDTO>> findAll() {
        List<Equipe> all = equipeService.findAll();

        if (all.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<EquipeResponseDTO> equipeResponseDtos = all.stream()
                .map(EquipeMapper::toEquipeResponseDto)
                .toList();

        return ResponseEntity.ok(equipeResponseDtos);
    }

    //create
    @PostMapping
    public ResponseEntity<EquipeSimpleResponseDTO> create(@RequestBody EquipeCreateRequestDTO dto) {
        Equipe equipe = EquipeMapper.toEntity(dto);

        Equipe equipeResponse = equipeService.create(equipe);

        EquipeSimpleResponseDTO equipeResponseDto = EquipeMapper.toEquipeSimpleResponse(equipeResponse);

        return ResponseEntity.ok(equipeResponseDto);
    }

    @GetMapping("/{nome}")
    public ResponseEntity<EquipeResponseDTO> findByNome(@PathVariable String nome) {
        Equipe equipe = equipeService.findByNome(nome);

        if (equipe == null) {
            return ResponseEntity.notFound().build();
        }

        EquipeResponseDTO equipeResponseDto = EquipeMapper.toEquipeResponseDto(equipe);

        return ResponseEntity.ok(equipeResponseDto);
    }

    @GetMapping("/{nomeDoTecnico}")
    public ResponseEntity<EquipeResponseDTO> findByNomeDoTecnico(@PathVariable String nomeDoTecnico) {
        Equipe equipe = equipeService.findByNomeDoTecnico(nomeDoTecnico);

        if (equipe == null) {
            return ResponseEntity.notFound().build();
        }

        EquipeResponseDTO equipeResponseDto = EquipeMapper.toEquipeResponseDto(equipe);

        return ResponseEntity.ok(equipeResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipeSimpleResponseDTO> findById(@PathVariable Integer id) {
        Equipe equipe = equipeService.findById(id);

        if (equipe == null) {
            return ResponseEntity.notFound().build();
        }

        EquipeSimpleResponseDTO equipeResponseDto = EquipeMapper.toEquipeSimpleResponse(equipe);

        return ResponseEntity.ok(equipeResponseDto);
    }
}
