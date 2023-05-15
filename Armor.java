package com.company;

public class Armor{
    private String name;
    private int dodge;
    private int resist;
    private int thorn;
    private int cost;

    public Armor(String name, int dodge, int resist, int thorn, int cost){
        this.name = name; this.dodge = dodge; this.resist = resist; this.thorn = thorn; this.cost = cost;

    }
    public int getResist(){
        return resist;
    }

    public int getDodge() {
        return dodge;
    }

    public String getName() {
        return name;
    }

    public int getThorn() {
        return thorn;
    }
    public int getCost(){
        return cost;
    }

    @Override
    public String toString(){
        return name + " - Resistance: " + resist;
    }



    public static Armor[] initializeArmor(){
        return new Armor[]{
                new Armor("Long Sleeve Shirt", 2, 5, 0, 120),
                new Armor("Leather Jacket", 3, 7, 0, 150),
                new Armor("Three-piece Suit", 1, 9, 0, 190),
                new Armor("Ninja Costume (Dodge)", 6, 7, 0, 210),
                //===================================================
                new Armor("Really Nice Jeans", 3, 10, 1, 225),
                new Armor("Spiked Bracelet (Thorn)", 1, 11, 5, 275),
                new Armor("Really Thick Blazer", 1, 14, 0, 300),
                new Armor("Sneaky Pajamas (Dodge)", 7, 11, 0, 330),
                //===================================================
                new Armor("Even Nicer Pants", 1, 18,0,380),
                new Armor("Crazy Mohawk (Thorns)", 2, 14, 7, 420),
                new Armor("Full Metal Jacket", 1, 23, 0, 480),
                new Armor("Porcupine Jacket", 1, 18, 6, 550),

                new Armor("Fake Fur Coat", 1,23, 2, 690),
                new Armor("Real Fur Coat", 1, 27, 3, 840),
                //===================================================
                new Armor("Fringe Jacket", 1, 30, 5, 1000)



        };
    }

}
