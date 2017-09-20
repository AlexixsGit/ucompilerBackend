package com.itm.ucompiler.model;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Alexis Ortiz
 * @since 2017
 */
@Entity
@Table(name = "users")
@Access(AccessType.FIELD)
public class User extends ParentEntity {

	private static final long serialVersionUID = -5701159148702082140L;

	@Column(name = "user_name", nullable = false, length = 50)
	private String userName;

	@Column(name = "complete_name", length = 100)
	private String completeName;

	@Column(name = "email", length = 100, nullable = false)
	private String email;

	@Column(name = "user_password", length = 500, nullable = false)
	private String userPassword;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birthdate")
	private Date birthdate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sex")
	private AuxData sex;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_status")
	private AuxData userStatus;

	@Column(name = "country", length = 50)
	private String country;

	@Column(name = "institution", length = 60)
	private String institution;

	@Column(name = "course_code", length = 25)
	private String courseCode;

	@Column(name = "photo", length = 500)
	private String photo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "is_email_confirmed", nullable = false)
	private AuxData isEmailConfirmed;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "is_admin", nullable = false)
	private AuxData isAdmin;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "is_superadmin", nullable = false)
	private AuxData isSuperAdmin;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "is_password_temp", nullable = false)
	private AuxData isPasswordTemp;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCompleteName() {
		return completeName;
	}

	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public AuxData getSex() {
		return sex;
	}

	public void setSex(AuxData sex) {
		this.sex = sex;
	}

	public AuxData getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(AuxData userStatus) {
		this.userStatus = userStatus;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public AuxData getIsEmailConfirmed() {
		return isEmailConfirmed;
	}

	public void setIsEmailConfirmed(AuxData isEmailConfirmed) {
		this.isEmailConfirmed = isEmailConfirmed;
	}

	public AuxData getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(AuxData isAdmin) {
		this.isAdmin = isAdmin;
	}

	public AuxData getIsSuperAdmin() {
		return isSuperAdmin;
	}

	public void setIsSuperAdmin(AuxData isSuperAdmin) {
		this.isSuperAdmin = isSuperAdmin;
	}

	public AuxData getIsPasswordTemp() {
		return isPasswordTemp;
	}

	public void setIsPasswordTemp(AuxData isPasswordTemp) {
		this.isPasswordTemp = isPasswordTemp;
	}
}
