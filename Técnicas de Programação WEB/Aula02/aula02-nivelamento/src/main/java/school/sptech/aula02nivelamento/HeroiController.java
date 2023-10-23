package school.sptech.aula02nivelamento;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroiController {

    private List<Heroi> listaHerois = new ArrayList<>(
            List.of(new Heroi("Homem sereia", 8001, "Nadar", 1200, true),
                    new Heroi("Batman", 9000, "Descer o k7", 40, true)

            ));

    @GetMapping
    public List<Heroi> todos(){
        return listaHerois;
    }

    @GetMapping("/{indice}")
    public Heroi json(@PathVariable int indice) {
        return (verificacao(indice)) ? listaHerois.get(indice) : null;
    }

    @GetMapping("/cadastrar/{nome}/{habilidade}/{idade}/{forca}/{vivo}")
    public Heroi cadastrar(@PathVariable String nome, @PathVariable String habilidade,
                           @PathVariable int idade, @PathVariable int forca, @PathVariable boolean vivo){
        listaHerois.add(new Heroi(nome, forca, habilidade, idade, vivo));
        return listaHerois.get(listaHerois.size()-1);
    }

    @GetMapping("/atualizar/{indice}/{nome}/{habilidade}/{idade}/{forca}/{vivo}")
    public Heroi atualizar(@PathVariable int indice, @PathVariable String nome,
                           @PathVariable String   habilidade, @PathVariable int idade,
                           @PathVariable int forca, @PathVariable boolean vivo){
        if (verificacao(indice)) {
            Heroi heroi = new Heroi(nome, forca, habilidade, idade, vivo);
            listaHerois.set(indice, heroi);
        }
        return verificacao(indice) ? listaHerois.get(indice) : null;
    };

    @GetMapping("/remover/{indice}")
    public String remove(@PathVariable int indice) {
        if (verificacao(indice)) {
            listaHerois.remove(indice);
        }

        return verificacao(indice) ? "Herói não encontrado" : "Heroi removido";
    }

    public boolean verificacao(int indice) {
        return indice >= 0 && indice < listaHerois.size();
    }
}
