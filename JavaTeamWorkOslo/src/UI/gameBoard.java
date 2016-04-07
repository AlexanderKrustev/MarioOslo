package UI;

import Models.Player;

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

                                                                                  //Instance of player class
    Image background, menuBackgroundIcon;                                                                //The background images
    Timer time;                                                                              //A timer
    private Menu Menu;
    private JFrame Frame;
    private JLabel HighScore;
    private JButton ButtonR;
    private Player player;



    public static enum STATE {MENU,GAME};

    public static STATE State = STATE.MENU;

    public gameBoard(Player player) {


        this.addMouseListener(new mouseInput());
        this.player=player ;                                       //Start running player class
        Menu = new Menu();
        addKeyListener(new AL());                                                            //Listen for keys
        setFocusable(true);
        this.HighScore=new JLabel("Your Score");

        //this.HighScore.setBackground(Color.cyan);
        this.HighScore.setVisible(false);
        ImageIcon worldBackgroundIcon = new ImageIcon("Menu.jpg");                  //Image for Menu
        menuBackgroundIcon = worldBackgroundIcon.getImage();
        worldBackgroundIcon = new ImageIcon("World.jpg");  //Image for background
        background = worldBackgroundIcon.getImage();                                                           //Give the background the image
        time = new Timer(20,this);                                                           //Timer set to update "this" class every 20 milliseconds(Approximately 50fps)
        time.start();

        this.HighScore.setBounds(100,100,100,100);
        this.add(HighScore);
                                                                                              //Actually start the timer
    }

    public void actionPerformed(ActionEvent e) {
        player.move();                                                                            //Call the move method from the player class
        repaint();                                                                           //Repaint
    }

    public void paintComponent(Graphics g) {                                                 //Graphics method
        if(State==STATE.GAME) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;                                             //casts 2d graphics(or however you would explain it)
            this.HighScore.setVisible(true);
            g2d.drawImage(background, -player.firstRepBackground, 0, null);                                   //Draw the background image
            g2d.drawImage(background, -player.secondRepBackground, 0, null);                                  //Draw the background image

            if(-player.firstRepBackground <-4500)  {                                                            //If going forwards
               player.firstRepBackground =-4500;
            }                                                                                    //Start placing forwards every 575px in front on the last one
            else if(-player.firstRepBackground >4500)
                                                                                              //If going backwards
                player.firstRepBackground = 4500;                                                               //Start placing backwards every 575px behind the last one

            if(-player.secondRepBackground <-4500)                                                             //If going forwards
                player.secondRepBackground =-4500;                                                             //Start placing forwards every 575px in front on the last one
            else if(-player.secondRepBackground >4500)                                                         //If going backwards
                player.secondRepBackground =4500;                                                              //Start placing backgrounds every 575px behind the last one

            g2d.drawImage(player.getImage(), player.getX(), player.getY(), null);                      //Draw the player at the position he is currently(Coordinate values taken from player class)
        } else {
            g.drawImage(menuBackgroundIcon, 1, 1, null);
            menu.render(g);
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
