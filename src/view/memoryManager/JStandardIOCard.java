package view.memoryManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JStandardIOCard extends JPanel {

	private static final Font SCHEDULE_FONT = new Font("Arial", Font.BOLD, 10);

	private JPanel container;

	private JLabelFormat dataLbl;

	public JStandardIOCard(Object[] data, boolean input, ActionListener actionListener) {
		this.setLayout(new BorderLayout(0, 0));
		this.setOpaque(false);
		this.setBorder(BorderFactory.createEmptyBorder(10, 15, 5, 15));

		this.container = new JPanel(new BorderLayout());
		this.container.setBorder(BorderFactory.createEmptyBorder(3, 7, 10, 7));
		this.container.setBackground(new Color(90, 90, 90));

		JPanel processTitlePanel = new JPanel(new BorderLayout());
		processTitlePanel.setBorder(BorderFactory.createEmptyBorder(5, 7, 3, 5));
		processTitlePanel.setOpaque(false);

		JLabelFormat nameLbl = new JLabelFormat(((input)?"Entrada Estandar":"Salida Estandar"), SCHEDULE_FONT, Color.WHITE);
		nameLbl.setHorizontalAlignment(SwingConstants.LEFT);
		processTitlePanel.add(nameLbl, BorderLayout.WEST);

		this.container.add(processTitlePanel, BorderLayout.NORTH);

		JPanel dataPanel = new JPanel();
		dataPanel.setBackground(Color.WHITE);
		dataPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.BLACK));
		dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
		dataLbl = new JLabelFormat(data[0]==null?"[Vacio]":(String)data[0], new Font("Arial", Font.PLAIN, 10), Color.BLACK);
		dataLbl.setBorder(BorderFactory.createEmptyBorder(2,5,15,5));
		dataPanel.add(dataLbl);

		this.container.add(dataPanel, BorderLayout.CENTER);

		this.add(this.container, BorderLayout.NORTH);
	}

	public void refreshData(Object[] data){
		dataLbl.setText((String)data[0]);
	}

}