package UserInterface.CustomerControl;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import UserInterface.MFEcuFaunaStyle;

public class MFLabel extends JLabel{
    public MFLabel(){
        customizeComponent();
    }
    public MFLabel(String text){
        setText(text);
        customizeComponent();
    }
    private void customizeComponent(){
        setCustomizeComponent(getText(), MFEcuFaunaStyle.FONT, MFEcuFaunaStyle.COLOR_FONT_LIGHT, MFEcuFaunaStyle.ALIGNMENT_LEFT);
    }
    public void setCustomizeComponent(String text, Font  font, Color color, int alignment) {
        setText(text);
        setFont(font);
        setOpaque(false);
        setBackground(null);
        setForeground(color);
        setHorizontalAlignment(alignment);
        //setIcon(new ImageIcon(iconPath));
    }
}