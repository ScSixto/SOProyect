package view.memoryManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.memoryManager.Command;

public class JProcessCard extends JPanel {

	private static final Font SCHEDULE_FONT = new Font("Arial", Font.BOLD, 10);

	private static final String PROCESS_SEGMENT_ID_FORMAT = "%s" + "-" + "%s";

	private JPanel segmentsPanel;
	private JPanel container;
	private JButtonFormat sendToVMBtn;

	@SuppressWarnings("unchecked")
	public JProcessCard(Object[] processData, boolean ppalMemory, ActionListener actionListener) {
		this.setName(String.valueOf(processData[0]));
		this.setLayout(new BorderLayout(0, 0));
		this.setOpaque(false);
		this.setBorder(BorderFactory.createEmptyBorder(10, 15, 5, 15));

		this.container = new JPanel(new BorderLayout());
		this.container.setBorder(BorderFactory.createEmptyBorder(3, 7, 10, 7));
		this.container.setBackground(new Color(90, 90, 90));

		JPanel processTitlePanel = new JPanel(new BorderLayout());
		processTitlePanel.setBorder(BorderFactory.createEmptyBorder(5, 7, 3, 5));
		processTitlePanel.setOpaque(false);

		JLabelFormat nameLbl = new JLabelFormat("PID "+String.valueOf(processData[0]) + " (" + ((processData[1] != null)?(String) processData[1]:"Sin nombre") + ")", SCHEDULE_FONT,
				Color.WHITE);
		nameLbl.setHorizontalAlignment(SwingConstants.LEFT);
		processTitlePanel.add(nameLbl, BorderLayout.WEST);

		JLabelFormat sizeLbl = new JLabelFormat(String.valueOf(processData[2]) + " bytes", SCHEDULE_FONT,
				Color.WHITE);
		sizeLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		processTitlePanel.add(sizeLbl, BorderLayout.EAST);

		this.container.add(processTitlePanel, BorderLayout.NORTH);

		segmentsPanel = new JPanel();
		segmentsPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.BLACK));
		segmentsPanel.setOpaque(false);
		segmentsPanel.setLayout(new BoxLayout(segmentsPanel, BoxLayout.Y_AXIS));

		this.container.add(segmentsPanel, BorderLayout.CENTER);

		this.add(this.container, BorderLayout.NORTH);

		for (Object[] segmentData : ((ArrayList<Object[]>) processData[3])) {
				segmentsPanel.add(new JPSegmentCard(String.format(PROCESS_SEGMENT_ID_FORMAT, String.valueOf(processData[0]), String.valueOf(segmentData[0])), (ArrayList<Object[]>) segmentData[1], actionListener));
		}

		sendToVMBtn = new JButtonFormat(new JLabelFormat((ppalMemory)?"Enviar a Memoria virtual":"Enviar a Memoria principal", new Font("Arial", Font.PLAIN, 12), Color.DARK_GRAY), Color.WHITE);
		sendToVMBtn.setName(this.getName());
		sendToVMBtn.addActionListener(actionListener);
		sendToVMBtn.setActionCommand((ppalMemory)?Command.SEND_TO_VIRTUAL_MEMORY.toString():Command.SEND_TO_PRINCIPAL_MEMORY.toString());

		this.container.add(UtilView.createPanelContainer(sendToVMBtn, BorderFactory.createEmptyBorder(5,0,0,0)), BorderLayout.SOUTH);
	}

	public void showSegmentDescription(String componentName) {
		for (Component segmentCard : segmentsPanel.getComponents()) {
			if (segmentCard.getName().equals(componentName)) {
				((JPSegmentCard) segmentCard).showSegmentDescription();
			}
		}
	}

	public void leaveToShowSegmentDescription(String componentName) {
		for (Component segmentCard : segmentsPanel.getComponents()) {
			if (segmentCard.getName().equals(componentName)) {
				((JPSegmentCard) segmentCard).leaveToShowSegmentDescription();
			}
		}
	}

}
