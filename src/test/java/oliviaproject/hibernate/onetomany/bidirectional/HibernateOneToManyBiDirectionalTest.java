package oliviaproject.hibernate.onetomany.bidirectional;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;
import oliviaproject.hibernate.onetomany.OneToManyChessBoardPreference;
import oliviaproject.hibernate.onetomany.OneToManyUserName;

/**
 * @author HaoNguyen This junit test is to show the necessity to commit the
 *         transaction to see the changes in the database.
 * 
 */
public class HibernateOneToManyBiDirectionalTest extends TestCase {
	private static final Logger log = LoggerFactory.getLogger(HibernateOneToManyBiDirectionalTest.class);

	private static SessionFactory factory;

	public void setUp() {
		try {

			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			;
		} catch (Throwable ex) {
			log.error("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void testOneToOneNotCommitted() {
		Session session = factory.openSession();
		Transaction tx = null;

		OneToManyBiDirChessBoardPreference preference = new OneToManyBiDirChessBoardPreference();
		preference.setChesswidth(80);

// Add new username object
		OneToManyBiDirUserName userName = new OneToManyBiDirUserName();
		userName.setEmail("demo-user@mail.com");
		userName.setUserName("olivia");

// Save preference
		session.persist(preference);

		assertNotNull(preference.getId());

// Save username
		Set<OneToManyBiDirChessBoardPreference> preferences = new HashSet<>();
		preferences.add(preference);
		userName.setPreferences(preferences);
		session.persist(userName);
		assertNotNull(userName.getId());

		assertNotNull(preference.getId());
	}

	public static void testOneToOneAndCommitTx() {
		Session session = factory.openSession();
		/**
		 * 
		 * tx is needed to commit to database
		 */
		Transaction tx = session.beginTransaction();

		OneToManyBiDirChessBoardPreference preference = new OneToManyBiDirChessBoardPreference();
		preference.setChesswidth(80);

		OneToManyBiDirUserName userName = new OneToManyBiDirUserName();
		userName.setEmail("demo-user@mail.com");
		userName.setUserName("olivia");

		session.persist(preference);

		assertNotNull(preference.getId());

		Set<OneToManyBiDirChessBoardPreference> preferences = new HashSet<>();
		preferences.add(preference);
		userName.setPreferences(preferences);
		/**
		 * Query is not fired here.Object is made persistent. Data for user now
		 * available in first level cache but not in db.
		 */
		session.persist(userName);
		/**
		 * 
		 * So, it is always better to use Persist() rather than Save() as save has to be
		 * carefully used when dealing with Transient object
		 */
		assertNotNull(userName.getId());

		assertNotNull(preference.getId());
		/**
		 * Query will be fired at this point and data for user will now also be
		 * available in DB
		 * 
		 */
		session.getTransaction().commit();
		/**
		 * 
		 * if you play twice you need to change the userName Caused by:
		 * java.sql.SQLIntegrityConstraintViolationException: ORA-00001: unique
		 * constraint (CALYPSO_161.UK_APNNTI2FQ7NWY851I8QQATYT7) violated This is
		 * because {link UserName.userName gets the annotation: @Column(unique = true)
		 *
		 */

		session.close();
	}
}