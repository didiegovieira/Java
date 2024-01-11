package sptech.school.atividade2sprint3.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.atividade2sprint3.controller.dto.atleta.AtletaCreateRequestDTO;
import sptech.school.atividade2sprint3.controller.dto.atleta.AtletaResponseDTO;
import sptech.school.atividade2sprint3.controller.dto.atleta.AtletaSimpleResponseDTO;
import sptech.school.atividade2sprint3.controller.dto.atleta.mapper.AtletaMapper;
import sptech.school.atividade2sprint3.entity.Atleta;
import sptech.school.atividade2sprint3.service.AtletaService;

import java.util.List;

@RestController
@RequestMapping("/atletas")
public class AtletaController {
    final private AtletaService atletaService;

    public AtletaController(AtletaService atletaService) {
        this.atletaService = atletaService;
    }

    @GetMapping
    public ResponseEntity<List<AtletaResponseDTO>> findAll() {
        List<Atleta> all = atletaService.findAll();

        if (all.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<AtletaResponseDTO> atletaResponseDtos = all.stream()
                .map(AtletaMapper::toAtletaResponseDto)
                .toList();

        return ResponseEntity.ok(atletaResponseDtos);
    }

    @PostMapping
    public ResponseEntity<AtletaSimpleResponseDTO> create(@RequestBody @Valid AtletaCreateRequestDTO dto) {
        Atleta atleta = AtletaMapper.toEntity(dto);

        Atleta atletaResponse = atletaService.create(atleta);

        AtletaSimpleResponseDTO atletaResponseDto = AtletaMapper.toAtletaSimpleResponseDto(atletaResponse);

        return ResponseEntity.ok(atletaResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtletaSimpleResponseDTO> findById(@PathVariable Integer id) {
        Atleta atleta = atletaService.findById(id);

        if (atleta == null) {
            return ResponseEntity.notFound().build();
        }

        AtletaSimpleResponseDTO atletaResponseDto = AtletaMapper.toAtletaSimpleResponseDto(atleta);

        return ResponseEntity.ok(atletaResponseDto);
    }

    @GetMapping("/{nome}")
    public ResponseEntity<AtletaResponseDTO> findByNome(@PathVariable String nome) {
        Atleta atleta = atletaService.findByNome(nome);

        if (atleta == null) {
            return ResponseEntity.notFound().build();
        }

        AtletaResponseDTO atletaResponseDto = AtletaMapper.toAtletaResponseDto(atleta);

        return ResponseEntity.ok(atletaResponseDto);
    }

    @GetMapping("/{posicao}")
    public ResponseEntity<AtletaResponseDTO> findByPosicao(@PathVariable String posicao) {
        Atleta atleta = atletaService.findByPosicao(posicao);

        if (atleta == null) {
            return ResponseEntity.notFound().build();
        }

        AtletaResponseDTO atletaResponseDto = AtletaMapper.toAtletaResponseDto(atleta);

        return ResponseEntity.ok(atletaResponseDto);
    }

    @GetMapping("/idade")
    public ResponseEntity<List<AtletaSimpleResponseDTO>> findByIdade() {
        List<Atleta> atleta = atletaService.findAllByOrderByIdadeAsc();

        if (atleta == null) {
            return ResponseEntity.notFound().build();
        }

        List<AtletaSimpleResponseDTO> atletaResponseDto = atleta.stream()
                .map(AtletaMapper::toAtletaSimpleResponseDto)
                .toList();

        return ResponseEntity.ok(atletaResponseDto);
    }
}
