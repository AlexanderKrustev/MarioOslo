package UI;

import javax.swing.*;

/**
 * Created by krustev on 06-Apr-16.
 */

public class Display extends JFrame {
    public static String version="Oslo Mario v0.0.1";
    public JFrame gameFrame;
    public menu menu;


    public Display(gameBoard Board){

        this.gameFrame = new JFrame(version);                                                           //Create JFrame called frame
        this.gameFrame.getContentPane().add(Board);                                           //Go to board class
        this.gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                //Make frame close on X click
        this.gameFrame.setSize(550, 450);                                                              //Set the frame size to the size of the background
        this.gameFrame.setResizable(false);                                                           //Make sure the user can't resize the frame
        this.gameFrame.setLocation(20, 50);                                                         //Place the frame in a nicer positio
        this.gameFrame.setVisible(true);
        this.gameFrame.setLocationRelativeTo(null);
        this.menu = new menu();
                                                                                                //Make the frame visible

      //  int frameWidth = gameFrame.getContentPane().getWidth();
      //  int frameHeight = gameFrame.getContentPane().getHeight();
    }
}
