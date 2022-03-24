package view.memoryManager;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class JButtonFormat extends JButton{

    private static final long serialVersionUID = 1L;
	
	public static final int DEFAULT_ANGLE_BORDER = 5;
    public static final Color NOT_COLOR = Color.MAGENTA;

    private Color borderColor;
    private JLabelFormat lblFormat;

    public JButtonFormat(JLabelFormat lblFormat){
        this.lblFormat = lblFormat;
        this.add(this.lblFormat);
        this.lblFormat.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.lblFormat.setHorizontalAlignment(SwingConstants.CENTER);

        this.lblFormat.setAlignmentY(Component.CENTER_ALIGNMENT);
        this.lblFormat.setVerticalAlignment(SwingConstants.CENTER);

        this.setFocusPainted(false);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));

        this.setBackground(NOT_COLOR);
        this.setOpaque(false);

        this.borderColor = NOT_COLOR;
        this.setBorder(BorderFactory.createEmptyBorder(2,5,2,5));
        this.setBorderPainted(false);
    }
    
    public JButtonFormat(JLabelFormat lblText, Color background){
        this(lblText);
        this.setBackground(background);
    }

    public JButtonFormat(JLabelFormat lblText, Color background, Color bordeColor){
        this(lblText);
        this.setOpaque(false);
        this.setBackground(background);
        this.borderColor = bordeColor;
    }
    
    public Color getBorderColor(){
        return borderColor;
    }

    public void setBorderColor(Color borderColor){
        this.borderColor = borderColor;
    }

    @Override
    public void setAlignmentX(float alignmentX) {
        super.setAlignmentX(alignmentX);
        if(this.lblFormat!=null)this.lblFormat.setAlignmentX(alignmentX);
    }

    @Override
    public void setAlignmentY(float alignmentY) {
        super.setAlignmentY(alignmentY);
        if(this.lblFormat!=null)this.lblFormat.setAlignmentY(alignmentY);
    }

    @Override
    public void setHorizontalAlignment(int alignment) {
        super.setHorizontalAlignment(alignment);
        if(this.lblFormat!=null)this.lblFormat.setHorizontalAlignment(alignment);
    }

    @Override
    public void setVerticalAlignment(int alignment) {
        super.setVerticalAlignment(alignment);
        if(this.lblFormat!=null)this.lblFormat.setVerticalAlignment(alignment);
    }

    public void setLabelIcon(String filePath, int height){
        this.lblFormat.setIcon(filePath, height);
    }

    public String getLabelText() {
        return lblFormat.getText();
    }

    public void setLabelText(String text){
        this.lblFormat.setText(text);
    }

    public void setLabelForeground(Color fg){
        this.lblFormat.setForeground(fg);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;

        graphics.setColor(this.getBackground());
        if(!graphics.getColor().equals(NOT_COLOR)){
            graphics.fillRoundRect(0, 0, getWidth(), getHeight(), DEFAULT_ANGLE_BORDER, DEFAULT_ANGLE_BORDER);
        }
        graphics.setColor(this.borderColor);
        if(!graphics.getColor().equals(NOT_COLOR)){
            graphics.drawRoundRect(0, 0, getWidth(), getHeight(), DEFAULT_ANGLE_BORDER, DEFAULT_ANGLE_BORDER);
        }
        super.paint(graphics);
        if(!isEnabled()){
            graphics.setColor(new Color(255,255,255,100));
            graphics.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}
