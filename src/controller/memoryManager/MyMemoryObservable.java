package controller.memoryManager;

import java.util.ArrayList;

public interface MyMemoryObservable {

    public void saveDirectoryEntry(String name, String fullpath);

    public void removeDirectoryEntry();

    public void loadMemoryData(ArrayList<String> instructionsList);

    public void saveStandardInput(String data);

    public void saveStandardOutput(String data);

    public String readStandardInput();

    public String readStandardOutput();

    public void enterStandardOutputToProcessData();

}
