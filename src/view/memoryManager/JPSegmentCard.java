package view.memoryManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.memoryManager.Command;

public class JPSegmentCard extends JPanel{

    private static final int ARROW_BTON_ICON_HEIGHT = 10;
    private static final String ARROW_UP_ICON_PATH = "src/resources/img/arrowUp.png";
    private static final String ARROW_DOWN_ICON_PATH = "src/resources/img/arrowDown.png";
    
    private JButton segmentButton;
    private JPanel container;
    private JPanel panelDescription;
    private JPanel segmentIndicationsPanel;

    private JPSegmentCard(ActionListener actionListener){
        this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setOpaque(false);
        
        this.container = new JPanel();
        this.container.setLayout(new BorderLayout());
        this.container.setBackground(Color.WHITE);
        this.container.setOpaque(true);
        this.container.setAlignmentX(Component.LEFT_ALIGNMENT);
    }
    
    public JPSegmentCard(String segmentId, ArrayList<Object[]> pageListData, ActionListener actionListener) {
        this(actionListener);
        this.setName(segmentId);
    
        this.addSegmentButton(actionListener);
        
        this.panelDescription = new JPanel();
        this.panelDescription.setLayout(new BoxLayout(panelDescription, BoxLayout.Y_AXIS));
        this.panelDescription.setBorder(BorderFactory.createEmptyBorder(2,0,10,0));
        this.panelDescription.setOpaque(false);
        this.panelDescription.setVisible(false);

        for (Object[] pageData : pageListData) {
            panelDescription.add(new JLabelFormat(String.format("Pagina %s: %s bytes ocupados.", String.valueOf(pageData[0]), String.valueOf(pageData[1])), new Font("Arial", Font.PLAIN, 10), Color.BLACK));
        }

        this.container.add(panelDescription, BorderLayout.SOUTH);

        this.add(container);

        segmentIndicationsPanel = new JPanel(new BorderLayout());
        segmentIndicationsPanel.setOpaque(false);
        segmentIndicationsPanel.setBorder(BorderFactory.createEmptyBorder(0,20,0,15));
        
        panelDescription.add(segmentIndicationsPanel, BorderLayout.NORTH);
    }

    private void addSegmentButton(ActionListener actionListener) {
        segmentButton = new JButtonFormat(new JLabelFormat(this.getName().substring(this.getName().indexOf("-") + 1), new Font("Arial", Font.PLAIN, 12), Color.BLACK));
        segmentButton.setLayout(new BoxLayout(segmentButton, BoxLayout.X_AXIS));
        segmentButton.setBackground(JButtonFormat.NOT_COLOR);
        segmentButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        segmentButton.setOpaque(false);
        segmentButton.setName(this.getName());
        segmentButton.addActionListener(actionListener);
        segmentButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        segmentButton.setActionCommand(Command.SHOW_SEGMENT_DESCRIPTION.toString());

        JLabelFormat arrow = new JLabelFormat(ARROW_DOWN_ICON_PATH, ARROW_BTON_ICON_HEIGHT);
        arrow.setAlignmentX(Component.RIGHT_ALIGNMENT);
        arrow.setBackground(Color.PINK);
        arrow.setOpaque(true);
        segmentButton.add(arrow, BorderLayout.EAST);

        this.container.add(segmentButton, BorderLayout.NORTH);
    }

    public void showSegmentDescription() {
        this.panelDescription.setVisible(true);
        this.segmentButton.setActionCommand(Command.LEAVE_TO_SHOW_SEGMENT_DESCRIPTION.toString());
        ((JLabelFormat)this.segmentButton.getComponent(1)).setIcon(ARROW_UP_ICON_PATH, ARROW_BTON_ICON_HEIGHT);
        this.revalidate();
    }

    public void leaveToShowSegmentDescription() {
        this.panelDescription.setVisible(false);
        this.segmentButton.setActionCommand(Command.SHOW_SEGMENT_DESCRIPTION.toString());
        ((JLabelFormat)this.segmentButton.getComponent(1)).setIcon(ARROW_DOWN_ICON_PATH, ARROW_BTON_ICON_HEIGHT);
        this.revalidate();
    }

}