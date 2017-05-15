/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bacedevotees.pojo;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author ashish
 */
@Entity
@Table
public class Devotee implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "dob")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dob;
	
	@Column(name = "permanentAddress")
	private String permanentAddress;
	
	@Column(name = "currentAddress")
	private String currentAddress;
	
	@Column(name = "mobileNumber")
	private String mobileNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "fatherName")
	private String fatherName;
	
	@Column(name = "emergencyNumber")
	private String emergencyNumber;
	
	@Column(name = "baceJoinDate")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date baceJoinDate;
	
	@Column(name = "baceLeftDate")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date baceLeftDate;
	
	private static final long serialVersionUID = 947152066071669636L;

	public Devotee() {
	}

	public Devotee(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getEmergencyNumber() {
		return emergencyNumber;
	}

	public void setEmergencyNumber(String emergencyNumber) {
		this.emergencyNumber = emergencyNumber;
	}

	public Date getBaceJoinDate() {
		return baceJoinDate;
	}

	public void setBaceJoinDate(Date baceJoinDate) {
		this.baceJoinDate = baceJoinDate;
	}
	
	public Date getBaceLeftDate() {
		return baceLeftDate;
	}

	public void setBaceLeftDate(Date baceLeftDate) {
		this.baceLeftDate = baceLeftDate;
	}

}