package main;

public class Formattext {
	public String format(String text, int type) {
		String res = "";
		if (type == 0) {
			res = text;
		} else if(type == 1) {
			res = removeSpace(text);
		} else if (type == 2) {
			res = group5(text);
		}
		
		return res;
	}
	
	public String removeSpace(String txt) {
		return txt.replaceAll(" ", "");
	}
	
	public String group5(String txt) {
		String str = removeSpace(txt);
		String res = "";
		int i = 0;
		int remain = str.length() % 5;
		while(i < (str.length() - remain)) {
			res += str.substring(i, i+5) + " ";
			i += 5;
		}
		res += str.substring(str.length() - remain);
		return res;
	}
}
