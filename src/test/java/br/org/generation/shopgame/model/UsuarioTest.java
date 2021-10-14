package br.org.generation.shopgame.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsuarioTest {

	public Usuario usuario;
	public Usuario usuarioErro = new Usuario();
	@Autowired
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator= factory.getValidator();
	
	@BeforeEach
	public void start() {
		usuario= new Usuario(0L, "Samantha Cristina da Costa", "samy@gmail.com","12345678");
	}
	@Test
	@DisplayName("✔ Valida Atributos Não Nulos")
	void testValidaAtributos() {
		Set<ConstraintViolation<Usuario>> violacao = validator.validate(usuario);
		System.out.println(violacao.isEmpty());
		assertTrue(violacao.isEmpty());
	}
	@Test
	@DisplayName("❌ Não valida atributos nulos")
	void testNaoValidaAtributos() {
		Set<ConstraintViolation<Usuario>>violacao=validator.validate(usuarioErro);
		System.out.println(violacao.toString());
		assertFalse(violacao.isEmpty());
	}
	
}
