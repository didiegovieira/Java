package school.sptech.aula02nivelamento;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    public List<String> pokemons = new ArrayList<>();

    @GetMapping
    public String listar(){
        return String.format("Total de pokemon cadastrados: %d (tamanho da lista)", pokemons.size());
    }

    @GetMapping("/cadastrar/{pokemon}")
    public String cadastrar(@PathVariable String pokemon){
        pokemons.add(pokemon);
        return "Pokemon cadastrado";
    }

    @GetMapping("/recuperar/{indice}")
    public String recuperar(@PathVariable int indice){
        if (pokemons.get(indice) == null){
            return "Pokemon não encontrado";
        }

        return String.format("Você escolheu o %s!", pokemons.get(indice));
    }

    @GetMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice){
        if (pokemons.get(indice) == null){
            return "Pokemon não encontrado";
        }
        pokemons.remove(indice);
        return String.format("Excluído!");
    }

    @GetMapping("/atualizar/{indice}/{novoNome}")
    public String atualizar(@PathVariable int indice, @PathVariable String novoNome){
        if (pokemons.get(indice) == null){
            return "Pokemon não encontrado";
        }
        String nome = pokemons.get(indice);
        pokemons.set(indice, novoNome);

        return "Pokemon Atualizado";
    }

    public boolean verificar(int indice){
        int tamanho = pokemons.size();

        return (tamanho >= 0 && indice <= 0) ? true : false;

    }
}
