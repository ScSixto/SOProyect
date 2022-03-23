package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Actions;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public MainPanel(ActionListener actionListener) {
		
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createTitledBorder("Usuario"));
		this.setLayout(new FlowLayout());
		
		JButton openFileButton = new JButton("Abrir archivo");
		customButton(openFileButton);
		openFileButton.addActionListener(actionListener);
		openFileButton.setActionCommand(Actions.OPEN_FILE.name());
		add(openFileButton);
	}
	
	private void customButton(JButton button) {
		button.setPreferredSize(new Dimension(200, 50));
		button.setFocusable(false);
		button.setBackground(Color.decode("#4D96FF"));
		button.setForeground(Color.decode("#FFFFFF"));
		button.setFont(new Font("SansSerif", Font.BOLD, 20));
		button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.setBorderPainted(false);
	}
}
