package com.company;

import java.util.regex.Pattern;

public class Char {
    private String name;
    private int hp;
    private int strength;
    private int xp;
    private int maxHP;
    private int level;
    private int agility;
    private Weapon weapon;
    private Weapon weapon2;
    static private Potions potion1;
    static private Potions potion2;
   static  private Potions potion3;
    private Armor armor;
    private int gold;
    private int maxExp;

    public Char(String name) {
        this.name = name;
        level = 1;
        xp = 0;
        weapon = new Weapon("Copper Shortsword", 2, 0, 1, 0);
        weapon2 = new  Weapon("EMPTY SLOT", 0, 0, 0, 0);
        potion1 = new Potions("EMPTY SLOT", 0, 0,0,0,0,0);
        potion2 = new Potions("EMPTY SLOT", 0, 0,0,0,0,0);
        potion3 = new Potions("EMPTY SLOT", 0, 0,0,0,0,0);
        armor = new Armor("Graphic T", 0, 1, 0, 0);
        strength = (int) (Math.random() * 5) + 5;
        agility = (int) (Math.random() * 4) + 5;
        gold = (int) (Math.random() * 31);
        maxHP = (int) (Math.random() * 21) + 50;
        hp = maxHP;
        maxExp = level*50;
        if (name.equals("frizz")) {
            strength = 50;
            agility = 50;
            gold = 5000;
            maxHP = 1000;
            weapon = new Weapon("God's Wrath", 10000, 250, 1000, 0);
            weapon2 = new Weapon("God's Fury", 50000, 0, 1, 0);
            potion1 = new Potions("Chug Jug",10000,10000,10000,0, 5,999);
            potion2 = new Potions("Chug Jug", 10000,10000,10000,0,5,999);
            potion3 = new Potions("Chug Jug",10000,10000,10000,0,5,999);
            armor = new Armor("God's Protection", 150, 500, 250, 1000);
            level = 20;
            hp = maxHP;
        }
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getStrength() {
        return strength;
    }

    public int getXp() {
        return xp;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getLevel() {
        return level;
    }

    public int getAgility() {
        return agility;
    }

    public Weapon getWeapon2() {
        return weapon2;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public Potions getPotion1() {
        return potion1;
    }

    public Potions getPotion2() {
        return potion2;
    }

    public Potions getPotion3() {
        return potion3;
    }

    public int getGold() {
        return gold;
    }
    public int getDamage(){
        return strength + weapon.getDamage();

    }

    public void gainExperience(int gain) {
            xp += gain;
            if (xp >= level * 50) {
                xp -= level * 50;
                level++;
                int strup = (int) (Math.random() * 2) + 1;
                int agiup = (int) (Math.random() * 2) + 1;
                int healthup = (int) (Math.random() * 11) + 11;

                strength += strup;
                agility += agiup;
                maxHP += healthup;

                System.out.println("\n\n\nLEVEL UP");
                System.out.println("Strength increased by " + strup + "!");
                System.out.println("Agility increased by " + agiup + "!");
                System.out.println("Maximum health increased by " + healthup + "!");
                heal(999999);

                System.out.println("(You were healed fully!)");

                System.out.println("\n\n\n\nStats are now:");
                displayStats();


            }
        }
            public boolean takeDamage(int damage){

            hp -= (damage * (100- armor.getResist()) / 150);
                System.out.println("The enemy hit you for " + damage + ", but your armor absorbed some of the damage.");
                System.out.println();
             //hp -= Math.max(damage - armor.getResist(), 0);
                return hp > 0;
        }



        public void heal(int amo){
            hp += Math.min(amo, maxHP-hp);

        }
        public boolean doesItHit(int enemyValue){
        return (int)(Math.random()*(5*enemyValue))+(2*enemyValue) > agility/2 + armor.getDodge();



        }








    public void displayStats(){
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("HP: " + hp + " / " + maxHP);
        System.out.println("Strength: " + strength);
        System.out.println("Agility: " + agility);
        System.out.println("Experience: " + xp + " / " + level*50);
        System.out.println("Gold: " + gold);
        System.out.println("Weapon: " + weapon);
        System.out.println("Secondary Weapon: " + weapon2);
        System.out.println("Armor: " + armor);
        System.out.println("Potion Slot 1: "+ potion1);
        System.out.println("Potion Slot 2: "+ potion2);
        System.out.println("Potion Slot 3: "+ potion3);
        System.out.println("\n\n");





    }

    public void decreaseGold(int amount) {
        gold-=amount;
    }
    public void increaseGold(int amount){
        gold+=amount;
    }



    public void setWeapon(Weapon weapon, int slot) {
        if(slot == 1){
            this.weapon = weapon;

        }
        if(slot==2){
            weapon2 = weapon;
        }

    }
    public void increaseAgility(int amount){
        agility+=amount;
    }
    public void increaseStrength(int amount){
        strength+=amount;
    }
    public void increaseHealth(int amount){
        hp+=Math.max(amount, maxHP-hp);
    }
    public void setArmor(Armor armor){
        this.armor = armor;
    }
    public void setPotions(Potions potions, int slot){
        if(slot == 1){
            potion1 = potions;
        }
        else if(slot == 2){
            potion2 = potions;
        }
        else{
            potion3 = potions;
        }
    }
    public static void setEmptyPSlot(int slot){
        Potions pholder = new Potions("EMPTY SLOT", 0, 0,0,0,0,0);
        if(slot == 1){
            potion1 = pholder;
        }
        if(slot == 2){
            potion2 = pholder;
        }
        if(slot == 3){
            potion3 = pholder;
        }


    }
    public void levelUp(){
        level+=1;
        System.out.println("You leveled up! You are now level " + level);
        int strup = (int) (Math.random() * 2) + 1;
        int agiup = (int) (Math.random() * 2) + 1;
        int healthup = (int) (Math.random() * 11) + 11;

        strength += strup;
        agility += agiup;
        maxHP += healthup;

        System.out.println("\n\n\nLEVEL UP");
        System.out.println("Strength increased by " + strup + "!");
        System.out.println("Agility increased by " + agiup + "!");
        System.out.println("Maximum health increased by " + healthup + "!");
        heal(99999999);

        System.out.println("\n\n\n\nStats are now:");
        displayStats();
    }
    public void decreaseAgility(int amount){
        agility -= amount;
    }
    public void decreaseStrength(int amount){
        strength-=amount;
    }

}
