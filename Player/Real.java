package Player;

import java.util.*;

import Cards.*;
import Game.*;

public class Real extends Player {
    public Real(int age, String name) {
        super(name);
        this.age = age;
    }

    public void chooseTrick(Pile p) {
        System.out.println("Le tour actuel est :" + p.getCurrentTrick());

        Scanner sc = new Scanner(System.in);
        System.out.println("Quel tour voulez vous realiser ? Celui la (0) ou le suivant (1) ? ");
        String sReponse = sc.nextLine();
        Tricks t;
        if (sReponse.equals("0")) {
            t = p.getCurrentTrick();
        } else {
            p.openNext();
            t = p.getCurrentTrick();
        }

        System.out.println("Vous avez choisi le tour  " + t.toString());

    }

    public void prepareProps() {
        int propswap;
        System.out.println("Voici vos Props : " + this.getCards());
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel props souhaitez vous echanger ?  Le premier (0) ou le deuxieme (1) ? ");
        String sReponse = sc.nextLine();

        if (sReponse.equals("0")) {
            propswap = 0;
        } else {
            propswap = 1;
        }
        System.out.println("Vous avez choisi le prop : " + propswap);
        int[] playerToChoose = this.getIdExceptMe();
        System.out.println("Selectionnez le joueur avec qui vous souhaitez echanger : " + this.g.getPlayer(playerToChoose[0]).name + "(0) ou " + this.g.getPlayer(playerToChoose[1]).name);
        Player p;
        if (sReponse.equals("0")) {
            p = this.g.getPlayer(playerToChoose[0]);
        } else {
            p = this.g.getPlayer(playerToChoose[1]);
        }
        System.out.println("Selectionnez le prop de ce joueur que vous souhaitez echanger : Le premier (0) ou le deuxieme (1) ? ");
        int propplayer;
        if (sReponse.equals("0")) {
            propplayer = 0;
        } else {
            propplayer = 1;
        }
        this.swap(p, propswap, propplayer);
    }




    public void onWin() {

    }
}