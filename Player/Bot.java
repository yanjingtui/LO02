package Player;

import Cards.Props;
import Cards.Tricks;
import Game.Pile;

import java.util.ArrayList;
import java.util.Random;


public class Bot extends Player {
    public Bot(String name) {
        super(name);
        this.age = (int) Math.round(Math.random() * 100);
    }

    public void chooseTrick(Pile p) {
        Tricks t;
        if(trickIsSuccessful(p) == true){
            t = p.getCurrentTrick();
            System.out.println("Bot a choisi le tour   "+ t.toString());
        }else {
            p.openNext();
            t = p.getCurrentTrick();
            System.out.println("Bot a choisi le tour   "+ t.toString());
        }
    }

    public void prepareProps() {
        int propSwap;
        ArrayList<Props> propsInHand = this.getCards();
        propSwap = compareCounts();

        Player p;
        Random random = new Random();
        int[] playerToChoose = this.getIdExceptMe();
        int numPlayer = random.nextInt(2);
        p = this.g.getPlayer(playerToChoose[numPlayer]);
        int propplayer = random.nextInt(2);
        this.swap(p, propSwap, propplayer);


    }

    public void onWin() {

    }
}
