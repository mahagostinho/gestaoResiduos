package br.com.fiap.gestaoResiduos.repository;

import br.com.fiap.gestaoResiduos.model.Caminhao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {

}
