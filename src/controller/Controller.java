package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.MainManager;
import view.MainWindow;


public class Controller implements ActionListener{
	
	private MainWindow mainWindow;
	private MainManager mainManager;
	
	public Controller() {
		mainWindow = new MainWindow(this);
		mainManager = new MainManager();
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