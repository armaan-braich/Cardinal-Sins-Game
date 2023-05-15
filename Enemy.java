package com.company;

public class Enemy {
    private String name;
    private int damage;
    private int enemySpeed;
    private int health;
    private int dodge;
    private int gold;
    private int level;
    private int xp;
    private int type;
    private int maxHp;
    //Type 5 - Nothing
    //Type 1 - Fire
    //Type 2 - Water
    //Type 3 - Grass



    public Enemy(String name, int damage, int enemySpeed, int health, int agility, int gold, int level, int xp, int type){
        this.name = name;
        this.damage = damage;
        this.enemySpeed = enemySpeed;
        this.health = health;
        dodge = agility;
        this.gold = gold;
        this.level = level;
        this.xp = xp;
        this.type = type;
        maxHp = health;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return xp;
    }

    public int getDamage() {
       return damage;
 //+(int) (0.5*Math.random()*damage);
     }
    public int getEnemySpeed() {
        return enemySpeed;
    }

    public int getHealth() {
        return health;
    }

    public int getXp() {
        return xp;
    }

    public int getType() {
        return type;
    }

    public boolean doesItHit(int playerHitValue) {
        return playerHitValue + (int) (Math.random()*playerHitValue)+1 > (int)(Math.random()*(2+dodge))+2 ;
    }
    public boolean takeDamage(int damageFromPlayer, int str,  int weapontype){
        if(damageFromPlayer>1) {
            int tDamageFromPlayer = damageFromPlayer + str;
            int tDamage = (tDamageFromPlayer + (int)(Math.random() * 7) + 3);



            if (type + 1 == weapontype || type == 3 && weapontype == 1) {


                health -= (tDamage) * 2;
                System.out.println("It was super effective! Double damage!");
                System.out.println("You dealt " + tDamage * 2 + " damage!");

            }
            else if (type - 1 == weapontype || type == 1 && weapontype == 3 || type==weapontype) {
                health -= tDamage / 2;
                System.out.println("That attack wasn't very effective... Only dealt half damage...");
                System.out.println("You dealt " + tDamage / 2 + " damage!");

            } else{
                health -= tDamage;
                System.out.println(name + " was hit by your attack!");
                System.out.println("You dealt " + tDamage + " damage!");

            }
        }
        else{
            System.out.println("That is an empty slot, and not a weapon. Fool.");
        }






        return health<=0;
    }
    public void thornDamage(int thorny){
        if(thorny>=1) {
            health -= ((damage / 10) + (int)(Math.random()*thorny)+2);
            System.out.println("Your enemy was hurt for " + ((damage / 10) + (int)(Math.random()*thorny)+2) + " damage because of thorns!");
        }
    }

    public int getDodge() {
        return dodge;
    }

    public int getGold() {
        return gold;
    }

