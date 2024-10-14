package br.com.fiap.gestaoResiduos.repository;

import br.com.fiap.gestaoResiduos.model.Recipiente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipienteRepository extends JpaRepository<Recipiente, Long> {
}
