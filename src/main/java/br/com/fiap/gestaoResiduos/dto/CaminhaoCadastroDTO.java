package br.com.fiap.gestaoResiduos.dto;

import jakarta.persistence.Column;


public record CaminhaoCadastroDTO(
        Long caminhaoId,
        String modelo,
        Double capacidadeMaximaLitros,
        Boolean status
) {
}
