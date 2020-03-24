package machine;

/**
 * A part of the Coffee Machine project
 *
 * @author fabioanzola
 */
public class CoffeeMachine {

    /**
     * The States for the machine (ENUM CLASS)
     */
    enum State {
        MAIN,
        BUY,
        FILL_w,
        FILL_m,
        FILL_b,
        FILL_c,
    }

    /**
     * Sets the initial water-level
     */
    private int water = 400;

    /**
     * Sets the initial milk-level
     */
    private int milk = 540;

    /**
     * Sets the initial beans-level
     */
    private int beans = 120;

    /**
     * Sets the initial cup-number
     */
    private int cups = 9;

    /**
     * Sets the initial money
     */
    private int money = 550;

    /**
     * Sets the initial machine state
     */
    private State machineState = State.MAIN;

    /**
     * Processes the user-input
     *
     * @param s The user-input as a String
     */
    public void input(String s) {
        switch (s) {
            case "remaining":
                remaining();
                System.out.println("Write action (buy, fill, take, remaining, exit): ");
                break;
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                machineState = State.BUY;
                break;
            case "fill":
                machineState = State.FILL_w;
                System.out.println("Write how many ml of water do you want to add: ");
                break;
            case "take":
                take();
                System.out.println("Write action (buy, fill, take, remaining, exit): ");
                break;
            case "exit":
                System.exit(1);
                break;
            default:
                if (machineState.equals(State.FILL_c)) {
                    fill(Integer.parseInt(s));
                }
                if (machineState.equals(State.FILL_b)) {
                    fill(Integer.parseInt(s));
                }
                if (machineState.equals(State.BUY)) {
                    buy(s);
                }
                if (machineState.equals(State.FILL_m)) {
                    fill(Integer.parseInt(s));
                }
                if (machineState.equals(State.FILL_w)) {
                    fill(Integer.parseInt(s));
                }
                if (machineState.equals(State.MAIN)) {
                    System.out.println("Write action (buy, fill, take, remaining, exit): ");
                }
        }
    }

    /**
     * Removes all the money from the machine
     */
    private void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    /**
     * Output all remaining resources
     */
    private void remaining() {
        System.out.println("The coffee machine has: ");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + money + " of money");
    }

    /**
     * Initialises the filling process
     *
     * @param i The number to add
     */
    private void fill(int i) {
        boolean exe = false;
        if (machineState.equals(State.FILL_w)) {
            water += i;
            machineState = (State.FILL_m);
            System.out.println("Write how many ml of milk do you want to add: ");
            exe = true;
        }
        if (machineState.equals(State.FILL_m) && !exe) {
            milk += i;
            machineState = (State.FILL_b);
            System.out.println("Write how many grams of coffee beans do you want to add: ");
            exe = true;
        }
        if (machineState.equals(State.FILL_b) && !exe) {
            beans += i;
            machineState = (State.FILL_c);
            System.out.println("Write how many disposable cups of coffee do you want to add: ");
            exe = true;
        }
        if (machineState.equals(State.FILL_c) && !exe) {
            cups += i;
            machineState = (State.MAIN);
            //System.out.println("Write action (buy, fill, take, remaining, exit): ");
        }
    }

    /**
     * Initialises the buying process
     *
     * @param s The product as a String
     */
    private void buy(String s) {
        switch (s) {
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
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
    }
}