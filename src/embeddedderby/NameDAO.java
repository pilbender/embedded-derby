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
		// We need to make sure we don't insert a duplicate!!
		em.persist(name);
		em.getTransaction().commit();
	}

	public Name getName(Name name) {
		em.getTransaction().begin();
		name = em.find(Name.class, name.getId());
		em.getTransaction().commit();
		return name;
	}

	public void updateName(Name name) {
		em.getTransaction().begin();
		em.merge(name);
		em.getTransaction().commit();
	}

	public void deleteName(Name name) {
		em.getTransaction().begin();
		/* This find command is needed because the object is detached prior
		to this find command.  I don't know why merge doesn't work for 
		this.  It's just one of those things.
		 */
		name = em.find(Name.class, name.getId());
		em.remove(name);
		em.getTransaction().commit();
	}

	/**
	 * Returns a <code>List</code> object containing all the names.
	 * @return
	 */
	public List<Name> getAllNames() {
		Query query = em.createNativeQuery("select * from names");
		return query.getResultList();
	}
}
