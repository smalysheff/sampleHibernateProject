package ru.sapteh.dao.impl;

import com.sun.istack.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sapteh.dao.EngineDAO;
import ru.sapteh.model.Engine;

public class EngineDAOImpl implements EngineDAO<Engine, Integer> {

    private final SessionFactory factory;

    public EngineDAOImpl(@NotNull final SessionFactory factory){
        this.factory=factory;
    }

    @Override
    public void create(@NotNull final Engine engine) {
        try(final Session session = factory.openSession()){
            session.beginTransaction();
            session.save(engine);
            session.getTransaction().commit();
        }
    }

    @Override
    public Engine read(@NotNull final Integer id) {
        try(final Session session = factory.openSession()){
            final Engine result = session.get(Engine.class, id);
            return result != null ? result : new Engine();
        }
    }

    @Override
    public void update(@NotNull final Engine engine) {
        try(final Session session = factory.openSession()){
            session.beginTransaction();
            session.update(engine);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final Engine engine) {
        try(final Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(engine);
            session.getTransaction().commit();
        }
    }
}
