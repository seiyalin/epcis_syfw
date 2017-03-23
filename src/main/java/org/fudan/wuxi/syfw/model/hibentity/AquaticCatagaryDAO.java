package org.fudan.wuxi.syfw.model.hibentity;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * AquaticCatagary entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.fudan.wuxi.syfw.model.hibentity.AquaticCatagary
 * @author MyEclipse Persistence Tools
 */
public class AquaticCatagaryDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AquaticCatagaryDAO.class);
	// property constants
	public static final String NAME = "name";

	public void save(AquaticCatagary transientInstance) {
		log.debug("saving AquaticCatagary instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AquaticCatagary persistentInstance) {
		log.debug("deleting AquaticCatagary instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AquaticCatagary findById(java.lang.String id) {
		log.debug("getting AquaticCatagary instance with id: " + id);
		try {
			AquaticCatagary instance = (AquaticCatagary) getSession().get(
					"org.fudan.wuxi.syfw.model.hibentity.AquaticCatagary", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AquaticCatagary instance) {
		log.debug("finding AquaticCatagary instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"org.fudan.wuxi.syfw.model.hibentity.AquaticCatagary")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding AquaticCatagary instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AquaticCatagary as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findAll() {
		log.debug("finding all AquaticCatagary instances");
		try {
			String queryString = "from AquaticCatagary";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AquaticCatagary merge(AquaticCatagary detachedInstance) {
		log.debug("merging AquaticCatagary instance");
		try {
			AquaticCatagary result = (AquaticCatagary) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AquaticCatagary instance) {
		log.debug("attaching dirty AquaticCatagary instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AquaticCatagary instance) {
		log.debug("attaching clean AquaticCatagary instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}