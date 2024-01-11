package school.sptech.atividade1.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.atividade1.controller.dto.UsuarioCreateRequestDto;
import school.sptech.atividade1.controller.dto.UsuarioResponseDto;
import school.sptech.atividade1.controller.dto.UsuarioSimpleResponse;
import school.sptech.atividade1.controller.dto.mapper.UsuarioMapper;
import school.sptech.atividade1.entity.Usuario;
import school.sptech.atividade1.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> listar() {
        // FIXME: Implementar lógica para converter a entidade em DTO

        List<Usuario> all = usuarioService.listar();

        if (all.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<UsuarioResponseDto> usuarioResponseDtos = all.stream()
                .map(UsuarioMapper::toUsuarioReponseDto)
                .toList();

        if (usuarioResponseDtos.isEmpty()) {
            throw new RuntimeException("Erro ao listar usuários");
        }

        return ResponseEntity.ok(usuarioResponseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> buscarPorId(@PathVariable int id) {
        // FIXME: Implementar lógica para converter a entidade em DTO

        Optional<Usuario> byId = Optional.ofNullable(usuarioService.buscarPorId(id));

        if (byId.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        UsuarioResponseDto usuarioResponseDto = UsuarioMapper.toUsuarioReponseDto(byId.get());
        return ResponseEntity.ok(usuarioResponseDto);
    }

    @GetMapping("/resumo")
    public ResponseEntity<List<UsuarioSimpleResponse>> listarResumo() {
        // FIXME: Implementar lógica para converter a entidade em DTO
        List<Usuario> all = usuarioService.listar();

        if (all.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<UsuarioSimpleResponse> usuarioResponseDtos = all.stream()
                .map(UsuarioMapper::toUsuarioSimpleResponse)
                .toList();

        if (usuarioResponseDtos.isEmpty()) {
            throw new RuntimeException("Erro ao listar usuários");
        }

        return ResponseEntity.ok(usuarioResponseDtos);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> salvar(@RequestBody @Valid UsuarioCreateRequestDto usuarioDto) {
        // FIXME: Implementar lógica para converter a entidade em DTO
        Usuario usuario = usuarioService.salvar(UsuarioMapper.toEntity(usuarioDto));

        if (usuario == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.created(null).body(UsuarioMapper.toUsuarioReponseDto(usuario));
    }
}
