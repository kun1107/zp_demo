package com.incture.zp.demo.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.incture.zp.demo.dto.BaseDto;
import com.incture.zp.demo.entity.BaseDo;

@Repository("BaseDao")
public abstract class BaseDao<E extends BaseDo, D extends BaseDto> {
	@Autowired
	private SessionFactory sessionFactory;
	
//	private static final Logger logger = LoggerFactory.getLogger(BaseDao.class);

	public abstract E importDto(D dto);

	public abstract D exportDto(E entity);

	public Session getSession() {
		try {
			return sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			//logger.error("com.incture.delfi.dao.BaseDao");
			return sessionFactory.openSession();
		}
	}

	public void persist(E entity) {
		try {
			getSession().persist(entity);
		} catch (Exception e) {
			//logger.error("BaseDao persist() exception"+e.getMessage());
		}
	}

	public String save(E entity) {
		String primaryKey = null;
		try {
			primaryKey = (String) getSession().save(entity);
		} catch (Exception e) {
			//logger.error("BaseDao save() exception"+e.getMessage());
		}

		return primaryKey;
	}

	public void update(E entity) {
		try {
			getSession().update(entity);
		} catch (Exception e) {
			//logger.error("BaseDao update() exception"+e.getMessage());
		}
	}

	public void delete(E entity) {
		try {
			getSession().delete(entity);

		} catch (Exception e) {
			//logger.error("BaseDao delete() exception"+e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public E get(E entity) {
		E result = null;
		try {
			Long primaryKey = (Long) entity.getPrimaryKey();
			result = (E) getSession().load(entity.getClass(), primaryKey);

		} catch (Exception e) {
			//logger.error("BaseDao get() exception"+e.getMessage());
		}
		return result;
	}

}
