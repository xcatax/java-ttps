package DAOimplements;
	import java.util.ArrayList;
	import java.util.List;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityTransaction;
	import javax.persistence.Query;

	import DAO.GenericDAO;
	import inicio.Factory;


public class GenericDAOimpl<T> implements GenericDAO<T>{

	
		protected Class<T> persistentClass;
		
		public GenericDAOimpl(Class<T> clase) {
			persistentClass = clase;
		}
		 

		@Override
		public T guardar(T entidad) {
			EntityManager em = Factory.getEntityManagerFactory().createEntityManager();
			EntityTransaction tx = null;
			try {
				 tx = em.getTransaction();
				 tx.begin();
				 em.persist(entidad);
				 tx.commit();
			}
			catch (RuntimeException e) {
				 if ( tx != null && tx.isActive() ) 
					 tx.rollback();
				 throw e; 
			}
			finally {
				em.close();
			}
			return entidad; 

		}


}
