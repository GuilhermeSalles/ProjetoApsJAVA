package entities;

import java.util.*;

public class DadosAlunos {

	private String ra;
	private String name;
	private Double nota;
	private Date creantionDate;

	public DadosAlunos() {
	}

	public DadosAlunos(String ra, String name, Double nota, Date creantionDate) {
		this.ra = ra;
		this.name = name;
		this.nota = nota;
		this.creantionDate = creantionDate;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Date getCreantionDate() {
		return creantionDate;
	}

	public void setCreantionDate(Date creantionDate) {
		this.creantionDate = creantionDate;
	}

}
