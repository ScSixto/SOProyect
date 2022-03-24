package view.memoryManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.border.Border;
public class UtilView {


    public static final String EMPTY_STRING = "";
    public static final String TITLE_PROGRAM = "Simulador Round Robin";
    public static final String LOGO_FILE_PATH = null;
	public static final Color TRANSPARENT_BLACK_COLOR = new Color(0, 0, 0, 100);
    public static final Color BACKGROUND_COLOR = Color.decode("#282E33");

    public static Object getProcessIdData(Object[] processData) {
        return (processData!=null)?processData[0]:null;
    }

    public static Object getProcessNameData(Object[] processData) {
        return (processData!=null)?processData[1]:null;
    }

    public static Object getProcessStartTimeData(Object[] processData) {
        return processData[2];
    }

    public static Object getProcessExecutingTimeData(Object[] processData) {
        return (processData!=null)?processData[3]:null;
    }

    public static Object getProcessFinishTimeData(Object[] processData) {
        return (processData!=null)?processData[4]:null;
    }

    public static JPanel createPanelContainer(Component component, Border border) {
		JPanel jPanel = new JPanel(new BorderLayout(0, 0));
		jPanel.setOpaque(false);
		jPanel.setBorder(border);
		jPanel.add(component, BorderLayout.NORTH);
		return jPanel;
	}
}