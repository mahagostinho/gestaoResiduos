package br.com.fiap.gestaoResiduos.dto;

import br.com.fiap.gestaoResiduos.model.Caminhao;

public record CaminhaoExibicaoDTO(
        Long caminhaoId,
        String modelo,
        Double capacidadeMaximaLitros,
        Boolean status
) {
    public CaminhaoExibicaoDTO(Caminhao caminhao){
        this(
                caminhao.getCaminhaoId(),
                caminhao.getModelo(),
                caminhao.getCapacidadeMaximaLitros(),
                caminhao.getStatus()
        );
    }
}
