package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JPanel panelActual;
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
		
		initPanels(actionListener);
		
		setVisible(true);
	}
	
	private void initPanels(ActionListener actionListener) {
		mainPanel = new MainPanel(actionListener);
		panelFileManager = new PanelFileManager();
		panelMemoryManagement = new PanelMemoryManagement();
		panelProcessManagement = new PanelProcessManagement();
		panelResourcesManagement = new PanelResourcesManagement(actionListener);
		panelDeviceManagement = new PanelDeviceManagement();
		panelActual = mainPanel;
		add(panelActual, BorderLayout.CENTER);
	}
	
	private void changePanel(JPanel newPanel) {
		getContentPane().remove(panelActual);
		panelActual = newPanel;
		add(panelActual, BorderLayout.CENTER);
		getContentPane().revalidate();
		getContentPane().repaint();	
	}

	public void changeToPanelResourcesManagement() {
		changePanel(panelResourcesManagement);
	}
	
	
}