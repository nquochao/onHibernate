package oliviaproject.hibernate.onetomany.bidirectional;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
/**
 * @author HaoNguyen
 * this is the best setup. we rely on onetomany and manytoone with mappedby field.
 * in fact the onetomany may be removed and we would use the manytoone + we create the set with query 1
2
3
4
5
6
List<OneToManyBiDirChessboardPreference> preferences = entityManager.createQuery(
    "select pc " +
    "from OneToManyBiDirChessBoardPreference pc " +
    "where pc.username.id = :Id", OneToManyBiDirChessBoardPreference.class)
.setParameter( "Id", 1L )
 */
public class OneToManyBiDirUserName  {
	@Id
    @GeneratedValue

	Integer id;


	@Column(unique = true)
	private String userName;
	private String email;
	private String phone;

	
	private Boolean isConnected;
	private String password;
	 @OneToMany(
		        mappedBy = "userName",
		        cascade = CascadeType.ALL,
		        orphanRemoval = true
		    )
    private Set<OneToManyBiDirChessBoardPreference> preferences;
    public Set<OneToManyBiDirChessBoardPreference>  getPreferences() {
		return preferences;
	}

	public void setPreferences(Set<OneToManyBiDirChessBoardPreference>  preferences) {
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
