package br.org.generation.shopgame.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import br.org.generation.shopgame.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
		Usuario usuario = new Usuario(0, "Samantha Cristina da Costa","samy@gmail.com","12345678");
		if(!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
			usuarioRepository.save(usuario);
		
		usuario = new Usuario(0,"Sabrina da Costa","sabrina@gmail.com", "12345678");
		if(!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
			usuarioRepository.save(usuario);
		
		usuario = new Usuario(0,"Rodrigo Moreira da Costa","rodrigo@gmail.com", "12345678");
		if(!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
			usuarioRepository.save(usuario);
		
		usuario = new Usuario(0,"Rejane Aparecida da Silva","rejane@gmail.com", "12345678");
		if(!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
			usuarioRepository.save(usuario);
	}
@Test
@DisplayName("💾 Retorna o nome")
public void findByRetornaNome() throws Exception{
	Usuario usuario = usuarioRepository.findByNome("Samantha Cristina da Costa");
	assertTrue(usuario.getNome().equals("Samantha Cristina da Costa"));
	}
@Test
@DisplayName("💾 Retorna 3 usuarios")
public void findAllNomeContainingIgnoreCaseRetornaTresUsuarios() {
	List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Costa");
	assertEquals (3,listaDeUsuarios.size());
}
@AfterAll
public void end() {
	usuarioRepository.deleteAll();
}
}
