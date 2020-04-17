package srpfacadelab;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class RpgPlayer extends Entity implements IMob {

    public static final int MAX_CARRYING_CAPACITY = 1000;

    private int health;

    private int maxHealth;

    private int armour;

    private int load;

    // inventory: itemId : item name
    // items are stored by entity id, since there can be several of the same class
    private HashMap<Integer, String> inventory;

    // How much the player can carry in pounds
    private int carryingCapacity;

    public RpgPlayer(IGameEngine gameEngine) {
        super(gameEngine);
        this.load = 0;
        inventory = new HashMap<>();
        setCarryingCapacity(MAX_CARRYING_CAPACITY);
    }


    protected int getId(){
        return super.id;
    }

    protected HashMap<Integer, String> getInventory(){
        return inventory;
    }

    public int getLoad(){
        return load;
    }

    protected void setLoad(int newload){
        load = newload;
    }

    public int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    protected void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getArmour() {
        return armour;
    }

    protected void setArmour(int armour) {
        this.armour = armour;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    protected void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public boolean pickUpItem(int typeId, int itemId) {
        return gameEngine.pickUpItem(this, typeId, itemId);
    }

    public void useItem(int itemid) {
        gameEngine.useItem(this, itemid);
    }

    public void takeDamage(int damage) {
        health -= damage;
    }
}
