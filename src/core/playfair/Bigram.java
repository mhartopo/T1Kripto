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
public class Bigram {
    private final char char1;
    private final char char2;

    public Bigram(char char1, char char2){
        this.char1 = char1;
        this.char2 = char2;
    }

    public char getChar1(){
        return char1;
    }

    public char getChar2(){
        return char2;
    } 
    
    public String toString(){
        return char1+""+char2;
    }
}
