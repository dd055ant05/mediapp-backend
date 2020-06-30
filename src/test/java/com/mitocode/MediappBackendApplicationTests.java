package com.mitocode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mitocode.model.Usuario;
import com.mitocode.repo.IUsuarioRepo;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MediappBackendApplicationTests {

	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@Autowired
	private IUsuarioRepo repo;

	@Test
	void crearUsuario() {

		Usuario user = new Usuario();
		user.setUsername("mitocode@gmail.com");
		user.setEnabled(true);
		user.setPassword(bcrypt.encode("123"));

		Usuario retorno = repo.save(user);

		assertTrue(retorno.getPassword().equalsIgnoreCase(user.getPassword()));
	}

}
