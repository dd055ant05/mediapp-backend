package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Menu;

public interface IMenuService extends IGenericService<Menu, Integer>{
	
	List<Menu> listarMenuPorUsuario(String nombre);

}
