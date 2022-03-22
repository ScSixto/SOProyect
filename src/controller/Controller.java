package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.MainManager;
import view.MainWindow;


public class Controller implements ActionListener{
	
	private MainWindow jMainFrame;
	private MainManager mainManager;
	
	public Controller() {
		jMainFrame = new MainWindow(this);
		mainManager = new MainManager();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

	

}