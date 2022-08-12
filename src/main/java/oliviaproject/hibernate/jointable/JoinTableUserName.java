package oliviaproject.hibernate.jointable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;

@Entity
public class JoinTableUserName  {
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
	  @JoinTable(name = "JOINTABLE_USERNAME_CHESSBOARDPREFERENCE",
	      joinColumns = @JoinColumn(name = "USERNAME_ID"),
	      inverseJoinColumns = @JoinColumn(name = "CHESSBOARD_PREFERENCE_ID"))
    //JOINTABLE_USERNAME_CHESSBOARDPREFERENCE table will link USERNAME_ID with CHESSBOARD_PREFERENCE_ID
    private JoinTableChessBoardPreference preference;

	public JoinTableChessBoardPreference getPreference() {
		return preference;
	}

	public void setPreference(JoinTableChessBoardPreference preference) {
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
