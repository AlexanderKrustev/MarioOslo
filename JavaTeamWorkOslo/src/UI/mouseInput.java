package UI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by krustev on 31-Mar-16.
 */
public class mouseInput implements MouseListener{
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if(mx>=10 && mx<=110) {
            if(my>=50 && my<=87) {
                gameBoard.State = gameBoard.STATE.GAME;
            }
            if(my>=102 && my<=139) {
                //HELP
            }
            if(my>=154 && my<=191) {
                System.exit(1);
            }
        }
    }
    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
