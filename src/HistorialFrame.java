import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HistorialFrame extends JFrame{
    private JPanel historialTrPanel;
    private JTextField textID;
    private JButton mostrarTrBtn;
    private JTable tablaHistorial;
    private JButton volverBtn;
    private JTextField textCui;
    private JTextField textNombre;
    private JTextField textApellido;
    DisplayFrames d = new DisplayFrames();
    boolean mostrar = true;
    boolean NoEdit = false;

    public HistorialFrame (){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(historialTrPanel);
        mostrarTrBtn.setFocusable(false);
        mostrarTrBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));
        volverBtn.setFocusable(false);
        volverBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));
        textCui.setHorizontalAlignment(JTextField.CENTER);
        textApellido.setHorizontalAlignment(JTextField.CENTER);
        textNombre.setHorizontalAlignment(JTextField.CENTER);
        textCui.setEditable(NoEdit);
        textNombre.setEditable(NoEdit);
        textApellido.setEditable(NoEdit);
        textID.setHorizontalAlignment(JTextField.CENTER);

        String[]f1 = {"0000","00/00/00 00:00","-------","0.00","0.00","0.00"};
        String[]f2 = {"0000","00/00/00 00:00","-------","0.00","0.00","0.00"};
        String[]f3 = {"0000","00/00/00 00:00","-------","0.00","0.00","0.00"};
        String[]f4 = {"0000","00/00/00 00:00","-------","0.00","0.00","0.00"};




        DefaultTableModel modelo1 = new DefaultTableModel();
        modelo1.addColumn("ID");
        modelo1.addColumn("Fecha");
        modelo1.addColumn("Detalle");
        modelo1.addColumn("Débito");
        modelo1.addColumn("Crédito");
        modelo1.addColumn("Saldo disponible");
        modelo1.addRow(f1);
        modelo1.addRow(f2);
        modelo1.addRow(f3);
        modelo1.addRow(f4);






        volverBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.PantallaCharacter(mostrar);
                dispose();
            }
        });
        mostrarTrBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean encontrado = true;
                if(textID.getText()==null){
                    JOptionPane.showMessageDialog(null, "Debe ingresar un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }else {
                    if(textID.getText().equals(Main.arrayCuentas[0].ID)||textID.getText().equals(Main.arrayCuentas[1].ID)||textID.getText().equals(Main.arrayCuentas[2].ID)||textID.getText().equals(Main.arrayCuentas[3].ID)||textID.getText().equals(Main.arrayCuentas[4].ID)){

                        tablaHistorial.setModel(Main.modeloCl1);
                        textCui.setText(Main.cliente1.CUI);
                        textNombre.setText(Main.cliente1.Nombre);
                        textApellido.setText(Main.cliente1.Apellido);
                        encontrado=false;

                    }
                    if(textID.getText().equals(Main.arrayCuentas[5].ID)||textID.getText().equals(Main.arrayCuentas[6].ID)||textID.getText().equals(Main.arrayCuentas[7].ID)||textID.getText().equals(Main.arrayCuentas[8].ID)||textID.getText().equals(Main.arrayCuentas[9].ID)){

                        tablaHistorial.setModel(Main.modeloCl2);
                        textCui.setText(Main.cliente2.CUI);
                        textNombre.setText(Main.cliente2.Nombre);
                        textApellido.setText(Main.cliente2.Apellido);
                        encontrado=false;

                    }
                    if(textID.getText().equals(Main.arrayCuentas[10].ID)||textID.getText().equals(Main.arrayCuentas[11].ID)||textID.getText().equals(Main.arrayCuentas[12].ID)||textID.getText().equals(Main.arrayCuentas[13].ID)||textID.getText().equals(Main.arrayCuentas[14].ID)){

                        tablaHistorial.setModel(Main.modeloCl3);
                        textCui.setText(Main.cliente3.CUI);
                        textNombre.setText(Main.cliente3.Nombre);
                        textApellido.setText(Main.cliente3.Apellido);
                        encontrado=false;

                    }
                    if(textID.getText().equals(Main.arrayCuentas[15].ID)||textID.getText().equals(Main.arrayCuentas[16].ID)||textID.getText().equals(Main.arrayCuentas[17].ID)||textID.getText().equals(Main.arrayCuentas[18].ID)||textID.getText().equals(Main.arrayCuentas[19].ID)){

                        tablaHistorial.setModel(Main.modeloCl4);
                        textCui.setText(Main.cliente4.CUI);
                        textNombre.setText(Main.cliente4.Nombre);
                        textApellido.setText(Main.cliente4.Apellido);
                        encontrado=false;

                    }
                    if(textID.getText().equals(Main.arrayCuentas[20].ID)||textID.getText().equals(Main.arrayCuentas[21].ID)||textID.getText().equals(Main.arrayCuentas[22].ID)||textID.getText().equals(Main.arrayCuentas[23].ID)||textID.getText().equals(Main.arrayCuentas[24].ID)){

                        tablaHistorial.setModel(Main.modeloCl5);
                        textCui.setText(Main.cliente5.CUI);
                        textNombre.setText(Main.cliente5.Nombre);
                        textApellido.setText(Main.cliente5.Apellido);
                        encontrado=false;

                    }
                    if(encontrado){
                        JOptionPane.showMessageDialog(null, "El ID ingresado no coincide con ninguna cuenta.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }











                }
            }
        });
    }
}
