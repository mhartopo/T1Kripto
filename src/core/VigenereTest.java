package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class VigenereTest {
	Vigenere vg = new Vigenere(0);
	String txt = "HELLOWORLD";
	String key = "ABC";
	String key2 = "" + (char)(0) + (char)(1) + (char)(2);
	@Test
	public void testNormalEncr() {
		String expected = "HFNLPYOSND";
		String res = vg.Encrypt(txt, key);
		assertEquals(res,expected);
	}
	
	@Test
	public void testNormalDecrypt() {
		String res = vg.Encrypt(txt, key);
		res = vg.Decrypt(res, key);
		assertEquals(res,txt);
		
	}
	@Test
	public void testAdvEncr() {
		vg.setMode(1);
		String expected = "HFNLPYOSND";
		String res = vg.Encrypt(txt, key2);
		assertEquals(res,expected);
	}
	
	@Test
	public void testAdvDecrypt() {
		String res = vg.Encrypt(txt, key2);
		res = vg.Decrypt(res, key2);
		assertEquals(res,txt);
		
	}
}
