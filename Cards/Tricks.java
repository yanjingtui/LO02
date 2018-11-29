package Cards;

import Game.*;


public class Tricks extends Cards {
    public final String trickCombinations[][] = {{"The Rabbit", "Carrots"}, {"The Other Rabbit", "Carrots"},
            {"The Rabbit", "The Lettuce"}, {"The Other Rabbit", "The Lettuce"}, {"Carrots", "Carrots"},
            {"The Hat", "Carrots"}, {"The Hat", "The Lettuce"}, {"Carrots", "The Lettuce"}, {"The Hat", "Carrots"},
            {"The Hat", "The Rabbit"}, {"The Hat", "The Other Rabbit"}, {"The Rabbit"}, {"The Other Rabbit"}};
    private String[] combination;
    private String name;
   
    
    private int point;

    public Tricks(String name, int point) {
    
        this.name = name;
        this.point = point;
    }

    public String[] getTricksCombine(){
        return this.combination;
    }

    public String toString() {
    	return ("Nom :" + this.name +", Points :" + this.point);
    }
   
    }

