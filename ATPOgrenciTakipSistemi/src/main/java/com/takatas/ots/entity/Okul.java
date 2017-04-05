package com.takatas.ots.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "okul")
@SequenceGenerator(allocationSize = 1, name = "default_id_generator", sequenceName = "seq_okul")
public class Okul extends EBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1343265989077217183L;

	private String okulAd;
	private String sinif;
	private String okulNo;

	@Column(name = "okul_ad", length = 100)
	public String getOkulAd() {
		return okulAd;
	}

	public void setOkulAd(String okulAd) {
		this.okulAd = okulAd;
	}

	@Column(name = "sinif", length = 5)
	public String getSinif() {
		return sinif;
	}

	public void setSinif(String sinif) {
		this.sinif = sinif;
	}

	@Column(name = "okul_no", length = 30)
	public String getOkulNo() {
		return okulNo;
	}

	public void setOkulNo(String okulNo) {
		this.okulNo = okulNo;
	}

}
