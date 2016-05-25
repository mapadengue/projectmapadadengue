package model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "FOCO")
public class Foco {
	@Id
	@GeneratedValue
	private int id;
	private String descricao;
	private int latitude;
	private int longetude;
	@Temporal(TemporalType.DATE)
	private Calendar dataDenuncia;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "DESCRICAO")
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Column(name = "LATITUDE")
	public int getLatitude() {
		return latitude;
	}
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	
	@Column(name = "LONGETUDE")
	public int getLongetude() {
		return longetude;
	}
	public void setLongetude(int longetude) {
		this.longetude = longetude;
	}
	
	@Column(name = "DESCRICAO")
	public Calendar getDataDenuncia() {
		return dataDenuncia;
	}
	public void setDataDenuncia(Calendar dataDenuncia) {
		this.dataDenuncia = dataDenuncia;
	}
	
}
