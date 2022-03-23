package model.deviceManagement;

public class Device {

	private int id;
	private String name;
	private boolean status = true;
	
	public Device(String name, int id) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isStatus() {
		return status;
	}
	
	public void changeStatus() {
		status = !status;
	}
	
}