package com.company;


public class Potions {
    private String name;
    private int pAgility;
    private int pStrength;
    private int pHealth;
    private int pCost;
    private int pType;
    private int pPotency;
    //Type 1 - Agility
    //Type 2 - Strength
    //Type 3 - Health
    //Type 4 - All in One

    public Potions(String name, int pAgility, int pStrength, int pHealth, int pCost, int pType, int pPotency){
        this.name = name;
        this.pAgility = pAgility;
        this.pStrength = pStrength;
        this.pHealth = pHealth;
        this.pCost = pCost;
        this.pType = pType;
        this.pPotency = pPotency;
    }

    public String getName() {
        return name;
    }

    public int getPAgility() {
        return pAgility;
    }

    public int getPStrength() {
        return pStrength;
    }

    public int getPHealth() {
        return pHealth;
    }

    public int getPCost() {
        return pCost;
    }

    public int getPType() {
        return pType;
    }

    public int getPPotency() {
        return pPotency;
    }

    @Override
    public String toString(){
        if(pType==1){
            return name + " - Agility Increase: " + pAgility;
        }
        else if (pType==2){
            return  name + " - Strength Increase: " + pStrength;
        }
        else if (pType==3){
            return name + " - Health Increase: " + pHealth;
        }
        else if(pType==4){
            return name + " - Agility Increase: " + pAgility + " | " + " - Strength Increase: " + pStrength + " | " + " - Health Increase: " + pHealth;
        }
        else if(pType==0) {
            return name;

        }else{
            return "This isn't supposed to be in the game";
        }


    }

    public static Potions[] initializePotions(){
        return new Potions[]{
                new Potions("Agility I", 2, 0, 0,  100,1,2),
                new Potions("Agility II", 4, 0, 0, 150,1,4),
                new Potions("Agility III", 6, 0, 0, 300,1,6),
                new Potions("Strength I", 0, 4, 0, 250,2,4),
                new Potions("Strength II", 0, 6, 0, 325,2,6),
                new Potions("Strength III", 0, 8, 0, 400,2,8),
                new Potions("Health I", 0, 0, 30, 180,3,30),
                new Potions("Health II", 0, 0, 40, 225,3,50),
                new Potions("Health III", 0, 0, 50, 300,3,75),
                new Potions("All in One", 5,7, 45, 500,4,999)

        };
    }



}

