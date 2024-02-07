package com.control;

import com.to.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.AttributeConverter;

public class HibernateMain {


    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(com.to.Player.class);

        StandardServiceRegistryBuilder builder =
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory factory = configuration.buildSessionFactory(builder.build());

        Session session = factory.openSession();
        Transaction trn = session.beginTransaction();


        Player p1 = new Player(3,"Yasir","PSG",37);

        Player p = session.get(Player.class,1);
        System.out.println(p.getAge());
        if (p.getAge()==25){
            System.out.println("can be updated");
        } else System.out.println("Cant be OOOOOOPS");

        //session.save(p1);
        trn.commit();
        session.close();




    }

}
