package view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PanelResourcesManagement extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private ActionListener actionListener;
	
	public PanelResourcesManagement(ActionListener actionListener) {

		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createTitledBorder("Subsistema de gestión de recursos"));
		this.actionListener = actionListener;
		
	}

}
