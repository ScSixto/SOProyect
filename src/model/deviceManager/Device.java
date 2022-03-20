package model.deviceManager;

public class Device {

	private int id;
	private static int count = 1 ;
	private String name;
	private boolean status;
	
	public Device(String name) {
		this.id = count;
		this.name = name;
		count++;
	}

	public int getId() {
		return id;
	}

	public static int getCount() {
		return count;
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
