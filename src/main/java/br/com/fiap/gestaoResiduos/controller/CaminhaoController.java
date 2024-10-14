package br.com.fiap.gestaoResiduos.controller;

import br.com.fiap.gestaoResiduos.dto.CaminhaoCadastroDTO;
import br.com.fiap.gestaoResiduos.dto.CaminhaoExibicaoDTO;
import br.com.fiap.gestaoResiduos.model.Caminhao;
import br.com.fiap.gestaoResiduos.service.CaminhaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CaminhaoController {

    @Autowired
    private CaminhaoService caminhaoService;

    @PostMapping("/caminhao")
    @ResponseStatus(HttpStatus.CREATED)
    public CaminhaoExibicaoDTO salvar(@RequestBody CaminhaoCadastroDTO caminhao){
        return caminhaoService.salvarCaminhao(caminhao);
    }

    @GetMapping("/caminhao")
    @ResponseStatus(HttpStatus.OK)
    public List<CaminhaoExibicaoDTO> listarTodos()
    {
        return caminhaoService.listarTodos();

    }

    @GetMapping("/caminhao/{caminhaoId}")
    public ResponseEntity<CaminhaoExibicaoDTO> buscarPorId(@PathVariable Long caminhaoId){
        try {
            return ResponseEntity.ok(caminhaoService.buscarPorId(caminhaoId));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/caminhao/{caminhaoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long caminhaoId){
        caminhaoService.excluir(caminhaoId);
    }

    @PutMapping("/caminhao")
    @ResponseStatus(HttpStatus.OK)
    public Caminhao atualizar(@RequestBody Caminhao caminhao){
        return caminhaoService.atualizar(caminhao);
    }

}
