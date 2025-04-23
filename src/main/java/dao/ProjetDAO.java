
package dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Departement;
import model.Personne;
import model.Projet;
import util.HibernateUtil;

public class ProjetDAO {
	SessionFactory sessionFactory;
	public ProjetDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	public Projet findById(long id) {
		Session session=sessionFactory.openSession();
		Projet p=session.get(Projet.class, id);
		session.close(); 
		return p;
	}
	public boolean create(Projet p) {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		boolean success = false;
		try {
			tx = session.beginTransaction();
			session.persist(p);
			tx.commit();
			success=true;
		}
		catch (Exception e) { 
			if (tx!=null) 
				tx.rollback(); throw e; 
		}
		finally { session.close(); }
		return success;
	}

	public boolean update(Long id, String nom) {
		Session session=sessionFactory.openSession();
		Projet p=session.get(Projet.class, id);
		boolean success = false;
		if(p!=null) {
			p.setNom(nom);
			Transaction tx=null;
			try {
				tx = session.beginTransaction();
				session.persist(p);
				tx.commit();
				success=true;
			} catch (Exception e) { 
				if (tx!=null) 
					tx.rollback(); throw e; 
			}
			finally { session.close(); }
		} 
		return success;
	}
	public boolean delete(long id) {
		Session session=sessionFactory.openSession();
		Projet p=session.get(Projet.class, id);
		boolean success = false;
		if(p!=null) {
			Transaction tx=null;
			try {
				tx = session.beginTransaction();
				session.remove(p);
				tx.commit();
				success=true;
			}
			catch (Exception e) { 
				if (tx!=null) 
				tx.rollback(); throw e; 
			}
			finally { session.close(); }
		}
	return success;
	}


	public List<Projet> findAll(){
		   Session session=sessionFactory.openSession();
		   List<Projet> result = 
		 		session.createQuery("from Projet", Projet.class).getResultList(); 
		   session.close(); 
		   return result;
		
		}

}

