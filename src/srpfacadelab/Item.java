package srpfacadelab;

public class Item extends Entity{

    private String name;

    // this is a number to represent the item type
    // there can be many items of the same type
    private int typeId;

    // How much the item heals by.
    private int heal;

    // How much armour the player gets when it is equipped.
    private int armour;

    // How much this item weighs in pounds.
    private int weight;

    // A unique item can only be picked up once.
    private boolean unique;

    // Rare items are shiny
    private final boolean rare;

    public Item(IGameEngine gameEngine, String name, int typeId, int heal, int armour, int weight, boolean unique, boolean rare){
        super(gameEngine);
        this.setName(name);
        this.typeId = typeId;
        this.setHeal(heal);
        this.setArmour(armour);
        this.setWeight(weight);
        this.setUnique(unique);
        this.rare = rare;
    }

    public int getId() {
        return super.id;
    }

    public int getTypeId(){
        return this.typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isUnique() {
        return unique;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    public boolean isRare() {
        return rare;
    }
}
