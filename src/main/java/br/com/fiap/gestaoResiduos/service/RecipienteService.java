package br.com.fiap.gestaoResiduos.service;


import br.com.fiap.gestaoResiduos.dto.RecipienteCadastroDTO;
import br.com.fiap.gestaoResiduos.dto.RecipienteExibicaoDTO;
import br.com.fiap.gestaoResiduos.model.Recipiente;
import br.com.fiap.gestaoResiduos.repository.RecipienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipienteService {

    @Autowired
    RecipienteRepository recipienteRepository;

    public RecipienteExibicaoDTO salvarRecipiente(RecipienteCadastroDTO recipienteDTO){
        Recipiente recipiente = new Recipiente();
        BeanUtils.copyProperties(recipienteDTO, recipiente);

        Recipiente recipienteSalvo = recipienteRepository.save(recipiente);
        return new RecipienteExibicaoDTO(recipienteSalvo);
    }

    public RecipienteExibicaoDTO buscarPorId(Long id){

        Optional<Recipiente> recipienteOptional = recipienteRepository.findById(id);

        if(recipienteOptional.isPresent()){
            return new RecipienteExibicaoDTO(recipienteOptional.get());
        } else {
            throw new RuntimeException("Recipiente não existe!");
        }
    }

    public List<RecipienteExibicaoDTO> listarTodos(){

        return recipienteRepository.findAll().stream().map(RecipienteExibicaoDTO::new).toList();
    }

    public void excluir(Long id) {

        Optional<Recipiente> recipienteOptional = recipienteRepository.findById(id);

        if (recipienteOptional.isPresent()) {
            recipienteRepository.delete(recipienteOptional.get());
        } else {
            throw new RuntimeException("Recipiente não encontrado!");
        }
    }

    public Recipiente atualizar(Recipiente recipiente){

        Optional<Recipiente> recipienteOptional = recipienteRepository.findById(recipiente.getRecipienteId());

        if (recipienteOptional.isPresent()){
            return recipienteRepository.save(recipiente);
        } else {
            throw new RuntimeException("Recipiente não encontrado!");
        }
    }


}
