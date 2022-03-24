package view.memoryManager;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;


public class JPTxtFieldPanel extends JPanel implements KeyListener{

    private static final long serialVersionUID = 1L;
    
    public static final String WRONG_TEXT_MESSAGE = "Valor no válido";
    public static final Font FIELD_TITLE_TEXT_FONT = new Font("Arial", Font.BOLD, 12);
    public static final Color FIELD_TITLE_TEXT_FOREGROUND = Color.DARK_GRAY;
	public static final Font WRONG_FIELD_TEXT_MESSAGE_FONT = new Font("Arial", Font.PLAIN, 10);
    public static final Color WRONG_FIELD_TEXT_MESSAGE_FOREGROUND = Color.RED;

    protected JTextComponentFormat txtField;
    private JLabelFormat alertMessage;
    private JLabelFormat titleLbl;

    public JPTxtFieldPanel(String title, String initialValue) {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(0,5,5,5));
        this.setOpaque(false);

        this.createTextField(initialValue);
        this.addTitleLabel(title);
        this.createAlertMessage();
	}

    public JPTxtFieldPanel(String title, String initialValue, int horizontalTitleAlignment) {
        this(title, initialValue);
        this.titleLbl.setAlignmentX(horizontalTitleAlignment);
	}

    private void createTextField(String initialValue) {
        JPRoundBorderPanel roundBorderPanel;
        txtField = new JTextFieldFormat(this, initialValue);
        roundBorderPanel = new JPRoundBorderPanel(txtField);
        roundBorderPanel.add((JTextFieldFormat)txtField);
        this.add(roundBorderPanel);
    }

    private void addTitleLabel(String title){
        titleLbl = new JLabelFormat(title,FIELD_TITLE_TEXT_FONT, FIELD_TITLE_TEXT_FOREGROUND);
        titleLbl.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        this.add(titleLbl, BorderLayout.NORTH);
    }

    private void createAlertMessage(){
        alertMessage = new JLabelFormat(UtilView.EMPTY_STRING, WRONG_FIELD_TEXT_MESSAGE_FONT, WRONG_FIELD_TEXT_MESSAGE_FOREGROUND);
        alertMessage.setOpaque(false);
        alertMessage.setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
        this.add(alertMessage, BorderLayout.SOUTH);
        alertMessage.setVisible(false);
    }

    public boolean validateState(){
        boolean isGeneralState = false;
        this.txtField.setText(this.txtField.getText().replace(this.txtField.getInitialValue(), UtilView.EMPTY_STRING));
        String txt = txtField.getText();
        if(txt.length() == 0){    
            showGeneralState();
            isGeneralState = true;
        }else{
            showGoodState();
        }
        return isGeneralState;
    }

    public void showGeneralState() {
        txtField.showGeneralState();
        this.titleLbl.setForeground(FIELD_TITLE_TEXT_FOREGROUND);
        alertMessage.setVisible(false);
    }

	public void showGoodState() {
        txtField.showGoodState();
        this.titleLbl.setForeground(FIELD_TITLE_TEXT_FOREGROUND);
        alertMessage.setVisible(false);
    }

	public void showWrongState(String message) {
        txtField.showWrongState();
        this.titleLbl.setForeground(WRONG_FIELD_TEXT_MESSAGE_FOREGROUND);
        alertMessage.setText(message);
        alertMessage.setVisible(true);
	}

    public int getState(){
        return this.txtField.getState();
    }

    public String getText(){
        this.txtField.setText(this.txtField.getText().replace(this.txtField.getInitialValue(), UtilView.EMPTY_STRING));
        return this.txtField.getText();
    }

    public String getTitle(){
        return this.titleLbl.getText();
    }

    public void setText(String text){
        this.txtField.setText(text);
    }

    public void setTitle(String title){
        this.titleLbl.setText(title);
    }

    public void setInitialValue(String str){
        this.txtField.setInitialValue(str);
    }

    public String getInitialValue(){
        return this.txtField.getInitialValue();
    }

    @Override
    public void setEnabled(boolean enabled) {
        txtField.setEditable(false);
        super.setEnabled(enabled);
    }

    public void setFieldFont(Font font){
        this.txtField.setFont(font);
    }

    public void setTitleFont(Font font){
        this.titleLbl.setFont(font);
    }

    public void setTitleForeground(Color foreground){
        this.titleLbl.setForeground(foreground);
    }
    
    public void setTitleBackground(Color bgColor) {
        this.titleLbl.setBackground(bgColor);
        this.titleLbl.setOpaque(true);
    }

    public void setFieldForeground(Color foreground){
        this.txtField.setForeground(foreground);
    }

    public void setBorderColor(Color borderColor){
        this.txtField.setBorderColor(borderColor);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        validateState();
        if(this.txtField.getState() == JTextFieldFormat.GENERAL_STATE && e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            e.consume();
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        validateState();
    }
}