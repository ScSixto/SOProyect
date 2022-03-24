package model.memoryManager;

import java.util.ArrayList;

public class Segment {

    private int id;
    private ArrayList<Page> pageList;

    public Segment(int id, ArrayList<Page> pageList){
        this.id = id;
        this.pageList = pageList;
    }

    public int getId() {
        return id;
    }
    public ArrayList<Page> getPageList() {
        return pageList;
    }
    public void setPageList(ArrayList<Page> pageList) {
        this.pageList = pageList;
    }
    public void setId(int id) {
        this.id = id;
    }
}
