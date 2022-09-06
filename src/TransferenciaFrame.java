import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferenciaFrame extends JFrame {
    private JPanel transferenciaCuentasPanel;
    private JComboBox cuentaOrigenBox;
    private JTextField montoText;
    private JButton aceptarTrBtn;
    private JComboBox cuentaDestinoBox;

    private JComboBox comboBoxAux;
    private JComboBox comboBoxAux2;
    private JButton volverBtn;
    double monto;


    DisplayFrames d = new DisplayFrames();
    Cuentas c = new Cuentas();

    CrearTransaccion q = new CrearTransaccion();

    boolean mostrar = true;

    public TransferenciaFrame (){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(transferenciaCuentasPanel);
        aceptarTrBtn.setFocusable(false);
        aceptarTrBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));
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
        comboBoxAux = new JComboBox(arrayAux);
        comboBoxAux2= new JComboBox(arrayAux);
        cuentaOrigenBox.setModel(comboBoxAux.getModel());
        cuentaDestinoBox.setModel(comboBoxAux2.getModel());

        volverBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.PantallaCharacter(mostrar);
                dispose();
            }
        });
        aceptarTrBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    monto = Double.parseDouble(montoText.getText());
                    montoText.setText(null);
                    if(monto<=0.0){
                        JOptionPane.showMessageDialog(null, "El monto debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                    }else {
                        if(cuentaOrigenBox.getSelectedIndex()==cuentaDestinoBox.getSelectedIndex()) {
                            JOptionPane.showMessageDialog(null, "La cuenta destino no puede ser igual a la cuenta de origen.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        }else {
                            if (Main.arrayCuentas[cuentaOrigenBox.getSelectedIndex()].ID == null||Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].ID == null) {
                                JOptionPane.showMessageDialog(null, "Ambas campos deben estar seleccionados en una cuenta", "Error", JOptionPane.ERROR_MESSAGE);
                            }else {
                                if (Main.arrayCuentas[cuentaOrigenBox.getSelectedIndex()].Saldo < monto) {
                                    JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                } else {

                                    Main.arrayCuentas[cuentaOrigenBox.getSelectedIndex()].Saldo = Main.arrayCuentas[cuentaOrigenBox.getSelectedIndex()].Saldo - monto;
                                    Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo = Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo + monto;
                                    JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    if (cuentaOrigenBox.getSelectedIndex()==0||cuentaOrigenBox.getSelectedIndex()==1||cuentaOrigenBox.getSelectedIndex()==2||cuentaOrigenBox.getSelectedIndex()==3||cuentaOrigenBox.getSelectedIndex()==4) {
                                        q.LlenarTrCliente(1, "Transferencia", monto, 0, Main.arrayCuentas[cuentaOrigenBox.getSelectedIndex()].Saldo);
                                        if (cuentaDestinoBox.getSelectedIndex()==0||cuentaDestinoBox.getSelectedIndex()==1||cuentaDestinoBox.getSelectedIndex()==2||cuentaDestinoBox.getSelectedIndex()==3||cuentaDestinoBox.getSelectedIndex()==4) {
                                            q.LlenarTrCliente(1, "Transferencia", 0, monto, Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex()==5||cuentaDestinoBox.getSelectedIndex()==6||cuentaDestinoBox.getSelectedIndex()==7||cuentaDestinoBox.getSelectedIndex()==8||cuentaDestinoBox.getSelectedIndex()==9) {
                                            q.LlenarTrCliente(2, "Transferencia", 0, monto, Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex()==10||cuentaDestinoBox.getSelectedIndex()==11||cuentaDestinoBox.getSelectedIndex()==12||cuentaDestinoBox.getSelectedIndex()==13||cuentaDestinoBox.getSelectedIndex()==14) {
                                            q.LlenarTrCliente(3, "Transferencia", 0, monto, Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex()==15||cuentaDestinoBox.getSelectedIndex()==16||cuentaDestinoBox.getSelectedIndex()==17||cuentaDestinoBox.getSelectedIndex()==18||cuentaDestinoBox.getSelectedIndex()==19) {
                                            q.LlenarTrCliente(4, "Transferencia", 0, monto, Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex()==20||cuentaDestinoBox.getSelectedIndex()==21||cuentaDestinoBox.getSelectedIndex()==22||cuentaDestinoBox.getSelectedIndex()==23||cuentaDestinoBox.getSelectedIndex()==24) {
                                            q.LlenarTrCliente(4, "Transferencia", 0, monto, Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo);
                                        }


                                    }
                                    if (cuentaOrigenBox.getSelectedIndex()==5||cuentaOrigenBox.getSelectedIndex()==6||cuentaOrigenBox.getSelectedIndex()==7||cuentaOrigenBox.getSelectedIndex()==8||cuentaOrigenBox.getSelectedIndex()==9) {
                                        q.LlenarTrCliente(1, "Transferencia", monto, 0, Main.arrayCuentas[cuentaOrigenBox.getSelectedIndex()].Saldo);
                                        if (cuentaDestinoBox.getSelectedIndex()==0||cuentaDestinoBox.getSelectedIndex()==1||cuentaDestinoBox.getSelectedIndex()==2||cuentaDestinoBox.getSelectedIndex()==3||cuentaDestinoBox.getSelectedIndex()==4) {
                                            q.LlenarTrCliente(1, "Transferencia", 0, monto, Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex()==5||cuentaDestinoBox.getSelectedIndex()==6||cuentaDestinoBox.getSelectedIndex()==7||cuentaDestinoBox.getSelectedIndex()==8||cuentaDestinoBox.getSelectedIndex()==9) {
                                            q.LlenarTrCliente(2, "Transferencia", 0, monto, Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex()==10||cuentaDestinoBox.getSelectedIndex()==11||cuentaDestinoBox.getSelectedIndex()==12||cuentaDestinoBox.getSelectedIndex()==13||cuentaDestinoBox.getSelectedIndex()==14) {
                                            q.LlenarTrCliente(3, "Transferencia", 0, monto, Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex()==15||cuentaDestinoBox.getSelectedIndex()==16||cuentaDestinoBox.getSelectedIndex()==17||cuentaDestinoBox.getSelectedIndex()==18||cuentaDestinoBox.getSelectedIndex()==19) {
                                            q.LlenarTrCliente(4, "Transferencia", 0, monto, Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex()==20||cuentaDestinoBox.getSelectedIndex()==21||cuentaDestinoBox.getSelectedIndex()==22||cuentaDestinoBox.getSelectedIndex()==23||cuentaDestinoBox.getSelectedIndex()==24) {
                                            q.LlenarTrCliente(4, "Transferencia", 0, monto, Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo);
                                        }


                                    }
                                    if (cuentaOrigenBox.getSelectedIndex()==10||cuentaOrigenBox.getSelectedIndex()==11||cuentaOrigenBox.getSelectedIndex()==12||cuentaOrigenBox.getSelectedIndex()==13||cuentaOrigenBox.getSelectedIndex()==14) {
                                        q.LlenarTrCliente(1, "Transferencia", monto, 0, Main.arrayCuentas[cuentaOrigenBox.getSelectedIndex()].Saldo);
                                        if (cuentaDestinoBox.getSelectedIndex()==0||cuentaDestinoBox.getSelectedIndex()==1||cuentaDestinoBox.getSelectedIndex()==2||cuentaDestinoBox.getSelectedIndex()==3||cuentaDestinoBox.getSelectedIndex()==4) {
                                            q.LlenarTrCliente(1, "Transferencia", 0, monto, Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex()==5||cuentaDestinoBox.getSelectedIndex()==6||cuentaDestinoBox.getSelectedIndex()==7||cuentaDestinoBox.getSelectedIndex()==8||cuentaDestinoBox.getSelectedIndex()==9) {
                                            q.LlenarTrCliente(2, "Transferencia", 0, monto, Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex()==10||cuentaDestinoBox.getSelectedIndex()==11||cuentaDestinoBox.getSelectedIndex()==12||cuentaDestinoBox.getSelectedIndex()==13||cuentaDestinoBox.getSelectedIndex()==14) {
                                            q.LlenarTrCliente(3, "Transferencia", 0, monto, Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex()==15||cuentaDestinoBox.getSelectedIndex()==16||cuentaDestinoBox.getSelectedIndex()==17||cuentaDestinoBox.getSelectedIndex()==18||cuentaDestinoBox.getSelectedIndex()==19) {
                                            q.LlenarTrCliente(4, "Transferencia", 0, monto, Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex()==20||cuentaDestinoBox.getSelectedIndex()==21||cuentaDestinoBox.getSelectedIndex()==22||cuentaDestinoBox.getSelectedIndex()==23||cuentaDestinoBox.getSelectedIndex()==24) {
                                            q.LlenarTrCliente(4, "Transferencia", 0, monto, Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo);
                                        }


                                    }
                                    if (cuentaOrigenBox.getSelectedIndex()==15||cuentaOrigenBox.getSelectedIndex()==16||cuentaOrigenBox.getSelectedIndex()==17||cuentaOrigenBox.getSelectedIndex()==18||cuentaOrigenBox.getSelectedIndex()==19) {
                                        q.LlenarTrCliente(1, "Transferencia", monto, 0, Main.arrayCuentas[cuentaOrigenBox.getSelectedIndex()].Saldo);
                                        if (cuentaDestinoBox.getSelectedIndex()==0||cuentaDestinoBox.getSelectedIndex()==1||cuentaDestinoBox.getSelectedIndex()==2||cuentaDestinoBox.getSelectedIndex()==3||cuentaDestinoBox.getSelectedIndex()==4) {
                                            q.LlenarTrCliente(1, "Transferencia", 0, monto, Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex()==5||cuentaDestinoBox.getSelectedIndex()==6||cuentaDestinoBox.getSelectedIndex()==7||cuentaDestinoBox.getSelectedIndex()==8||cuentaDestinoBox.getSelectedIndex()==9) {
                                            q.LlenarTrCliente(2, "Transferencia", 0, monto, Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex()==10||cuentaDestinoBox.getSelectedIndex()==11||cuentaDestinoBox.getSelectedIndex()==12||cuentaDestinoBox.getSelectedIndex()==13||cuentaDestinoBox.getSelectedIndex()==14) {
                                            q.LlenarTrCliente(3, "Transferencia", 0, monto, Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex()==15||cuentaDestinoBox.getSelectedIndex()==16||cuentaDestinoBox.getSelectedIndex()==17||cuentaDestinoBox.getSelectedIndex()==18||cuentaDestinoBox.getSelectedIndex()==19) {
                                            q.LlenarTrCliente(4, "Transferencia", 0, monto, Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex()==20||cuentaDestinoBox.getSelectedIndex()==21||cuentaDestinoBox.getSelectedIndex()==22||cuentaDestinoBox.getSelectedIndex()==23||cuentaDestinoBox.getSelectedIndex()==24) {
                                            q.LlenarTrCliente(4, "Transferencia", 0, monto, Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo);
                                        }


                                    }
                                    if (cuentaOrigenBox.getSelectedIndex()==20||cuentaOrigenBox.getSelectedIndex()==21||cuentaOrigenBox.getSelectedIndex()==22||cuentaOrigenBox.getSelectedIndex()==23||cuentaOrigenBox.getSelectedIndex()==24) {
                                        q.LlenarTrCliente(1, "Transferencia", monto, 0, Main.arrayCuentas[cuentaOrigenBox.getSelectedIndex()].Saldo);
                                        if (cuentaDestinoBox.getSelectedIndex()==0||cuentaDestinoBox.getSelectedIndex()==1||cuentaDestinoBox.getSelectedIndex()==2||cuentaDestinoBox.getSelectedIndex()==3||cuentaDestinoBox.getSelectedIndex()==4) {
                                            q.LlenarTrCliente(1, "Transferencia", 0, monto, Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex()==5||cuentaDestinoBox.getSelectedIndex()==6||cuentaDestinoBox.getSelectedIndex()==7||cuentaDestinoBox.getSelectedIndex()==8||cuentaDestinoBox.getSelectedIndex()==9) {
                                            q.LlenarTrCliente(2, "Transferencia", 0, monto, Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex()==10||cuentaDestinoBox.getSelectedIndex()==11||cuentaDestinoBox.getSelectedIndex()==12||cuentaDestinoBox.getSelectedIndex()==13||cuentaDestinoBox.getSelectedIndex()==14) {
                                            q.LlenarTrCliente(3, "Transferencia", 0, monto, Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex()==15||cuentaDestinoBox.getSelectedIndex()==16||cuentaDestinoBox.getSelectedIndex()==17||cuentaDestinoBox.getSelectedIndex()==18||cuentaDestinoBox.getSelectedIndex()==19) {
                                            q.LlenarTrCliente(4, "Transferencia", 0, monto, Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex()==20||cuentaDestinoBox.getSelectedIndex()==21||cuentaDestinoBox.getSelectedIndex()==22||cuentaDestinoBox.getSelectedIndex()==23||cuentaDestinoBox.getSelectedIndex()==24) {
                                            q.LlenarTrCliente(4, "Transferencia", 0, monto, Main.arrayCuentas[cuentaDestinoBox.getSelectedIndex()].Saldo);
                                        }


                                    }

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
