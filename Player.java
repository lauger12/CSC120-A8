import java.util.ArrayList;

public class Player implements Contract {

    private Number size;
    private ArrayList<String> inventory;
    private Number yCoord;
    private Number xCoord;
    private boolean isWalking;
    private boolean isFlying;
    public String name;

    /**
     * Constructor for the Player class
     * 
     * @param name
     * @param size
     * @param x
     * @param y
     */
    public Player(String name, Number size, Number x, Number y) {
        this.name = name;
        this.size = size;
        this.xCoord = x;
        this.yCoord = y;
        this.inventory = new ArrayList<String>();
        this.isFlying = false;
        this.isWalking = false;
    }

    /**
     * Default constructor for the Player class
     */
    public Player() {
        this.name = "Joe";
        this.size = 1;
        this.xCoord = 0;
        this.yCoord = 0;
        this.inventory = new ArrayList<String>();
        this.isFlying = false;
        this.isWalking = false;
    }

    /**
     * The player becomes a bee! A method that sets the player's size to 0.01, and
     * sets their state to flying. Adds honey to inventory.
     */
    public void transmutate() {
        System.out.println("You feel your magic enveloping your body...");
        this.size = 0.01;
        this.isFlying = true;
        System.out.println("Buzz buzz! You've become a bee! 🐝 ");
        this.inventory.add("Honey");
        System.out.println(">>Honey added to Inventory<<");
    }

    /**
     * The specificed item is picked up and added to the player's inventory (and a
     * message is displayed to signal)
     * 
     * @param item String
     */
    public void grab(String item) {
        this.inventory.add(item);
        System.out.println("You have picked up " + item);
    }

    /**
     * If the player is holding the item, it is removed from their inventory (and a
     * message is played). Otherwise an exception is thrown
     * 
     * @param item
     * @return String that displays which item has been dropped
     * @throws RuntimeException if item that they player tries to drop isn't in
     *                          inventory
     */
    public String drop(String item) {
        if (!this.inventory.contains(item)) {
            throw new RuntimeException("You can't drop something you aren't holding!");
        }
        this.inventory.remove(item);
        System.out.println("You have dropped " + item);
        return "You have dropped " + item;

    }

    /**
     * Gives a basic description of an item observed by a player
     * 
     * @param item the item to be examined
     */
    public void examine(String item) {
        System.out.println("An average looking " + item);
    }

    /**
     * If the player is holding the item, they are given a message that they have
     * used it. Otherwise an exception is thrown
     * 
     * @param item
     * @throws RuntimeException if item that they player tries to use isn't in
     *                          inventory
     */
    public void use(String item) {
        if (!this.inventory.contains(item)) {
            throw new RuntimeException("You need to hold the item to use it");
        }
        System.out.println("You have used your " + item);
    }

    /**
     * Starts the player walking in a given direction
     * 
     * @param direction
     * @return boolean isWalking, which is whether the player is walking or not, and
     *         it is set to true here in this method, so it will return true. The
     *         player's location is updated based on the input direction.
     */
    public boolean walk(String direction) {
        if (direction == "North") {
            this.yCoord = yCoord.intValue() + 1;
        } else if (direction == "South") {
            this.yCoord = yCoord.intValue() - 1;
        } else if (direction == "East") {
            this.xCoord = xCoord.intValue() + 1;
        } else if (direction == "West") {
            this.xCoord = xCoord.intValue() - 1;
        } else {
            throw new RuntimeException("Please input: North, South, East, or West");
        }
        System.out.println("You are  walking towards the " + direction + " direction");
        System.out.println("Your location is (" + this.xCoord + ", " + this.yCoord + ")");
        this.isWalking = true;
        return isWalking;
    }

   
    /**
     * Overloaded walk method: the player walks aimlessly with no goal, and ends up going practically nowhere, but is still walking!
     * For when no parameter is given for direction
     * 
     * @return boolean isWalking, which is whether the player is walking or not, and
     *         it is set to true here in this method, so it will return true. The
     *         player's location is updated based on the input direction.
     */
    public boolean walk() {
        System.out.println("You begin to wander around aimlessly, not really ending up anywhere new, but you march forth anyways, how valiant!");
        this.isWalking = true;
        return isWalking;
    }

    /**
     * The player starts flying, and flies to the specified coordinates, and they
     * remain flying afterwards
     * 
     * @param x, the desired x coordinate to travel to
     * @param y, the desired y coordinate to travel to
     * @return boolean isFlying, which is whether the player is flying or not, and
     *         it is set to true here in this method, so it will return true
     */
    public boolean fly(int x, int y) {
        System.out.println("You fly towards (" + x + ", " + y + ") and are still flying");
        this.xCoord = x;
        this.yCoord = y;
        this.isFlying = true;
        return isFlying;

    }

    /**
     * Decreases the player's size by 1
     * 
     * @return size of the player object
     */
    public Number shrink() {
        System.out.println("You feel your body start to shrink!");
        this.size = -1;
        return this.size;
    }

    /**
     * Increments the player's size by 1
     * 
     * @return size of the player object
     */
    public Number grow() {
        System.out.println("You feel your body start to grow!");
        this.size = +1;
        return this.size;
    }

    /**
     * Sets values for walking and flying to false so that the player stops moving
     * to rest
     */
    public void rest() {
        System.out.println("You stop to rest");
        this.isWalking = false;
        this.isFlying = false;
    }

    /**
     * Method to reset the player's statistics/any changes they would have made back
     * to the default. This includes size, location, coordinates, flying + walking
     * status, and inventory (cleared)
     */
    public void undo() {
        System.out.println("Resetting Player...");
        this.size = 1;
        this.xCoord = 0;
        this.yCoord = 0;
        this.isFlying = false;
        this.isWalking = false;
        this.inventory = new ArrayList<String>();
        System.out.println("Done. Let's start again, shall we?");

    }

    /**
     * toString for class Player
     * 
     * @return toString for Player class
     */
    public String toString() {
        return this.name + " has a size of " + this.size + ", is located at (" + this.xCoord + ", " + this.yCoord + ")";
    }

    public static void main(String[] args) {
        Player p = new Player();
        System.out.println(p);
        System.out.println(p.size);
        System.out.println(p.isFlying);
        p.transmutate();
        // p.grab("Apple");
        System.out.println(p.inventory);
        System.out.println(p.size);
        System.out.println(p.isFlying);
        p.walk();
        // p.fly(1, 2);
        System.out.println(p.xCoord.intValue() + " " + p.yCoord.intValue());
        // p.undo();
        // System.out.println(p.inventory);
        // System.out.println(p.xCoord.intValue() + " " + p.yCoord.intValue());
    }
}
