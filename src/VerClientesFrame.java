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
        textCUI.setHorizontalAlignment(JTextField.CENTER);



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





        tablaCuentasAsociadas.setModel(Main.modeloVerClientes);
        Main.modeloVerClientes.setValueAt("----",0,0);
        Main.modeloVerClientes.setValueAt("----",1,0);
        Main.modeloVerClientes.setValueAt("----",2,0);
        Main.modeloVerClientes.setValueAt("----",3,0);
        Main.modeloVerClientes.setValueAt("----",4,0);


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
              if(textCUI.getText()==null){
                  JOptionPane.showMessageDialog(null, "Debe ingresar un CUI para buscar sus cuentas asociadas.", "Error", JOptionPane.ERROR_MESSAGE);
              }else {

                  if(textCUI.getText().equals(Main.cliente1.getCUI())){

                      Main.modeloVerClientes.setValueAt(Main.arrayCuentas[0].ID,0,0);
                      Main.modeloVerClientes.setValueAt(Main.arrayCuentas[1].ID,1,0);
                      Main.modeloVerClientes.setValueAt(Main.arrayCuentas[2].ID,2,0);
                      Main.modeloVerClientes.setValueAt(Main.arrayCuentas[3].ID,3,0);
                      Main.modeloVerClientes.setValueAt(Main.arrayCuentas[4].ID,4,0);


                  }
                  if(textCUI.getText().equals(Main.cliente2.getCUI())){


                      Main.modeloVerClientes.setValueAt(Main.arrayCuentas[5].ID,0,0);
                      Main.modeloVerClientes.setValueAt(Main.arrayCuentas[6].ID,1,0);
                      Main.modeloVerClientes.setValueAt(Main.arrayCuentas[7].ID,2,0);
                      Main.modeloVerClientes.setValueAt(Main.arrayCuentas[8].ID,3,0);
                      Main.modeloVerClientes.setValueAt(Main.arrayCuentas[9].ID,4,0);

                  }
                  if(textCUI.getText().equals(Main.cliente3.getCUI())){

                      Main.modeloVerClientes.setValueAt(Main.arrayCuentas[10].ID,0,0);
                      Main.modeloVerClientes.setValueAt(Main.arrayCuentas[11].ID,1,0);
                      Main.modeloVerClientes.setValueAt(Main.arrayCuentas[12].ID,2,0);
                      Main.modeloVerClientes.setValueAt(Main.arrayCuentas[13].ID,3,0);
                      Main.modeloVerClientes.setValueAt(Main.arrayCuentas[14].ID,4,0);

                  }
                  if(textCUI.getText().equals(Main.cliente4.getCUI())){

                      Main.modeloVerClientes.setValueAt(Main.arrayCuentas[15].ID,0,0);
                      Main.modeloVerClientes.setValueAt(Main.arrayCuentas[16].ID,1,0);
                      Main.modeloVerClientes.setValueAt(Main.arrayCuentas[17].ID,2,0);
                      Main.modeloVerClientes.setValueAt(Main.arrayCuentas[18].ID,3,0);
                      Main.modeloVerClientes.setValueAt(Main.arrayCuentas[19].ID,4,0);


                  }
                  if(textCUI.getText().equals(Main.cliente5.getCUI())){

                      Main.modeloVerClientes.setValueAt(Main.arrayCuentas[20].ID,0,0);
                      Main.modeloVerClientes.setValueAt(Main.arrayCuentas[21].ID,1,0);
                      Main.modeloVerClientes.setValueAt(Main.arrayCuentas[22].ID,2,0);
                      Main.modeloVerClientes.setValueAt(Main.arrayCuentas[23].ID,3,0);
                      Main.modeloVerClientes.setValueAt(Main.arrayCuentas[24].ID,4,0);

                  }




              }


                }

        });
    }



}



