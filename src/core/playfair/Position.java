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
public class Position {
    private final int x;
    private final int y;
    public Position(int i, int j){
        this.x = j;
        this.y = i;
    }
    public int getX(){
        return x;
    } 
    public int getY(){
        return y;
    }   
}
