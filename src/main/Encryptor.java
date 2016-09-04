package main;

import core.playfair.Playfair;
import core.vigenere.*;

public class Encryptor {
	private int algorithm;
	// 0 = normal vigenere, 1 = 256 vigenere, 2 = vigenere modifikasi, 3 = playfair
	private Vigenere vigenere;
	private ModifiedVigenere mvigenere;
	private Playfair playfair;
	
	public Encryptor() {
		setAlgorithm(0);
		vigenere = new Vigenere();
		mvigenere = new ModifiedVigenere();
		playfair = new Playfair();
	}

	public String encrypt(String plainMsg, String key, int algo) {
		String res = "";
		if (algo == 0) {
			vigenere.setMode(0);
			res = vigenere.encrypt(plainMsg, key);
		} else if (algo == 1) {
			vigenere.setMode(1);
			res = vigenere.encrypt(plainMsg, key);
		} else if (algo == 2) {
			res = mvigenere.Encrypt(plainMsg);
		} else if (algo == 3) {
			res = playfair.Encrypt(plainMsg, key);
		}
		return res;
	}
	
	public byte[] encrypt(byte[] plainMsg, String key, int algo) {
		byte[] res = new byte[plainMsg.length];
		if (algo == 0) {
			vigenere.setMode(0);
			res = vigenere.encrypt(plainMsg, key);
		} else if (algo == 1) {
			vigenere.setMode(1);
			res = vigenere.encrypt(plainMsg, key);
		}
		return res;
	}
	
	public String decrypt(String chiperMsg, String key, int algo) {
		String res = "";
		if (algo == 0) {
			vigenere.setMode(0);
			res = vigenere.decrypt(chiperMsg, key);
		} else if (algo == 1) {
			vigenere.setMode(1);
			res = vigenere.decrypt(chiperMsg, key);
		} else if (algo == 2) {
			res = mvigenere.Decrypt(chiperMsg);
		} else if (algo == 3) {
			res = playfair.Decrypt(chiperMsg, key);
		}
		return res;
	}
	
	public byte[] decrypt(byte[] Msg, String key, int algo) {
		byte[] res = new byte[Msg.length];
		if (algo == 0) {
			vigenere.setMode(0);
			res = vigenere.decrypt(Msg, key);
		} else if (algo == 1) {
			vigenere.setMode(1);
			res = vigenere.decrypt(Msg, key);
		}
		return res;
	}
	//Getter and setter
	public int getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(int algorithm) {
		this.algorithm = algorithm;
	}
	
	public static void main(String[] args) {
		Encryptor enc = new Encryptor();
		String txt = "Hello world nama saya adalah haha";
		String key = "halobandung";
		String res = enc.encrypt(txt, key, 0);
		System.out.println(res);
		System.out.println(enc.decrypt(res, key, 0));
	}
}
