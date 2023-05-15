package com.company;



import java.util.Scanner;
import java.util.concurrent.DelayQueue;

public class Main {
    private static Char player;
    static Scanner input;
    static Weapon[] weapons;
    static Armor[] armors;
    static Potions[] potions;
    static boolean win = false;
    static int pAgi;
    static int pStr;
    static int pType;

    public static void main(String[] args) {
        input = new Scanner(System.in);

        weapons = Weapon.initializeWeapons();
        armors = Armor.initializeArmor();
        potions = Potions.initializePotions();

        rollStats();
        intro();

        while (!win) {
            townMenu();
        }


    }


    public static void rollStats() {
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        char reroll = 'y';
        while (reroll == 'y') {
            System.out.println("\n\n\n");
            player = new Char(name);
            player.displayStats();


            System.out.println("\nWould you like to roll your stats again? (y/n): ");
            reroll = input.nextLine().toLowerCase().charAt(0);
        }

    }

    private static void intro() {

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\uD835\uDD4E\uD835\uDD3C\uD835\uDD43ℂ\uD835\uDD46\uD835\uDD44\uD835\uDD3C \uD835\uDD4B\uD835\uDD46 \uD835\uDD4Bℍ\uD835\uDD3C \uD835\uDD44\uD835\uDD38\uD835\uDD43\uD835\uDD43!\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        pause(1);

    }

    private static void townMenu() {
        clearEffects(pType, pAgi, pStr);


        System.out.println("You are in the mall exploring");
        System.out.println("Would you like to:");
        System.out.println("\n (B) - Battle your inner demons?");
        System.out.println("\n (W) - Go to the House of Knives?");
        System.out.println("\n (A) - Go to Hudson's Bay?");
        System.out.println("\n (P) - Test out the new oils at Sage?");
        System.out.println("\n (T) - Test out the mattresses at Mattress Mattress? (10 dollarinos)");
        System.out.println("\n (C) - Waste your kid's university fund at the Casino?");
        System.out.println("\n (S) - Peep the phone?");
        System.out.println("\n\nCurrent dollars: " + player.getGold());
        System.out.println("\n\n What would you like to do?:");

        char choice = input.next().toLowerCase().charAt(0);
        System.out.println("\n=============================================");
        System.out.println("=============================================");
        System.out.println("=============================================\n");


        switch (choice) {
            case 'b':
                battle();
                break;
            case 'w':
                weaponShop();
                break;
            case 'a':
                armourShop();
                break;
            case 't':
                inn();
                break;
            case 'p':
                potionShop();
                break;
            case 'c':
                casino();
                break;
            case 's':
                player.displayStats();
                pause(4);
                System.out.println("\n");
                input.nextLine();
                break;

            default:
                System.out.println("You suck. That is not an option.");
                pause(4);
        }


    }

    private static void potionShop() {
        System.out.println("\n\n");
        System.out.println("Welcome to Sage!");
        System.out.println("What would you like?");
        for (int i = 0; i < potions.length; i++) {
            System.out.println((i + 1) + " - " + potions[i] + ", Cost: " + potions[i].getPCost());
        }
        System.out.println("Press 0 to exit.");
        System.out.println("Your choice: ");
        while (!input.hasNextInt()) {
            System.out.println("Stop");
            input.nextLine();
        }
        int choice = input.nextInt();
        if (choice == 0) {
            System.out.println("See ya.");
            return;
        } else if (choice >= 1 && choice <= potions.length) {
            int index = choice - 1;
            if (player.getGold() >= potions[index].getPCost()) {

                    System.out.println("Which slot would you like to equip this potion (1/2/3)");
                    choice = input.nextInt();
                    if (choice == 1) {
                        player.setPotions(potions[index], 1);
                        player.decreaseGold(potions[index].getPCost());
                    }
                    else if(choice == 2){
                        player.setPotions(potions[index], 2);
                        player.decreaseGold(potions[index].getPCost());
                    }
                    else if(choice==3){
                        player.setPotions(potions[index], 3);
                        player.decreaseGold(potions[index].getPCost());
                    }


            } else {
                System.out.println("The oils of Sage lead you to falling asleep. You wake up outside of the store.");
            }

        }
    }

