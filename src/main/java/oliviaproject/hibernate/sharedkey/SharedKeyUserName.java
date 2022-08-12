package oliviaproject.hibernate.sharedkey;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class SharedKeyUserName  {
	@Id
    @GeneratedValue
	Integer id;


	@Column(unique = true)
	private String userName;
	private String email;
	private String phone;

	
	private Boolean isConnected;
	private String password;
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private SharedKeyChessBoardPreference preference;

	public SharedKeyChessBoardPreference getPreference() {
		return preference;
	}

	public void setPreference(SharedKeyChessBoardPreference preference) {
		this.preference = preference;
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
