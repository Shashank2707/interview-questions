package com.test.lld.question.carrentaldesign;

public class User {

    int userId;
    int userName;
    int drivingLicense;
    Location location;

    public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserName() {
        return userName;
    }

    public void setUserName(int userName) {
        this.userName = userName;
    }

    public int getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(int drivingLicense) {
        this.drivingLicense = drivingLicense;
    }
}
