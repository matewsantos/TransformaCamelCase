package principal;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TransformarCadeiaCaracteresTeste {

	List<String> palavrasConvertidas;
	
	@Before
	public void inicializaListaPalavras(){
		palavrasConvertidas = new ArrayList<String>();
	}

	@Test
	public void converterUmaPalavraTeste() {
		assertEquals("lista", Palavra.converterCamelCase("lista").get(0).toString());
		assertEquals("lista", Palavra.converterCamelCase("Lista").get(0).toString());
	}

	@Test(expected = IniciaComNumeroException.class)
	public void palavraIniciadaComNumeroTeste() {
		palavrasConvertidas = Palavra.converterCamelCase("1Contador");
	}
	
	@Test
	public void converterPalavraCompostaCamelCase() {
		List<String> palavras = new ArrayList<String>();
		palavras.add("nome");
		palavras.add("do");
		palavras.add("cachorro");
		
		assertEquals(palavras, Palavra.converterCamelCase("nomeDoCachorro"));
	}
	
	@Test
	public void converterPalavraCompostaIniciandoComMaiusculaCamelCase() {
		List<String> palavras = new ArrayList<String>();
		palavras.add("nome");
		palavras.add("do");
		palavras.add("cachorro");
		
		assertEquals(palavras, Palavra.converterCamelCase("NomeDoCachorro"));
	}
	
	@Test
	public void converterPalavraCompostaComNumeroCamelCase() {
		List<String> palavras = new ArrayList<String>();
		palavras.add("com");
		palavras.add("1");
		palavras.add("numero");
		
		assertEquals(palavras, Palavra.converterCamelCase("com1Numero"));
	}
	
	@Test
	public void converterPalavraCompostaComNumeroIniciandoComMaiusculaCamelCase() {
		List<String> palavras = new ArrayList<String>();
		palavras.add("com");
		palavras.add("10");
		palavras.add("numero");
		palavras.add("20");
		palavras.add("com");
		
		assertEquals(palavras, Palavra.converterCamelCase("Com10Numero20com"));
	}
	
	@Test(expected=CaracteresEspeciaisException.class)
	public void converterPalavraComCaracterEspecial(){
		Palavra.converterCamelCase("@emailDoUser01");
	}
	
}
