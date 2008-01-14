package embeddedderby;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Richard Scott Smith
 */
@Entity
@Table(name = "Names")
public class Name implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String firstName;
	private String middleName;
	private String lastName;

	/**
	 * Doesn't use autogeneration because that is broken!  Also, there may be 
	 * some problems with <code>long</code> or <code>Long</code>, but I'm not
	 * sure.
	 * @return
	 */
	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}
	 */

	/*
	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Name)) {
			return false;
		}
		Name other = (Name) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
	 */

	
	@Override
	public String toString() {
		//return "embeddedderby.Names[id=" + id + "]";
		return firstName + " " + middleName + " " + lastName;
	}

	@Column (name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column (name = "middle_name")
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column (name = "last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
