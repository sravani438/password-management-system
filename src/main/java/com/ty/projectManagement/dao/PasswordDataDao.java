package com.ty.projectManagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.projectManagement.dto.PasswordData;



public class PasswordDataDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void savePasswordData(PasswordData user) {
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
	}

	public List<PasswordData> getPasswordDataByEmailAndPassword(String email, String password) {
		Query query = entityManager.createQuery("select u from PasswordData u where u.email= ?1 and u.password= ?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<PasswordData> user =query.getResultList() ;
				if(user.size()>0) {
			return user;
		}
		else {
			return null;
		}
	}

	public List<PasswordData> getAllPasswordDatasDetails() {
		Query query = entityManager.createQuery("Select u from PasswordData u", PasswordData.class);
		return query.getResultList();
	}

	public PasswordData getPasswordDataById(int id) {
		return entityManager.find(PasswordData.class, id);
	}

	public PasswordData deletePasswordDataById(int id) {
		PasswordData user = entityManager.find(PasswordData.class, id);
		entityTransaction.begin();
		entityManager.remove(user);
		entityTransaction.commit();
		return user;
	}

	public PasswordData updatePasswordDataById(PasswordData passwordData) {
		entityTransaction.begin();
		entityManager.merge(passwordData);
		entityTransaction.commit();
		return passwordData;
	}

}
