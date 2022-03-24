package model.memoryManager;

public class Buffer {
    
    public static void sendProcessToVirtualMemory(PCB pcb, VirtualMemory virtualMemory){
        virtualMemory.addPCB(pcb);
    }

    public static void sendProcessToPrincipalMemory(PCB pcb, Memory ppalMemory){
        ppalMemory.addPCB(pcb);
    }
}