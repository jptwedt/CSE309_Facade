package srpfacadelab;

import java.util.List;

public interface IGameEngine {

    void playSpecialEffect(String effectName);
    List<IMob> getEnemiesNear(RpgPlayer player);
    int getUniqueId();
    boolean pickUpItem(RpgPlayer player, int typeId, int itemId);
    void useItem(RpgPlayer player, int itemid);
}
