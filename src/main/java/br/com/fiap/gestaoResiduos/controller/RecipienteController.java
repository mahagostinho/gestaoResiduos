package br.com.fiap.gestaoResiduos.controller;

import br.com.fiap.gestaoResiduos.dto.RecipienteCadastroDTO;
import br.com.fiap.gestaoResiduos.dto.RecipienteExibicaoDTO;
import br.com.fiap.gestaoResiduos.model.Recipiente;
import br.com.fiap.gestaoResiduos.service.RecipienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecipienteController {

    @Autowired
    private RecipienteService recipienteService;

    @PostMapping("/recipiente")
    @ResponseStatus(HttpStatus.CREATED)
    public RecipienteExibicaoDTO salvar(@RequestBody RecipienteCadastroDTO recipiente){
        return recipienteService.salvarRecipiente(recipiente);
    }

    @GetMapping("/recipiente")
    @ResponseStatus(HttpStatus.OK)
    public List<RecipienteExibicaoDTO> listarTodos()
    {
        return recipienteService.listarTodos();

    }

    @GetMapping("/recipiente/{recipienteId}")
    public ResponseEntity<RecipienteExibicaoDTO> buscarPorId(@PathVariable Long recipienteId){
        try {
            return ResponseEntity.ok(recipienteService.buscarPorId(recipienteId));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/recipiente/{recipienteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long recipienteId){
        recipienteService.excluir(recipienteId);
    }

    @PutMapping("/recipiente")
    @ResponseStatus(HttpStatus.OK)
    public Recipiente atualizar(@RequestBody Recipiente recipiente){

        return recipienteService.atualizar(recipiente);
    }

}
