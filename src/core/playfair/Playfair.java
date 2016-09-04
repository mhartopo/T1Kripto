/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.playfair;

/**
 *
 * @author fikri
 */
public class Playfair {
	
    public Playfair(){
    }

    public String Encrypt(String text, String key){
    	text = text.replace(" ", "");
        text = text.toLowerCase();
        text = text.replace('j', 'i');
        
        key = key.replace(" ", "");
        key = key.toLowerCase();
        
        String result = "";
        
        KeySquare keySquare = new KeySquare();
        keySquare.generateKey(key);
        int position=0;
        while(position < text.length()){
            char char1, char2;
            char1 = text.charAt(position);
            position++;
            if (position == text.length()){
                char2 = 'z';
            } else {
                char2 = text.charAt(position);
                position++;
            }
            if (char1 == char2){
                position--;
                char2 = 'z';
            }
            result = result+keySquare.generateChiper(new Bigram(char1, char2)).toString();
        }
        return result;
    }

    public String Decrypt(String text, String key){
    	text = text.replace(" ", "");
    	String result = "";
        KeySquare keySquare = new KeySquare();
        keySquare.generateKey(key);
        int position=0;
        while(position < text.length()){
            char char1, char2;
            char1 = text.charAt(position);
            position++;
            char2 = text.charAt(position);
            position++;
            result = result+keySquare.generatePlain(new Bigram(char1, char2)).toString();
        }
        return result;
    }
}

