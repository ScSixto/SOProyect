package view.memoryManager;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JFramePpal extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int WIDTH = (int) SCREEN_SIZE.getWidth();
    public static final int HEIGHT = (int) SCREEN_SIZE.getHeight();

    public static final String FRAME_TITLE_TEXT = "Gestión de Memoria";

    private JPMainPanel mainPanel;

    public JFramePpal(ActionListener act){
        super(FRAME_TITLE_TEXT);
        this.setMinimumSize(new Dimension(700/*1250*/,600/*400*/));
        this.initComponents(act);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void initComponents(ActionListener act){
        this.mainPanel = new JPMainPanel(act);
        this.add(this.mainPanel);
    }

    public void addScrollBar(){
        JScrollPane scrollPane = new JScrollPane(this.mainPanel);
        this.add(scrollPane);
    }
    
    public void showMemoryPanel(Object[] ppalMemoryData , ArrayList<Object[]> virtualMemoryData) {
        mainPanel.showMemoryPanel(ppalMemoryData, virtualMemoryData);
    }

    public void leaveToShowSegmentDescription(String segmentName) {
        mainPanel.leaveToShowSegmentDescription(segmentName);
    }

    public void showSegmentDescription(String segmentName) {
        mainPanel.showSegmentDescription(segmentName);
    }
}