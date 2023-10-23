package com.example.aula03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Controller // MVC -> retorna paginas em html
@RestController // API em REST
@RequestMapping("/musicas")
public class MusicController {
    private List<Music> musicas = new ArrayList<>();

    @GetMapping("/listar")
    public List<Music> listar(){
        return this.musicas;
    }

    @GetMapping("/consultar/{indice}")
    public Music consultarPorIndice(@PathVariable int indice){
        return this.musicas.get(indice);
    }

    @GetMapping("/cadastrar/{nome}/{artista}")
    public Music cadastrar(@PathVariable String nome, @PathVariable String artista){
        musicas.add(new Music(nome, artista));
        return musicas.get(musicas.size()-1);

    }


    @PostMapping("/postbody")
    public String postBody(@RequestBody String fullName) {
        return "Hello " + fullName;
    }

    @PostMapping("/cadastrar")
    public Music postBody(@RequestBody Music musica) {
        musicas.add(musica);
        return musica;
    }

    @DeleteMapping("/{indice}")
    public String delete(@PathVariable int indice){
        musicas.remove(musicas.get(indice));
        return "Deletado";
    }

    @PutMapping("/atualizar/{indice}")
    public Music atualizar(@RequestBody Music musica, @PathVariable int indice){
        musicas.set(indice, musica);
        return musica;
    }
}
