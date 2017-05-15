/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bacedevotees.dao;

import bacedevotees.pojo.Devotee;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DevoteeDao {

	@PersistenceContext
	private EntityManager entitymanager;

	public void save(Devotee devotee) {
		entitymanager.persist(devotee);
	}

	public Devotee saveOrUpdate(Devotee devotee) {
		return entitymanager.merge(devotee);
	}

}
