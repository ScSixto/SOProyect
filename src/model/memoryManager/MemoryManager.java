package model.memoryManager;

import java.util.ArrayList;

public class MemoryManager{
    
    private Memory ppalMemory;
    private VirtualMemory virtualMemory;
    private DirectoryEntry directoryEntry;
    private String standardInput;
    private String standardOutput;

    public MemoryManager(int pageSize, int segmentSize){
        ppalMemory = new Memory(pageSize, segmentSize);
        virtualMemory = new VirtualMemory(pageSize, segmentSize);
        directoryEntry = new DirectoryEntry();
    }

    public void sendToVirtualMemory(int processId){
        for (PCB pcb : ppalMemory.getPCBList()) {
            if(pcb.getId() == processId){
                Buffer.sendProcessToVirtualMemory(pcb, virtualMemory);
                ppalMemory.removePCB(processId);
                break;
            }
        }
    }

    public void sendToPrincipalMemory(int processId){
        for (PCB pcb : virtualMemory.getPCBList()) {
            if(pcb.getId() == processId){
                Buffer.sendProcessToPrincipalMemory(pcb, ppalMemory);
                virtualMemory.removePCB(processId);
                break;
            }
        }
    }

    public PCB createPCB(int processId, int size, ArrayList<String> instructionList){
        return ppalMemory.createPCB(processId,  size, instructionList);
    }

    public Memory getPpalMemory() {
        return ppalMemory;
    }

    public void addPCB(PCB pcb) {
        ppalMemory.addPCB(pcb);
    }

    public void removePCB(int processId) {
        ppalMemory.removePCB(processId);
        virtualMemory.removePCB(processId);
    }

    public ArrayList<Object[]> getPpalProcessListData() {
        return Util.toProcessListData(ppalMemory.getPCBList());
    }

    public ArrayList<Object[]> getVirtualProcessListData() {
        return Util.toProcessListData(virtualMemory.getPCBList());
    }

    public void saveDirectoryEntry(String name, String fullpath) {
        directoryEntry.addPath(name, fullpath);
    }

    public void removeDirectoryEntry() {
        directoryEntry.removeDirectoryEntry();
    }

    public void loadMemoryData(ArrayList<String> instructionsList) {
        // TODO Auto-generated method stub   
    }

    public void saveStandardInput(String data) {
        standardInput = data;
    }

    public void saveStandardOutput(String data) {
        standardOutput = data;
    }

    public String readStandardInput() {
        return standardInput;
    }

    public String readStandardOutput() {
        return standardOutput;
    }

    public void enterStandardOutputToProcessData() {
        
    }

    public Object[] getPpalMemoryData() {
        return new Object[]{getPpalProcessListData(), Util.toStandardIOData(standardInput), Util.toStandardIOData(standardOutput), Util.toDirectoryEntryData(directoryEntry)};
    }
}
