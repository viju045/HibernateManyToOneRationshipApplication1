package org.mahagan;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.mahagan.model.Country;
import org.mahagan.model.State;

import java.util.Iterator;
import java.util.List;
//This is my first ManyToOne mapping relationship application in hibernate.
public class ManyToOneRelationshipApplicationFetchDataHB1 {
    public static void main(String[] args) {
        StandardServiceRegistry ssr =  new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata =new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = metadata.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction tsx = session.beginTransaction();

        TypedQuery query = session.createQuery("from Country country");
        List<Country>list = query.getResultList();
        Iterator<Country>iterator = list.listIterator();
        while(iterator.hasNext())
        {
            Country country = iterator.next();
            System.out.println(country.getCountryName()+ " "+country.getPopulation());


                State state = country.getState();
            System.out.println(state.getStateName()+ " "+state.getStatePopulation());
            }
            session.close();
            System.out.println("Fetch data successfully");
        }
    }

