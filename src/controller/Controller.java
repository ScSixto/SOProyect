package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.MainManager;
import view.JMainFrame;


public class Controller implements ActionListener{
	
	private JMainFrame jMainFrame;
	private MainManager mainManager;
	
	public Controller() {
		jMainFrame = new JMainFrame(this);
		mainManager = new MainManager();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

	

}