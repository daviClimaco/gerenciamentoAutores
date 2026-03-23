package daviClimaco.gerenciamentoAutores.repository;

import daviClimaco.gerenciamentoAutores.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
