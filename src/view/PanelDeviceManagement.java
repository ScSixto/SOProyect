package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PanelDeviceManagement extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelDeviceManagement() {

		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createTitledBorder("Subsistema de gestión de dispositivos"));
	}
}
