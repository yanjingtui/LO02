package Player;

import Game.*;

import java.util.*;

import Cards.Props;
import Cards.Tricks;
import Game.Pile;

public abstract class Player implements Poker {
    protected int age;
    protected String name;
    protected ArrayList<Props> propsInHand;
    protected int score;
    protected int id;
    protected Game g;
    protected ArrayList<Tricks> tricksOK;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public enum Playertype {
        REAL,
        BOT;
    }

    public ArrayList<Props> getCards() {
        return this.propsInHand;
    }


    public int getAge() {
        return this.age;
    }

    public int getScore() {
        return this.score;
    }

    public String name() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public int[] getIdExceptMe(){
        int[] id = {0,1,2};
        int myId = getId();
        int[] tmp = new int[id.length - 1];
        int idx = 0;
        boolean hasRemove = false;
        for (int i = 0; i < id.length; i++) {

            if (!hasRemove && id[i] == myId) {
                hasRemove = true;
                continue;
            }

            tmp[idx++] = id[i];
        }
        return tmp;
        }

    public Props getCards(Player p, int cartemontre) {
        return p.propsInHand.get(cartemontre);
    }

    public void swap(Player p, int carteorigine, int cartevoulue) {
        Props inter = this.propsInHand.get(carteorigine);
        this.propsInHand.set(carteorigine, p.propsInHand.get(cartevoulue));
        p.propsInHand.set(cartevoulue, inter);
    }

    public boolean trickIsSuccessful(Pile p){
        boolean flag = false;
        Props left = this.propsInHand.get(0);
        Props right = this.propsInHand.get(1);
        String[] nameOfProps = {left.getName(),right.getName()};

        Tricks t;
        t = p.getCurrentTrick();
        String[] trickCard = t.getTricksCombine();
        if (stringArrayCompare(trickCard,nameOfProps) == true){
            flag = true;
        }
        return flag;
    }


    public boolean stringArrayCompare(String[] b, String[] c) {
        boolean flag = false;
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (c[i].equals(b[j])) {
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }
        }
        return flag;
    }

    public int compareCounts(){
        int smallerPropIndex;
        int count0 = this.propsInHand.get(0).getCount();
        int count1 = this.propsInHand.get(1).getCount();
        if (count0 <= count1){
            smallerPropIndex = 0;
        }else{
            smallerPropIndex = 1;
        }
        return smallerPropIndex;
    }


    public void openNext(Pile p) {
        p.openNext();
    }

    private void setMidCard(int MidCard) {
        //is the mid card true
    }

    public void performTrick() {

        //Trickperformed true
        //score trick.pointsh

    }

    abstract void chooseTrick(Pile p);

    abstract void prepareProps();

    abstract void onWin();

    public void showCard(Player p1, Player p2, int cartemontre) {
        p1.getCards(this, cartemontre);
        p2.getCards(this, cartemontre);
    }
}

