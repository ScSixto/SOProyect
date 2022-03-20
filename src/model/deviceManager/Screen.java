package model.deviceManager;

import javax.swing.JOptionPane;

public class Screen extends Device{

	public Screen(String name) {
		super(name);
	}

	public void showMessage(String message) {
		this.changeStatus();
		JOptionPane.showMessageDialog(null, message);
	}

}
