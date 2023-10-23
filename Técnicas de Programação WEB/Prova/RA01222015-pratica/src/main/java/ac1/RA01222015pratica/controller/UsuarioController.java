package ac1.RA01222015pratica.controller;

import ac1.RA01222015pratica.entity.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    List<Usuario> usuarioList = new ArrayList<>();
    List<Integer> ids = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Usuario>> getTodos() {
        return ResponseEntity.status(200).body(usuarioList);
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastro(@RequestBody Usuario usuario) {
        if (!validacaoEmail(usuario)) {
            return ResponseEntity.status(400).build();
        }

        usuarioList.add(usuario);
        ids.add(1);
        usuario.setId(ids.size());

        return ResponseEntity.status(201).body(usuario);
    }

    @GetMapping("/{indice}")
    public ResponseEntity<Usuario> getUm(@PathVariable int indice) {
        if (indice < 0 || indice > usuarioList.size()) {
            return ResponseEntity.status(400).build();
        }

        if (usuarioList.get(indice) == null || usuarioList.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(usuarioList.get(indice));
    }

    @PostMapping("/{indice}")
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario, @PathVariable int indice) {
        if (!validacaoEmail(usuario)){
            return ResponseEntity.status(400).build();
        }

        if (usuarioList.get(indice) == null || usuarioList.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        int id = usuarioList.get(indice).getId();
        usuarioList.set(indice, usuario);
        usuario.setId(id);

        return ResponseEntity.status(200).body(usuario);
    }

    @DeleteMapping("/{indice}")
    public ResponseEntity<Usuario> deletar(@PathVariable int indice){
        if (indice < 0 || indice > usuarioList.size()) {
            return ResponseEntity.status(400).build();
        }

        if (usuarioList.get(indice) == null || usuarioList.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(204).body(usuarioList.remove(indice));
    }

    public boolean validacaoEmail(Usuario usuario) {
        if  (   usuario.getEmail().isBlank() ||
                usuario.getEmail().length() < 10 ||
                !usuario.getEmail().contains("@"))
        {
            return false;
        }

        for (Usuario user : usuarioList){
            if (usuario.getEmail().equals(user.getEmail())) {
                return false;
            }
        }

        return true;
    }

}
