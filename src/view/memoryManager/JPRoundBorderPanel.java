package view.memoryManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class JPRoundBorderPanel extends JPanel{

    private static final int DEFAULT_TXT_FIELD_ANGLE = 10;

    private JTextComponentFormat componentFormat;
    private int angleBorder;

    public JPRoundBorderPanel(JTextComponentFormat componentFormat){
        this.setLayout(new BorderLayout(0, 0));
        this.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        this.setBackground(Color.WHITE);
        this.setOpaque(false);
        this.angleBorder = DEFAULT_TXT_FIELD_ANGLE;
        this.componentFormat = componentFormat;
    }
    
    @Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(this.getBackground());
		g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, this.angleBorder, this.angleBorder);
		g2.setColor(this.componentFormat.getBorderColor());
		g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, this.angleBorder,this.angleBorder);
		super.paint(g);
	}
}
