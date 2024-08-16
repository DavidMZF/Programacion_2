package UserInterface.Form;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

import UserInterface.MFEcuFaunaStyle;
import UserInterface.CustomerControl.MFLabel;

public class MFDatosPanel extends JPanel{
    private MFLabel mfLblCedula = new MFLabel("Cedula:");
    private MFLabel mfLblNombre = new MFLabel("Nombre:");
    private JTextField mfTxtCedula = new JTextField("100511918-3");
    private JTextField mfTxtNombre = new JTextField("Morales Francisco");
    private JPanel mfGraySquarePanel = new JPanel();
    
    public MFDatosPanel(){
        mfCustomizeComponent();
    }

    private void mfCustomizeComponent() {
        setLayout(new GridBagLayout());
        setSize(new Dimension(350, 350));
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.insets = new Insets(5, 5, 5, 5);
        
        mfLblCedula.setFont(MFEcuFaunaStyle.FONT_BOLD);
        mfLblNombre.setFont(MFEcuFaunaStyle.FONT_BOLD);

        mfTxtCedula.setFont(MFEcuFaunaStyle.FONT);
        mfTxtCedula.setPreferredSize(new Dimension(300, 25));
        mfTxtCedula.setEditable(false);
        mfTxtCedula.setHorizontalAlignment(JTextField.CENTER);
        mfTxtCedula.setBorder(BorderFactory.createLineBorder(MFEcuFaunaStyle.COLOR_FONT_LIGHT, 1));
        
        mfTxtNombre.setFont(MFEcuFaunaStyle.FONT);
        mfTxtNombre.setPreferredSize(new Dimension(300, 25));
        mfTxtNombre.setEditable(false);
        mfTxtNombre.setHorizontalAlignment(JTextField.CENTER);
        mfTxtNombre.setBorder(BorderFactory.createLineBorder(MFEcuFaunaStyle.COLOR_FONT_LIGHT, 1));

        mfGraySquarePanel.setBackground(MFEcuFaunaStyle.COLOR_FONDO_DATOS);
        mfGraySquarePanel.setPreferredSize(new Dimension(600, 100));
        mfGraySquarePanel.setOpaque(true);
        
        gbc.anchor = GridBagConstraints.WEST;
        
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 0;
        gbc.insets = new Insets(0, 90, 35, 0);
        add(mfLblCedula, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 300, 35, 0);
        add(mfTxtCedula, gbc);
        
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 0;
        gbc.insets = new Insets(35, 90, 0, 0);
        add(mfLblNombre, gbc);
        
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(35, 300, 0, 0);
        add(mfTxtNombre, gbc);
        
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(14, 14, 14, 14);
        add(mfGraySquarePanel, gbc);

    }
}
