package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Actions;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public MainPanel(ActionListener actionListener) {
		
		this.setLayout(new BorderLayout());
		
		JButton openFileButton = new JButton("Abrir archivo");
		customButton(openFileButton);
		openFileButton.addActionListener(actionListener);
		openFileButton.setActionCommand(Actions.OPEN_FILE.name());
		add(openFileButton);
	}
	
	private void customButton(JButton button) {
		button.setFocusable(false);
		button.setBackground(Color.decode("#CCC478"));
		button.setForeground(Color.decode("#000000"));
		button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
	}
}
