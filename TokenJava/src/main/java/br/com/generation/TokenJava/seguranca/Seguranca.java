package br.com.generation.TokenJava.seguranca;

import javax.xml.bind.DatatypeConverter;

import br.com.generation.TokenJava.Model.Usuario;

public class Seguranca {
	
	private static final String PREFIXO="ZuZu|"; 
	
	public static String generateToken(Usuario usuario) {
		String str = PREFIXO + usuario.toString(); 
		String tokenz = DatatypeConverter.printHexBinary(str.getBytes()); 
		return tokenz; 
	}

	public static boolean isValid(String tokenz) {
		byte[] vetor = DatatypeConverter.parseHexBinary(tokenz); 
		String anotherS = new String (vetor); 
		System.out.println("Debug= " +anotherS); 
		if (anotherS.startsWith(PREFIXO)) {
			return true; 
		}
		else { 
			return false; 
		}
	}
		
	
	
}
