package soac.miniprojet.model.beans;
// Generated 7 janv. 2020 11:56:55 by Hibernate Tools 5.4.7.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * InscriptionPeriod generated by hbm2java
 */
public class InscriptionPeriod implements java.io.Serializable {

	private Integer id;
	private Date startInscDate;
	private Date endInscDate;
	private Date startReinscDate;
	private Date endReinscDate;

	public InscriptionPeriod() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStartInscDate() {
		return this.startInscDate;
	}

	public void setStartInscDate(Date startInscDate) {
		this.startInscDate = startInscDate;
	}

	public Date getEndInscDate() {
		return this.endInscDate;
	}

	public void setEndInscDate(Date endInscDate) {
		this.endInscDate = endInscDate;
	}

	public Date getStartReinscDate() {
		return this.startReinscDate;
	}

	public void setStartReinscDate(Date startReinscDate) {
		this.startReinscDate = startReinscDate;
	}

	public Date getEndReinscDate() {
		return this.endReinscDate;
	}

	public void setEndReinscDate(Date endReinscDate) {
		this.endReinscDate = endReinscDate;
	}

}
