package view.memoryManager;

import javax.swing.*;
import java.awt.*;

public class JLabelFormat extends JLabel {
	
	private static final long serialVersionUID = 1L;
	
    public JLabelFormat(String text, Font font, Color foreground){
        super(text);
        this.setFont(font);
        this.setForeground(foreground);
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
    }

    public JLabelFormat(String iconPath, int height){
        this.setIcon(new ImageIcon(new ImageIcon(iconPath).getImage().getScaledInstance(height,height,Image.SCALE_AREA_AVERAGING)));
    }

    public JLabelFormat(String text, String iconPath, Font font, Color foreground, int iconHeight, int horizontalTextAlign, int verticalTextAlign){
        this(text, font, foreground);
        this.setVerticalTextPosition(verticalTextAlign);
        this.setHorizontalTextPosition(horizontalTextAlign);
        this.setIcon(new ImageIcon(new ImageIcon(iconPath).getImage().getScaledInstance(iconHeight,iconHeight,Image.SCALE_AREA_AVERAGING)));
    }

    public JLabelFormat(String text, Font font, Color foreground, int horizontalTextAlign, int verticalTextAlign){
        this(text, font, foreground);
        this.setHorizontalTextPosition(horizontalTextAlign);
        this.setVerticalTextPosition(verticalTextAlign);
    }

    public void setIcon(String iconPath, int iconHeight){
        this.setIcon(new ImageIcon(new ImageIcon(iconPath).getImage().getScaledInstance(iconHeight, iconHeight,Image.SCALE_AREA_AVERAGING)));
    }
}
