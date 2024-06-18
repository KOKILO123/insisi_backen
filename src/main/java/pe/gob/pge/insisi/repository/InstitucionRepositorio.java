package pe.gob.pge.insisi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.gob.pge.insisi.entity.Institucion;

import java.util.List;

public interface InstitucionRepositorio extends JpaRepository<Institucion, Long> {
    @Query(value="select t from Institucion t where t.estado=1")
    List<Institucion> list();
}
