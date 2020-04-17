package srpfacadelab;

public abstract class Entity {
    // this is the unique id given to each entity
    final int id;
    final IGameEngine gameEngine;

    protected Entity(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
        this.id = gameEngine.getUniqueId();
    }

    abstract int getId();
}
