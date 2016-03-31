package UI;

import javax.swing.*;

/**
 * Created by krustev on 31-Mar-16.
 */
public class run {
    public static void main(String[] args)  {
        JFrame frame = new JFrame("Oslo Mario v0.0.1 ");                     //Create JFrame called frame

        frame.getContentPane().add(new gameBoard());                       //Go to board class
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                //Make frame close on X click
        frame.setSize(600,413);                                                              //Set the frame size to the size of the background
        frame.setResizable(false);                                                           //Make sure the user can't resize the frame
        frame.setLocation(20, 50);                                                           //Place the frame in a nicer position
        frame.setVisible(true);                                                              //Make the frame visible

        int frameWidth  = frame.getContentPane().getWidth();
        int frameHeight  = frame.getContentPane().getHeight();
    }
}