    public int getLevel() {
        return level;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public static Enemy getNextEnemy(int num){

        if(num >= 0 && num <= 5){
            int rEnemy = (int)(Math.random()*3) + 1;
            int level = (int)(Math.random()*4)+4;
            if(rEnemy == 1){System.out.println("You encounter a Cockroach!");
                return new Enemy("Cockroach", (int)(Math.random()*(3+level)) + (5+level), (int)(Math.random()*3)+1,(int)(Math.random()*(15+level))+(60+level), (int)(Math.random()*2)+3, (int)(Math.random()*(10*level))+(10+level), level, (int)(Math.random()*(11 + level)) + (35 + level), 5);
            }
            if(rEnemy == 2){System.out.println("You encounter a Florist!");
                return new Enemy("Florist", (int)(Math.random()*(6+level)) + (6+level), (int)(Math.random()*4) + 1, (int)(Math.random()*(20+level)) + (63+level), (int)(Math.random()*2)+3,(int)(Math.random()*(13*level))+(10+level), level, (int)(Math.random()*(13+level)) + (38+level), 3);
            }
            if(rEnemy == 3){System.out.println("You encounter a Janitor!");
                return new Enemy("Janitor", (int)(Math.random()*(5+level)) + (7+level), (int)(Math.random()*2)+1, (int)(Math.random()*(18+level)) + (75 + level), (int)(Math.random()*2)+3, (int)(Math.random()*(15+level))+(15+level), level, (int)(Math.random()*(15+level)) + (40+level), 2);
            }





        }
        if(num>5 && num <10){
            int rEnemy = (int)(Math.random()*3) + 1;
            int level = (int)(Math.random()*4)+4;
            if(rEnemy == 1){System.out.println("You encounter a Cook!");
                return new Enemy("Cook", (int)(Math.random()*(6+level)) + (12+level), 1, (int)(Math.random()*(22 + level)) + (103+level), (int)(Math.random()*4)+3, (int) (Math.random() * (15 + level)) + (20+level), level+ (int) (Math.random() * 3) +4, (int) (Math.random() * (15 + level)) + (43 + level), 1);
            }
            if(rEnemy == 2){System.out.println("You encounter an Edgy Skater Kid!");
                return new Enemy("Edgy Skater Kid", (int) (Math.random() * (5 + level)) + (15+level), 1, (int) (Math.random() * (18 + level)) + (123+level), (int) (Math.random() * 4) +3, (int) (Math.random() * (15 + level)) + (25+level), level + (int) (Math.random() * 3) +4, (int) (Math.random() * (17 + level)) + (47 + level), 5);
            }
            if(rEnemy == 3){System.out.println("You encounter a Rip Curl Employee!");
                return new Enemy("Rip Curl Employee", (int) (Math.random() * (5 + level)) + (18+level), 1, (int) (Math.random() * (20 + level)) + (120 + level), (int) (Math.random() * 3) +3, (int) (Math.random() * (17 + level)) + (30 + level), level + (int) (Math.random() * 3) +4, (int) (Math.random() * (18 + level)) + (51+ level), 2);


            }
        }
        if(num == 10){
            System.out.println("                            ,-.\n" +
                    "       ___,---.__          /'|`\\          __,---,___\n" +
                    "    ,-'    \\`    `-.____,-'  |  `-.____,-'    //    `-.\n" +
                    "  ,'        |           ~'\\     /`~           |        `.\n" +
                    " /      ___//              `. ,'          ,  , \\___      \\\n" +
                    "|    ,-'   `-.__   _         |        ,    __,-'   `-.    |\n" +
                    "|   /          /\\_  `   .    |    ,      _/\\          \\   |\n" +
                    "\\  |           \\ \\`-.___ \\   |   / ___,-'/ /           |  /\n" +
                    " \\  \\           | `._   `\\\\  |  //'   _,' |           /  /\n" +
                    "  `-.\\         /'  _ `---'' , . ``---' _  `\\         /,-'\n" +
                    "     ``       /     \\    ,='/ \\`=.    /     \\       ''\n" +
                    "             |__   /|\\_,--.,-.--,--._/|\\   __|\n" +
                    "             /  `./  \\\\`\\ |  |  | /,//' \\,'  \\\n" +
                    "            /   /     ||--+--|--+-/-|     \\   \\\n" +
                    "           |   |     /'\\_\\_\\ | /_/_/`\\     |   |\n" +
                    "            \\   \\__, \\_     `~'     _/ .__/   /\n" +
                    "             `-._,-'   `-._______,-'   `-._,-'");
            System.out.println("L̟ͯE͇ͥ̇T͌͐̎ ͚̃͊Gͮ́O̚");


            return new Enemy("Moving Plant", 0, 0,150,0,0,666,0,3);
        }
        if(num>10 && num<15 || num>15 && num<20){
            int rEnemy = (int)(Math.random()*5) + 1;
            int level = (int)(Math.random()*4)+4;
            if(rEnemy == 1){System.out.println("You encounter a Strange Man in an Irish Man!");
                return new Enemy("Irish Man", (int)(Math.random()*(7+level))+(20+level), 1, (int)(Math.random()*(25+level)) + (147 +level), (int)(Math.random()*5) + 4, (int)(Math.random()*(20+level)) + (38 + level),  level + (int)(Math.random()*7) + 20, (int)(Math.random()*(20+level) + (57+level)), 5 );
            }
            if(rEnemy == 2){System.out.println("You encounter a Miitary Officer!");
                return new Enemy("Military Officer", (int)(Math.random()*(5+level)) + (23+level), 1, (int)(Math.random()*(30+level)) + (165 + level), (int)(Math.random()*5) +4, (int)(Math.random()*(20+level)) + (35+level), level + (int)(Math.random()*7) + 20, (int)(Math.random()*(25+level)) + (59+level), 5 );
            }
            if(rEnemy == 3){System.out.println("You encounter a Hot Dog Stand Man!");
                return new Enemy("Hot Dog Stand Man",(int)(Math.random()*(6+level)) + (25+level), 1, (int)(Math.random()*(25+level)) + (140+level), (int)(Math.random()*5) + 4, (int)(Math.random()*(23+level)) + (44+level), level + (int)(Math.random()*7) + 20, (int)(Math.random()*( 25+level)) +  (59+level), 1  );
            }
            if(rEnemy == 4){System.out.println("You encounter a Strange Man in a Ghillie Suit!");
                return new Enemy("Strange Man in a Ghillie Suit", (int)(Math.random()*(7+level)) + (28+level), 1, (int)(Math.random()*(30+level)) + (150 +level), (int)(Math.random()*5) + 4, (int)(Math.random()*(25+level)) + (43+level), level + (int)(Math.random()*7) + 20, (int)(Math.random()*(30+level)) + (62+level), 3 );
            }
            if(rEnemy == 5){
                System.out.println("You encounter a Lifeguard!");
                return new Enemy("Lifeguard", (int)(Math.random()*(8+level)) + (27+level), 1, (int)(Math.random()*(30+level)) + (155+level), (int)(Math.random()*5)+4, (int)(Math.random()*(20+level)) + (43+level), level + (int)(Math.random()*5) + 20, (int)(Math.random()*(15+level)) + (62+level), 2 );
            }
        }
        if(num == 15){
            System.out.println("                            ,-.\n" +
                    "       ___,---.__          /'|`\\          __,---,___\n" +
                    "    ,-'    \\`    `-.____,-'  |  `-.____,-'    //    `-.\n" +
                    "  ,'        |           ~'\\     /`~           |        `.\n" +
                    " /      ___//              `. ,'          ,  , \\___      \\\n" +
                    "|    ,-'   `-.__   _         |        ,    __,-'   `-.    |\n" +
                    "|   /          /\\_  `   .    |    ,      _/\\          \\   |\n" +
                    "\\  |           \\ \\`-.___ \\   |   / ___,-'/ /           |  /\n" +
                    " \\  \\           | `._   `\\\\  |  //'   _,' |           /  /\n" +
                    "  `-.\\         /'  _ `---'' , . ``---' _  `\\         /,-'\n" +
                    "     ``       /     \\    ,='/ \\`=.    /     \\       ''\n" +
                    "             |__   /|\\_,--.,-.--,--._/|\\   __|\n" +
                    "             /  `./  \\\\`\\ |  |  | /,//' \\,'  \\\n" +
                    "            /   /     ||--+--|--+-/-|     \\   \\\n" +
                    "           |   |     /'\\_\\_\\ | /_/_/`\\     |   |\n" +
                    "            \\   \\__, \\_     `~'     _/ .__/   /\n" +
                    "             `-._,-'   `-._______,-'   `-._,-'");
            System.out.println("\n\n\nY̵O̷U̴ ̷A̴R̴E̶ ̷L̴O̶S̷I̷N̴G̴ ̴I̷T̵\n\n\n");
            return new Enemy("Shopping Cart", 0,1,200,1,0,666,0,5);
        }
        if(num==20) {
            System.out.println("                            ,-.\n" +
                    "       ___,---.__          /'|`\\          __,---,___\n" +
                    "    ,-'    \\`    `-.____,-'  |  `-.____,-'    //    `-.\n" +
                    "  ,'        |           ~'\\     /`~           |        `.\n" +
                    " /      ___//              `. ,'          ,  , \\___      \\\n" +
                    "|    ,-'   `-.__   _         |        ,    __,-'   `-.    |\n" +
                    "|   /          /\\_  `   .    |    ,      _/\\          \\   |\n" +
                    "\\  |           \\ \\`-.___ \\   |   / ___,-'/ /           |  /\n" +
                    " \\  \\           | `._   `\\\\  |  //'   _,' |           /  /\n" +
                    "  `-.\\         /'  _ `---'' , . ``---' _  `\\         /,-'\n" +
                    "     ``       /     \\    ,='/ \\`=.    /     \\       ''\n" +
                    "             |__   /|\\_,--.,-.--,--._/|\\   __|\n" +
                    "             /  `./  \\\\`\\ |  |  | /,//' \\,'  \\\n" +
                    "            /   /     ||--+--|--+-/-|     \\   \\\n" +
                    "           |   |     /'\\_\\_\\ | /_/_/`\\     |   |\n" +
                    "            \\   \\__, \\_     `~'     _/ .__/   /\n" +
                    "             `-._,-'   `-._______,-'   `-._,-'");
            System.out.println("\n\n\nG̴̼̈́I̴̜͌V̶̟̀Ë̶̤ ̵̳͝I̴̙͆N̶͍̿\n\n\n");
            pause(2);
            System.out.println("\nWhat are you?\n");
            pause(3);
            System.out.println("                            ,-.\n" +
                    "       ___,---.__          /'|`\\          __,---,___\n" +
                    "    ,-'    \\`    `-.____,-'  |  `-.____,-'    //    `-.\n" +
                    "  ,'        |           ~'\\     /`~           |        `.\n" +
                    " /      ___//              `. ,'          ,  , \\___      \\\n" +
                    "|    ,-'   `-.__   _         |        ,    __,-'   `-.    |\n" +
                    "|   /          /\\_  `   .    |    ,      _/\\          \\   |\n" +
                    "\\  |           \\ \\`-.___ \\   |   / ___,-'/ /           |  /\n" +
                    " \\  \\           | `._   `\\\\  |  //'   _,' |           /  /\n" +
                    "  `-.\\         /'  _ `---'' , . ``---' _  `\\         /,-'\n" +
                    "     ``       /     \\    ,='/ \\`=.    /     \\       ''\n" +
                    "             |__   /|\\_,--.,-.--,--._/|\\   __|\n" +
                    "             /  `./  \\\\`\\ |  |  | /,//' \\,'  \\\n" +
                    "            /   /     ||--+--|--+-/-|     \\   \\\n" +
                    "           |   |     /'\\_\\_\\ | /_/_/`\\     |   |\n" +
                    "            \\   \\__, \\_     `~'     _/ .__/   /\n" +
                    "             `-._,-'   `-._______,-'   `-._,-'");

            System.out.println("\n\nỈ̶̜ ̶̘̙͂̔A̴͙̯͑̌M̸̜̉̿ ̶̣̎͜Y̸͇̕Ó̶̩̾U̵̪̾\n\n");
            pause(2);

            System.out.println("\n\nI̶ ̴A̵M̶ ̵T̸H̷E̴ ̸D̸E̸M̸O̶N̴ ̵T̶H̸A̷T̵ ̸L̵I̴V̸E̷S̸ ̷I̷N̴S̷I̷D̴E̵ ̴Y̴O̴U̶\n\n");
            pause(2);

            System.out.println("\n\nI̸ ̸A̴M̴ ̷A̷L̸L̴ ̵T̸H̷E̷ ̸E̸V̵I̴L̴ ̴T̸H̵A̵T̴ ̵M̸A̵K̴E̷S̸ ̵Y̵O̴U̷\n\n");
            pause(2);

            System.out.println("\n\nI̶ ̸A̸M̶ ̸P̸R̷I̶D̴E̸,̶ ̶G̷R̸E̴E̵D̸,̵ ̶E̷N̸V̶Y̴,̸ ̵W̸R̴A̴T̸H̵,̵ ̷L̶U̷S̵T̷,̸ ̵G̸L̴U̸T̸T̵O̶N̵Y̸,̵ ̷S̵L̵O̸T̷H̷\n\n");
            pause(3);

            System.out.println("\n\nI̵ ̵L̸I̸V̸E̷ ̶I̴N̷S̶I̷D̵E̸ ̶Y̶O̴U̴ ̶A̷N̸D̵ ̸I̴ ̶W̷I̴L̶L̵ ̵N̴E̸V̵E̷R̴ ̵L̸E̵A̸V̵E̵\n\n");
            pause(2);

            System.out.println("Well, I won't allow that, so I'll start by taking you out one by one.");

            return new Enemy("THE BEGINNING OF THE END", 0,0,0,0,0,0,0,0);


        }
        if (num == 21) {



            int rEnemy = (int)(Math.random()*3) + 1;
            //int level = (int)(Math.random()*4)+4;

            if(rEnemy== 1){
                System.out.println("666 LAZINESS 666");
                return new Enemy("LAZINESS", (int)(Math.random()*15) + 30, 1, (int)(Math.random()*50)+200, (int)(Math.random()*5)+10, (int)(Math.random()*35)+50, 666, 0, 5);
            }
            if(rEnemy==2){System.out.println("666 INACTIVITY 666");
                return new Enemy("INACTIVITY", (int)(Math.random()*15)+30,  1, (int)(Math.random()*50)+200, (int)(Math.random()*5)+10, (int)(Math.random()*35)+50, 666, 0, 5);
            }
            if(rEnemy==3){
                System.out.println("\nS̸L̸O̸T̴H̷:̶ ̶F̵A̴I̷L̸U̸R̴E̴ ̵T̴O̷ ̶D̴O̴ ̶T̶H̴I̴N̴G̴S̵ ̸O̸N̴E̴ ̵S̶H̴O̵U̶L̴D̸ ̷D̶O̶\n");
                pause(3);

                return new Enemy("(BOSS) S̸L̴O̶T̷H̴", (int)(Math.random()*30)+30, 1, (int)(Math.random()*100)+250, (int)(Math.random()*8)+10, (int)(Math.random()*70)+200, 666, 0, 5);

            }



        }
        if(num==22){
            int rEnemy = (int)(Math.random()*3)+1;
            if(rEnemy==1){System.out.println("666 DEVOUR 666");
                return new Enemy("DEVOUR", (int)(Math.random()*15)+35, 1,(int)(Math.random()*100)+225, (int)(Math.random()*5)+10, (int)(Math.random()*35)+50, 666, 0, 5);
            }
            if(rEnemy==2){System.out.println("666 CONSUME 666");
                return new Enemy("CONSUME", (int)(Math.random()*15)+35, 1,(int)(Math.random()*100)+225, (int)(Math.random()*5)+10, (int)(Math.random()*35)+50, 666, 0, 5);
            }
            if(rEnemy==3){
                System.out.println("\nG̴L̴U̵T̷T̶O̷N̴Y̶:̶ ̵T̵H̴E̸ ̶O̶V̵E̵R̵C̶O̷N̶S̶U̴M̸P̵T̷I̵O̵N̶ ̵O̷F̸ ̵S̸O̴M̴E̶T̷H̸I̵N̴G̷ ̸T̸O̸ ̷T̴H̵E̵ ̷P̵O̷I̴N̷T̸ ̵O̸F̷ ̷W̸A̸S̷T̵E̴\n");
                pause(3);
                return new Enemy("(BOSS) G̶L̶U̶T̵T̴O̵N̸Y̸", (int)(Math.random()*20) + 20, 1, (int)(Math.random()*250) + 1000, (int)(Math.random()*8)+10, (int)(Math.random()*80)+210, 666, 0, 5 );
            }
        }
        if(num==23){
            int rEnemy = (int)(Math.random()*3)+1;
            if(rEnemy==1){
                System.out.println("666 DESIRE 666");
                return new Enemy("DESIRE", (int)(Math.random()*20)+38, 1, (int)(Math.random()*75)+250, (int)(Math.random()*5)+10, (int)(Math.random()*75)+75, 666, 0, 5);
            }
            if(rEnemy ==2) {System.out.println("666 CRAVE 666");
                return new Enemy("CRAVE", (int) (Math.random() * 20) + 38, 1, (int) (Math.random() * 75) + 250, (int) (Math.random() * 5) + 10, (int) (Math.random() * 75) + 75, 666, 0, 5);
            }
            if(rEnemy==3){
                System.out.println("\n\nL̵U̴S̷T̵:̷ ̴A̸N̵ ̵I̷N̷T̷E̸N̷S̵E̶ ̴D̶E̵S̵I̷R̴E̸,̸ ̷A̷ ̷P̸A̴S̴S̴I̸O̸N̶ ̷T̷H̸A̴T̶ ̸G̷O̸V̷E̸R̵N̸S̶ ̴O̷N̴E̵'̶S̴ ̸W̴I̵L̷L̷\n\n");
                pause(3);
                return new Enemy("(BOSS) L̴U̸S̶T̶", (int)(Math.random()*25)+45, 1, (int)(Math.random()*100)+350, (int)(Math.random()*8)+10, (int)(Math.random()*50)+100, 666,0,5);
            }
        }
        if(num==24){
            int rEnemy = (int)(Math.random()*3)+1;
            if(rEnemy==1){System.out.println("666 HATRED 666");
                return new Enemy("HATRED", (int)(Math.random()*30)+75, 1, (int)(Math.random()*50)+150, (int)(Math.random()*5)+10, (int)(Math.random()*50)+75, 666, 0,5 );
            }
            if(rEnemy==2){System.out.println("666 ANGER 666");
                return new Enemy("ANGER",(int)(Math.random()*30)+75, 1, (int)(Math.random()*50)+150, (int)(Math.random()*5)+10, (int)(Math.random()*50)+75, 666, 0,5);
            }
            if(rEnemy==3) {
                System.out.println("\n\nW̸R̷A̷T̶H̶:̷ ̵T̴H̶E̶ ̷D̸E̸S̷I̸R̵E̷ ̷T̴H̴A̶T̴ ̸A̶N̸O̶T̴H̷E̵R̵ ̶M̷A̴Y̷ ̸S̴U̴F̶F̸E̶R̴ ̶M̶I̴S̵F̵O̴R̸T̸U̵N̶E̶ ̵O̵R̴ ̸E̷V̵I̷L̶\n\n");
                pause(3);
                return new Enemy("(BOSS) W̸R̶A̵T̸H̴", (int)(Math.random()*50)+125, 1, (int)(Math.random()*50)+150, (int)(Math.random()*8)+10, (int)(Math.random()*100+150), 666, 0, 5);
            }
        }
        if(num==25){
            int rEnemy = (int)(Math.random()*3)+1;
            if(rEnemy == 1){System.out.println("666 JEALOUSY 666");
                return new Enemy("JEALOUSY", (int)(Math.random()*25)+40, 1, (int)(Math.random()*50)+250, (int)(Math.random()*5)+10, (int)(Math.random()*50)+75, 666, 0,5);

            }
            if(rEnemy == 2){
                System.out.println("666 COVET 666");
                return new Enemy("COVET", (int)(Math.random()*25)+40, 1, (int)(Math.random()*50)+250, (int)(Math.random()*5)+10, (int)(Math.random()*50)+75, 666, 0,5);
            }
            if(rEnemy==3){
                System.out.println("\n\nE̷N̴V̴Y̵:̸ ̴T̷H̴E̷ ̷W̸I̵S̸H̷ ̸T̴O̸ ̵H̸A̵V̷E̷ ̵S̷O̴M̶E̶T̵H̴I̸N̵G̴ ̷T̷H̶A̵T̴ ̴A̴N̵O̵T̶H̶E̸R̸ ̴P̶O̴S̶S̶E̴S̶S̵E̴S̷ ̶O̶R̸ ̵F̸O̶R̷ ̶T̸H̷E̵ ̴O̵T̸H̸E̷R̴ ̷T̶O̴ ̵L̸A̸C̴K̸ ̷I̷T̸\n\n");
                pause(3);
                return new Enemy("(BOSS) E̶N̵V̷Y̵", (int)(Math.random()*30)+50,1,(int)(Math.random()*100)+450, (int)(Math.random()*8)+10, (int)(Math.random()*75)+150, 666, 0, 5  );
            }
        }
        if(num==26){
            int rEnemy = (int)(Math.random()*3)+1;
            if(rEnemy==1) {System.out.println("666 AVARICE 666");
                return new Enemy("AVARICE", (int)(Math.random()*20)+50, 1, (int)(Math.random()*50)+300, (int)(Math.random()*5)+10, (int)(Math.random()*50)+75, 666,0,5);
            }
            if (rEnemy==2){System.out.println("666 CUPIDITY 666");
                return new Enemy("CUPIDITY", (int)(Math.random()*20)+50, 1, (int)(Math.random()*50)+300, (int)(Math.random()*5)+10, (int)(Math.random()*50)+75, 666,0,5);
            }
            if (rEnemy==3){
                System.out.println("\n\nG̷R̶E̶E̸D̵:̵ ̴A̵N̷ ̴I̵N̶O̷R̶D̶I̷N̵A̷T̵E̷ ̸D̸E̴S̶I̷R̶E̸ ̵T̶O̸ ̴P̶O̵S̷S̶E̶S̸S̸ ̵M̵O̶R̵E̶ ̷T̵H̸A̸N̴ ̴O̷N̸E̶ ̵N̷E̴E̸D̷S̶\n\n");
                pause(3);
                return new Enemy("(BOSS) G̴R̵E̷E̸D̵", (int)(Math.random()*30)+60, 1, (int)(Math.random()*100)+500, (int)(Math.random()*8)+10, (int)(Math.random()*100)+150, 666, 0,5);
            }
        }
        if(num==27){
            int rEnemy = (int)(Math.random()*3)+1;
            if(rEnemy==1){System.out.println("666 HUBRIS 666");
                return new Enemy("HUBRIS", (int)(Math.random()*23)+80, 1, (int)(Math.random()*150)+300,(int)(Math.random()*5)+10, (int)(Math.random()*200)+200, 666,0,5);
            }
            if(rEnemy==2){System.out.println("666 EGO 666");
                return new Enemy("EGO", (int)(Math.random()*23)+80, 1, (int)(Math.random()*150)+300,(int)(Math.random()*5)+10, (int)(Math.random()*200)+200, 666,0,5);
            }
            if (rEnemy==3){
                System.out.println("\n\nP̷R̶I̶D̵E̴:̶ ̸D̴A̷N̶G̵E̴R̵O̸U̶S̸L̵Y̶ ̴C̵O̸R̸R̷U̸P̷T̷ ̴S̸E̵L̴F̵I̸S̴H̷N̷E̵S̸S̸.̶ ̷T̸H̸E̴ ̵R̴O̵O̸T̴ ̶O̶F̵ ̵A̵L̴L̸ ̷E̵V̴I̴L̴\n\n");
                pause(3);
                return new Enemy("P̴R̸I̴D̵E̵", (int)(Math.random()*30)+75, 1, (int)(Math.random()*100)+575, (int)(Math.random()*8)+10, 0, 666,0,5);
            }

        }



            return new Enemy("PHOLDER", 1, 1,100,1,(int)Math.random()*10 +20,1, (int)(Math.random()*20) + 50, 0);

    }
    private static void pause(double seconds) {
        int milliseconds = (int) (seconds * 1000);
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
//    Enemy currentEnemy = getNextEnemy(player.getLevel());
}

