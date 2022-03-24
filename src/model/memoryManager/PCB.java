package model.memoryManager;

import java.util.ArrayList;

public class PCB {
    
    private int id;
    private int size;
    private ArrayList<String> instructionList;
    private ArrayList<Page> pageList;
    private ArrayList<Segment> segmentList;
    
    public PCB(int id, int size, ArrayList<String> instructionList, ArrayList<Page> pageList, ArrayList<Segment> segmentList){
         this.id = id;
         this.size = size;
         this.instructionList = instructionList;
         this.pageList = pageList;
         this.segmentList = segmentList;
    }

    public ArrayList<String> getInstructionList() {
        return instructionList;
    }

    public void setInstructionList(ArrayList<String> instructionList) {
        this.instructionList = instructionList;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Page> getPageList() {
        return pageList;
    }

    public void setPageList(ArrayList<Page> pageList) {
        this.pageList = pageList;
    }

    public ArrayList<Segment> getSegmentList() {
        return segmentList;
    }
    
    public void setSegmentList(ArrayList<Segment> segmentList) {
        this.segmentList = segmentList;
    }
}
