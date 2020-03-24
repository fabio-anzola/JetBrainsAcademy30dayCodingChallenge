package machine;

import java.util.Scanner;

/**
 * The Coffee Machine project
 *
 * @author fabioanzola
 */
public class Main {
    public static void main(String[] args) {
    }

    /**
     * Stage one of the project
     */
    public static void stage1() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }

    /**
     * Stage two of the project
     */
    public static void stage2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int count = sc.nextInt();
        System.out.println(String.format("For %d cups of coffee you will need:", count));
        System.out.println(String.format("%d ml of water", 200 * count));
        System.out.println(String.format("%d ml of milk", 50 * count));
        System.out.println(String.format("%d g of coffee beans", 15 * count));
    }

    /**
     * Stage three of the project
     */
    public static void stage3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has: ");
        int water = sc.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milk = sc.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int beans = sc.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int count = sc.nextInt();

        int available = Math.min((water / 200), Math.min((milk / 50), (beans / 15)));

        if (available == count) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (available < count) {
            System.out.println(String.format("No, I can make only %d cup(s) of coffee", available));
        } else {
            System.out.println(String.format("Yes, I can make that amount of coffee (and even %d more than that)", available - count));
        }
    }

    /**
     * Stage 4 of the project
     */
    public static void stage4() {
        int water = 1200;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;
        Scanner sc = new Scanner(System.in);
        System.out.println("The coffee machine has: ");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");

        System.out.println("Write action (buy, fill, take): ");
        String action = sc.nextLine();

        switch (action) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                switch (sc.nextInt()) {
                    case 1://espresso
                        water -= 250;
                        beans -= 16;
                        money += 4;
                        break;
                    case 2://latte
                        water -= 350;
                        milk -= 75;
                        beans -= 20;
                        money += 7;
                        break;
                    case 3://cappuccino
                        water -= 200;
                        milk -= 100;
                        beans -= 12;
                        money += 6;
                        break;
                }
                cups--;
                System.out.println("The coffee machine has: ");
                System.out.println(water + " of water");
                System.out.println(milk + " of milk");
                System.out.println(beans + " of coffee beans");
                System.out.println(cups + " of disposable cups");
                System.out.println(money + " of money");
                break;
            case "fill":
                System.out.println("Write how many ml of water do you want to add: ");
                water += sc.nextInt();
                System.out.println("Write how many ml of milk do you want to add: ");
                milk += sc.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add: ");
                beans += sc.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add: ");
                cups += sc.nextInt();
                System.out.println("The coffee machine has: ");
                System.out.println(water + " of water");
                System.out.println(milk + " of milk");
                System.out.println(beans + " of coffee beans");
                System.out.println(cups + " of disposable cups");
                System.out.println(money + " of money");
                break;
            case "take":
                System.out.println("I gave you $" + money);
                money = 0;
                System.out.println("The coffee machine has: ");
                System.out.println(water + " of water");
                System.out.println(milk + " of milk");
                System.out.println(beans + " of coffee beans");
                System.out.println(cups + " of disposable cups");
                System.out.println(money + " of money");
                break;
        }
    }

    /**
     * Stage 5 of the project
     */
    public static void stage5() {
        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;
        boolean next = true;
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (next) {
                System.out.println("Write action (buy, fill, take, remaining, exit): ");
            }
            next = false;
            switch (sc.nextLine()) {
                case "remaining":
                    next = true;
                    System.out.println("The coffee machine has: ");
                    System.out.println(water + " of water");
                    System.out.println(milk + " of milk");
                    System.out.println(beans + " of coffee beans");
                    System.out.println(cups + " of disposable cups");
                    System.out.println("$" + money + " of money");
                    break;
                case "buy":
                    next = true;
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                    switch (sc.nextLine()) {
                        case "1"://espresso
                            water -= 250;
                            beans -= 16;
                            if (water >= 0 && beans >= 0) {
                                System.out.println("I have enough resources, making you a coffee!");
                                money += 4;
                                cups--;
                            } else {
                                if (water <= 0) {
                                    System.out.println("Sorry, not enough water!");
                                }
                                if (milk <= 0) {
                                    System.out.println("Sorry, not enough milk!");
                                }
                                if (beans <= 0) {
                                    System.out.println("Sorry, not enough beans!");
                                }
                                if (cups <= 0) {
                                    System.out.println("Sorry, not enough cups!");
                                }
                                water += 250;
                                beans += 16;
                            }
                            break;
                        case "2"://latte
                            water -= 350;
                            milk -= 75;
                            beans -= 20;
                            if (water >= 0 && beans >= 0 && milk >= 0) {
                                System.out.println("I have enough resources, making you a coffee!");
                                money += 7;
                                cups--;
                            } else {
                                if (water <= 0) {
                                    System.out.println("Sorry, not enough water!");
                                }
                                if (milk <= 0) {
                                    System.out.println("Sorry, not enough milk!");
                                }
                                if (beans <= 0) {
                                    System.out.println("Sorry, not enough beans!");
                                }
                                if (cups <= 0) {
                                    System.out.println("Sorry, not enough cups!");
                                }
                                water += 350;
                                milk += 75;
                                beans += 20;
                            }
                            break;
                        case "3"://cappuccino
                            water -= 200;
                            milk -= 100;
                            beans -= 12;
                            if (water >= 0 && beans >= 0 && milk >= 0) {
                                System.out.println("I have enough resources, making you a coffee!");
                                money += 6;
                                cups--;
                            } else {
                                if (water <= 0) {
                                    System.out.println("Sorry, not enough water!");
                                }
                                if (milk <= 0) {
                                    System.out.println("Sorry, not enough milk!");
                                }
                                if (beans <= 0) {
                                    System.out.println("Sorry, not enough beans!");
                                }
                                if (cups <= 0) {
                                    System.out.println("Sorry, not enough cups!");
                                }
                                water += 200;
                                milk += 100;
                                beans += 12;
                            }
                            break;
                        case "exit":
                            break;
                    }
                    break;
                case "fill":
                    next = true;
                    System.out.println("Write how many ml of water do you want to add: ");
                    water += sc.nextInt();
                    System.out.println("Write how many ml of milk do you want to add: ");
                    milk += sc.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add: ");
                    beans += sc.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add: ");
                    cups += sc.nextInt();
                    break;
                case "take":
                    next = true;
                    System.out.println("I gave you $" + money);
                    money = 0;
                    break;
                case "exit":
                    System.exit(1);
                    break;
            }
        }
    }

    /**
     * Stage 6 of the project (final stage)
     */
    public void stage6() {
        Scanner sc = new Scanner(System.in);
        CoffeeMachine c = new CoffeeMachine();
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        while (true) {
            c.input(sc.nextLine());
        }
    }
}
