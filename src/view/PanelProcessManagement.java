package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PanelProcessManagement extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public PanelProcessManagement() {
		
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createTitledBorder("Subsistema de gestión de procesos"));
	}

}
