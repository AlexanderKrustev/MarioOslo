package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by krustev on 31-Mar-16.
 */
public class gameBoard extends JPanel implements ActionListener {

    UI.Player player;                                                                                //Instance of player class
    Image background, menuBackgroundIcon;                                                                //The background images
    Timer time;                                                                              //A timer
    private menu Menu;
    private JFrame Frame;



    public static enum STATE {MENU,GAME};

    public static STATE State = STATE.MENU;

    public gameBoard() {
        this.addMouseListener(new mouseInput());
        player = new UI.Player();                                                                    //Start running player class
        Menu = new menu();

        addKeyListener(new AL());                                                            //Listen for keys
        setFocusable(true);                                                                                                                  //Allows movement
        ImageIcon worldBackgroundIcon = new ImageIcon("Menu.jpg");                  //Image for menu
        menuBackgroundIcon = worldBackgroundIcon.getImage();
        worldBackgroundIcon = new ImageIcon("World.png");  //Image for background
        background = worldBackgroundIcon.getImage();                                                           //Give the background the image
        time = new Timer(20,this);                                                           //Timer set to update "this" class every 20 milliseconds(Approximately 50fps)
        time.start();                                                                        //Actually start the timer
    }

    public void actionPerformed(ActionEvent e) {
        player.move();                                                                            //Call the move method from the player class
        repaint();                                                                           //Repaint
    }

    public void paintComponent(Graphics g) {                                                 //Graphics method
        if(State==STATE.GAME) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;                                             //casts 2d graphics(or however you would explain it)

            g2d.drawImage(background, -player.nx, 0, null);                                   //Draw the background image
            g2d.drawImage(background, -player.nx2, 0, null);                                  //Draw the background image

            if(-player.nx<-575)  {                                                            //If going forwards
               player.nx=-575;
            }                                                                                    //Start placing forwards every 575px in front on the last one
            else if(-player.nx>575)
                                                                                              //If going backwards
                player.nx=575;                                                               //Start placing backwards every 575px behind the last one

            if(-player.nx2<-575)                                                             //If going forwards
                player.nx2=-575;                                                             //Start placing forwards every 575px in front on the last one
            else if(-player.nx2>575)                                                         //If going backwards
                player.nx2=575;                                                              //Start placing backgrounds every 575px behind the last one

            g2d.drawImage(player.getImage(), player.getX(), player.getY(), null);                      //Draw the player at the position he is currently(Coordinate values taken from player class)
        } else {
            g.drawImage(menuBackgroundIcon, 1, 1, null);
            Menu.render(g);
        }
    }

    private class AL extends KeyAdapter {                                                    //Action Listener extends key adapter
        public void keyPressed(KeyEvent e) {                                                 //On key press
            player.keyPressed(e);                                                                 //Send whatever key was pressed  TO the keyPressed  method in the player class
        }
        public void keyReleased(KeyEvent e) {                                                //On key release
            player.keyReleased(e);                                                                //Send whatever key was released TO the keyReleased method in the player class
        }
    }
}
