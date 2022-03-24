package model.memoryManager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;

public class Util {

    public static Object[] toProcessData(PCB pcb) {
        return new Object[]{pcb.getId(), "pcb.getName()", toSegmentListData(pcb.getSegmentList())};
    }

    private static ArrayList<Object[]> toSegmentListData(ArrayList<Segment> segmentList) {
        ArrayList<Object[]> segmentListData = new ArrayList<>();
        for (Segment segment : segmentList) {
            segmentListData.add(toSegmentData(segment));
        }
        return segmentListData;
    }

    private static Object[] toSegmentData(Segment segment) {
        return new Object[]{segment.getId(), toPageListData(segment.getPageList())};
    }

    private static ArrayList<Object[]> toPageListData(ArrayList<Page> pageList) {
        ArrayList<Object[]> pageListData = new ArrayList<>();
        for (Page page : pageList) {
            pageListData.add(toPageData(page));
        }
        return pageListData;
    }

    private static Object[] toPageData(Page page) {
        return new Object[]{page.getId(), page.getSize()};
    }

    public static ArrayList<Object[]> orderByStartTime(ArrayList<Object[]> processListData) {
        processListData.sort(new Comparator<Object[]>() {
            @Override
            public int compare(Object[] o1, Object[] o2) {
                return (Integer)o1[2] - (Integer)o2[2];
            }
        });
        return processListData;
    }

    public static ArrayList<Object[]> toProcessListData(ArrayList<PCB> pcbList) {
        ArrayList<Object[]> pcbListData = new ArrayList<>();
        for (PCB pcb : pcbList) {
            pcbListData.add(toPCBData(pcb));
        }
        return pcbListData;
    }

    private static Object[] toPCBData(PCB pcb) {
        return new Object[]{pcb.getId(), "", pcb.getSize(), toSegmentListData(pcb.getSegmentList())};
    }

    public static Object[] toStandardIOData(String standardIO) {
        return new Object[]{standardIO};
    }

    public static ArrayList<Object[]> toDirectoryEntryData(DirectoryEntry directoryEntry) {
        ArrayList<Object[]> directoryEntryData = new ArrayList<Object[]>();
        Iterator<Entry<String,String>> it = directoryEntry.getPathList().entrySet().iterator();
        while(it.hasNext()){
            Entry<String, String> i = it.next();
            directoryEntryData.add(new Object[]{i.getValue(),i.getKey()});
        }
        return directoryEntryData;
    }
}