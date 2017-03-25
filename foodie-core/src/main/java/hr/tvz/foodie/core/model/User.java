package hr.tvz.foodie.core.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "IO.Korisnik")
public class User implements Serializable {

	private static final long serialVersionUID = -5319116409546825712L;

	private int id;
	private String username;
	private String password;
	private String email;
	private Date dateRegistered;
	private Boolean isAdminUser;

	private List<Ingredient> allergens;

	public User(String username, String password, String email, Timestamp dateRegistered) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.dateRegistered = dateRegistered;
	}

	public User() {}

	@Id
	@Column(name = "Id")
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "Username", unique = true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "Password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "Email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "VrijemeRegistracije")
	public Date getDateRegistered() {
		return dateRegistered;
	}

	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}

	@Column(name = "IsAdmin")
	public Boolean getIsAdminUser() {
		return isAdminUser;
	}

	public void setIsAdminUser(Boolean isAdminUser) {
		this.isAdminUser = isAdminUser;
	}

	@ManyToMany(targetEntity = Ingredient.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "IO.KorisnikAlergen", joinColumns = {
			@JoinColumn(name = "IdKorisnik", nullable = false)}, inverseJoinColumns = {
			@JoinColumn(name = "IdSastojak", nullable = false) })
	public List<Ingredient> getAllergens() {
		return allergens;
	}

	public void setAllergens(List<Ingredient> allergens) {
		this.allergens = allergens;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", dateRegistered="
				+ dateRegistered + ", isAdminUser=" + isAdminUser + ", allergens=" + allergens + "]";
	}

}
