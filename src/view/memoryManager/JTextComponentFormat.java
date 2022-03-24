package view.memoryManager;

import java.awt.Color;
import java.awt.Font;

public interface JTextComponentFormat {

    public static final Color GENERAL_TEXT_BACKGROUND = Color.WHITE;
    public static final Color GENERAL_STATE_COLOR = Color.decode("#818181");
    public static final Color WRONG_STATE_COLOR = Color.decode("#A50505");
    
    public static final int DEFAULT_ANGLE_BORDER = 10;

    public static final int GENERAL_STATE = 0;
    public static final int GOOD_STATE = 1;
    public static final int WRONG_STATE = -1;

    public int getState();
    public Color getBorderColor();
    public void setBorderColor(Color borderColor);
    public String getText();
    public String getInitialValue();
    public void setText(String text);
    public void showGeneralState();
    public void showGoodState();
    public void showWrongState();
	public void setForeground(Color color);
	public void setEditable(boolean editable);
    public void setFont(Font font);
	public void setInitialValue(String str);
}
