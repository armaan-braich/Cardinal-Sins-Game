package com.company;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Weapon {
    private String name;
    private int damage;
    private int cost;
    private int type;

    private int speed;

    public Weapon(String name, int damage, int cost, int speed, int type){
        this.name = name;
        this.damage = damage;
        this.cost = cost;
       this.type = type;
        this.speed = speed;
    }
    public String getName(){
        return name;
    }

    public int getType() {
        return type;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDamage(){
        return damage;
    }
    public int getCost(){
        return cost;
    }



    @Override
    public String toString(){
        return name + " - Damage: " + damage;
    }

    public static Weapon[] initializeWeapons(){
        return new Weapon[]{
                new Weapon("Wood Sword", 4,110,3, 9),
                new Weapon("Bronze sword",7,130,2, 9),
                new Weapon("Marshmallow Stick (FIRE)", 6, 130, 2, 1),
                new Weapon("Surfboard (WATER)", 6, 150, 3, 2),
                new Weapon("Silver Sword", 9, 170, 4, 9),
                //=================================================
                new Weapon("Blade of Grass (GRASS)", 11, 270, 5, 3),
                new Weapon("Water Gun (WATER)", 12, 290,4,2),
                new Weapon("Katana", 14, 300, 7, 9),
                new Weapon("Lava Blade (FIRE)", 16, 350, 3, 1),
                //=================================================
                new Weapon("Golden Sword", 20, 500, 5,9),
                new Weapon("Hell's Blade(FIRE)", 24,570,4,1),
                new Weapon("Forest's Spear(GRASS)", 24,570,4,3),
                new Weapon("Ocean's Trident(WATER)", 24,570,4,2),



                new Weapon("Meteor Sword", 24, 690, 4, 9 ),
                new Weapon("Galactic Sword", 29, 840, 4, 9),

                //=================================================
                new Weapon("Excalibur", 39, 1000, 4, 9),
                new Weapon("Night's Edge", 50, 1500,5,9)


        };
    }

}
