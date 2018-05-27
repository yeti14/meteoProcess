package cat.meteo.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="LOG_DADES_METEO")
public class DadesMeteo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "DATA", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@Column(name="ZONA")
	private String zona;
	
	@Column(name="TEMPERATURA")
	private float temperatura;
	
	@Column(name="PRESSIO")
	private float pressio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}

	public float getPressio() {
		return pressio;
	}

	public void setPressio(float pressio) {
		this.pressio = pressio;
	}
	
	

}
