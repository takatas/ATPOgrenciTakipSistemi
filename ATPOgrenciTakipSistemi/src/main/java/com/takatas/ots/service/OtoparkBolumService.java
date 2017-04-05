package com.takatas.ots.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.takatas.ots.entity.OtoparkBolum;
import com.takatas.ots.util.BaseDao;
import com.takatas.ots.util.HRException;
import com.takatas.ots.util.PagingResult;

/**
 * 
 * @author takatas
 * 
 */

@Service
public class OtoparkBolumService {

	@Autowired
	private transient BaseDao baseDao;

	public boolean save(OtoparkBolum entity) throws Exception {

		if (entity.getTanim() == null || entity.getTanim().trim().equals("")) {
			throw new HRException("Taným Boþ Olmamalýdýr");
		}

		baseDao.save(entity);

		return true;

	}

	public boolean update(OtoparkBolum entity) throws Exception {

		if (entity.getTanim() == null || entity.getTanim().trim().equals("")) {
			throw new HRException("Taným Boþ Olmamalýdýr");
		}
		baseDao.update(entity);
		return true;

	}

	public boolean delete(OtoparkBolum entity) throws Exception {

		baseDao.delete(entity);
		return true;

	}

	public boolean delete(Long entityId) throws Exception {

		baseDao.delete(entityId, OtoparkBolum.class);
		return true;

	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<OtoparkBolum> getAll(String query) {

		return baseDao.getAll(OtoparkBolum.class);

	}
	
	@Transactional
	public OtoparkBolum getById(Long id) {
		return (OtoparkBolum) baseDao.getById(id, OtoparkBolum.class);
	}
	

	@Transactional
	public PagingResult getByPaging(int first, int pageSize, Map<String, Object> filters) {
		return baseDao.getByPaging(OtoparkBolum.class, first, pageSize, filters);
	}
	

}
