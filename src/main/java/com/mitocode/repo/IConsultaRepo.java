package com.mitocode.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitocode.model.Consulta;

public interface IConsultaRepo extends IGenericRepo<Consulta, Integer> {

	@Query("FROM Consulta c WHERE c.paciente.dni =:dni OR LOWER(c.paciente.nombres)"
			+ " like %:nombreCompleto% OR LOWER(c.paciente.apellidos) like %:nombreCompleto%")
	List<Consulta> buscar(@Param("dni") String dni, @Param("nombreCompleto") String nombreCompleto);

	@Query("FROM Consulta c WHERE c.fecha between :fechaConsulta and :fechaSgte")
	List<Consulta> buscarFecha(@Param("fechaConsulta") LocalDateTime fechaConsulta,
			@Param("fechaSgte") LocalDateTime fechaSgte);

	@Query(value = "SELECT * FROM fn_listarResumen()", nativeQuery = true)
	List<Object[]> listarResumen();

}
