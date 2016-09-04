/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.vigenere;

/**
 *
 * @author fikri
 */
public class ModifiedVigenere {
    
    public ModifiedVigenere(){
    }
    
    public String Encrypt(String text){
        String result = "";
        int pos = 1;
        result+=(char)((text.charAt(0) + text.length()) % 256);
        while(pos < text.length()){
            result+=(char)((text.charAt(pos) + text.charAt(pos-1)) % 256);
            pos++;
        }
        return result;
    }
    
    public String Decrypt(String text){
        String result = "";
        int pos = 1;
        result+=(char)((text.charAt(0) - text.length()) % 256);
        while(pos < text.length()){
            result+=(char)((text.charAt(pos) - result.charAt(result.length()-1)) % 256);
            pos++;
        }        
        return result;
    }
}
