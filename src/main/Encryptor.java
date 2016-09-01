package main;

public class Encryptor {
	private int algorithm;
	// 0 = normal vigenere, 1 = 256 vigenere, 2 = vigenere modifikasi, 3 = playfair
	private int textType;
	//0 = text, 1 = binary
	
	public Encryptor() {
		setAlgorithm(0);
		setTextType(0);
	}
	
	public Encryptor(int algo, int ttype) {
		setAlgorithm(algo);
		setTextType(ttype);
	}
	
	public String encrypt(String plainMsg) {
		String res = "";
		//masih stub
		return res;
	}
	
	public String decrypt(String chiperMsg) {
		String res = "";
		//masih stub
		return res;
	}
	//Getter and setter
	public int getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(int algorithm) {
		this.algorithm = algorithm;
	}

	public int getTextType() {
		return textType;
	}

	public void setTextType(int textType) {
		this.textType = textType;
	}
	
	
}
