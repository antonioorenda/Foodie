package hr.tvz.foodie.core.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Sifra.TipKuhinje")
public class FoodType implements Serializable {

	private Long id;
	private String title;

	public FoodType(String id) {
		this.id = new Long(id);
	}

	public FoodType() {}

	@Id
	@Column(name = "Id")
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "Naziv")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "FoodType [id=" + id + ", title=" + title + "]";
	}
	
}
