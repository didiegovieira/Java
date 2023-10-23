package school.sptech.aula02nivelamento;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/frases")
public class FraseController {

    private List<String> listaFrases = new ArrayList<>();

    @GetMapping("/contagem")
    public String contagem(){
        return String.format("Você tem %s frases cadastradas!", listaFrases.size());
    }

    @GetMapping("/listar")
    public String listar(){
        String nome = "";
        for (int i = 0; i <= listaFrases.size(); i++) {
            nome += listaFrases.get(i) + "\n";
        }
        return nome;
    }

    @GetMapping("/addfrase/{frase}")
    public String addFrase(@PathVariable String frase){
        listaFrases.add(frase);
        return "frase cadastrada";
    }

    @GetMapping
    public String frase() {
        return "Hello World";
    }

    @GetMapping("/outra-frase")
    public String outraFrase(){
        return "Hello World";
    }

    @GetMapping("/personalizada/{nome}")
    public String personalizada(@PathVariable String nome){
        return String.format("Boa tarde %s! Você está muito bonito(a) como sempre!", nome);
    }

    @GetMapping("/personalizada/{nome}/{sobrenome}")
    public String personalizada(@PathVariable String nome, @PathVariable String sobrenome){
        return String.format("Boa tarde %s %s! Você está muito bonito(a) como sempre!", nome, sobrenome);
    }
}
