package com.anti.hibarnate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 * 
 *  remove "name" attribute from session-Factory. It is not needed it make error 
 *  <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/sakila?serverTimezone=UTC</property>
 *  kenyszeriteni kell utc hasznaljon 
 *  https://stackoverflow.com/questions/26515700/mysql-jdbc-driver-5-1-33-time-zone-issue
 * https://stackoverflow.com/questions/52728319/cant-set-lower-case-table-names-in-mysql-8-x-on-windows-10
 * https://stackoverflow.com/questions/43716068/invalid-syntax-error-type-myisam-in-ddl-generated-by-hibernate
 */
public class App 
{
    public static void main( String[] args )
     
    {   
    	
    	
        Alien munyi = new Alien();
        AlienName aname = new AlienName();
        
        aname.fname = "Munyi";
        aname.lname = "Manok";
        aname.mname = "Spring";
        
        munyi.setAid(147);
        munyi.setColor("Yellow");
        munyi.setAname(aname);
        
        Alien out;
        
        System.out.println(munyi.toString());
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        
        ServiceRegistry  reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        // nem kötelezö serviceregistry muködik neklkule is 
        SessionFactory sf = con.buildSessionFactory(reg);
       
        //SessionFactory sf = con.buildSessionFactory();
        
        Session session = sf.openSession();
        
    	Transaction tx =   session.beginTransaction();
        session.save(munyi); 
        tx.commit();
        
        
        
        out = (Alien) session.get(Alien.class,  147); 
        System.out.println(out.toString());
        
    }
}
