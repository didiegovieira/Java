package school.sptech.aula04revisaohttp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroiController {

  private List<Heroi> herois = new ArrayList<>();

  @GetMapping
  public List<Heroi> listar() {
    return herois;
  }

  @GetMapping("/{indice}")
  public ResponseEntity<Heroi> getByIndice (@PathVariable int indice) {
    if (indice < 0 || indice > herois.size()) {
      return ResponseEntity.status(400).build();
    }

    return ResponseEntity.status(200).body(herois.get(indice));
  }

  @PostMapping()
  public ResponseEntity<Heroi> cadastrar (@RequestBody Heroi heroi) {
    if (heroi.getNome().length() < 3) {
      return ResponseEntity.status(400).build();
    }
    if (heroi.getHabilidade().length() < 3) {
      return ResponseEntity.status(400).build();
    }
    if (heroi.getIdade() > 0) {
      return ResponseEntity.status(400).build();
    }
    if (heroi.getForca() > 0 && heroi.getForca() < 100) {
      return ResponseEntity.status(400).build();
    }

    herois.add(heroi);
    return ResponseEntity.status(201).body(heroi);
  }

  @PutMapping("/{indice}")
  public ResponseEntity<Heroi> atualizar (@RequestBody Heroi heroi, @PathVariable int indice) {
    if (indice < 0 || indice > herois.size()) {
      return ResponseEntity.status(400).build();
    }

    if (heroi.getNome().length() < 3) {
      return ResponseEntity.status(400).build();
    }
    if (heroi.getHabilidade().length() < 3) {
      return ResponseEntity.status(400).build();
    }
    if (heroi.getIdade() > 0) {
      return ResponseEntity.status(400).build();
    }
    if (heroi.getForca() > 0 && heroi.getForca() < 100) {
      return ResponseEntity.status(400).build();
    }

    herois.set(indice, heroi);
    return ResponseEntity.status(201).body(heroi);
  }

  @DeleteMapping("/{indice}")
  public ResponseEntity<Heroi> deletar (@PathVariable int indice) {
    if (indice < 0 || indice > herois.size()) {
      return ResponseEntity.status(400).build();
    }

    return ResponseEntity.status(201).body(herois.remove(indice));
  }
}
