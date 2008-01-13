package embeddedderby;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Richard Scott Smith
 */
public class NameDAO {
	private Name name;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("embedded-derbyPU");
	EntityManager em = emf.createEntityManager();

	public void addName(Name name) {
		em.getTransaction().begin();
		em.persist(name);
		em.getTransaction().commit();
	}

	public Name getName(Name name) {
		return em.find(Name.class, name.getFirstName());
	}

	public void updateName(Name name) {
		em.getTransaction().begin();
		em.merge(name);
		em.getTransaction().commit();
	}

	public void deleteName(Name name) {
		em.getTransaction().begin();
		name = em.find(Name.class, name.getFirstName());
		em.remove(name);
		em.getTransaction().commit();
	}

	public List<Name> getAllNames() {
		Query query = em.createNativeQuery("select * from names");
		return query.getResultList();
	}

}
