package view.memoryManager;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class JTextFieldFormat extends JTextField implements JTextComponentFormat{

    private static final long serialVersionUID = 1L;

    private Color borderColor;
    private int state;
    private String initialValue;
    
    public JTextFieldFormat(KeyListener kListener, String initialValue) {
        this.setFocusable(true);
        this.addKeyListener(kListener);
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        this.setForeground(Color.LIGHT_GRAY);
        this.initialValue = initialValue;
        this.setText(initialValue);
        this.setSelectedTextColor(Color.DARK_GRAY);
        this.setSelectionColor(Color.LIGHT_GRAY);
        this.setBackground(GENERAL_TEXT_BACKGROUND);
        this.borderColor = GENERAL_STATE_COLOR;
        this.setCursor(new Cursor(Cursor.TEXT_CURSOR));
    }
    
    public int getState() {
        return state;
    }

    public Color getBorderColor(){
        return borderColor;
    }
    
    public void setBorderColor(Color borderColor){
        this.borderColor = borderColor;
    }
    
    public void showGeneralState(){
        this.setText(initialValue);
        this.setForeground(Color.LIGHT_GRAY);
        this.borderColor = GENERAL_STATE_COLOR;
        this.state = GENERAL_STATE;
    }
    
    public void showGoodState(){
        this.setForeground(Color.BLACK);
        this.borderColor = GENERAL_STATE_COLOR;
        this.state = GOOD_STATE;
    }

    public void showWrongState(){
        this.setForeground(Color.BLACK);
        this.borderColor = WRONG_STATE_COLOR;
        this.state = WRONG_STATE;
    }

    public String getInitialValue() {
        return initialValue;
    }

    @Override
    public void setInitialValue(String str) {
        this.initialValue = str;
    }
}