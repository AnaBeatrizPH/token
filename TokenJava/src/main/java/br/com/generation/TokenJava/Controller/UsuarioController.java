package br.com.generation.TokenJava.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.generation.TokenJava.Model.Usuario;
import br.com.generation.TokenJava.seguranca.Seguranca;
import br.com.generation.TokenJava.seguranca.Token;



@RestController
@CrossOrigin("*")
public class UsuarioController {
	
	
		@PostMapping("/login")
		public ResponseEntity<Token> autentica(@RequestBody Usuario usuario){
			if (usuario.getEmail().equals("anathiwedding@gmail.com") && usuario.getSenha().equals("12345")) {
				
				usuario.setId(1);
				usuario.setName("Ana e Thi");		
			
				
				String tk = Seguranca.generateToken(usuario);
				System.out.println("TOKEN Gerado = "+tk);
				Token token = new Token();
				token.setStrToken(tk);
				return ResponseEntity.ok(token);
			}
			else {
				return ResponseEntity.status(403).build();
			}
			
		}
	
	
	
	
	
	
	/*@GetMapping("/login")
	public ResponseEntity<ArrayList<Usuario>> getAllUsuario(@RequestParam String token ){
		if (Seguranca.isValid(token)) {
			ArrayList<Usuario> list = new ArrayList<Usuario>();
			for (int i =0; i<15; i++) {
				
				Usuario u = new Usuario(); 
				u.setId(100);
				u.setName("Zuzu");
				u.setEmail("zuzu@balandia.com.uk");
				u.setSenha("12345");
				
				list.add(u); 
				
			}
			
			return ResponseEntity.ok(list); 
		}
		
		else {
			
			return ResponseEntity.status(403).build(); 
		
			}
	}*/
	
}
