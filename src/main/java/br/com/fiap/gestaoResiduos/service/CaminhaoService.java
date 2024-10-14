package br.com.fiap.gestaoResiduos.service;

import br.com.fiap.gestaoResiduos.dto.CaminhaoCadastroDTO;
import br.com.fiap.gestaoResiduos.dto.CaminhaoExibicaoDTO;
import br.com.fiap.gestaoResiduos.model.Caminhao;
import br.com.fiap.gestaoResiduos.repository.CaminhaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaminhaoService {
    @Autowired
    private CaminhaoRepository caminhaoRepository;

    public CaminhaoExibicaoDTO salvarCaminhao(CaminhaoCadastroDTO caminhaoDTO){
        Caminhao caminhao = new Caminhao();
        BeanUtils.copyProperties(caminhaoDTO, caminhao);

        Caminhao caminhaoSalvo = caminhaoRepository.save(caminhao);
        return new CaminhaoExibicaoDTO(caminhaoSalvo);
    }

    public CaminhaoExibicaoDTO buscarPorId(Long id){

        Optional<Caminhao> caminhaoOptional = caminhaoRepository.findById(id);

        if(caminhaoOptional.isPresent()){
            return new CaminhaoExibicaoDTO(caminhaoOptional.get());
        } else {
            throw new RuntimeException("Caminhao não existe!");
        }
    }

    public List<CaminhaoExibicaoDTO> listarTodos(){

        return caminhaoRepository.findAll().stream().map(CaminhaoExibicaoDTO::new).toList();
    }

    public void excluir(Long id) {

        Optional<Caminhao> caminhaoOptional = caminhaoRepository.findById(id);

        if (caminhaoOptional.isPresent()) {
            caminhaoRepository.delete(caminhaoOptional.get());
        } else {
            throw new RuntimeException("Veículo não encontrado!");
        }
    }

    public Caminhao atualizar(Caminhao caminhao){

        Optional<Caminhao> caminhaoOptional = caminhaoRepository.findById(caminhao.getCaminhaoId());

        if (caminhaoOptional.isPresent()){
            return caminhaoRepository.save(caminhao);
        } else {
            throw new RuntimeException("Veículo não encontrado!");
        }
    }
}
