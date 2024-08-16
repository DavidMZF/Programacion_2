package UserInterface.Form;

import java.awt.Container;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import UserInterface.MFEcuFaunaStyle;

public class MFMainForm extends JFrame{
    
    MFDatosPanel    mfPnlDatos    = new MFDatosPanel();
    MFHormigaPanel  mfPnlHormiga  = new MFHormigaPanel();
    
    public MFMainForm(String tilteApp){
        mfCustomizeComponent(tilteApp);
    }

    private void mfCustomizeComponent(String tilteApp){
        setTitle(tilteApp);
        setSize(700, 600);
        setResizable(false);
        //setMinimumSize(new Dimension(950, 800));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container mfContainer = getContentPane();
        mfContainer.setLayout(new BorderLayout());
        
        mfContainer.add(mfPnlDatos, BorderLayout.NORTH);        
        mfContainer.add(mfPnlHormiga, BorderLayout.CENTER);        
        setVisible(true);
    }
}
