package model.memoryManager;

import java.util.ArrayList;

public class Memory {

    public static final int MAX_SEGMENT_QUANTITY = Integer.MAX_VALUE;
    // public static final int MAX_SEGMENT_QUANTITY = 50;

    private ArrayList<PCB> PCBList;
    private int pageSize;
    private int segmentSize;

    public Memory(int pageSize, int segmentSize){
        this.pageSize = pageSize;
        this.segmentSize = segmentSize;
        this.PCBList = new ArrayList<>();
    }

    public ArrayList<PCB> getPCBList(){
        return PCBList;
    }

    private int getRandomSegmentId() {
        int segmentId = (int) (Math.random()*(MAX_SEGMENT_QUANTITY));
        while (searchSegment(segmentId)) {
            segmentId = (int) (Math.random()*(MAX_SEGMENT_QUANTITY));
        }
        return segmentId;
    }

    //Obtener Id de segmento validando que haya cantidad suficiente de segmentos hacia abajo para un programa especifico
    private int getValidSegmentId(int segmentId, int pageQuantity){
        for (PCB pcb : PCBList) {
            if(pcb.getId() > segmentId){
                if((pcb.getId() < segmentId + Math.ceil((float) (pageSize * pageQuantity) / (float) segmentSize))){
                    segmentId = getValidSegmentId(getRandomSegmentId(), pageQuantity);
                }
            }else{
                if(segmentId <= pcb.getId() + pcb.getSize()){
                    segmentId = getValidSegmentId(getRandomSegmentId(), pageQuantity);
                }
            }
        }
        // for (int i = segmentId + 1; i < (segmentId + Math.ceil((float) (pageSize * pageQuantity) / (float) segmentSize)); i++) {
        //     if(searchSegment(i)){
        //        segmentId = getValidSegmentId(getRandomSegmentId(), pageQuantity);
        //        break;
        //     }
        // }
        return segmentId;
    }

    public boolean searchSegment(int segmentId){
        boolean found = false;
        for (PCB pcb : PCBList) {
            if(pcb.getId() == segmentId){
                found = true;
                break;
            }
        }
        return found;
    }

    public PCB createPCB(int processId, int size, ArrayList<String> instructionList){
        ArrayList<Page> pageList = getPageList(size);
        ArrayList<Segment> segmentList = getSegmentList(pageList);
        return new PCB(processId, size, instructionList, pageList, segmentList);
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

    public ArrayList<Page> getPageList(int processSize){
        ArrayList<Page> pageList = new ArrayList<>();
        int pageId = 0;
        while(processSize > 0){
            pageList.add(new Page(pageId++, (processSize > pageSize)?pageSize:processSize));
            processSize -= pageSize;
        }
        return pageList;
    }

    public ArrayList<Segment> getSegmentList(ArrayList<Page> pageList){
        ArrayList<Segment> segmentList = new ArrayList<>();
        int segmentId = getValidSegmentId(getRandomSegmentId(), pageList.size());
        int i = segmentId;
        int j = 0;
        while(i < segmentId + Math.ceil((float) (pageSize * pageList.size()) / (float) segmentSize)){
            ArrayList<Page> segmentPageList = new ArrayList<>();
            while(j < pageList.size() && segmentPageList.size() < segmentSize / pageSize){
                segmentPageList.add(pageList.get(j++));
            }
            segmentList.add(new Segment(i++, segmentPageList));
        }
        return segmentList;
    }
}