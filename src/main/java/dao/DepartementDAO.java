
package dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Departement;
import model.Personne;
import util.HibernateUtil;

public class DepartementDAO {
	SessionFactory sessionFactory;
	public DepartementDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	public Departement findById(long id) {
		Session session=sessionFactory.openSession();
		Departement p=session.get(Departement.class, id);
		session.close(); 
		return p;
	}
	public boolean create(Departement p) {
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
		Departement p=session.get(Departement.class, id);
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
		Departement p=session.get(Departement.class, id);
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


	public List<Departement> findAll(){
		   Session session=sessionFactory.openSession();
		   List<Departement> result = 
		 		session.createQuery("from Departement", Departement.class).getResultList(); 
		   session.close(); 
		   return result;
		
		}

}
