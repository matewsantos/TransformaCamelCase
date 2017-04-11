package principal;

import java.util.ArrayList;
import java.util.List;

public class Palavra {

	private List<String> listaDePalavrasConvertidas = new ArrayList<String>();
	private String numero = new String();
	private int contador = 0;

	public static List<String> converterCamelCase(String original) {
		Palavra nonStaticMethod = new Palavra();
		if (nonStaticMethod.primeiroTemDigito(original)) {
			throw new IniciaComNumeroException("Inválido - não deve começar com números.");
		} else if (!original.matches("[a-zA-Z0-9]*")) {
			throw new CaracteresEspeciaisException(
					"Inválido - caracteres especiais não são permitidos, somente letras e números.");
		}
		return nonStaticMethod.converterPalavraCamelCase(original);
	}
	

	private boolean primeiroTemDigito(String s) {
		return Character.isDigit(s.charAt(0));
	}

	private boolean ehMaiusculaOuNumero(char letra) {
		if (Character.isUpperCase(letra) || Character.isDigit(letra))
			return true;
		else
			return false;
	}

	private List<String> converterPalavraCamelCase(String palavra) {
		char[] letras = palavra.toCharArray();
		for (int i = 1; i < letras.length; i++) {
			if (ehMaiusculaOuNumero(palavra.charAt(i))) {
				listaDePalavrasConvertidas.add(palavra.substring(contador, i).toLowerCase());
				if (Character.isDigit(palavra.charAt(i)))
					i = pegarNumeroNaPalavra(letras, palavra, i);
				contador = i;
			} else if (i == letras.length - 1)
				listaDePalavrasConvertidas.add(palavra.substring(contador, palavra.length()).toLowerCase());
		}
		return listaDePalavrasConvertidas;
	}

	private int pegarNumeroNaPalavra(char[] letras, String palavra, int contador) {
		for (int y = contador; y < letras.length; y++) {
			if (Character.isDigit(palavra.charAt(y))) {
				numero = numero + palavra.charAt(y);
				contador = y;
			} else 
				break;
		}
		if (!numero.equals(""))
			listaDePalavrasConvertidas.add(numero);
		numero = new String();
		return contador + 1;
	}

}
