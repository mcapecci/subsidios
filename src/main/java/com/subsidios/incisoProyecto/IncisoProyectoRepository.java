package com.subsidios.incisoProyecto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IncisoProyectoRepository extends JpaRepository<IncisoProyecto, Long>{

	List<IncisoProyecto> findByProyectoId(long idProyecto);

	/*
	@Query("select ip from INCISO_PROYECTO ip where ip.id_proyecto = :idProyecto")
	List<IncisoProyecto> findAllByProyectoId(@Param("idProyecto") long idProyecto);
	*/

}
