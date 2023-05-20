package cameraRental;

public class CameraDetails {
	private String brand;
	private String model;
	private float perDayRentalAmount;
	private static int count = 1;
	private int id;
	private String status;


	public CameraDetails(String brand, String model, float PerDayRentalAmount){
		
		this.id = count++;
		this.brand = brand;
		this.model = model;
		this.perDayRentalAmount = PerDayRentalAmount;
		this.status = "Available";
			
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	

	@Override
	public String toString() {
		return id+"\t\t"+brand+"\t\t"+model+"\t"+perDayRentalAmount+"\t\t"+status;
	}

	public int getCount() {
		return count;
	}

//	public void setCount(int count) {
//		this.count = count;
//	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getperDayRentalAmount() {
		return perDayRentalAmount;
	}

	public void setperDayRentalAmount(float perDayRentalAmount) {
		this.perDayRentalAmount = perDayRentalAmount;
	};
	
	

}
