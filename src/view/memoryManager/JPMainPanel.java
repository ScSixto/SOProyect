package view.memoryManager;

import javax.swing.*;

import controller.memoryManager.Command;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPMainPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	// private ProcessManager processManager;
	// private JPExcecutionPanel processExecutionPanel;
	// private JPFinishedProcessPanel finishedProcessListPanel;
	// private JPCreatedProcessPanel createdProcessListPanel;
	// private JPanel processPanel;
	private JPanel memoryPanel;

	// private JButtonFormat processPanelBtn;
// 
	private JPProcessListPanel ppalMemoryPanel;

	private JPProcessListPanel virtualMemoryPanel;

	public JPMainPanel(ActionListener act) {
		// this.processManager = processManager;
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.initComponents(act);
	}

	public void initComponents(ActionListener act) {
		addNorthPanel(act);
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
		addMemoryPanel(container, act);
		this.add(container);
	}

	private void addMemoryPanel(JPanel container, ActionListener actionListener) {
		memoryPanel = new JPanel(new BorderLayout());
		memoryPanel.setLayout(new BoxLayout(memoryPanel, BoxLayout.X_AXIS));

		// memoryPanel.setPreferredSize(new Dimension(200, 200));

		ppalMemoryPanel = new JPProcessListPanel(actionListener);
		memoryPanel.add(ppalMemoryPanel);

		virtualMemoryPanel = new JPProcessListPanel(actionListener);
		memoryPanel.add(virtualMemoryPanel);
		
		// memoryPanel.setVisible(false);
		container.add(memoryPanel);
	}

	private void addNorthPanel(ActionListener act) {
		JPanel northPanel = new JPanel(new BorderLayout());
		northPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 0));

		JLabel title = new JLabel(JFramePpal.FRAME_TITLE_TEXT);
		title.setFont(new Font("Arial", Font.BOLD, 25));
		title.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		northPanel.add(title, BorderLayout.CENTER);

		JPanel controlPanel = new JPanel();
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		controlPanel.setLayout(flowLayout);
		controlPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		controlPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));

		// processPanelBtn = new JButtonFormat(
		// 		new JLabelFormat("Panel de proceso", new Font("Arial", Font.PLAIN, 12), Color.BLACK), Color.GRAY);
		// processPanelBtn.addActionListener(act);
		// processPanelBtn.setActionCommand(Command.SHOW_PROCESS_PANEL.toString());
		// controlPanel.add(processPanelBtn);

		// memoryPanelBt n.setActionCommand(Command.SHOW_MEMORY_PANEL.toString());
		// controlPanel.add(memoryPanelBtn);

		northPanel.add(controlPanel, BorderLayout.SOUTH);

		this.add(northPanel, BorderLayout.NORTH);
	}

	// public void runExecutingShowThread() {
	// 	finishedProcessListPanel.cleanTable();
	// 	processExecutionPanel.cleanTable();
	// 	startFinishedProcessThread();
	// 	startQuantumThread();
	// 	showExecutingProcessMessage();
	// 	showRegisterInformation();
	// }

	// @SuppressWarnings("unchecked")
	// public void startQuantumThread() {
	// 	Thread t = new Thread(new Runnable() {
	// 		@Override
	// 		public void run() {
	// 			try {
	// 				Thread.sleep(ProcessManager.SLEEP_TIME);
	// 				do {
	// 					Object[] newRegister = processManager.getRegisterData();
	// 					Object[] lastRegister = processExecutionPanel.getLastRegister();
	// 					ArrayList<Object[]> aux1 = (ArrayList<Object[]>) newRegister[1];
	// 					ArrayList<Object[]> aux2 = (ArrayList<Object[]>) newRegister[3];
	// 					Thread.sleep(ProcessManager.SLEEP_TIME / 2);
	// 					if ((Integer) newRegister[4] == processManager.getInitialQuantum()) {
	// 						if (aux1.size() > 0 && lastRegister[2] != null) {
	// 							if (!String.valueOf(aux1.get(aux1.size() - 1)[0])
	// 									.equals((String) ((Object[]) lastRegister[2])[0])) {
	// 								processExecutionPanel.setQuantumLabel(newRegister[0]);
	// 							}
	// 						} else if (aux2.size() > 0) {
	// 							if (String.valueOf(aux2.get(aux2.size() - 1)[0])
	// 									.equals((String) ((Object[]) lastRegister[2])[0])) {
	// 								processExecutionPanel.setQuantumLabel(newRegister[0]);
	// 							}
	// 						}
	// 					}
	// 					Thread.sleep(ProcessManager.SLEEP_TIME / 2);
	// 					processExecutionPanel.reloadQuantumLabelAnimation();
	// 				} while (processManager.isRunning());
	// 				processExecutionPanel.reloadQuantumLabelAnimation();
	// 			} catch (InterruptedException e2) {
	// 				e2.printStackTrace();
	// 			}
	// 		}
	// 	});
	// 	t.start();
	// }

	// public void startFinishedProcessThread() {
	// 	Thread t = new Thread(new Runnable() {
	// 		@Override
	// 		public void run() {
	// 			try {
	// 				Thread.sleep(ProcessManager.SLEEP_TIME);
	// 				do {
	// 					showFinishedProcess();
	// 				} while (processManager.isRunning());
	// 				showFinishedProcess();
	// 			} catch (InterruptedException e2) {
	// 				e2.printStackTrace();
	// 			}
	// 		}
	// 	});
	// 	t.start();
	// }

	// @SuppressWarnings("unchecked")
	// private void showFinishedProcess() throws InterruptedException {
	// 	Object[] newRegister = processManager.getRegisterData();
	// 	Object[] lastRegister = processExecutionPanel.getLastRegister();
	// 	ArrayList<Object[]> processListDataAux = (ArrayList<Object[]>) newRegister[1];
	// 	if (((ArrayList<Object[]>) newRegister[1]).size() > ((ArrayList<Object>) lastRegister[1]).size()) {
	// 		processExecutionPanel.setFinishedProcessLabel(processListDataAux.get(processListDataAux.size() - 1));
	// 		finishedProcessListPanel.addRow(processListDataAux.get(processListDataAux.size() - 1));
	// 		removeFinishedProcess(String.valueOf(processListDataAux.get(processListDataAux.size() - 1)[0]));
	// 		Thread.sleep(ProcessManager.SLEEP_TIME / 2);
	// 		processExecutionPanel.reloadFinishedProcessLabelAnimation();
	// 		Thread.sleep(ProcessManager.SLEEP_TIME / 2);
	// 	}
	// }

	// public void showExecutingProcessMessage() {
	// 	Thread t = new Thread(new Runnable() {
	// 		@Override
	// 		public void run() {
	// 			try {
	// 				Thread.sleep(ProcessManager.SLEEP_TIME);
	// 				do {
	// 					Object[] newRegister = processManager.getRegisterData();
	// 					Object[] lastRegister = processExecutionPanel.getLastRegister();
	// 					if (lastRegister[2] != null) {
	// 						if (!((String) ((Object[]) lastRegister[2])[0]).equals(
	// 								processExecutionPanel.formatExecutingProcessData((Object[]) newRegister[2]))) {
	// 							processExecutionPanel.setExecutingProcessLabel((Object[]) newRegister[2]);
	// 							for (int i = 0; i <= JPExcecutionPanel.POINT_EXECUTING_QUANTITY; i++) {
	// 								Thread.sleep(
	// 										ProcessManager.SLEEP_TIME / JPExcecutionPanel.POINT_EXECUTING_QUANTITY);
	// 								processExecutionPanel.addExecutingProcessLabelAnimation();
	// 							}
	// 							Thread.sleep(ProcessManager.SLEEP_TIME / JPExcecutionPanel.POINT_EXECUTING_QUANTITY);
	// 							processExecutionPanel.reloadExecutingProcessLabelAnimation();
	// 						}
	// 					}
	// 				} while (processManager.isRunning());
	// 				processExecutionPanel.finishExecutingProcessLabelAnimation();
	// 			} catch (InterruptedException e2) {
	// 				e2.printStackTrace();
	// 			}
	// 		}
	// 	});
	// 	t.start();
	// }

	// public void showRegisterInformation() {
	// 	Thread t = new Thread(new Runnable() {
	// 		@Override
	// 		public void run() {
	// 			try {
	// 				Thread.sleep(ProcessManager.SLEEP_TIME / 2);
	// 				do {
	// 					Object[] newRegister = processManager.getRegisterData();
	// 					processExecutionPanel.addRow(newRegister);
	// 					Object executingProcessId = UtilView.getProcessIdData((Object[]) (newRegister[2]));
	// 					if (executingProcessId != null)
	// 						createdProcessListPanel.removeProcess(String.valueOf(executingProcessId));
	// 					revalidate();
	// 					Thread.sleep(ProcessManager.SLEEP_TIME);
	// 				} while (processManager.isRunning());
	// 				Object[] newRegister = processManager.getRegisterData();
	// 				processExecutionPanel.addRow(newRegister);
	// 				createdProcessListPanel.enableProcessCreation();
	// 			} catch (InterruptedException e2) {
	// 				e2.printStackTrace();
	// 			}
	// 		}
	// 	});
	// 	t.start();
	// }

	// public void disableProcessCreation() {
	// 	createdProcessListPanel.disableProcessCreation();
	// }

	// public void addCreatedProcess(Object[] processData) {
	// 	createdProcessListPanel.addProcess(processData);
	// }

	// public void removeCreatedProcess(String processId) {
	// 	createdProcessListPanel.removeProcess(processId);
	// }

	// public boolean isCorrectToPlay() {
	// 	return createdProcessListPanel.isCorrectToPlay();
	// }

	// public void showPlayCorrections() {
	// 	createdProcessListPanel.showPlayCorrections();
	// }

	// public String getQuantumValue() {
	// 	return createdProcessListPanel.getQuantumValue();
	// }

	// public void showProcessPanel() {
	// 	processPanelBtn.setBorderColor(Color.GRAY);
	// 	processPanelBtn.setBackground(Color.GRAY);
	// 	memoryPanelBtn.setBorderColor(JButtonFormat.NOT_COLOR);
	// 	memoryPanelBtn.setBackground(JButtonFormat.NOT_COLOR);
	// 	memoryPanel.setVisible(false);
	// 	processPanel.setVisible(true);
	// }

	public void showMemoryPanel(Object[] ppalMemoryData , ArrayList<Object[]> virtualMemoryData) {
		ppalMemoryPanel.showProcessList((ArrayList<Object[]>)ppalMemoryData[0], (Object[]) ppalMemoryData[1], (Object[]) ppalMemoryData[2], (ArrayList<Object[]>) ppalMemoryData[3]);
		// ppalMemoryPanel.setPreferredSize(new Dimension(200,100));

		virtualMemoryPanel.showProcessList(virtualMemoryData);
		// virtualMemoryPanel.setPreferredSize(new Dimension(200,100));

		// memoryPanelBtn.setBorderColor(Color.GRAY);
		// memoryPanelBtn.setBackground(Color.GRAY);
		// processPanelBtn.setBorderColor(JButtonFormat.NOT_COLOR);
		// processPanelBtn.setBackground(JButtonFormat.NOT_COLOR);
		// memoryPanel.setVisible(true);
		// processPanel.setVisible(false);
		revalidate();
		repaint();
	}

    public void leaveToShowSegmentDescription(String segmentName) {
		virtualMemoryPanel.leaveToShowSegmentDescription(segmentName);
		ppalMemoryPanel.leaveToShowSegmentDescription(segmentName);
    }
	
    public void showSegmentDescription(String segmentName) {
		virtualMemoryPanel.showSegmentDescription(segmentName);
		ppalMemoryPanel.showSegmentDescription(segmentName);
    }
}