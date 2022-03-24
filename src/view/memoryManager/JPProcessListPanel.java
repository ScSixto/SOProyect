package view.memoryManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JPProcessListPanel extends JPanel{

    private static final Font TITLE_FONT = new Font("Arial", Font.BOLD, 20);

    private JLabelFormat title;
    private JPanel processListPanel;
    private ActionListener actionListener;

    public JPProcessListPanel(ActionListener actionListener){
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(20, 0, 5, 0));

        this.actionListener = actionListener;
        
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setOpaque(false);
        this.title = new JLabelFormat(UtilView.EMPTY_STRING, TITLE_FONT, Color.DARK_GRAY);
        this.title.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        titlePanel.add(title, BorderLayout.NORTH);
        
        this.add(titlePanel, BorderLayout.NORTH);

        processListPanel = new JPanel();
        processListPanel.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));
        processListPanel.setOpaque(false);
        processListPanel.setLayout(new BoxLayout(processListPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(processListPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setOpaque(false);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, this.getHeight()));
        scrollPane.setWheelScrollingEnabled(true);
		scrollPane.setHorizontalScrollBar(null);
		
        this.add(scrollPane, BorderLayout.CENTER);
        // this.add(UtilView.createPanelContainer(processListPanel, BorderFactory.createEmptyBorder()), BorderLayout.CENTER);
    }

    public void showProcessList(ArrayList<Object[]> processListData) {
        this.processListPanel.removeAll();
        
        this.title.setText("Memoria Virtual");
        for (Object[] processData : processListData) {
            this.processListPanel.add(new JProcessCard(processData, false, this.actionListener));
        }
    }

    public void showProcessList(ArrayList<Object[]> processListData, Object[] standardInputData, Object[] standardOutputData, ArrayList<Object[]> directoryEntryData) {
        this.processListPanel.removeAll();
        this.processListPanel.add(new JStandardIOCard(standardInputData, true, actionListener));
        this.processListPanel.add(new JStandardIOCard(standardOutputData, false, actionListener));
        this.processListPanel.add(new JPDirectoryEntry(directoryEntryData, actionListener));
        this.title.setText("Memoria Principal");
            for (Object[] processData : processListData) {
            this.processListPanel.add(new JProcessCard(processData, true, this.actionListener));
        }
    }

    public void showSegmentDescription(String componentName) {
        for (Component processCard : this.processListPanel.getComponents()) {
            if(processCard.getName().equals(componentName.split("-")[0])){
                ((JProcessCard)processCard).showSegmentDescription(componentName);
            }
        }
    }

    public void leaveToShowSegmentDescription(String componentName) {
        for (Component processCard : this.processListPanel.getComponents()) {
            if(processCard.getName().equals(componentName.split("-")[0])){
                ((JProcessCard)processCard).leaveToShowSegmentDescription(componentName);
            }
        }
    }

    public void leaveToShow(){
        this.processListPanel.removeAll();
    }

    public void removeProcess(String processId) {
        for (Component processCard : this.processListPanel.getComponents()) {
            if(processCard.getName().equals(processId.split("-")[0])){
                remove(processCard);
            }
        }
    }

    // @Override
    // public void paint(Graphics g) {
    //     g.setColor(UtilView.TRANSPARENT_VINO_TINTO_COLOR);
    //     g.fillRect(7, 0, (int)(getWidth() / 4), getHeight());
    //     g.fillRect(0, 12, getWidth(), 60);
    //     g.setColor(UtilView.TRANSPARENT_BLACK_COLOR);
    //     g.fillRect(0, 12, getWidth(), 60);
    //     super.paint(g);
    // }
}
