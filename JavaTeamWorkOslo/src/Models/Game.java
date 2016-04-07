package Models;

import UI.Display;
import UI.gameBoard;

/**
 * Created by krustev on 06-Apr-16.
 */
public class Game {

    private Display display;
    private gameBoard game;
    private Player player;

    public Game(){

        player=new Player();
        game= new gameBoard(this.player);
        display=new Display(this.game);
    }
}
