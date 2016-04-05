package UI;

import java.awt.*;

/**
 * Created by krustev on 31-Mar-16.
 */
public class menu {
    public static Rectangle playButton = new Rectangle(10, 50, 100, 37);
    public static Rectangle helpButton = new Rectangle(10, 102, 100, 37);
    public static Rectangle quitButton = new Rectangle(10, 154, 100, 37);
    public static Rectangle customizeButton = new Rectangle(10, 206, 100, 37);

    public static void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font fnt0 = new Font("arial", Font.BOLD, 45);
        Font fnt1 = new Font("arial", Font.BOLD, 30);
        Font fnt2 = new Font("arial", Font.BOLD, 15);
        g.setFont(fnt0);
        g.setColor(Color.white);
        g.drawString("Oslo Mario", 10, 40);

        g.setFont(fnt1);
        g.drawString("Play", playButton.x + 19, playButton.y + 29);
        g2d.draw(playButton);
        g.drawString("Help", helpButton.x + 19, helpButton.y + 29);
        g2d.draw(helpButton);
        g.drawString("Quit", quitButton.x + 19, quitButton.y + 29);
        g2d.draw(quitButton);
        g.drawString("Customize", customizeButton.x + 19, customizeButton.y + 29);
        g2d.draw(customizeButton);

        g.setFont(fnt2);
        g.drawString("Version 0.0.1",500,380);
    }
}
