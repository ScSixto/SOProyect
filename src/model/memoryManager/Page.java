package model.memoryManager;

public class Page {

    private int id;
    private int size;
    
    public Page(int id, int size){
        this.id = id;
        this.size = size;
    }
    
    public int getId() {
        return id;
    }
    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setId(int id) {
        this.id = id;
    }
}