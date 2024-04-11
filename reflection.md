Use this file to record your reflection on this assignment.

- Tell me about your class! What does it represent?
- What additional methods (if any) did you implement alongside those listed in the interface?
- What worked, what didn't, what advice would you give someone taking this course in the future?

-The class represents a player, such as in a game! They can interact with their surroundings, grab items, use them, drop them, and move around via flying and walking, as well as grow and shrink in size to move around their surroundings, with some fantasy magic. My idea was that this player was a mage, so they could transform themselves, and at this point they only transform to become a bee to fit into small spaces. (buzz buzz! 🐝) 

    void grab(String item):
        the player picks up the input item and it is added to their inventory
    String drop(String item);
        the specified item, if in the inventory, is removed from inventory
    void examine(String item);
        the specified item is examined for any peculiar features (here, if I were to make multiple object classes, would have special descriptions for each type of object and any special properties)
    void use(String item);
         If the player is holding the item, they are given a message that they have used it. Otherwise an exception is thrown since they can't use an object they aren't holding it in their inventory
    boolean walk(String direction);
        The player's status isWalking is set to true, and a message is displayed that the player has begun to walk in the given direction. Their coordinates are updated depending on if they enter "North", "South", "East", or "West"
    boolean fly(int x, int y);
        Flies towards the given coordinates, and isFlying is set to true
    Number shrink();
        Player's size is decreased by 1
    Number grow();
        Player's size is increased by 1
    void rest();
        Player stops all walking or flying
    void undo();
        Resets player's position, inventory, and other states back to default values

-Added:
    a toString() method
        overridden toString to display some player information/stats
    a transmutate() method
        Sets the player's size to 0.01, state to flying, and adds honey to inventory.
    an overloaded walking method for if no direction is input
        the player walks aimlessly with no goal, and ends up going practically nowhere 

-What did/didn't work:
    -For the undo() class I attempted to try to remove all pointers to the object so that the garbage collector took it away, but I ended up deciding instead to reset all the values back to defaults, such as clearing the inventory and resetting the player's position to (0, 0). Therefore, the player object could remain but still have a fresh start. 
    -Was able to have a player location through the x and y coordinates
        -Was able to have the coordinates specifically change in the player's attributes depending on which direction they input for travel
    -For advice: imagination truly is the limit! And sometimes if you can't think of what a class should do, just write out some ideas/brainstorm, or write the first thing that comes to mind--you can always change it later :D