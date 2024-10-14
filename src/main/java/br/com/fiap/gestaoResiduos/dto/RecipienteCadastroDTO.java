package br.com.fiap.gestaoResiduos.dto;

public record RecipienteCadastroDTO(
        Long recipienteId,
        Double volumeAtualLitros,
        Double volumeTotalLitros,
        String status
) {
}
