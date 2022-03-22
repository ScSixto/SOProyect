package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.MainManager;
import view.MainWindow;


public class Controller implements ActionListener{
	
	private MainWindow mainPanel;
	private MainManager mainManager;
	
	public Controller() {
		mainPanel = new MainWindow(this);
		mainManager = new MainManager();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		switch (Actions.valueOf(event.getActionCommand())) {
		case OPEN_FILE:
				System.out.println("Abrir archivo");
			break;
		default:
			break;
		}
	}
}