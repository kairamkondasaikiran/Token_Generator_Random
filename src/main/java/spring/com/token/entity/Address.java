package spring.com.token.entity;

public class Address {

	private String house_number;
	private String street;
	private Long pincode;
	private String state;
	private String village;
	private String district;
	public String getHouse_number() {
		return house_number;
	}
	public void setHouse_number(String house_number) {
		this.house_number = house_number;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	@Override
	public String toString() {
		return "Address [house_number=" + house_number + ", street=" + street + ", pincode=" + pincode + ", state="
				+ state + ", village=" + village + ", district=" + district + "]";
	}
	
	
	
}
