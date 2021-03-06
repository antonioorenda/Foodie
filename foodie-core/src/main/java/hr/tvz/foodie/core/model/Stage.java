package hr.tvz.foodie.core.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Sifra.Faza")
public class Stage implements Serializable {

	private static final long serialVersionUID = 7686657836435086581L;

	private int id;
	private String stage;
	
	public Stage(String stage) {
		this.stage = stage;
	}
	
	public Stage() {
	}

	@Id
	@Column(name = "Id")
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "Faza")
	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	@Override
	public String toString() {
		return "Stage [Stage=" + stage + "]";
	}

}
