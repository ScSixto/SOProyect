package model.deviceManager;

public class DeviceManager {

	
	private Disk disk;
	private Keyboard keyboard;
	private Screen screen;
	
	public DeviceManager() {
		disk = new Disk("");
		keyboard = new Keyboard("");
		screen = new Screen("");
		
	}
	
	public void generateInterruption() {
		
	}

	public Disk getDisk() {
		return disk;
	}

	public void setDisk(Disk disk) {
		this.disk = disk;
	}

	public Keyboard getKeyboard() {
		return keyboard;
	}

	public Screen getScreen() {
		return screen;
	}
}
