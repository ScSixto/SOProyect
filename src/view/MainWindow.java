package view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class MainWindow extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private MainPanel mainPanel;
	private PanelFileManager panelFileManager;
	private PanelMemoryManagement panelMemoryManagement;
	private PanelProcessManagement panelProcessManagement;
	private PanelResourcesManagement panelResourcesManagement;
	private PanelDeviceManagement panelDeviceManagement;

	public MainWindow(ActionListener actionListener) {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Extreme Battle");
		setMinimumSize(new Dimension(950, 680));
		setLocationRelativeTo(null);
		
		
	}
	
	
	
	
}