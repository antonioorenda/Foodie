package hr.tvz.foodie.core.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "IO.Sastojak")
public class Ingredient implements Serializable {
	
	private static final long serialVersionUID = -6116433666342582670L;

	private int id;
	private String title;
	private int amount;

	public Ingredient(String title) {
		this.title = title;
	}
	
	public Ingredient() {}

	@Id
	@Column(name = "Id")
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "Kolicina")
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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
		return "Ingredient [title=" + title + ", amount=" + amount + "]";
	}
	
}
