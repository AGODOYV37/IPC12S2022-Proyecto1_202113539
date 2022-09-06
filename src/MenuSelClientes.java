import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MenuSelClientes extends JFrame {

    Random random = new Random();


    boolean mostrar = true;
    public JComboBox comboBoxClientes;
    public JComboBox comboBoxAux;
    public String[] arrayClientesAux = new String[5];
    private JButton crearClienteBtn;
    private JPanel comboClientesPanel;
    private JButton volverBtn;




    DisplayFrames d = new DisplayFrames();

    Cuentas c = new Cuentas();

    Main m = new Main();






    public void setComboBoxClientes(JComboBox comboBoxClientes) {
        this.comboBoxClientes = comboBoxClientes;


    }




    public MenuSelClientes (){
        arrayClientesAux[0]=Main.cliente1.CUI+" - "+Main.cliente1.Nombre+" "+Main.cliente1.Apellido;
        arrayClientesAux[1]=Main.cliente2.CUI+" - "+Main.cliente2.Nombre+" "+Main.cliente2.Apellido;
        arrayClientesAux[2]=Main.cliente3.CUI+" - "+Main.cliente3.Nombre+" "+Main.cliente3.Apellido;
        arrayClientesAux[3]=Main.cliente4.CUI+" - "+Main.cliente4.Nombre+" "+Main.cliente4.Apellido;
        arrayClientesAux[4]=Main.cliente5.CUI+" - "+Main.cliente5.Nombre+" "+Main.cliente5.Apellido;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(comboClientesPanel);
        crearClienteBtn.setFocusable(false);
        crearClienteBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));
        volverBtn.setFocusable(false);
        volverBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));
        comboBoxAux = new JComboBox(arrayClientesAux);
        comboBoxClientes.setModel(comboBoxAux.getModel());



        crearClienteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Main.arrayClientes[comboBoxClientes.getSelectedIndex()].getNombre()==null){
                    JOptionPane.showMessageDialog(null, "No hay ningún cliente seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    switch (comboBoxClientes.getSelectedIndex()){
                        case(0):
                            if(Main.contCuentas1>=5){
                                JOptionPane.showMessageDialog(null, "No es posible crear más cuentas para el cliente seleccionado. ", "Advertencia", JOptionPane.WARNING_MESSAGE);
                            }else{
                                Main.arrayCuentas[Main.contCuentas1].ID = c.GenerarID();
                                Main.contCuentas1++;
                                JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                            }
                            break;

                        case (1):
                            if(Main.contCuentas2>=5){
                                JOptionPane.showMessageDialog(null, "No es posible crear más cuentas para el cliente seleccionado. ", "Advertencia", JOptionPane.WARNING_MESSAGE);
                            }else{
                                Main.arrayCuentas[5+Main.contCuentas2].ID = c.GenerarID();
                                Main.contCuentas2++;
                                JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                            }
                            break;
                        case (2):
                            if(Main.contCuentas3>=5){
                                JOptionPane.showMessageDialog(null, "No es posible crear más cuentas para el cliente seleccionado. ", "Advertencia", JOptionPane.WARNING_MESSAGE);
                            }else{
                                Main.arrayCuentas[10+Main.contCuentas3].ID = c.GenerarID();
                                Main.contCuentas3++;
                                JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                            }
                            break;
                        case (3):
                            if(Main.contCuentas4>=5){
                                JOptionPane.showMessageDialog(null, "No es posible crear más cuentas para el cliente seleccionado. ", "Advertencia", JOptionPane.WARNING_MESSAGE);
                            }else{
                                Main.arrayCuentas[15+Main.contCuentas4].ID = c.GenerarID();
                                Main.contCuentas4++;
                                JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                            }
                            break;
                        case (4):
                            if(Main.contCuentas5>=5){
                                JOptionPane.showMessageDialog(null, "No es posible crear más cuentas para el cliente seleccionado. ", "Advertencia", JOptionPane.WARNING_MESSAGE);
                            }else{
                                Main.arrayCuentas[20+Main.contCuentas5].ID = c.GenerarID();
                                Main.contCuentas5++;
                                JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                            }
                            break;





                    }




                }






            }
        });
        volverBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.PantallaCharacter(mostrar);
                dispose();


            }
        });
    }





}
