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
public class KeySquare {
    private char[][] key;
    public KeySquare(){ 
        
    }

    public void generateKey(String key){
        this.key = createKeySquare(key);
    }

    public Bigram generateChiper(Bigram text){
        Position positionChar1Bigram = null; 
        Position positionChar2Bigram = null;
        char resultChar1Bigram, resultChar2Bigram;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(key[i][j]==text.getChar1()){
                    positionChar1Bigram = new Position(i,j);
                }
            }
        }
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(key[i][j]==text.getChar2()){
                    positionChar2Bigram = new Position(i,j);
                }
            }
        }
        if (positionChar1Bigram.getY() == positionChar2Bigram.getY()){
            resultChar1Bigram = key[positionChar1Bigram.getY()][(positionChar1Bigram.getX()+1)%5];
            resultChar2Bigram = key[positionChar2Bigram.getY()][(positionChar2Bigram.getX()+1)%5];
        } else 
        if (positionChar1Bigram.getX() == positionChar2Bigram.getX()){
            resultChar1Bigram = key[(positionChar1Bigram.getY()+1)%5][positionChar1Bigram.getX()];
            resultChar2Bigram = key[(positionChar2Bigram.getY()+1)%5][positionChar2Bigram.getX()];           
        } else {
            resultChar1Bigram = key[positionChar1Bigram.getY()][positionChar2Bigram.getX()];
            resultChar2Bigram = key[positionChar2Bigram.getY()][positionChar1Bigram.getX()];
        }
        return new Bigram(resultChar1Bigram,resultChar2Bigram);
    }

    public Bigram generatePlain(Bigram text){
        Position positionChar1Bigram = null; 
        Position positionChar2Bigram = null;
        char resultChar1Bigram, resultChar2Bigram;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(key[i][j]==text.getChar1()){
                    positionChar1Bigram = new Position(i,j);
                }
            }
        }
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(key[i][j]==text.getChar2()){
                    positionChar2Bigram = new Position(i,j);
                }
            }
        }
        if (positionChar1Bigram.getY() == positionChar2Bigram.getY()){
            resultChar1Bigram = key[positionChar1Bigram.getY()][(positionChar1Bigram.getX()+4)%5];
            resultChar2Bigram = key[positionChar2Bigram.getY()][(positionChar2Bigram.getX()+4)%5];
        } else 
        if (positionChar1Bigram.getX() == positionChar2Bigram.getX()){
            resultChar1Bigram = key[(positionChar1Bigram.getY()+4)%5][positionChar1Bigram.getX()];
            resultChar2Bigram = key[(positionChar2Bigram.getY()+4)%5][positionChar2Bigram.getX()];           
        } else {
            resultChar1Bigram = key[positionChar1Bigram.getY()][positionChar2Bigram.getX()];
            resultChar2Bigram = key[positionChar2Bigram.getY()][positionChar1Bigram.getX()];
        }
        return new Bigram(resultChar1Bigram,resultChar2Bigram);
    }

    char[][] createKeySquare(String key){
        String KeyString = "";
        key = key.replace('j', 'i');
        System.out.println(key);
        char[][] result = new char[5][5];
        for(int i=0; i<key.length(); i++){          
            if(!KeyString.contains(String.valueOf(key.charAt(i)))){
                KeyString = KeyString + key.charAt(i);
            }
        }
        for(char i='a'; i<='z'; i++){
            if(!KeyString.contains(String.valueOf(i)) && (i!='j'))
                KeyString = KeyString + i;
        }
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                result[i][j] = KeyString.charAt(i*5+j);
            }
        }
        return result;
    }    
    
    public void print(){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                System.out.print(key[i][j]);
            }
            System.out.println();
        }
    }
}
