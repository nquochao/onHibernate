package oliviaproject.hibernate.foreignkey.namedquery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@org.hibernate.annotations.NamedQuery(name = "checkCredentials", 
query = "from NamedQueryUserName where userName = :userName and password =:password")
public class NamedQueryUserName  {
	@Id
    @GeneratedValue

	Integer id;


	@Column(unique = true)
	private String userName;
	private String email;
	private String phone;

	
	private Boolean isConnected;
	private String password;
    @OneToOne
    @JoinColumn(name="CHESSBOARD_PREFERENCE_ID")
    //UserName.CHESSBOARD_PREFERENCE_ID column will contain the foreign key
    private NamedQueryChessBoardPreference preference;

	public NamedQueryChessBoardPreference getPreference() {
		return preference;
	}

	public void setPreference(NamedQueryChessBoardPreference preference) {
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
