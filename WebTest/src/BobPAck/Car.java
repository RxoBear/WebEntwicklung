package BobPAck;

import java.io.File;

import com.mysql.cj.jdbc.Blob;

public class Car {

	private String cid;
	private String cname;
	private String color;
	private String speed;
	private String mfdctry;
	private String picture;

	public Car() {
	}

	public Car(String cid, String cname, String color, String speed,
			String mfdctry, String  picture) {
		this.cid = cid;
		this.cname = cname;
		this.color = color;
		this.speed = speed;
		this.mfdctry = mfdctry;
		this.picture = picture;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getMfdctry() {
		return mfdctry;
	}

	public void setMfdctry(String mfdctry) {
		this.mfdctry = mfdctry;
	}
	
	public String  getPicture() {
		return picture;
	}

	public void setPicture(String  picture) {
		this.picture = picture;
	}


}