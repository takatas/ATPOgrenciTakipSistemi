package com.takatas.ots.service;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.takatas.ots.entity.Kisi;
import com.takatas.ots.entity.Okul;
import com.takatas.ots.util.BaseDao;
import com.takatas.ots.util.HRException;
import com.takatas.ots.util.OrderUtil;
import com.takatas.ots.util.PagingResult;

/**
 * 
 * @author takatas
 * 
 */
@Service
public class OkulService {

	@Autowired
	private transient BaseDao baseDao;

	public boolean save(Okul entity) throws Exception {
		if (entity.getOkulAd() == null || entity.getOkulAd().trim().equals("")) {
			throw new HRException("Okul Adý Boþ Olmamalýdýr");
		}

		baseDao.save(entity);
		return true;
	}

	@Async
	public void asyncMetod() {
		for (int i = 0; i < 1000000; i++) {
			System.out.println("Mesaj" + i);
		}

	}

	public boolean update(Okul entity) throws Exception {
		if (entity.getOkulAd() == null || entity.getOkulAd().trim().equals("")) {
			throw new HRException("Okul Adý Boþ Olmamalýdýr");
		}
		baseDao.update(entity);
		return true;
	}

	public boolean delete(Okul entity) {
		baseDao.delete(entity);
		return true;
	}

	public boolean delete(Long entityId) {
		baseDao.delete(entityId, Okul.class);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Okul> getAll(String query) {
		return baseDao.getAll(Okul.class);
	}

	public Okul getById(Long id) {
		return (Okul) baseDao.getById(id, Okul.class);
	}

	@Transactional
	public Okul getByTC(String okulAd, String okulNo) {
		Session session = baseDao.getCurrentSession();
		Criteria criteria = session.createCriteria(Okul.class);
		criteria.add(Restrictions.eq("okulAd", okulAd));
		criteria.add(Restrictions.eq("okulNo", okulNo));
		return (Okul) criteria.uniqueResult();
	}

	@Transactional
	public PagingResult getByPaging(int first, int pageSize,
			Map<String, Object> filters, OrderUtil order) {
		PagingResult result = new PagingResult();
		Session session = baseDao.getCurrentSession();
		Criteria criteria = session.createCriteria(Okul.class);

		criteria.setProjection(Projections.rowCount());
		result.setRowCount((Long) criteria.uniqueResult());

		criteria.setProjection(null);
		criteria.setFirstResult(first);
		criteria.setMaxResults(pageSize);

		if (order.getField() != null) {
			if (order.getOrderType() == OrderUtil.OrderType.ASC)
				criteria.addOrder(Order.asc(order.getField()));
			else
				criteria.addOrder(Order.desc(order.getField()));
		}

		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		result.setList(criteria.list());
		return result;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Transactional
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Okul> acomp(String query) {
		Session session = baseDao.getCurrentSession();
		Criteria criteria = session.createCriteria(Kisi.class);
		criteria.add(Restrictions.or(
				Restrictions.ilike("ad", query, MatchMode.ANYWHERE),
				Restrictions.ilike("soyad", query, MatchMode.ANYWHERE)));

		criteria.setMaxResults(15);
		List lst = criteria.list();
		return lst;
	}
}
