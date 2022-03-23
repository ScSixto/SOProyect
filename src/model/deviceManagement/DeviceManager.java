package model.deviceManagement;

public class DeviceManager {
	
	private Device disk;
	private Device keyboard;
	private Device screen;
	
	public DeviceManager() {
		
	}
	
	public void createDevices() {
		disk = new Device("Disco", 1);
		keyboard = new Device("Teclado", 2);
		screen = new Device("Pantalla", 3);
	}
	
	public void generateInterruption() {
		
	}
}
