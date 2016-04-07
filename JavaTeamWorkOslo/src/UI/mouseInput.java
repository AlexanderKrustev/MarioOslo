package UI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by krustev on 31-Mar-16.
 */

public class mouseInput implements MouseListener{

    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if(mouseX>=10 && mouseX<=110) {
            if(mouseY>=50 && mouseY<=87) {
                gameBoard.State = gameBoard.STATE.GAME;
            }
            if(mouseY>=102 && mouseY<=139) {
                //HELP
            }
            if(mouseY>=154 && mouseY<=191) {
                System.exit(1); //exit
            }
            if(mouseY>=206 && mouseY<=258) {
                gameBoard.State = gameBoard.STATE.GAME;
            }
        }
    }
    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
