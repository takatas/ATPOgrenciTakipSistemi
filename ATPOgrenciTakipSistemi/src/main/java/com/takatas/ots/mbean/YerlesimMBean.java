package com.takatas.ots.mbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.takatas.ots.entity.Il;
import com.takatas.ots.entity.Ilce;
import com.takatas.ots.service.YerlesimService;
import com.takatas.ots.util.YerlesimTip;

@Controller("yerlesimMBean")
@Scope("session")
public class YerlesimMBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5719769023659204319L;

	@Autowired
	private transient YerlesimService yerlesimService;
	
	private List<Il> ilListesi;
	private List<Ilce> ilceListesi;
		
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	private void init() {
		ilListesi=yerlesimService.getAll(YerlesimTip.IL);
	}
	
	public List<Il> getIlListesi() {
		return ilListesi;
	}
	
	public List<Ilce> getIlceListesi() {
		return ilceListesi;
	}
	
	public void ilChange(Long id) {
		ilceListesi=yerlesimService.getAllByIlId(id);
	}
}
