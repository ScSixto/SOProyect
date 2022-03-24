package model.memoryManager;

import java.util.ArrayList;

public class VirtualMemory {
    
    private ArrayList<PCB> PCBList;
    private int pageSize;
    private int segmentSize;

    public VirtualMemory(int pageSize, int segmentSize){
        this.pageSize = pageSize;
        this.segmentSize = segmentSize;
        this.PCBList = new ArrayList<>();
    }

    public int getSegmentSize() {
        return segmentSize;
    }

    public void setSegmentSize(int segmentSize) {
        this.segmentSize = segmentSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public ArrayList<PCB> getPCBList() {
        return PCBList;
    }

    public void setPCBList(ArrayList<PCB> pCBList) {
        this.PCBList = pCBList;
    }

    public void addPCB(PCB pcb){
        PCBList.add(pcb);
    }

    public void removePCB(int processId){
        for (PCB pcb : PCBList) {
            if(pcb.getId() == processId){
                PCBList.remove(pcb);
                break;
            }
        }
    }
}
