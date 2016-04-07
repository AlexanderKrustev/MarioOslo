package Models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by krustev on 31-Mar-16.
 */

public class Player {

    public int playerPossitionX;
    public int dx;
    public int playerPossitionY;
    public int firstRepBackground;
    public int secondRepBackground;
    public int distanceTraveled;                                                     //x coordinate,change in x coordinate,y coordinate,1st rep bg,2nd rep bg,dist traveled
    public Image player;                                                                                //The player variable
    public ImageIcon playerFacingLeft = new     ImageIcon("MarioLeft.png");                             //Image for player while he is     turning left
    public ImageIcon playerFacingRight = new     ImageIcon("MarioRight.png");                              //Image for player while he is turning right
                                           //This method will return the player. Is used by other classes


    public Player() {
        player = playerFacingRight.getImage();                                               //Give the player the image
        playerPossitionX = 75;                                                                              //The original x position of the player
        playerPossitionY = 285;                                                                             //The original y position of the player
        secondRepBackground = -575;                                                                          //Repeating background 2
        distanceTraveled = 24;
    }

    public int   getX()     { return playerPossitionX;      }                                               //This method will return the x.      Is used by other classes
    public int   getY()     { return playerPossitionY;      }                                               //This method will return the y.      Is used by other classes
    public Image getImage() { return player; }

    public void move() {
        if(playerPossitionX>0 && playerPossitionX<300) {                                                                   //If the player is within the moving area
            playerPossitionX = playerPossitionX + dx;                                                                        //The x position is updated to become itself+the amount you moved
            firstRepBackground = firstRepBackground + dx;                                                                      //Place the repeating background at regular speed
            secondRepBackground = secondRepBackground + dx;                                                                    //Place the repeating background at regular speed
        }
        if(playerPossitionX<=0) {                                                                           //If the player has reached he very left side of the screen(0px)
            playerPossitionX=1;                                                                             //Move him up a pixel so he can move again
            firstRepBackground = firstRepBackground +(dx*(int)0.5);                                                           //Place the background at a slower speed since Mario stops moving
            secondRepBackground = secondRepBackground +(dx*(int)0.5);                                                         //Place the background at a slower speed since Mario stops moving
        }
        if(playerPossitionX>=300) {                                                                         //If the player has reached the center of the screen(300px)
            playerPossitionX=299;                                                                           //Move him down a pixel so he can move again
            firstRepBackground = firstRepBackground +(dx*(int)0.5);                                                           //Place the background at a slower speed since Mario stops moving
            secondRepBackground = secondRepBackground +(dx*(int)0.5);                                                         //Place the background at a slower speed since Mario stops moving
        }
        if(dx>0){
            distanceTraveled++;
        }
        else if(dx<0){
            distanceTraveled--;
        }
        if(distanceTraveled>104){
            playerPossitionX=299;
        }
        if(playerPossitionX==1 && dx<0){
            distanceTraveled++;
        }
        if(distanceTraveled<104){
            firstRepBackground =0;
            secondRepBackground =-575;
        }
    }


    public void keyPressed(KeyEvent e) {                                                     //Called from the board class, the argument is whatever key was pressed
        int key = e.getKeyCode();                                                            //The key originally sent from the board class

        if(key == KeyEvent.VK_LEFT) {                                                        //If the key sent was LEFT
            player = playerFacingLeft.getImage();                                            //Make the player face leftwards
            if(distanceTraveled<104){
                if(playerPossitionX==0 && playerPossitionY==285){
                     dx=10;
                }
                else {
                    dx = -3;
                }
            }
            else{
                dx=-2;
            }
        }

        if(key == KeyEvent.VK_RIGHT) {                                                       //If the key sent was RIGHT
            player = playerFacingRight.getImage();                                           //Make the player face rightwards
            if(distanceTraveled<104) {
                if(playerPossitionX==85 && playerPossitionY==285){

                }
                else {
                    dx = 3;
                }
            }else{
                dx=2;
            }
        }
        if(key == KeyEvent.VK_SPACE) {                                                       //If the key sent was RIGHT
            playerPossitionY=255;
        }
    }

    public void keyReleased(KeyEvent e) {                                                    //Called from the board class, the argument is whatever key was released
        int key = e.getKeyCode();                                                           //The key originally sent from the board class

        if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT)                              //If the left or right key was released
            dx = 0;
        if(key==KeyEvent.VK_SPACE){
            playerPossitionY=285;
        }
    }
}
