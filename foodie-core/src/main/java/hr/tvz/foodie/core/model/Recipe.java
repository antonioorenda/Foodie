package hr.tvz.foodie.core.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "IO.Recept")
public class Recipe implements Serializable {

	private Long id;
	private String title;
	private String description;
	private FoodType foodType;
	private int makingTime;
	private String skillLevel;
	private Integer readCount;
	private User user;
	private byte[] image;
	private String imageBase64;
	private Date uploadDate;

	private List<Ingredient> ingredients;
	private List<Stage> stages;

	public Recipe(String title, String description, FoodType foodType, int makingTime, String skillLevel,
				  List<Ingredient> ingredients, List<Stage> stages) {
		this.title = title;
		this.description = description;
		this.foodType = foodType;
		this.makingTime = makingTime;
		this.skillLevel = skillLevel;
		this.ingredients = ingredients;
		this.stages = stages;
	}

	public Recipe() {}

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@Column(name = "Opis")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne(targetEntity = FoodType.class)
	@JoinColumn(name = "IdTipKuhinje")
	public FoodType getFoodType() {
		return foodType;
	}

	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}

	@Column(name = "VrijemePripreme")
	public int getMakingTime() {
		return makingTime;
	}

	public void setMakingTime(int makingTime) {
		this.makingTime = makingTime;
	}

	@Column(name = "PotrebnaVjestina")
	public String getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}

	@ManyToMany(targetEntity = Ingredient.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(name = "IO.ReceptSastojak", joinColumns = {
			@JoinColumn(name = "IdRecept", nullable = false)}, inverseJoinColumns = {
			@JoinColumn(name = "IdSastojak", nullable = false)})
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@ManyToMany(targetEntity = Stage.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(name = "IO.ReceptFaza", joinColumns = {
			@JoinColumn(name = "IdRecept", nullable = false)}, inverseJoinColumns = {
			@JoinColumn(name = "IdFaza", nullable = false)})
	public List<Stage> getStages() {
		return stages;
	}

	public void setStages(List<Stage> stages) {
		this.stages = stages;
	}

	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "IdKorisnik")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "BrojCitanja")
	public Integer getReadCount() {
		return readCount;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}

	@Column(name = "Slika")
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Column(name = "VrijemeUmetanja")
	@Temporal(TemporalType.DATE)
	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	@Transient
	public String getImageBase64() {
		return imageBase64;
	}

	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
	}

	@Override
	public String toString() {
		return "Recipe [title=" + title + ", description=" + description + ", foodType=" + foodType + ", makingTime="
				+ makingTime + ", skillLevel=" + skillLevel + ", ingredients=" + ingredients + ", stages=" + stages +
				"]";
	}

}
