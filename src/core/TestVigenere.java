package core;

public class TestVigenere {
	public static void main(String[] args) {
		String key = "VIGENERECIPHER";
        String text = "Beware the Jabberwock my son The jaws that bite, the claws that catch";
		Vigenere vg = new Vigenere(0);
        String encrypt = vg.Encrypt(text, key);
		System.out.println(encrypt);
		System.out.println(vg.Decrypt(encrypt, key));
	}
}
