package com.mitocode.service;

import java.util.List;

import com.mitocode.dto.ConsultaListaExamenDTO;
import com.mitocode.dto.ConsultaResumenDTO;
import com.mitocode.dto.FiltroConsultaDTO;
import com.mitocode.model.Consulta;

public interface IConsultaService extends IGenericService<Consulta, Integer> {

	Consulta registrarTransaccional(ConsultaListaExamenDTO dto);

	List<Consulta> buscar(FiltroConsultaDTO dto);

	List<Consulta> buscarFecha(FiltroConsultaDTO dto);

	List<ConsultaResumenDTO> listarResumen();
	
	byte[] generarReporte();

}
