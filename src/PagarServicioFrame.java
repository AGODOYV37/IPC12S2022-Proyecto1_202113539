import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PagarServicioFrame extends JFrame {


    private JComboBox comboBoxAux;
    private JComboBox comboBoxAux2;
    private JTextField montoText;
    private JButton aceptarSerBtn;
    private JPanel pagarServicioPanel;
    private JButton volverBtn;
    private JComboBox comboBoxCuenta;
    private JComboBox comboBoxServicio;

    double monto;


    DisplayFrames d = new DisplayFrames();

    CrearTransaccion c = new CrearTransaccion();
    boolean mostrar = true;


    public PagarServicioFrame (){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pagarServicioPanel);
        aceptarSerBtn.setFocusable(false);
        aceptarSerBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));
        volverBtn.setFocusable(false);
        volverBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));
        montoText.setHorizontalAlignment(JTextField.CENTER);

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
        String[] arrayAux2 = {"Luz electrica","Agua","Servicio telefonico"};

        comboBoxAux = new JComboBox(arrayAux);
        comboBoxAux2= new JComboBox(arrayAux2);
        comboBoxCuenta.setModel(comboBoxAux.getModel());
        comboBoxServicio.setModel(comboBoxAux2.getModel());



        volverBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.PantallaCharacter(mostrar);
                dispose();

            }
        });
        aceptarSerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String detalle="";
                try{
                    monto = Double.parseDouble(montoText.getText());
                    montoText.setText(null);
                    if(monto<=0.0){
                        JOptionPane.showMessageDialog(null, "El monto del pago debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                    }else {
                        if(Main.arrayCuentas[comboBoxCuenta.getSelectedIndex()].Saldo<monto){
                            JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        }else {
                            if(Main.arrayCuentas[comboBoxCuenta.getSelectedIndex()].ID==null){
                                JOptionPane.showMessageDialog(null, "Debe seleccionar una cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
                            }else {
                                Main.arrayCuentas[comboBoxCuenta.getSelectedIndex()].Saldo = Main.arrayCuentas[comboBoxCuenta.getSelectedIndex()].Saldo - monto;
                                JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                switch (comboBoxServicio.getSelectedIndex()){
                                    case(0):
                                        detalle="Luz eléctrica";
                                        break;
                                    case(1):
                                        detalle="Agua";
                                        break;
                                    case(2):
                                        detalle="Servicio telefónico";
                                        break;


                                }
                                if(comboBoxCuenta.getSelectedIndex()==0||comboBoxCuenta.getSelectedIndex()==1||comboBoxCuenta.getSelectedIndex()==2||comboBoxCuenta.getSelectedIndex()==3||comboBoxCuenta.getSelectedIndex()==4){
                                    c.LlenarTrCliente(1,"Pago de servicio"+" - "+detalle,monto,0,Main.arrayCuentas[comboBoxCuenta.getSelectedIndex()].Saldo);
                                }
                                if(comboBoxCuenta.getSelectedIndex()==5||comboBoxCuenta.getSelectedIndex()==6||comboBoxCuenta.getSelectedIndex()==7||comboBoxCuenta.getSelectedIndex()==8||comboBoxCuenta.getSelectedIndex()==9){
                                    c.LlenarTrCliente(2,"Pago de servicio"+" - "+detalle,monto,0,Main.arrayCuentas[comboBoxCuenta.getSelectedIndex()].Saldo);
                                }
                                if(comboBoxCuenta.getSelectedIndex()==10||comboBoxCuenta.getSelectedIndex()==11||comboBoxCuenta.getSelectedIndex()==12||comboBoxCuenta.getSelectedIndex()==13||comboBoxCuenta.getSelectedIndex()==14){
                                    c.LlenarTrCliente(3,"Pago de servicio"+" - "+detalle,monto,0,Main.arrayCuentas[comboBoxCuenta.getSelectedIndex()].Saldo);
                                }
                                if(comboBoxCuenta.getSelectedIndex()==15||comboBoxCuenta.getSelectedIndex()==16||comboBoxCuenta.getSelectedIndex()==17||comboBoxCuenta.getSelectedIndex()==18||comboBoxCuenta.getSelectedIndex()==19){
                                    c.LlenarTrCliente(4,"Pago de servicio"+" - "+detalle,monto,0,Main.arrayCuentas[comboBoxCuenta.getSelectedIndex()].Saldo);
                                }
                                if(comboBoxCuenta.getSelectedIndex()==20||comboBoxCuenta.getSelectedIndex()==21||comboBoxCuenta.getSelectedIndex()==22||comboBoxCuenta.getSelectedIndex()==23||comboBoxCuenta.getSelectedIndex()==24){
                                    c.LlenarTrCliente(5,"Pago de servicio"+" - "+detalle,monto,0,Main.arrayCuentas[comboBoxCuenta.getSelectedIndex()].Saldo);
                                }




                            }
                    }
                    }

                }catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(null, "Debe llenar el campo con un número mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                    montoText.setText(null);
                }



            }
        });
        }
    }



