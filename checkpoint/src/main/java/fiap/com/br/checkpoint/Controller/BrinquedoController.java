package fiap.com.br.checkpoint.Controller;

import fiap.com.br.checkpoint.Dao.BrinquedoDaoImpl;
import fiap.com.br.checkpoint.Model.Brinquedo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Brinquedos")
public class BrinquedoController {

    private final BrinquedoDaoImpl brinquedoDao;

    @Autowired
    public BrinquedoController(BrinquedoDaoImpl brinquedoDao) {
        this.brinquedoDao = brinquedoDao;
    }

    @GetMapping("/Index")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("Estoque de Brinquedos");
    }

    @PostMapping("/Cadastrar")
    public ResponseEntity<Brinquedo> cadastrar(@RequestBody @Valid Brinquedo brinquedo) {
        Brinquedo novo = brinquedoDao.cadastrar(brinquedo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @GetMapping()
    public List<Brinquedo> listar() {
        return brinquedoDao.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brinquedo> procurarPorId(@PathVariable("id") int id) {
        Brinquedo brinquedo = brinquedoDao.buscar(id);
        return ResponseEntity.ok(brinquedo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerBrinquedo(@PathVariable("id") int id) {
        brinquedoDao.remover(id);
        return ResponseEntity.ok("Brinquedo excluido");
    }


}
