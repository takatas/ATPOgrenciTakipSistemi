package com.vektorel.oot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * 
 * @author takatas
 * 
 */
@Entity
@Table(name = "kisi")
@SequenceGenerator(allocationSize = 1, name = "default_id_generator", sequenceName = "seq_kisi")
public class Kisi extends EBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2361328748941723164L;

	private String ad;
	private String soyad;
	private Date dogumTarihi;
	private Long tc;
	private String babaAdi;
	private String anaAdi;
	private Cinsiyet cinsiyet;
	private String acikAdres;
	private String tel;
	private String alternatifTelefon;
	private String mail;
	private String lisansNo;
	private String meslek;
	private Okul okul;
	private KisiTip kisiTip;
	private OgrenciTip ogrenciTip;
	private KanGrubu kanGrubu;
	private Date kayitTarihi;
	
	@SuppressWarnings("unused")
	private String adSoyad;
	@SuppressWarnings("unused")
	private int yas;
	

	@Column(name = "ad", length = 70)
	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	@Column(name = "soyad", length = 70)
	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	@Column(name = "dogum_tarihi")
	@Temporal(TemporalType.DATE)
	public Date getDogumTarihi() {
		return dogumTarihi;
	}

	public void setDogumTarihi(Date dogumTarihi) {
		this.dogumTarihi = dogumTarihi;
	}
	@Column(name = "tc_no")
	public Long getTc() {
		return tc;
	}

	public void setTc(Long tc) {
		this.tc = tc;
	}

	@Column(name = "baba_adi", length = 70)
	public String getBabaAdi() {
		return babaAdi;
	}

	public void setBabaAdi(String babaAdi) {
		this.babaAdi = babaAdi;
	}

	@Column(name = "ana_adi", length = 70)
	public String getAnaAdi() {
		return anaAdi;
	}

	public void setAnaAdi(String anaAdi) {
		this.anaAdi = anaAdi;
	}

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "cinsiyet")
	public Cinsiyet getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(Cinsiyet cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	@Column(name = "acik_adres", length = 400)
	public String getAcikAdres() {
		return acikAdres;
	}

	public void setAcikAdres(String acikAdres) {
		this.acikAdres = acikAdres;
	}

	@Column(name = "tel", length = 20)
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "alternatif_tel", length = 20)
	public String getAlternatifTelefon() {
		return alternatifTelefon;
	}

	public void setAlternatifTelefon(String alternatifTelefon) {
		this.alternatifTelefon = alternatifTelefon;
	}

	@Column(name = "mail_adres", length = 50)
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Column(name = "lisans_no", length = 50)
	public String getLisansNo() {
		return lisansNo;
	}

	public void setLisansNo(String lisansNo) {
		this.lisansNo = lisansNo;
	}

	@Column(name = "meslek", length = 100)	
	public String getMeslek() {
		return meslek;
	}

	public void setMeslek(String meslek) {
		this.meslek = meslek;
	}

	@JoinColumn(name = "mail_adres")
	@ManyToOne(fetch = FetchType.LAZY)
	public Okul getOkul() {
		return okul;
	}

	public void setOkul(Okul okul) {
		this.okul = okul;
	}

	public KisiTip getKisiTip() {
		return kisiTip;
	}

	public void setKisiTip(KisiTip kisiTip) {
		this.kisiTip = kisiTip;
	}

	public OgrenciTip getOgrenciTip() {
		return ogrenciTip;
	}

	public void setOgrenciTip(OgrenciTip ogrenciTip) {
		this.ogrenciTip = ogrenciTip;
	}

	public KanGrubu getKanGrubu() {
		return kanGrubu;
	}

	public void setKanGrubu(KanGrubu kanGrubu) {
		this.kanGrubu = kanGrubu;
	}

	@Column(name = "kayit_tarihi")
	@Temporal(TemporalType.DATE)
	public Date getKayitTarihi() {
		return kayitTarihi;
	}

	public void setKayitTarihi(Date kayitTarihi) {
		this.kayitTarihi = kayitTarihi;
	}

	@Transient
	public String getAdSoyad() {
		return this.ad + " " + this.soyad;
	}

	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}

	@SuppressWarnings("deprecation")
	@Transient
	public int getYas() {
		if (this.dogumTarihi != null) {
			return new Date().getYear() - this.dogumTarihi.getYear();
		}
		return -1;
	}

	public void setYas(int yas) {
		this.yas = yas;
	}

	@Override
	public String toString() {
		return "Kisi{" + "id=" + getId() + "ad=" + ad + ", soyad=" + soyad
				+ ", dogumTarihi=" + dogumTarihi + ", tc=" + tc + ", babaAdi="
				+ babaAdi + ", anaAdi=" + anaAdi + ", cinsiyet=" + cinsiyet
				+ ", acikAdres=" + acikAdres + ", tel=" + tel + ", adSoyad="
				+ getAdSoyad() + ", yas=" + getYas() + '}';
	}

}