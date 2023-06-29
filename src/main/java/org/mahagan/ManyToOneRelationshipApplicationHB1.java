package org.mahagan;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.mahagan.model.Country;
import org.mahagan.model.State;

public class ManyToOneRelationshipApplicationHB1 {
    public static void main(String[] args) {
        StandardServiceRegistry ssr =  new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata =new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = metadata.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction tsx = session.beginTransaction();

        Country country = new Country();
        country.setCountryName("India");
        country.setPopulation("140cr");

        Country country1 = new Country();
        country1.setCountryName("USA");
        country1.setPopulation("20cr");

        Country country2 = new Country();
        country2.setCountryName("China");
        country2.setPopulation("135cr");

        State state = new State();
        state.setStateName("Maharashtra");
        state.setStatePopulation("14cr");

        country.setState(state);
        country1.setState(state);
        country2.setState(state);

        session.persist(country);
        session.persist(country1);
        session.persist(country2);

        tsx.commit();
        session.close();
        System.out.println("Data Has been Successfully saved in DB");
    }
}