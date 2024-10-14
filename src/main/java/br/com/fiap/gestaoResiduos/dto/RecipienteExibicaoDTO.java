package br.com.fiap.gestaoResiduos.dto;

import br.com.fiap.gestaoResiduos.model.Recipiente;

public record RecipienteExibicaoDTO(
        Long recipienteId,
        Double volumeAtualLitros,
        Double volumeTotalLitros,
        String status
) {
    public RecipienteExibicaoDTO(Recipiente recipiente){
        this(
                recipiente.getRecipienteId(),
                recipiente.getVolumeAtualLitros(),
                recipiente.getVolumeTotalLitros(),
                recipiente.getStatus()
        );
    }
}
