package ru.sapteh.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.EngineDAO;
import ru.sapteh.dao.impl.EngineDAOImpl;


public class Program {
    public static void main(String[] args) {

        SessionFactory factory = null;

        try {

            factory = new Configuration().configure().buildSessionFactory();

            EngineDAO <Engine, Integer> engineDAO = new EngineDAOImpl(factory);


            //Insert value to database
            final Engine engine = new Engine("3-UZ-FE", "400");
            engineDAO.create(engine);

            final Engine result = engineDAO.read(2);
            System.out.println("===============================>");
            System.out.println("Created : " + result);
            System.out.println();

            result.setPower("1000");
            engineDAO.update(result);

            final Engine update = new Engine();
            System.out.println("===============================>");
            System.out.println("Created : " + update);
            System.out.println();

            engineDAO.delete(engineDAO.read(7));

            System.out.println("===============================>");
            System.out.println("Delete(empty obj) : " + engineDAO.read(7));
            System.out.println();






        } finally {
            if(factory != null) {
                factory.close();
            }
        }


    }
}
