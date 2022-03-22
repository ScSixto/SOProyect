package view;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class PanelResourcesManagement extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private ActionListener actionListener;
	
	public PanelResourcesManagement(ActionListener actionListener) {

		this.actionListener = actionListener;
	}

}
