package pe.gob.pge.insisi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.gob.pge.insisi.controller.DashboardController;
import pe.gob.pge.insisi.entity.Area;
import pe.gob.pge.insisi.entity.Incidencia;
import pe.gob.pge.insisi.projection.DashboardProjection;

import java.util.List;

public interface IncidenciaRepositorio extends JpaRepository<Incidencia, Long> {
    @Query(value="select t from Incidencia t where t.estado=1")
    List<Incidencia> list();

    @Query(value = "EXEC dashboardList ?1 ", nativeQuery=true)
    List<DashboardProjection> getListDashboard(Integer estado);

}
