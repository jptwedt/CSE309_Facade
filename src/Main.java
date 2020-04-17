import srpfacadelab.IGameEngine;
import srpfacadelab.Item;
import srpfacadelab.RpgPlayer;
import srpfacadelab.SimpleGameEngine;

public class Main {

    public static void main(String[] args) {
        //This is meant to be simple and just show how you could instantiate the structure

        IGameEngine game = new SimpleGameEngine();
        RpgPlayer player1 = new RpgPlayer(game);
        RpgPlayer player2 = new RpgPlayer(game);
        ((SimpleGameEngine) game).addPlayer(player1);
        ((SimpleGameEngine) game).addPlayer(player2);

        //Here you would create items
        Item weakheal = new Item(game,"Weak Healing Potion", 1, 4, 0, 1, false, false);
        Item stinkbomb = new Item(game,"Stink Bomb", 2, 0, 0, 1, false, false);
        Item supermegasword = new Item(game,"Super Mega Sword", 3, 0, 0, 38, true, true);
        ((SimpleGameEngine) game).addItem(weakheal);
        ((SimpleGameEngine) game).addItem(stinkbomb);
        ((SimpleGameEngine) game).addItem(supermegasword);

        //Here you would tell the history and make the game happen
        System.out.print("A long, long time ago in a shire far away...");

        //You could make players pick up items
        if(player1.pickUpItem(weakheal.getTypeId(), weakheal.getId())){
            System.out.printf("player1 picked up %s\n", weakheal.getName());
        }
        else{
            System.out.printf("player1 could not pick up %s\n", weakheal.getName());
        }
        if(player1.pickUpItem(stinkbomb.getTypeId(), stinkbomb.getId())){
            System.out.printf("player1 picked up %s\n", stinkbomb.getName());
        }
        else{
            System.out.printf("player1 could not pick up %s\n", stinkbomb.getName());
        }
        if(player1.pickUpItem(supermegasword.getTypeId(), supermegasword.getId())){
            System.out.printf("player1 picked up %s\n", supermegasword.getName());
        }
        else{
            System.out.printf("player1 could not pick up %s\n", supermegasword.getName());
        }
        if(player1.pickUpItem(supermegasword.getTypeId(), supermegasword.getId())){
            System.out.printf("player1 picked up %s\n", supermegasword.getName());
        }
        else{
            System.out.printf("player1 could not pick up %s\n", supermegasword.getName());
        }
        //You could make players use items
        //etc.
        //You don't need to worry about it for the assignment
        //This is only to show how the 'external world' would instantiate the structure.
        //In the assignment, you're supposed to improve the design and not instantiate a game
    }
}
