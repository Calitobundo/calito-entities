package calito.bot;

import calito.bot.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EntityTestMain {

    public EntityTestMain() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("calitoPU");
        EntityManager  em = factory.createEntityManager();
        List<User> result = em.createNamedQuery("User.findAll", User.class).getResultList();
        for (User user : result) {
            System.out.println(user.getName());
        }
        em.close();
        factory.close();

    }

    public static void main(String[] args) {

        new EntityTestMain();

    }

}
