package UserInterface.CustomerControl;

import javax.swing.*;

import UserInterface.MFEcuFaunaStyle;

import java.awt.*;

public class MFLabelText extends JPanel{
    private MFLabel    lblEtiqueta = new MFLabel();
    private MFTextBox  txtContenido= new MFTextBox();

    public MFLabelText(String etiqueta) {
        setLayout(new BorderLayout());

        lblEtiqueta.setCustomizeComponent(  etiqueta, 
                                            MFEcuFaunaStyle.FONT_SMALL, 
                                            MFEcuFaunaStyle.COLOR_FONT_LIGHT, 
                                            MFEcuFaunaStyle.ALIGNMENT_LEFT); 
        //txtContenido.setBorder(txtContenido.createBorderLine());
        txtContenido.setBorderLine();
        add(lblEtiqueta, BorderLayout.NORTH);
        add(txtContenido, BorderLayout.CENTER);
    }
}