    private static void pause(double seconds) {
        int milliseconds = (int) (seconds * 1000);
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private static void battle() {
        pause(1);


        System.out.println("\n\n");
        Enemy enemy = Enemy.getNextEnemy(player.getLevel());

        while (true) {



            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n" + player.getName() + ": " + player.getHp() + " / " + player.getMaxHP());
            System.out.println(enemy.getName() + ": " + enemy.getHealth() + " / " + enemy.getMaxHp());
            System.out.println("What would you like to do?\n\n\n");
            System.out.println(" (M) Melee");
            System.out.println(" (P) Use a potion");
            System.out.println(" (R) Run away");
            System.out.println("\n\n\n");
            char choice = input.next().toLowerCase().charAt(0);
            if (choice == 'p') {
                System.out.println("Which potion would you like to use?");
                System.out.println(("(1) - " + player.getPotion1().getName()));
                System.out.println(("(2) - " + player.getPotion2().getName()));
                System.out.println(("(3) - " + player.getPotion3().getName()));
                System.out.println("(0) - Go back.");

                while (!input.hasNextInt()) {
                    System.out.println("Stop");
                    input.nextLine();
                }

                int pChoice = input.nextInt();
                if (pChoice == 1) {

                    potionEffects(player.getPotion1().getPType(), player.getPotion1().getPAgility(), player.getPotion1().getPStrength(), player.getPotion1().getPHealth());

                    player.setEmptyPSlot(1);


                }
                if (pChoice == 2 ) {

                    potionEffects(player.getPotion2().getPType(), player.getPotion2().getPStrength(), player.getPotion2().getPStrength(), player.getPotion2().getPHealth());

                    player.setEmptyPSlot(2);

                }
                if (pChoice == 3) {

                    potionEffects(player.getPotion3().getPType(), player.getPotion3().getPHealth(), player.getPotion3().getPStrength(), player.getPotion3().getPHealth());
                    player.setEmptyPSlot(3);

                }
                if (pChoice == 0) {
                    System.out.println("You fumble the potions, giving the enemy an opening to attack");
                }


            }

            if (choice == 'm') {
                System.out.println("Would you like to use " + player.getWeapon().getName() + "(1) or " + player.getWeapon2().getName() + "(2)?");

                Weapon weapon;
                while (!input.hasNextInt()) {
                    System.out.println("Stop");
                    input.nextLine();
                }
                int choice2 = input.nextInt();
                while(choice2 != 1&& choice2 !=2){
                    System.out.println("That weapon does not exist, try again");
                    choice2 = input.nextInt();
                }

                if (choice2 == 1) {
                    weapon = player.getWeapon();
                } else{
                    weapon = player.getWeapon2();
                }

                if (enemy.doesItHit(player.getAgility() + player.getArmor().getDodge() + weapon.getSpeed())) {

                    if(enemy.takeDamage(weapon.getDamage(), player.getStrength(), weapon.getType())) {

                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("\n\n\n");
                        System.out.println("You win!");
                        System.out.println("You receive " + enemy.getExperience() + " experience!");
                        System.out.println("You receive " + enemy.getGold() + " gold!");

                        player.increaseGold(enemy.getGold());
                        player.gainExperience(enemy.getExperience());

                        if(enemy.getName().equals("Moving Plant")){
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n What's happening? Am I going insane? Why was I fighting a plant? And what was that thing?\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            pause(5);
                            player.levelUp();
                        }
                        if(enemy.getName().equals("Shopping Cart")){
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nThere it was again, accompanied by those strange messages. Something's wrong.\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            pause(5);
                            player.levelUp();
                        }
                        if(enemy.getName().equals("THE BEGINNING OF THE END")){
                            player.levelUp();
                            pause(3);
                        }
                        if(enemy.getName().equals("(BOSS) S̸L̴O̶T̷H̴")){
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
                            pause(1);
                            System.out.println("\n\n\nS̷͓̋͜Ṫ̴͇O̷͖̍P̷͉̣̀ ̴̦͝T̸͙̕H̴̙̓̉A̴̛̮̗T̴̡̺̓͋\n\n\n");
                            pause(2);
                            System.out.println("\n\n1 down, 6 to go\n\n");
                            pause(4);
                            player.levelUp();
                        }
                        if(enemy.getName().equals("(BOSS) G̶L̶U̶T̵T̴O̵N̸Y̸")){
                            pause(2);
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
                            pause(2);
                            System.out.println("\nY̴O̵U̵ ̷M̷U̷S̴T̶ ̵F̸E̴E̸L̷ ̴G̶R̷E̷A̴T̵ ̶T̷H̴A̴T̴ ̴Y̴O̵U̵'̴V̸E̸ ̵M̵A̸D̶E̷ ̵I̷T̶ ̴T̷H̷I̶S̶ ̸F̵A̷R̶.̵ ̶I̴ ̴A̴M̷ ̴A̵L̷S̷O̸ ̶I̶M̴P̷R̶E̵S̵S̸E̴D̷.̷ ̵A̴L̵L̵ ̷G̷O̶O̷D̸ ̷T̴H̷I̴N̸G̸S̴ ̴M̶U̸S̴T̸ ̷C̴O̴M̶E̷ ̷T̸O̵ ̵A̶N̵ ̴E̶N̸D̷,̶ ̵I̸N̵C̴L̷U̶D̴I̵N̶G̶ ̵Y̴O̴U\n̶");
                            pause(2);
                            System.out.println("\nI won't let you control my life anymore!\n");
                            pause(2);


                            player.levelUp();
                        }
                        if(enemy.getName().equals("(BOSS) L̴U̸S̶T̶")){
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
                            System.out.println("\nO̵K̸A̵Y̴ ̸O̶K̵A̷Y̸,̵ ̴N̵O̴T̵ ̷T̵O̶O̸ ̷B̸A̷D̴.̸ ̸Y̵O̸U̵R̷ ̷J̵O̶U̸R̶N̸E̷Y̴ ̶E̷N̷D̵S̴ ̶H̸E̴R̵E̸\n");
                            pause(2);
                            System.out.println("\nNo it doesn't! I won't allow it devil man!\n");
                            pause(2);



                            player.levelUp();
                        }
                        if(enemy.getName().equals("(BOSS) W̸R̶A̵T̸H̴")){
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
                            System.out.println("\nN̷O̵W̵ ̵I̵'̵M̵ ̷A̴C̴T̷U̵A̶L̶L̴Y̸ ̵U̶P̵S̴E̸T̸\n");
                            pause(2);
                            System.out.println("\nI'm not done yet! I will end this!\n");
                            pause(2);


                            player.levelUp();
                        }
                        if(enemy.getName().equals("(BOSS) E̶N̵V̷Y̵")){
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
                            System.out.println("\nA̵L̷R̸I̴G̴H̷T̴,̴ ̵N̸O̵W̶ ̴Y̵O̵U̶'̴R̷E̸ ̷O̵N̵ ̴M̶Y̵ ̷N̸E̵R̵V̵E̴S̶,̶ ̸D̶O̶N̸'̶T̴ ̵M̵A̶K̶E̶ ̴M̶E̵ ̸T̴R̴Y̷\n");
                            pause(2);
                            System.out.println("\nYou scared? You should be!\n");
                            pause(2);


                            player.levelUp();
                        }
                        if(enemy.getName().equals("(BOSS) G̴R̵E̷E̸D̵")){
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
                            System.out.println("\n6̸ ̶D̵O̴W̴N̵,̷ ̴B̷U̸T̴ ̵P̵R̴I̴D̸E̷ ̵I̵S̸ ̴T̴H̸E̶ ̸S̵T̷R̵O̷N̴G̸E̷S̸T̷ ̷O̴F̶ ̵T̴H̸E̶M̵ ̴A̴L̶L̷\n");
                            pause(1);
                            System.out.println("\nP̸R̴I̴D̷E̵ ̸I̷S̸ ̴T̴H̷E̵ ̷R̷O̶O̷T̷ ̵O̸F̸ ̶A̸L̷L̸ ̵E̴V̴I̴L̵,̸ ̶A̸N̵D̵ ̸T̵H̴E̷ ̸R̴O̸O̷T̸ ̴O̴F̸ ̶A̸L̴L̸ ̸T̵H̸E̸ ̸O̶T̴H̸E̶R̷ ̸S̸I̶N̸S̵.̸ ̵I̸T̵ ̵I̸S̸ ̵N̶O̸T̶ ̶O̸N̴E̷ ̶Y̵O̴U̵ ̶C̶A̶N̴ ̸D̶E̴F̸E̶A̵T̷ ̵O̶N̷ ̷Y̴O̵U̶R̷ ̵O̷W̸N̷.̷\n");
                            pause(2);
                            System.out.println("I proved you wrong the other 6 times, this time won't be any different.");
                            pause(2);


                            player.levelUp();
                        }



                        if (enemy.getName().equals("P̴R̸I̴D̵E̵")) {
                            winScreen();
                            win = true;

                        }
//
                        break;

                    }
                }
                else {
                        System.out.println("You missed. Clown.");
                    }
                }
                if (player.doesItHit(enemy.getDodge())){
                    if(enemy.getDamage()>0) {
                        enemy.thornDamage(player.getArmor().getThorn());
                    }
                    if (!player.takeDamage(enemy.getDamage())) {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("An employee stands over you. He informs you that you've been laying on the floor in front of Burger King for 10 minutes. You are sent to the infirmary and lose 100 gold.");
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                        pause(6);
                        player.decreaseGold(Math.min(100, player.getGold()));
                        player.heal(99999999);
                        break;
                    }
                }
                else{
                    System.out.println("The enemy missed!");
                }

                if (choice == 'r') {

                    System.out.println("You ran away");
                    pause(3);

                    break;
                }
            }


        }


        private static void weaponShop(){
            System.out.println("\n\n");
            System.out.println("Welcome to House of Knives!");
            System.out.println("What would you like?");
            for (int i = 0; i < weapons.length; i++) {
                System.out.println((i + 1) + " - " + weapons[i] + ", Cost: " + weapons[i].getCost());
            }
            System.out.println("Press 0 to exit.");
            System.out.println("Your choice: ");
            while (!input.hasNextInt()) {
                System.out.println("Stop");
                input.nextLine();
            }
            int choice = input.nextInt();
            if (choice == 0) {
                System.out.println("See ya.");
                return;
            } else if (choice >= 1 && choice <= weapons.length) {
                int index = choice - 1;
                if (player.getGold() >= weapons[index].getCost()) {
                    if (player.getWeapon().getCost() > weapons[index].getCost() && player.getWeapon2().getCost() > weapons[index].getCost()) {
                        System.out.println("You already have a more prime knife.");
                    } else {
                        System.out.println("Which slot would you like to equip this weapon? (1/2)");
                        choice = input.nextInt();
                        if (choice == 1) {
                            player.setWeapon(weapons[index], 1);
                            player.decreaseGold(weapons[index].getCost());
                        }
                        else if(choice==2){
                            player.setWeapon(weapons[index], 2);
                            player.decreaseGold(weapons[index].getCost());
                        }

                    }
                } else {
                    System.out.println("An employee of House of Knives shouts: YOOO THIS MAN CAN'T AFFORD A KNIFE! ");
                }

            }

        }

        private static void armourShop () {
            System.out.println("\n\n");
            System.out.println("Welcome to Hudson's Bay! Feel free to browse our wide collection of clothing.");
            System.out.println("What would you like?");
            for (int i = 0; i < armors.length; i++) {
                System.out.println((i + 1) + " - " + armors[i] + ", Cost: " + armors[i].getCost());
            }
            System.out.println("Press 0 to exit.");
            System.out.println("Your choice: ");
            while (!input.hasNextInt()) {
                System.out.println("Stop");
                input.nextLine();
            }
            int choice = input.nextInt();
            if (choice == 0) {
                System.out.println("See ya.");
                return;
            } else if (choice >= 1 && choice <= armors.length) {
                int index = choice - 1;
                if (player.getGold() >= armors[index].getCost()) {
                    if (player.getWeapon().getCost() > armors[index].getCost()) {
                        System.out.println("You already have a better drip");
                    } else {
                        player.setArmor(armors[index]);
                        player.decreaseGold(armors[index].getCost());
                    }
                } else {
                    System.out.println("You attempt to steal a fur coat, but you are too fluffy to fit through the door.");
                    System.out.println(" ");
                }

            }

        }

        private static void inn () {
            if (player.getGold() >= 25) {
                player.heal(999999);
                player.decreaseGold(Math.min(25,player.getGold()));
                System.out.println(" \n\n");
                System.out.println("Successfully healed! You are back up to " + player.getMaxHP() + "!\n\n");
            } else {
                System.out.println("\n\nYou have been escorted out of Mattress Mattress for illegally trespassing on the mattresses!\n\n");

            }

        }
        private static void casino(){
            System.out.println("Welcome to the Casino! Ready to lose it all?");
            System.out.println("(1) to bet, (2) to exit;");
            int casChoice = input.nextInt();

            if (casChoice == 2) {
                System.out.println("\n\n\nScaredy Cat...\n\n\n");
                pause(3);
                return;
            }
            if (casChoice == 1) {
                System.out.println("\nHow much would you like to bet?\n");
                while(!input.hasNextInt()){
                    System.out.println("Stop");
                }

                int moneyBet = input.nextInt();
                while(moneyBet>player.getGold()){
                    System.out.println("Don't try to scam the scammers! Now try again");
                    moneyBet = input.nextInt();
                }
                System.out.println("\nWould you like to double(1), triple(2), or quadruple(3).\n");
                int casChoice2 = input.nextInt();
                System.out.println("\nRolling...\n");
                pause(4);
                if (casChoice2 == 1) {
                    int youLose = (int)(Math.random() * 5) + 1;
                    if (youLose < 5) {
                        System.out.println("\n\n\nThere goes all your money!\n\n\n");
                        player.decreaseGold(moneyBet);
                    }
                    if (youLose == 5) {
                        System.out.println("\n\n\nWow, you beat the system! You have been awarded " + moneyBet * 2 + " gold!\n\n\n");
                        player.increaseGold(moneyBet * 2);
                    }

                }
                if (casChoice2 == 2) {
                    int youLose = (int)(Math.random() * 8) + 1;
                    if (youLose < 8) {
                        System.out.println("\n\n\nThere goes all your money!");
                        player.decreaseGold(moneyBet);
                    }
                    if (youLose == 8) {
                        System.out.println("\n\n\nWow, you beat the system! You have been awarded " + moneyBet * 3 + " gold!\n\n\n");
                        player.increaseGold(moneyBet * 3);
                    }

                }
                if (casChoice2 == 3) {
                    int youLose = (int)(Math.random() * 10) + 1;
                    if (youLose < 10) {
                        System.out.println("\n\n\nThere goes all your money!");
                        player.decreaseGold(moneyBet);
                    }
                    if (youLose == 10) {
                        System.out.println("\n\n\nWow, you beat the system! You have been awarded " + moneyBet * 10 + " gold!\n\n\n");
                        player.increaseGold(moneyBet * 10);
                    }

                }
                if (casChoice2 == 777) {

                    System.out.println("\n\n\nAhh, it's the creator. Please, accept our humble gift. (Money has been increased by " + moneyBet * 500 + " gold)\n\n\n");
                    player.increaseGold(moneyBet * 500);
                }


            }
        }
        private static void winScreen(){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        pause(5);
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
            pause(4);

            System.out.println("\nA̷M̴ ̴I̷.̸.̸.̶ ̴D̵Y̷I̸N̶G̷?̵\n");
            pause(3);
            System.out.println("\nN̵O̶ ̴T̷H̸I̵S̸ ̴I̷S̴N̴'̶T̴\n");
            pause(2);
            System.out.println("\nT̴H̴I̵S̵ ̴I̴S̵N̵'̷T̵ ̷P̷O̷S̷S̶I̸B̴L̸E̴!̷\n");
            pause(1);
            System.out.println("\nT̷H̴I̸S̶ ̴C̶A̷N̸'̸T̵ ̶B̸E̵ ̶H̷A̶P̵P̷E̸N̸I̶N̷G̶!̷\n");
            pause(5);
            System.out.println("\n\n\n\n\n\n\n\n\n\nYour hunt to resolve your inner demons started as an everyday wander through the mall, but as you defeated those around you, you started to see your own imperfections. ");
            System.out.println("The path was not easy, but after all this time, you've defeated the most deadly sin of them all. Pride. You go on to live your life with a new found outlook on life,");
            System.out.println("and try to preach your journey of self-finding to others.\n\n\n\n\n");

            pause(7);
            System.out.println("\nDon't know if you got this far Mr. Bosdet, but if you did I hope you enjoyed it. I tried pretty hard to try and balance everything, and that was probably the hardest part. There were a lot of bugs");
            System.out.println("found during the playthrough's of the game, but I think it turned out pretty well. I hope you feel the same way and I hope you enjoyed it.");
            System.out.println( "It is currently 9:57pm on Tuesday, Oct. 20th, 2020. I think it's safe to say");
            System.out.println("the game is finally done!");
            pause(2);

            System.out.println("\nThanks for playing! Have a good one!");
        }
        private static void potionEffects(int type, int agi, int str, int hlt) {

                if (type == 1) {
                    player.increaseAgility(agi);
                    System.out.println("Your agility was increased by " + agi + "!");
                    pAgi = agi;
                }
                if (type == 2) {
                    player.increaseStrength(str);
                    System.out.println("Your strength was increased by " + str + "!");
                    pStr = str;
                }
                if (type == 3) {
                    player.increaseHealth(hlt);
                    System.out.println("Your health was increased by " + Math.max(hlt, player.getMaxHP()-player.getHp()) + "!");
                } else{
                    player.increaseStrength(str);
                    player.increaseHealth(hlt);
                    player.increaseAgility(agi);
                    pStr = str;
                    pAgi = agi;

                }
            }


        private static void clearEffects(int type, int agi, int str){

            if(type==1){
                player.decreaseAgility(str);
            }
            if(type ==2){
                player.decreaseStrength(agi);
            }
            else{
                player.decreaseStrength(str);
                player.decreaseAgility(agi);
            }
            pAgi = 0;
            pStr = 0;
        }
}




