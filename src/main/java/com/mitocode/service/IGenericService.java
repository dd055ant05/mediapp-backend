package com.mitocode.service;

import java.util.List;

public interface IGenericService<T, V> {

	T registrar(T obj) throws Exception;

	T modificar(T obj) throws Exception;

	List<T> listar() throws Exception;

	T listarPorId(V id) throws Exception;

	void eliminar(V id) throws Exception;
}
