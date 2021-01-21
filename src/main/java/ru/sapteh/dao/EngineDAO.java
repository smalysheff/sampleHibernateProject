package ru.sapteh.dao;

public interface EngineDAO<Entity, Key> {
    void create(Entity entity);
    Entity read(Key key);
    void update(Entity entity);
    void delete(Entity entity);

}
