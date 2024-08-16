package UserInterface.Form;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import UserInterface.MFEcuFaunaStyle;
import DataAccess.MFDTO.MFHormigasDTO;
import BusinessLogic.MFHormigasBL;
import DataAccess.MFHormigasDAO;

public class MFHormigaPanel extends JPanel {

    private DefaultListModel<String> mfListModel;
    private DefaultTableModel mfTableModel;
    private JTable mfTable;
    private int mfCurrentID;

    private String selectedGenoAlimento = "<GenoAlimento>";
    private String selectedIngestaNativa = "<IngestaNativa>";

    public MFHormigaPanel(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 30, 10, 30);

        // Crear el segundo panel
        JPanel secondPanel = new JPanel();
        secondPanel.setPreferredSize(new Dimension(600, 50));
        secondPanel.setLayout(new BorderLayout(10, 10));

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        ImageIcon logoIcon = new ImageIcon(MFEcuFaunaStyle.URL_LOGO);
        Image logoImage = logoIcon.getImage();
        Image resizedLogoImage = logoImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon resizedLogoIcon = new ImageIcon(resizedLogoImage);

        JLabel logoLabel = new JLabel(resizedLogoIcon);
        JLabel textLabel = new JLabel("Hormiguero virtual");
        textLabel.setForeground(Color.BLUE);

