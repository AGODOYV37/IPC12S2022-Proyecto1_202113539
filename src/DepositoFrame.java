import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class DepositoFrame extends JFrame {
    private JPanel depCuentaPanel;
    private JComboBox comboBox1;

    public static JComboBox comboBox;

    private  JComboBox comboBoxAux;
    private JTextField textMonto;
    private JButton aceptarBtn;
    private JButton volverBtn;

    double monto;

    DisplayFrames d = new DisplayFrames();
    CrearTransaccion c = new CrearTransaccion();

    Date Fecha = new Date();

    boolean mostrar = true;

    public void LlenarCombo(String elemento){
        comboBox.addItem(elemento);
    }



    public DepositoFrame (){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(depCuentaPanel);
        aceptarBtn.setFocusable(false);
        aceptarBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));
        volverBtn.setFocusable(false);
        volverBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));
        String[] arrayAux = {
                Main.cuenta1Cliente1.ID+" - "+"Cuenta de "+Main.cliente1.Nombre+" "+Main.cliente1.Apellido,
                Main.cuenta2Cliente1.ID+" - "+"Cuenta de "+Main.cliente1.Nombre+" "+Main.cliente1.Apellido,
                Main.cuenta3Cliente1.ID+" - "+"Cuenta de "+Main.cliente1.Nombre+" "+Main.cliente1.Apellido,
                Main.cuenta4Cliente1.ID+" - "+"Cuenta de "+Main.cliente1.Nombre+" "+Main.cliente1.Apellido,
                Main.cuenta5Cliente1.ID+" - "+"Cuenta de "+Main.cliente1.Nombre+" "+Main.cliente1.Apellido,
                Main.cuenta1Cliente2.ID+" - "+"Cuenta de "+Main.cliente2.Nombre+" "+Main.cliente2.Apellido,
                Main.cuenta2Cliente2.ID+" - "+"Cuenta de "+Main.cliente2.Nombre+" "+Main.cliente2.Apellido,
                Main.cuenta3Cliente2.ID+" - "+"Cuenta de "+Main.cliente2.Nombre+" "+Main.cliente2.Apellido,
                Main.cuenta4Cliente2.ID+" - "+"Cuenta de "+Main.cliente2.Nombre+" "+Main.cliente2.Apellido,
                Main.cuenta5Cliente2.ID+" - "+"Cuenta de "+Main.cliente2.Nombre+" "+Main.cliente2.Apellido,
                Main.cuenta1Cliente3.ID+" - "+"Cuenta de "+Main.cliente3.Nombre+" "+Main.cliente3.Apellido,
                Main.cuenta2Cliente3.ID+" - "+"Cuenta de "+Main.cliente3.Nombre+" "+Main.cliente3.Apellido,
                Main.cuenta3Cliente3.ID+" - "+"Cuenta de "+Main.cliente3.Nombre+" "+Main.cliente3.Apellido,
                Main.cuenta4Cliente3.ID+" - "+"Cuenta de "+Main.cliente3.Nombre+" "+Main.cliente3.Apellido,
                Main.cuenta5Cliente3.ID+" - "+"Cuenta de "+Main.cliente3.Nombre+" "+Main.cliente3.Apellido,
                Main.cuenta1Cliente4.ID+" - "+"Cuenta de "+Main.cliente4.Nombre+" "+Main.cliente4.Apellido,
                Main.cuenta2Cliente4.ID+" - "+"Cuenta de "+Main.cliente4.Nombre+" "+Main.cliente4.Apellido,
                Main.cuenta3Cliente4.ID+" - "+"Cuenta de "+Main.cliente4.Nombre+" "+Main.cliente4.Apellido,
                Main.cuenta4Cliente4.ID+" - "+"Cuenta de "+Main.cliente4.Nombre+" "+Main.cliente4.Apellido,
                Main.cuenta5Cliente4.ID+" - "+"Cuenta de "+Main.cliente4.Nombre+" "+Main.cliente4.Apellido,
                Main.cuenta1Cliente5.ID+" - "+"Cuenta de "+Main.cliente5.Nombre+" "+Main.cliente5.Apellido,
                Main.cuenta2Cliente5.ID+" - "+"Cuenta de "+Main.cliente5.Nombre+" "+Main.cliente5.Apellido,
                Main.cuenta3Cliente5.ID+" - "+"Cuenta de "+Main.cliente5.Nombre+" "+Main.cliente5.Apellido,
                Main.cuenta4Cliente5.ID+" - "+"Cuenta de "+Main.cliente5.Nombre+" "+Main.cliente5.Apellido,
                Main.cuenta5Cliente5.ID+" - "+"Cuenta de "+Main.cliente5.Nombre+" "+Main.cliente5.Apellido



        };
        comboBoxAux = new JComboBox(arrayAux);
        comboBox1.setModel(comboBoxAux.getModel());
        textMonto.setHorizontalAlignment(JTextField.CENTER);


        volverBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.PantallaCharacter(mostrar);
                dispose();

            }
        });
        aceptarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    monto = Double.parseDouble(textMonto.getText());
                    textMonto.setText(null);
                    if(monto<=0.0){
                        JOptionPane.showMessageDialog(null, "El monto debe ser mayor a 0.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }else {
                        if (Main.arrayCuentas[comboBox1.getSelectedIndex()].ID == null) {
                            JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            Main.arrayCuentas[comboBox1.getSelectedIndex()].Saldo = Main.arrayCuentas[comboBox1.getSelectedIndex()].Saldo + monto;
                            JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                            if(comboBox1.getSelectedIndex()==0||comboBox1.getSelectedIndex()==1||comboBox1.getSelectedIndex()==2||comboBox1.getSelectedIndex()==3||comboBox1.getSelectedIndex()==4){
                                c.LlenarTrCliente(1,"Depósito",0,monto,Main.arrayCuentas[comboBox1.getSelectedIndex()].Saldo);
                            }
                            if(comboBox1.getSelectedIndex()==5||comboBox1.getSelectedIndex()==6||comboBox1.getSelectedIndex()==7||comboBox1.getSelectedIndex()==8||comboBox1.getSelectedIndex()==9){
                                c.LlenarTrCliente(2,"Depósito",0,monto,Main.arrayCuentas[comboBox1.getSelectedIndex()].Saldo);
                            }
                            if(comboBox1.getSelectedIndex()==10||comboBox1.getSelectedIndex()==11||comboBox1.getSelectedIndex()==12||comboBox1.getSelectedIndex()==13||comboBox1.getSelectedIndex()==14){
                                c.LlenarTrCliente(3,"Depósito",0,monto,Main.arrayCuentas[comboBox1.getSelectedIndex()].Saldo);
                            }
                            if(comboBox1.getSelectedIndex()==15||comboBox1.getSelectedIndex()==16||comboBox1.getSelectedIndex()==17||comboBox1.getSelectedIndex()==18||comboBox1.getSelectedIndex()==19){
                                c.LlenarTrCliente(4,"Depósito",0,monto,Main.arrayCuentas[comboBox1.getSelectedIndex()].Saldo);
                            }
                            if(comboBox1.getSelectedIndex()==20||comboBox1.getSelectedIndex()==21||comboBox1.getSelectedIndex()==22||comboBox1.getSelectedIndex()==23||comboBox1.getSelectedIndex()==24){
                                c.LlenarTrCliente(5,"Depósito",0,monto,Main.arrayCuentas[comboBox1.getSelectedIndex()].Saldo);
                            }

                        }
                    }

                }catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(null, "Debe llenar el campo con un número mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                    textMonto.setText(null);
                }



            }
        });


    }





}
