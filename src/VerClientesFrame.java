import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerClientesFrame extends JFrame {

    DisplayFrames d = new DisplayFrames();

    boolean mostrar = true;
    private JTextField textCUI;
    private JButton buscarCuentasBtn;
    private JPanel verClientesFrame;
    private JPanel tablaClientesPanel;
    private JPanel tablacuentasAPanel;
    private JTable tablaCuentasAsociadas;
    private JTable tablaClientes;
    private JButton volverBtn;

    public VerClientesFrame (String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(verClientesFrame);
        buscarCuentasBtn.setFocusable(false);
        buscarCuentasBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));
        volverBtn.setFocusable(false);
        volverBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));


            String[]f1 = {Main.cliente1.CUI,Main.cliente1.Nombre,Main.cliente1.Apellido};
            String[]f2 = {Main.cliente2.CUI,Main.cliente2.Nombre,Main.cliente2.Apellido};
            String[]f3 = {Main.cliente3.CUI,Main.cliente3.Nombre,Main.cliente3.Apellido};
            String[]f4 = {Main.cliente4.CUI,Main.cliente4.Nombre,Main.cliente4.Apellido};
            String[]f5 = {Main.cliente5.CUI,Main.cliente5.Nombre,Main.cliente5.Apellido};


        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("CUI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addRow(f1);
        modelo.addRow(f2);
        modelo.addRow(f3);
        modelo.addRow(f4);
        modelo.addRow(f5);


        tablaClientes.setModel(modelo);

        DefaultTableModel modelo1 = new DefaultTableModel();
        String[]cf1 = {"00000"};
        String[]cf2 = {"00000"};
        String[]cf3 = {"00000"};
        String[]cf4 = {"00000"};
        String[]cf5 = {"00000"};

        modelo1.addColumn("Cuentas asociadas");
        modelo1.addRow(cf1);
        modelo1.addRow(cf2);
        modelo1.addRow(cf3);
        modelo1.addRow(cf4);
        modelo1.addRow(cf5);

        tablaCuentasAsociadas.setModel(modelo1);


        volverBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.PantallaCharacter(mostrar);
                dispose();
            }
        });
        buscarCuentasBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(Main.cliente1.CUI.equals(textCUI.getText())){
                    modelo1.setValueAt(""+Main.C1.ID1,0,0);
                    modelo1.setValueAt(""+Main.C1.ID2,1,0);
                    modelo1.setValueAt(""+Main.C1.ID3,2,0);
                    modelo1.setValueAt(""+Main.C1.ID4,3,0);
                    modelo1.setValueAt(""+Main.C1.ID5,4,0);

                }

                if(Main.cliente2.CUI.equals(textCUI.getText())){
                    modelo1.setValueAt(""+Main.C2.ID1,0,0);
                    modelo1.setValueAt(""+Main.C2.ID2,1,0);
                    modelo1.setValueAt(""+Main.C2.ID3,2,0);
                    modelo1.setValueAt(""+Main.C2.ID4,3,0);
                    modelo1.setValueAt(""+Main.C2.ID5,4,0);

                }

                if(Main.cliente3.CUI.equals(textCUI.getText())){
                    modelo1.setValueAt(""+Main.C3.ID1,0,0);
                    modelo1.setValueAt(""+Main.C3.ID2,1,0);
                    modelo1.setValueAt(""+Main.C3.ID3,2,0);
                    modelo1.setValueAt(""+Main.C3.ID4,3,0);
                    modelo1.setValueAt(""+Main.C3.ID5,4,0);

                }

                if(Main.cliente4.CUI.equals(textCUI.getText())){
                    modelo1.setValueAt(""+Main.C4.ID1,0,0);
                    modelo1.setValueAt(""+Main.C4.ID2,1,0);
                    modelo1.setValueAt(""+Main.C4.ID3,2,0);
                    modelo1.setValueAt(""+Main.C4.ID4,3,0);
                    modelo1.setValueAt(""+Main.C4.ID5,4,0);

                }

                if(Main.cliente5.CUI.equals(textCUI.getText())){
                    modelo1.setValueAt(""+Main.C5.ID1,0,0);
                    modelo1.setValueAt(""+Main.C5.ID2,1,0);
                    modelo1.setValueAt(""+Main.C5.ID3,2,0);
                    modelo1.setValueAt(""+Main.C5.ID4,3,0);
                    modelo1.setValueAt(""+Main.C5.ID5,4,0);

                }

                }

        });
    }



}



