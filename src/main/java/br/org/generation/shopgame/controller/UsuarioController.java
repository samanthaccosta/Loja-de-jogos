package br.org.generation.shopgame.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.shopgame.model.Usuario;
import br.org.generation.shopgame.model.UsuarioLogin;
import br.org.generation.shopgame.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Usuario>>getAll(){
		return ResponseEntity.ok(usuarioService.listaUsuarios());
	}
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin>login(@RequestBody Optional <UsuarioLogin> usuarioLogin){
		return usuarioService.loginUsuario(usuarioLogin)
				.map(respLogin -> ResponseEntity.status(HttpStatus.OK).body(respLogin))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());}
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario){
		return usuarioService.cadastrarUsuario(usuario)
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	}
	
	
	
	

