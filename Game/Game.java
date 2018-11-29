package Game;

import java.util.*;

import Player.*;

public class Game {
    private ArrayList<Player> players;
    private Pile pile;
    private boolean partieEnCours;
    private int nbplayers;


    public Game() {
        players = new ArrayList<Player>();
        pile.getInstance();
        pile.melanger();
        partieEnCours = false;

    }


    public void addBot(String n) {
        Bot b = new Bot(n);
        this.players.add(b);
        this.nbplayers += 1;
    }

    public Player getPlayer(int id) {
        return this.players.get(id);
    }

    public void addRealPlayer(String n, int a) {
        Real r = new Real(a, n);
        this.players.add(r);
        this.nbplayers += 1;
    }

    public Player youngestPlayer() {
        Player p;
        if (this.players.get(0).getAge() <= this.players.get(1).getAge() && this.players.get(0).getAge() <= this.players.get(2).getAge()) {
            p = this.players.get(0);
        } else if (this.players.get(1).getAge() <= this.players.get(0).getAge() && this.players.get(1).getAge() <= this.players.get(2).getAge()) {
            p = this.players.get(1);
        } else {
            p = this.players.get(2);
        }
        return p;
    }
}
