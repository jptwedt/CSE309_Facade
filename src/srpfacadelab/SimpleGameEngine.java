package srpfacadelab;

import java.util.*;

public class SimpleGameEngine implements IGameEngine{

    private List<IMob> enemies;
    private HashMap<Integer, RpgPlayer> players;
    private HashMap<Integer, Item> items;
    private Random roll;

    public SimpleGameEngine(){
        roll = new Random();
        roll.setSeed(System.currentTimeMillis());
        enemies = new ArrayList<>();
        enemies.add(new SimpleEnemy("Creeper"));
        enemies.add(new SimpleEnemy("Zombie"));
        enemies.add(new SimpleEnemy("Golem"));
        players = new HashMap<>();
        items = new HashMap<>();
    }

    public void addPlayer(RpgPlayer player){
        players.put(player.getId(), player);
    }

    public void addItem(Item item){
        items.put(item.getId(), item);
    }

    @Override
    public void playSpecialEffect(String effectName) {
        if (effectName.equals("green_swirly"))
            System.out.println("[Special Effect]: Green Swirl!!!");
        else if (effectName.equals("cool_swirly_particles"))
            System.out.println("[Special Effect]: Fancy Swirly Particles in the air!!!");
        else if (effectName.equals("parry"))
            System.out.println("[Special Effect]: Nop! Try better next time!");
        else if (effectName.equals("lots_of_gore"))
            System.out.println("[Special Effect]: Ouch!! That hurts!!");
    }

    @Override
    public List<IMob> getEnemiesNear(RpgPlayer player) {
        //Meant to be the simplest logic
        if (players.get(0).equals(player))
                return enemies; //First player got all enemies

        //Other players got none
        return null;
    }

    @Override
    public int getUniqueId() {
        int newid = roll.nextInt();
        while(players.get(newid) != null && items.get(newid) != null){
            newid = roll.nextInt();
        }
        return newid;
    }

    public void damagePlayer(RpgPlayer player, int damage) {
        int armour = player.getArmour();

        if (damage < armour) {
            playSpecialEffect("parry");
        }
        else {
            int damageToDeal = damage - armour;
            int load = player.getLoad();

            if ((double) load / player.getCarryingCapacity() < 0.5) {
                damageToDeal = damageToDeal * 3 / 4;
            }

            player.takeDamage(damageToDeal);
            playSpecialEffect("lots_of_gore");
        }
    }

    @Override
    public void useItem(RpgPlayer player, int itemid) {
        if (items.get(itemid).getName().equals("Stink Bomb")){
            List<IMob> enemies = getEnemiesNear(player);

            for (IMob enemy: enemies){
                enemy.takeDamage(100);
            }
        }
    }

    private void calculatePlayerStats(RpgPlayer player){
        int armour = 0;
        Iterator it = player.getInventory().entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer,String> pair = (Map.Entry)it.next();
            armour += items.get(pair.getKey()).getArmour();
        }

        player.setArmour(armour);
    }

    private void healPlayer(RpgPlayer player, Item item){
        int health = player.getHealth();
        int maxHealth = player.getMaxHealth();

        health += item.getHeal();

        if (health > maxHealth)
            health = maxHealth;

        player.setHealth(health);

        if (item.getHeal() > 500) {
            playSpecialEffect("green_swirly");
        }
    }

    @Override
    public boolean pickUpItem(RpgPlayer player, int typeId, int itemId) {
        Item item = items.get(itemId);

        if (player.getLoad() + item.getWeight() > player.getCarryingCapacity()) {
            return false;
        }

        if (item.isUnique() && playerHasItemType(player, typeId)) {
            return false;
        }

        // Don't pick up items that give health, just consume them.
        if (item.getHeal() > 0) {
            healPlayer(player, item);
            return true;
        }

        if (item.isRare()){
            playSpecialEffect("cool_swirly_particles");
        }

        if (item.isRare() && item.isUnique()){
            playSpecialEffect("blue_swirly");
        }

        player.getInventory().put(itemId, item.getName());
        player.setLoad(player.getLoad() + item.getWeight());
        calculatePlayerStats(player);

        return true;
    }

    private boolean playerHasItemType(RpgPlayer player, int typeId) {
        Iterator it = player.getInventory().entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer, Item> pair = (Map.Entry)it.next();
            if(items.get(pair.getKey()).getTypeId() == typeId){
                return true;
            }
        }
        return false;
    }


}
