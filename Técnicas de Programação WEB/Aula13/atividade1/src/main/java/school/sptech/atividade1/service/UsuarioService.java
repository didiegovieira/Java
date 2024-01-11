package school.sptech.atividade1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.sptech.atividade1.entity.Usuario;
import school.sptech.atividade1.repository.UsuarioRepository;

import java.util.List;

//FIXME: Completar a classe
@Service
@RequiredArgsConstructor
public class UsuarioService {

    public final UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        if (usuarioSalvo == null) {
            throw new RuntimeException("Erro ao salvar usuário");
        }

        return usuarioSalvo;
    }

    public List<Usuario> listar() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        if (usuarios == null) {
            throw new RuntimeException("Erro ao listar usuários");
        }

        return usuarios;
    }

    public Usuario buscarPorId(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        if (usuario == null) {
            throw new RuntimeException("Erro ao buscar usuário");
        }

        return usuario;
    }
}
