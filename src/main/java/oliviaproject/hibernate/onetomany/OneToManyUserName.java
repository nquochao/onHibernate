package oliviaproject.hibernate.onetomany;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class OneToManyUserName  {
	@Id
    @GeneratedValue

	Integer id;


	@Column(unique = true)
	private String userName;
	private String email;
	private String phone;

	
	private Boolean isConnected;
	private String password;
	 @OneToMany(cascade=CascadeType.ALL,orphanRemoval = true)
	 @JoinColumn(name = "USERNAME_ID")
    private Set<OneToManyChessBoardPreference> preferences;
/**
 * for one to many the external key is on the slave table and reference the owner table.
 * thus we ll have a column USERNAME_ID on OneToManyForeignKeyChessBoardPreference
 * 
 * @return
 */
    public Set<OneToManyChessBoardPreference>  getPreferences() {
		return preferences;
	}

	public void setPreferences(Set<OneToManyChessBoardPreference>  preferences) {
		this.preferences = preferences;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsConnected() {
		return isConnected;
	}

	public void setIsConnected(Boolean isConnected) {
		this.isConnected = isConnected;
	}



}
