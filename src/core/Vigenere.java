package core;

public class Vigenere {
	//mode 0 =  26 character (a - z), mode 1 = 256 ASCII
	private int mode;
	//constructor
	public Vigenere() {
		mode = 0;
	}
	
	public Vigenere(int mode) {
		this.mode = mode;
	}
	
	//getter and setter
	public int getMode() {
		return mode;
	}
	
	public void setMode(int mode) {
		this.mode = mode;
	}
	
	//operation
	public String encrypt(String text, String key) {
		String result  = "";
		if(mode == 0) {
			text = text.toUpperCase();
			int j = 0;
			for (int i = 0; i < text.length(); i++) {
				char c = text.charAt(i);
				if (c >= 'A' && c <= 'Z') {
					result += (char)((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
					j = (j+1) % key.length();
				} else {
					result += c;
				}
			}
		} else {
			int j = 0;
			for (int i = 0; i < text.length(); i++) {
				char c = text.charAt(i);
				if (c != ' ') {
					result += (char)((c + key.charAt(j)) % 256);
					j = (j+1) % key.length();
				} else {
					result += c;
				}
			}
		}
		return result;
	}
	
	public String decrypt(String chipertext, String key) {
		String result  = "";
		if(mode == 0) {
			int j = 0;
			for (int i = 0; i < chipertext.length(); i++) {
				char c = chipertext.charAt(i);
				if (c >= 'A' && c <= 'Z') {
					result += (char)((c - key.charAt(j) + 26) % 26 + 'A');
					j = (j+1) % key.length();
				} else {
					result += c;
				}
			}
		} else {
			int j = 0;
			for (int i = 0; i < chipertext.length(); i++) {
				char c = chipertext.charAt(i);
				if (c != ' ') {
					result += (char)((c - key.charAt(j)) % 256);
					j = (j+1) % key.length();
				} else {
					result += c;
				}
			}
		}
		return result;
	}
}
