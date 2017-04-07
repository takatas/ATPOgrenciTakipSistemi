package com.takatas.ots.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.takatas.ots.util.BaseDao;
import com.takatas.ots.util.CinsiyetYilDagilimi;


@Service
public class RaporService {

	
	private static final String CINSIYET_YIL_DAGILIMI=" Select " 
													    +" cast(EXTRACT(YEAR FROM k.dogum_tarihi) as integer ) yil ,  "
													    +" cast(cinsiyet as integer) , "
													    +" cast(count(k.id)  as integer)  as sayisi "
													    +"from kisi as k  group by k.cinsiyet, EXTRACT(YEAR FROM k.dogum_tarihi) "
													    +"order by yil,cinsiyet ";
	
	@Autowired
	private transient BaseDao baseDao;
	
	@SuppressWarnings("rawtypes")
	@Transactional
	public List<CinsiyetYilDagilimi> getCinsiyetYilDagilimiListesi() {
		try {
			Session session = baseDao.getCurrentSession();
			SQLQuery query = session.createSQLQuery(CINSIYET_YIL_DAGILIMI);
			List list = query.list();
			List<CinsiyetYilDagilimi> retList=new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				Object[] el  = (Object[]) list.get(i);
				CinsiyetYilDagilimi d=new CinsiyetYilDagilimi();
				d.setYil(Integer.parseInt(el[0].toString()));
				d.setCinsiyet(Integer.parseInt(el[1].toString()));
				d.setSayisi(Integer.parseInt(el[2].toString()));
				retList.add(d);
			}	
			return retList;
		} catch (Exception e) {
			e.printStackTrace();
		}			
		return null;
	}
	
	
}
