package edu.amrita.zoomcar.beans;

import java.util.Date;

public class User {
    
    public static final String
    		USER_ID = "USER_ID",
    		PASSWORD = "PASSWORD",
    		USER_NAME = "USER_NAME",
    		GENDER = "GENDER",
    		EMAIL = "EMAIL",
    		PHONE = "PHONE",
    		DOB = "DOB";

    private String userId , password , userName , gender , email , phone;
    private Date dob;
    
    public User() {
    	
    }
    
    public User(String userId , String userName , String password , String gender , String email , String phone , Date dob) {
    	this.userId = userId;
    	this.userName = userName;
    	this.password = password;
    	this.gender = gender;
    	this.email = email;
    	this.phone = phone;
    	this.dob = dob;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
}
