package model.memoryManager;

import java.util.HashMap;

public class DirectoryEntry {

    private HashMap<String, String> pathList;

    public DirectoryEntry(){
        pathList = new HashMap<>();
    }

    public void addPath(String name, String fullpath){
        pathList.put(fullpath, name);
    }

    public void removeDirectoryEntry(){
        pathList.clear();
    }

    public HashMap<String, String> getPathList(){
        return pathList;
    }
}
