package Models;

import UI.Display;
import UI.GameBoard;

/**
 * Created by krustev on 06-Apr-16.
 */
public class Game {

    private Display display;
    private GameBoard game;
    private Player player;

    public Game(){

        player=new Player();
        game= new GameBoard(this.player);
        display=new Display(this.game);
    }
}
