import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;

import UserInterface.MFEcuFaunaStyle;
import UserInterface.Form.MFMainForm;

public class App {
    public static void main(String[] args) throws Exception {
        
        FlatLightLaf.setup();
        FlatLightLaf.supportsNativeWindowDecorations();
        try {
                UIManager.setLookAndFeel(new FlatLightLaf());
            } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } 
        
        MFMainForm mfOMainForm = new MFMainForm("EcuaFauna 2K24A");
    }
}
