package com.batch;

public class LocationList {
	
	int mNumber;
	String userId;
	String mTime;
	String beaconId;
	
	
	
	public LocationList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LocationList(String userId, String mTime,String beaconId){
		this.userId = userId;
		this.mTime = mTime;
		this.beaconId = beaconId;
	}
	public LocationList(int mNumber, String userId, String mTime,
			String beaconId) {
		super();
		this.mNumber = mNumber;
		this.userId = userId;
		this.mTime = mTime;
		this.beaconId = beaconId;
	}
	public int getmNumber() {
		return mNumber;
	}
	public void setmNumber(int mNumber) {
		this.mNumber = mNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getmTime() {
		return mTime;
	}
	public void setmTime(String mTime) {
		this.mTime = mTime;
	}
	public String getBeaconId() {
		return beaconId;
	}
	public void setBeaconId(String beaconId) {
		this.beaconId = beaconId;
	}
	@Override
	public String toString() {
		return  this.mNumber+","+this.userId+"," + this.mTime+","+ this.beaconId;
	}
	
	
	
}