        leftPanel.add(logoLabel);
        leftPanel.add(textLabel);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));

        JButton createButton = new JButton("Crear Hormiga larva");
        createButton.setBackground(Color.DARK_GRAY);
        createButton.setForeground(Color.WHITE);
        createButton.setPreferredSize(new Dimension(300, 50));
        createButton.setFocusPainted(false);

        rightPanel.add(createButton);

        secondPanel.add(leftPanel, BorderLayout.WEST);
        secondPanel.add(rightPanel, BorderLayout.EAST);

        gbc.gridy = 0;
        gbc.weighty = 0.1;
        add(secondPanel, gbc);

        // Configuración de la tabla
        String[] columnNames = {"ID", "Sexo", "Provincia", "GenoAlimento", "IngestaNativa", "TipoHormiga", "Estado"};
        mfTableModel = new DefaultTableModel(columnNames, 0);
        mfTable = new JTable(mfTableModel); // Inicializar el JTable
        mfTable.setGridColor(Color.DARK_GRAY);
        mfTable.setBackground(Color.GRAY);
        mfTable.setForeground(Color.WHITE);
        mfTable.setSelectionBackground(Color.LIGHT_GRAY);
        mfTable.setSelectionForeground(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(mfTable);
        scrollPane.setPreferredSize(new Dimension(580, 150));

        gbc.gridy = 1;
        gbc.weighty = 0.3;
        add(scrollPane, gbc);

        // Crear el cuarto panel
        JPanel fourthPanel = new JPanel();
        fourthPanel.setPreferredSize(new Dimension(580, 150));
        fourthPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbcFourth = new GridBagConstraints();
        gbcFourth.insets = new Insets(10, 5, 10, 5);

        JButton leftButton1 = new JButton(selectedGenoAlimento);
        leftButton1.setBackground(Color.GRAY);
        leftButton1.setForeground(Color.WHITE);
        leftButton1.setPreferredSize(new Dimension(150, 50));
        leftButton1.setFocusPainted(false);

        JButton leftButton2 = new JButton(selectedIngestaNativa);
        leftButton2.setBackground(Color.GRAY);
        leftButton2.setForeground(Color.WHITE);
        leftButton2.setPreferredSize(new Dimension(150, 50));
        leftButton2.setFocusPainted(false);

        JPopupMenu popupMenu1 = new JPopupMenu();
        // Actualizar opciones del menú emergente
        JMenuItem option1_1 = new JMenuItem("<GenoAlimento>");
        JMenuItem option1_2 = new JMenuItem("XY");
        JMenuItem option1_3 = new JMenuItem("XX"); 
        popupMenu1.add(option1_1);
        popupMenu1.add(option1_2);
        popupMenu1.add(option1_3);

        JPopupMenu popupMenu2 = new JPopupMenu();
        // Actualizar opciones del menú emergente
        JMenuItem option2_1 = new JMenuItem("<IngestaNativa>");
        JMenuItem option2_2 = new JMenuItem("Carnivoro");
        JMenuItem option2_3 = new JMenuItem("Herbivoro");
        JMenuItem option2_4 = new JMenuItem("Omnivoro");
        JMenuItem option2_5 = new JMenuItem("Insectivoros");
        popupMenu2.add(option2_1);
        popupMenu2.add(option2_2);
        popupMenu2.add(option2_3);
        popupMenu2.add(option2_4);
        popupMenu2.add(option2_5);

        // ActionListener para actualizar el texto del botón
        ActionListener updateSelectedOption = e -> {
            JMenuItem source = (JMenuItem) e.getSource();
            String selectedOption = source.getText();

            // Determine qué botón fue clicado y actualiza el texto del botón
            if (source.getParent() == popupMenu1) {
                selectedGenoAlimento = selectedOption;
                leftButton1.setText(selectedGenoAlimento);
            } else if (source.getParent() == popupMenu2) {
                selectedIngestaNativa = selectedOption;
                leftButton2.setText(selectedIngestaNativa);
            }
        };

        option1_1.addActionListener(updateSelectedOption);
        option1_2.addActionListener(updateSelectedOption);
        option1_3.addActionListener(updateSelectedOption);
        option2_1.addActionListener(updateSelectedOption);
        option2_2.addActionListener(updateSelectedOption);
        option2_3.addActionListener(updateSelectedOption);
        option2_4.addActionListener(updateSelectedOption);
        option2_5.addActionListener(updateSelectedOption);

        leftButton1.addActionListener(e -> popupMenu1.show(leftButton1, 0, leftButton1.getHeight()));
        leftButton2.addActionListener(e -> popupMenu2.show(leftButton2, 0, leftButton2.getHeight()));

        JButton createButton1 = new JButton("Alimentar Con GenoAlimento");
        createButton1.setBackground(Color.DARK_GRAY);
        createButton1.setForeground(Color.WHITE);
        createButton1.setPreferredSize(new Dimension(300, 50));
        createButton1.setFocusPainted(false);

        JButton createButton2 = new JButton("Alimentar Con IngestaNativa");
        createButton2.setBackground(Color.DARK_GRAY);
        createButton2.setForeground(Color.WHITE);
        createButton2.setPreferredSize(new Dimension(300, 50));
        createButton2.setFocusPainted(false);

        // ActionListener para los botones de alimentación
        createButton1.addActionListener(e -> {
            updateColumnWithText(3, selectedGenoAlimento);
            checkAndUpdateRow();
        });

        createButton2.addActionListener(e -> {
            updateColumnWithText(4, selectedIngestaNativa);
            checkAndUpdateRow();
        });

        gbcFourth.gridx = 0;
        gbcFourth.gridy = 0;
        gbcFourth.weightx = 0.5;
        gbcFourth.fill = GridBagConstraints.VERTICAL;
        gbcFourth.anchor = GridBagConstraints.WEST;
        fourthPanel.add(leftButton1, gbcFourth);

        gbcFourth.gridy = 1;
        fourthPanel.add(leftButton2, gbcFourth);

        gbcFourth.gridx = 1;
        gbcFourth.gridy = 0;
        gbcFourth.weightx = 0.5;
        gbcFourth.fill = GridBagConstraints.VERTICAL;
        gbcFourth.anchor = GridBagConstraints.EAST;
        fourthPanel.add(createButton1, gbcFourth);

        gbcFourth.gridy = 1;
        fourthPanel.add(createButton2, gbcFourth);

        gbc.gridy = 2;
        gbc.weighty = 0.3;
        add(fourthPanel, gbc);
        
        // Crear el quinto panel
        JPanel fifthPanel = new JPanel();
        fifthPanel.setBackground(Color.LIGHT_GRAY);
        fifthPanel.setPreferredSize(new Dimension(580, 75));
        fifthPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        Color lightBlue = new Color(173, 216, 230);
        Border border = BorderFactory.createLineBorder(new Color(70, 130, 180), 2);

        JButton saveButton = new JButton("GUARDAR");
        saveButton.setBackground(lightBlue);
        saveButton.setForeground(Color.BLACK);
        saveButton.setPreferredSize(new Dimension(150, 50));
        saveButton.setFocusPainted(false);
        saveButton.setBorder(border);

        JButton exitButton = new JButton("ELIMINAR");
        exitButton.setBackground(lightBlue);
        exitButton.setForeground(Color.BLACK);
        exitButton.setPreferredSize(new Dimension(150, 50));
        exitButton.setFocusPainted(false);
        exitButton.setBorder(border);

        // Agregar el ActionListener para el botón "GUARDAR"
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });

        fifthPanel.add(saveButton);
        fifthPanel.add(exitButton);

        gbc.gridy = 3;
        gbc.weighty = 0.1;
        add(fifthPanel, gbc);

        // Inicializar el ID secuencial
        mfCurrentID = 1; // O cualquier valor inicial que desees

        // ActionListener para el botón "Crear Hormiga larva"
        createButton.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(this,
                "¿Estás seguro de crear una hormiga larva?", "Confirmación",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                addNewHormiga();
            }
        });
    }

    private void addNewHormiga() {
        // Incrementar el ID secuencial
        int newID = mfCurrentID++;

        // Datos predeterminados
        String sexo = "asexual";
        String provincia = getRandomProvincia();
        String genoAlimento = selectedGenoAlimento;
        String ingestaNativa = selectedIngestaNativa;
        String tipoHormiga = "larva";
        String estado = "viva";

        // Agregar la nueva fila al modelo de la tabla
        mfTableModel.addRow(new Object[] { newID, sexo, provincia, genoAlimento, ingestaNativa, tipoHormiga, estado });
    }

    private String getRandomProvincia() {
        String[] provincias = {"Azuay", "Bolívar", "Cañar", "Carchi", "Chimborazo", "Cotopaxi", "El Oro", "Esmeraldas", "Galápagos", "Guayas", "Imbabura", "Loja", "Los Ríos", "Manabí", "Morona Santiago", "Napo", "Orellana", "Pastaza", "Pichincha", "Santa Elena", "Santo Domingo de los Tsáchilas", "Sucumbíos", "Tungurahua", "Zamora-Chinchipe"};
        Random random = new Random();
        return provincias[random.nextInt(provincias.length)];
    }


    private void updateColumnWithText(int columnIndex, String text) {
        int selectedRow = mfTable.getSelectedRow(); // Obtener la fila seleccionada
        if (selectedRow != -1) { // Verificar si hay una fila seleccionada
            mfTableModel.setValueAt(text, selectedRow, columnIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila en la tabla para actualizar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Método para verificar y actualizar la fila según las selecciones
    private void checkAndUpdateRow() {
        int selectedRow = mfTable.getSelectedRow();
        if (selectedRow != -1) {
            String genoAlimento = (String) mfTableModel.getValueAt(selectedRow, 3);
            String ingestaNativa = (String) mfTableModel.getValueAt(selectedRow, 4);

            // Verificar las condiciones
            if ("XX".equals(genoAlimento) &&
                ("Herbivoro".equals(ingestaNativa)) ){
                mfTableModel.setValueAt("Rastreadora", selectedRow, 5);
                mfTableModel.setValueAt("Hembra", selectedRow, 1);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila en la tabla para actualizar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void saveData() {
        MFHormigasDAO dao = new MFHormigasDAO();
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fechaCrea = now.format(formatter);

            for (int row = 0; row < mfTableModel.getRowCount(); row++) {
                String idHormigaText = mfTableModel.getValueAt(row, 0).toString().trim();
                String idSexoText = mfTableModel.getValueAt(row, 1).toString().trim();
                String idProvinciaText = mfTableModel.getValueAt(row, 2).toString().trim();
                String idGenoAlimentoText = mfTableModel.getValueAt(row, 3).toString().trim();
                String idIngestaNativaText = mfTableModel.getValueAt(row, 4).toString().trim();
                String tipoHormiga = mfTableModel.getValueAt(row, 5).toString().trim();
                String estado = mfTableModel.getValueAt(row, 6).toString().trim();

                int idHormiga;
                int idSexo;
                int idProvincia;
                int idGenoAlimento;
                int idIngestaNativa;

                // Intentar convertir los textos a enteros
                try {
                    idHormiga = Integer.parseInt(idHormigaText);
                    idSexo = Integer.parseInt(idSexoText);
                    idProvincia = Integer.parseInt(idProvinciaText);
                    idGenoAlimento = Integer.parseInt(idGenoAlimentoText);
                    idIngestaNativa = Integer.parseInt(idIngestaNativaText);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Uno o más campos numéricos tienen un formato inválido. Asegúrate de que los campos numéricos contengan solo números enteros.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Crear el objeto DTO con la fecha actual
                MFHormigasDTO dto = new MFHormigasDTO(idHormiga, idSexo, idProvincia, idGenoAlimento, idIngestaNativa, tipoHormiga, estado, fechaCrea);

                // Verificar que los campos numéricos no estén vacíos
                if (tipoHormiga.isEmpty() || estado.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos de texto.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    dao.create(dto);
                    JOptionPane.showMessageDialog(this, "Datos guardados exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos en la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mfDataButton() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 25, 0, 25);

        gbc.gridx = 0; // Primera columna
        gbc.gridwidth = 2; // Ocupa dos columnas
        gbc.fill = GridBagConstraints.BOTH; // Ajusta el tamaño para eliminar el espacio vacío
        gbc.weightx = 1.0; // Expande horizontalmente
        gbc.weighty = 1.0; // Expande verticalmente
        // Configuración de los botones inferiores
       // Crear el quinto panel
        JPanel mfButtonPanel = new JPanel();
        mfButtonPanel.setBackground(MFEcuFaunaStyle.COLOR_FONDO_DATOS);
        mfButtonPanel.setPreferredSize(new Dimension(580, 75));
        mfButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));

        Border border = BorderFactory.createLineBorder(MFEcuFaunaStyle.COLOR_BUTTON_BORDER, 2);

        JButton saveButton = new JButton("GUARDAR");
        saveButton.setBackground(lightBlue);
        saveButton.setForeground(Color.BLACK);
        saveButton.setPreferredSize(new Dimension(150, 50));
        saveButton.setFocusPainted(false);
        saveButton.setBorder(border);

        JButton exitButton = new JButton("ELIMINAR");
        exitButton.setBackground(lightBlue);
        exitButton.setForeground(Color.BLACK);
        exitButton.setPreferredSize(new Dimension(150, 50));
        exitButton.setFocusPainted(false);
        exitButton.setBorder(border);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });
        
        mfButtonPanel.add(saveButton);
        mfButtonPanel.add(exitButton);

        gbc.gridy = 3;
        gbc.weighty = 0.;
        add(mfButtonPanel, gbc);
    }
}
