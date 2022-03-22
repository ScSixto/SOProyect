package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.deviceManagement.DeviceManager;
import view.MainWindow;


public class Controller implements ActionListener{
	
	private MainWindow mainWindow;
	private DeviceManager deviceManager;
	
	public Controller() {
		mainWindow = new MainWindow(this);
		deviceManager = new DeviceManager();
		deviceManager.createDevices();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		switch (Actions.valueOf(event.getActionCommand())) {
		case OPEN_FILE:
				mainWindow.changeToPanelResourcesManagement();
			break;
		default:
			break;
		}
	}
}