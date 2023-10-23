package school.sptech.aula02nivelamento;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculos")

public class CalculoController {


    private int contador;


    @GetMapping("/somar/{n1}/{n2}")
    public int somar(@PathVariable int n1, @PathVariable int n2){
        return n1 + n2;
    }

    @GetMapping("/multiplicar/{n1}/{n2}")
    public int multiplicar(@PathVariable int n1, @PathVariable int n2){
        return n1 * n2;
    }

    @GetMapping("/subtrair/{n1}/{n2}")
    public int subtrair(@PathVariable int n1, @PathVariable int n2){
        return n1 - n2;
    }

    @GetMapping("/dividir/{n1}/{n2}")
    public int dividir(@PathVariable int n1, @PathVariable int n2){
        return n1 / n2;
    }

    @GetMapping("/contador")
    public int contador(){
        return ++contador;
    }

    @GetMapping("/outro-contador")
    public int outroContador(){
        return ++contador;
    }

}
