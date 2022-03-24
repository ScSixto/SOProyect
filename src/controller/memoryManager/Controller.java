package controller.memoryManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;

import model.memoryManager.MemoryManager;
import view.memoryManager.JFramePpal;

public class Controller implements ActionListener, MyMemoryObservable{

    private MemoryManager memory;
    private JFramePpal view;

    public Controller(){
        this.memory = new MemoryManager(50, 100);
        view = new JFramePpal(this);
        memory.addPCB(memory.createPCB(1, 720, new ArrayList<String>(Arrays.asList("Linea1", "Linea2", "Linea3"))));
        showMemoryPanel();
        saveStandardInput("data");
        saveDirectoryEntry("suma.exe", "root/Carpeta1/carpeta2/suma.exe");
        saveStandardOutput("data2");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Command.valueOf(e.getActionCommand())) {
            case LEAVE_TO_SHOW_SEGMENT_DESCRIPTION:
                leaveToShowSegmentDescription(((JButton)(e.getSource())).getName());
                break;
            case SHOW_SEGMENT_DESCRIPTION:
                showSegmentDescription(((JButton)(e.getSource())).getName());
                break;
            case SEND_TO_VIRTUAL_MEMORY:
                sendToVirtualMemory(((JButton)(e.getSource())).getName());
                break;
            case SEND_TO_PRINCIPAL_MEMORY:
                sendToPrincipalMemory(((JButton)(e.getSource())).getName());
                break;
        }
    }

    private void sendToVirtualMemory(String processId) {
        memory.sendToVirtualMemory(Integer.parseInt(processId));
        showMemoryPanel();
    }

    private void sendToPrincipalMemory(String processId) {
        memory.sendToPrincipalMemory(Integer.parseInt(processId));
        showMemoryPanel();
    }

    private void leaveToShowSegmentDescription(String segmentName) {
        view.leaveToShowSegmentDescription(segmentName);
        
    }

    private void showSegmentDescription(String segmentName) {
        view.showSegmentDescription(segmentName);
    }

    private void showMemoryPanel() {
        view.showMemoryPanel(memory.getPpalMemoryData(), memory.getVirtualProcessListData());
    }

    @Override
    public void saveDirectoryEntry(String name, String fullpath) {
       memory.saveDirectoryEntry(name, fullpath);
       showMemoryPanel();
    }

    @Override
    public void removeDirectoryEntry() {
        memory.removeDirectoryEntry();
    }

    @Override
    public void loadMemoryData(ArrayList<String> instructionsList) {
        // TODO Auto-generated method stub   
    }

    @Override
    public void saveStandardInput(String data) {
        memory.saveStandardInput(data);
        showMemoryPanel();
        // Avisar al procesador
    }

    @Override
    public void saveStandardOutput(String data) {
        memory.saveStandardOutput(data);
        showMemoryPanel();
        // Avisar a recursos
    }

    @Override
    public String readStandardInput() {
        return memory.readStandardInput();
    }

    @Override
    public String readStandardOutput() {
        return memory.readStandardOutput();
    }

    @Override
    public void enterStandardOutputToProcessData() {
        
    }

    public static void main(String[] args) {
        new Controller();
    }
    
}
