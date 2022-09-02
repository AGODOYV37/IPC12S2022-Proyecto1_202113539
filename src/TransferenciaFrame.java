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
        String[] arrayAux = {
                Main.C1.ID1+" - "+"Cuenta de "+Main.cliente1.Nombre+" "+Main.cliente1.Apellido,
                Main.C1.ID2+" - "+"Cuenta de "+Main.cliente1.Nombre+" "+Main.cliente1.Apellido,
                Main.C1.ID3+" - "+"Cuenta de "+Main.cliente1.Nombre+" "+Main.cliente1.Apellido,
                Main.C1.ID4+" - "+"Cuenta de "+Main.cliente1.Nombre+" "+Main.cliente1.Apellido,
                Main.C1.ID5+" - "+"Cuenta de "+Main.cliente1.Nombre+" "+Main.cliente1.Apellido,
                Main.C2.ID1+" - "+"Cuenta de "+Main.cliente2.Nombre+" "+Main.cliente2.Apellido,
                Main.C2.ID2+" - "+"Cuenta de "+Main.cliente2.Nombre+" "+Main.cliente2.Apellido,
                Main.C2.ID3+" - "+"Cuenta de "+Main.cliente2.Nombre+" "+Main.cliente2.Apellido,
                Main.C2.ID4+" - "+"Cuenta de "+Main.cliente2.Nombre+" "+Main.cliente2.Apellido,
                Main.C2.ID5+" - "+"Cuenta de "+Main.cliente2.Nombre+" "+Main.cliente2.Apellido,
                Main.C3.ID1+" - "+"Cuenta de "+Main.cliente3.Nombre+" "+Main.cliente3.Apellido,
                Main.C3.ID2+" - "+"Cuenta de "+Main.cliente3.Nombre+" "+Main.cliente3.Apellido,
                Main.C3.ID3+" - "+"Cuenta de "+Main.cliente3.Nombre+" "+Main.cliente3.Apellido,
                Main.C3.ID4+" - "+"Cuenta de "+Main.cliente3.Nombre+" "+Main.cliente3.Apellido,
                Main.C3.ID5+" - "+"Cuenta de "+Main.cliente3.Nombre+" "+Main.cliente3.Apellido,
                Main.C4.ID1+" - "+"Cuenta de "+Main.cliente4.Nombre+" "+Main.cliente4.Apellido,
                Main.C4.ID2+" - "+"Cuenta de "+Main.cliente4.Nombre+" "+Main.cliente4.Apellido,
                Main.C4.ID3+" - "+"Cuenta de "+Main.cliente4.Nombre+" "+Main.cliente4.Apellido,
                Main.C4.ID4+" - "+"Cuenta de "+Main.cliente4.Nombre+" "+Main.cliente4.Apellido,
                Main.C4.ID5+" - "+"Cuenta de "+Main.cliente4.Nombre+" "+Main.cliente4.Apellido,
                Main.C5.ID1+" - "+"Cuenta de "+Main.cliente5.Nombre+" "+Main.cliente5.Apellido,
                Main.C5.ID2+" - "+"Cuenta de "+Main.cliente5.Nombre+" "+Main.cliente5.Apellido,
                Main.C5.ID3+" - "+"Cuenta de "+Main.cliente5.Nombre+" "+Main.cliente5.Apellido,
                Main.C5.ID4+" - "+"Cuenta de "+Main.cliente5.Nombre+" "+Main.cliente5.Apellido,
                Main.C5.ID5+" - "+"Cuenta de "+Main.cliente5.Nombre+" "+Main.cliente5.Apellido


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

                            switch (cuentaOrigenBox.getSelectedIndex()) {
                                case (0):
                                    if(Main.C1.SaldoID1<monto){
                                        JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                    }else {
                                        if (cuentaDestinoBox.getSelectedIndex() == 0) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C1, monto, 1, 1);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",monto,0,Main.C1.SaldoID1);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 1) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C1, monto, 1, 2);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",monto,0,Main.C1.SaldoID1);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",0,monto,Main.C1.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 2) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C1, monto, 1, 3);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",monto,0,Main.C1.SaldoID1);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",0,monto,Main.C1.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 3) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C1, monto, 1, 4);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",monto,0,Main.C1.SaldoID1);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",0,monto,Main.C1.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 4) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C1, monto, 1, 5);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",monto,0,Main.C1.SaldoID1);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",0,monto,Main.C1.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 5) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C2, monto, 1, 1);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",monto,0,Main.C1.SaldoID1);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 6) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C2, monto, 1, 2);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",monto,0,Main.C1.SaldoID1);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",0,monto,Main.C2.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 7) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C2, monto, 1, 3);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",monto,0,Main.C1.SaldoID1);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",0,monto,Main.C2.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 8) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C2, monto, 1, 4);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",monto,0,Main.C1.SaldoID1);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",0,monto,Main.C2.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 9) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C2, monto, 1, 5);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",monto,0,Main.C1.SaldoID1);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",0,monto,Main.C2.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 10) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C3, monto, 1, 1);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",monto,0,Main.C1.SaldoID1);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 11) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C3, monto, 1, 2);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",monto,0,Main.C1.SaldoID1);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",0,monto,Main.C3.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 12) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C3, monto, 1, 3);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",monto,0,Main.C1.SaldoID1);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",0,monto,Main.C3.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 13) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C3, monto, 1, 4);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",monto,0,Main.C1.SaldoID1);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",0,monto,Main.C3.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 14) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C3, monto, 1, 5);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",monto,0,Main.C1.SaldoID1);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",0,monto,Main.C3.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 15) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C4, monto, 1, 1);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",monto,0,Main.C1.SaldoID1);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 16) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C4, monto, 1, 2);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",monto,0,Main.C1.SaldoID1);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",0,monto,Main.C4.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 17) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C4, monto, 1, 3);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",monto,0,Main.C1.SaldoID1);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",0,monto,Main.C4.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 18) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C4, monto, 1, 4);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",monto,0,Main.C1.SaldoID1);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",0,monto,Main.C4.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 19) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C4, monto, 1, 5);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",monto,0,Main.C1.SaldoID1);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",0,monto,Main.C4.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 20) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C5, monto, 1, 1);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",monto,0,Main.C1.SaldoID1);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 21) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C5, monto, 1, 2);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",monto,0,Main.C1.SaldoID1);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",0,monto,Main.C5.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 22) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C5, monto, 1, 3);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",monto,0,Main.C1.SaldoID1);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",0,monto,Main.C5.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 23) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C5, monto, 1, 4);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",monto,0,Main.C1.SaldoID1);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",0,monto,Main.C5.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 24) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C5, monto, 1, 5);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",monto,0,Main.C1.SaldoID1);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",0,monto,Main.C5.SaldoID5);
                                        }
                                        JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    break;
                                case(1):
                                    if(Main.C1.SaldoID2<monto){
                                        JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                        q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",monto,0,Main.C1.SaldoID2);
                                        q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID1);
                                    }else {
                                        if (cuentaDestinoBox.getSelectedIndex() == 0) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C1, monto, 2, 1);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",monto,0,Main.C1.SaldoID2);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",0,monto,Main.C1.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 1) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C1, monto, 2, 2);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",monto,0,Main.C1.SaldoID2);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",0,monto,Main.C1.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 2) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C1, monto, 2, 3);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",monto,0,Main.C1.SaldoID2);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",0,monto,Main.C1.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 3) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C1, monto, 2, 4);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",monto,0,Main.C1.SaldoID2);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",0,monto,Main.C1.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 4) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C1, monto, 2, 5);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",monto,0,Main.C1.SaldoID2);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 5) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C2, monto, 2, 1);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",monto,0,Main.C1.SaldoID2);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",0,monto,Main.C2.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 6) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C2, monto, 2, 2);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",monto,0,Main.C1.SaldoID2);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",0,monto,Main.C2.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 7) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C2, monto, 2, 3);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",monto,0,Main.C1.SaldoID2);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",0,monto,Main.C2.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 8) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C2, monto, 1, 4);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",monto,0,Main.C1.SaldoID2);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",0,monto,Main.C2.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 9) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C2, monto, 2, 5);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",monto,0,Main.C1.SaldoID2);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 10) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C3, monto, 2, 1);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",monto,0,Main.C1.SaldoID2);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",0,monto,Main.C3.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 11) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C3, monto, 2, 2);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",monto,0,Main.C1.SaldoID2);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",0,monto,Main.C3.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 12) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C3, monto, 2, 3);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",monto,0,Main.C1.SaldoID2);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",0,monto,Main.C3.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 13) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C3, monto, 2, 4);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",monto,0,Main.C1.SaldoID2);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",0,monto,Main.C3.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 14) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C3, monto, 2, 5);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",monto,0,Main.C1.SaldoID2);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 15) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C4, monto, 2, 1);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",monto,0,Main.C1.SaldoID2);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",0,monto,Main.C4.SaldoID2);

                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 16) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C4, monto, 2, 2);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",monto,0,Main.C1.SaldoID2);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",0,monto,Main.C4.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 17) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C4, monto, 2, 3);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",monto,0,Main.C1.SaldoID2);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",0,monto,Main.C4.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 18) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C4, monto, 2, 4);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",monto,0,Main.C1.SaldoID2);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",0,monto,Main.C4.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 19) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C4, monto, 2, 5);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",monto,0,Main.C1.SaldoID2);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",0,monto,Main.C4.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 20) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C5, monto, 2, 1);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",monto,0,Main.C1.SaldoID2);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 21) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C5, monto, 2, 2);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",monto,0,Main.C1.SaldoID2);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",0,monto,Main.C5.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 22) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C5, monto, 2, 3);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",monto,0,Main.C1.SaldoID2);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",0,monto,Main.C5.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 23) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C5, monto, 2, 4);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",monto,0,Main.C1.SaldoID2);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",0,monto,Main.C5.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 24) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C5, monto, 2, 5);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",monto,0,Main.C1.SaldoID2);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",0,monto,Main.C5.SaldoID5);
                                        }
                                        JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    break;
                                case (2):
                                    if(Main.C1.SaldoID3<monto){
                                        JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                    }else {
                                        if (cuentaDestinoBox.getSelectedIndex() == 0) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C1, monto, 3, 1);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",monto,0,Main.C1.SaldoID3);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 1) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C1, monto, 3, 2);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",monto,0,Main.C1.SaldoID3);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",0,monto,Main.C1.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 2) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C1, monto, 3, 3);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",monto,0,Main.C1.SaldoID3);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",0,monto,Main.C1.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 3) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C1, monto, 3, 4);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",monto,0,Main.C1.SaldoID3);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",0,monto,Main.C1.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 4) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C1, monto, 3, 5);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",monto,0,Main.C1.SaldoID3);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",0,monto,Main.C1.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 5) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C2, monto, 3, 1);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",monto,0,Main.C1.SaldoID3);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 6) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C2, monto, 3, 2);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",monto,0,Main.C1.SaldoID3);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",0,monto,Main.C2.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 7) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C2, monto, 3, 3);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",monto,0,Main.C1.SaldoID3);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",0,monto,Main.C2.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 8) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C2, monto, 3, 4);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",monto,0,Main.C1.SaldoID3);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",0,monto,Main.C2.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 9) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C2, monto, 3, 5);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",monto,0,Main.C1.SaldoID3);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",0,monto,Main.C2.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 10) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C3, monto, 3, 1);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",monto,0,Main.C1.SaldoID3);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 11) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C3, monto, 3, 2);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",monto,0,Main.C1.SaldoID3);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",0,monto,Main.C3.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 12) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C3, monto, 3, 3);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",monto,0,Main.C1.SaldoID3);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",0,monto,Main.C3.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 13) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C3, monto, 3, 4);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",monto,0,Main.C1.SaldoID3);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",0,monto,Main.C3.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 14) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C3, monto, 3, 5);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",monto,0,Main.C1.SaldoID3);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",0,monto,Main.C3.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 15) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C4, monto, 3, 1);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",monto,0,Main.C1.SaldoID3);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 16) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C4, monto, 3, 2);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",monto,0,Main.C1.SaldoID3);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",0,monto,Main.C4.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 17) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C4, monto, 3, 3);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",monto,0,Main.C1.SaldoID3);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",0,monto,Main.C4.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 18) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C4, monto, 3, 4);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",monto,0,Main.C1.SaldoID3);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",0,monto,Main.C4.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 19) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C4, monto, 3, 5);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",monto,0,Main.C1.SaldoID3);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",0,monto,Main.C4.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 20) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C5, monto, 3, 1);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",monto,0,Main.C1.SaldoID3);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 21) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C5, monto, 3, 2);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",monto,0,Main.C1.SaldoID3);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",0,monto,Main.C5.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 22) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C5, monto, 3, 3);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",monto,0,Main.C1.SaldoID3);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",0,monto,Main.C5.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 23) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C5, monto, 3, 4);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",monto,0,Main.C1.SaldoID3);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",0,monto,Main.C5.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 24) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C5, monto, 3, 5);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",monto,0,Main.C1.SaldoID3);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",0,monto,Main.C5.SaldoID5);
                                        }
                                        JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    break;
                                case(3):
                                    if(Main.C1.SaldoID4<monto){
                                        JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                    }else {
                                        if (cuentaDestinoBox.getSelectedIndex() == 0) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C1, monto, 4, 1);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",monto,0,Main.C1.SaldoID4);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 1) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C1, monto, 4, 2);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",monto,0,Main.C1.SaldoID4);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",0,monto,Main.C1.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 2) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C1, monto, 4, 3);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",monto,0,Main.C1.SaldoID4);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",0,monto,Main.C1.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 3) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C1, monto, 4, 4);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",monto,0,Main.C1.SaldoID4);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",0,monto,Main.C1.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 4) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C1, monto, 4, 5);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",monto,0,Main.C1.SaldoID4);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",0,monto,Main.C1.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 5) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C2, monto, 4, 1);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",monto,0,Main.C1.SaldoID4);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 6) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C2, monto, 4, 2);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",monto,0,Main.C1.SaldoID4);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",0,monto,Main.C2.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 7) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C2, monto, 4, 3);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",monto,0,Main.C1.SaldoID4);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",0,monto,Main.C2.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 8) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C2, monto, 4, 4);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",monto,0,Main.C1.SaldoID4);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",0,monto,Main.C2.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 9) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C2, monto, 4, 5);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",monto,0,Main.C1.SaldoID4);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",0,monto,Main.C2.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 10) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C3, monto, 4, 1);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",monto,0,Main.C1.SaldoID4);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 11) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C3, monto, 4, 2);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",monto,0,Main.C1.SaldoID4);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",0,monto,Main.C3.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 12) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C3, monto, 4, 3);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",monto,0,Main.C1.SaldoID4);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",0,monto,Main.C3.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 13) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C3, monto, 4, 4);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",monto,0,Main.C1.SaldoID4);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",0,monto,Main.C3.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 14) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C3, monto, 4, 5);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",monto,0,Main.C1.SaldoID4);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",0,monto,Main.C3.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 15) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C4, monto, 4, 1);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",monto,0,Main.C1.SaldoID4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 16) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C4, monto, 4, 2);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",monto,0,Main.C1.SaldoID4);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",0,monto,Main.C4.SaldoID2);

                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 17) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C4, monto, 4, 3);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",monto,0,Main.C1.SaldoID4);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",0,monto,Main.C4.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 18) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C4, monto, 4, 4);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",monto,0,Main.C1.SaldoID4);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",0,monto,Main.C4.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 19) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C4, monto, 4, 5);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",monto,0,Main.C1.SaldoID4);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",0,monto,Main.C4.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 20) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C5, monto, 4, 1);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",monto,0,Main.C1.SaldoID4);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 21) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C5, monto, 4, 2);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",monto,0,Main.C1.SaldoID4);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",0,monto,Main.C5.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 22) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C5, monto, 4, 3);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",monto,0,Main.C1.SaldoID4);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",0,monto,Main.C5.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 23) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C5, monto, 4, 4);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",monto,0,Main.C1.SaldoID4);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",0,monto,Main.C5.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 24) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C5, monto, 4, 5);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",monto,0,Main.C1.SaldoID4);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",0,monto,Main.C5.SaldoID5);
                                        }
                                        JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    break;
                                case(4):
                                    if(Main.C1.SaldoID5<monto){
                                        JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                    }else {
                                        if (cuentaDestinoBox.getSelectedIndex() == 0) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C1, monto, 5, 1);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",monto,0,Main.C1.SaldoID5);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C5.SaldoID1);


                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 1) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C1, monto, 5, 2);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",monto,0,Main.C1.SaldoID5);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",0,monto,Main.C5.SaldoID2);

                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 2) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C1, monto, 5, 3);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",monto,0,Main.C1.SaldoID5);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",0,monto,Main.C5.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 3) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C1, monto, 5, 4);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",monto,0,Main.C1.SaldoID5);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",0,monto,Main.C5.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 4) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C1, monto, 5, 5);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",monto,0,Main.C1.SaldoID5);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",0,monto,Main.C5.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 5) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C2, monto, 5, 1);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",monto,0,Main.C1.SaldoID5);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 6) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C2, monto, 5, 2);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",monto,0,Main.C1.SaldoID5);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",0,monto,Main.C2.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 7) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C2, monto, 5, 3);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",monto,0,Main.C1.SaldoID5);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",0,monto,Main.C2.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 8) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C2, monto, 5, 4);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",monto,0,Main.C1.SaldoID5);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",0,monto,Main.C2.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 9) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C2, monto, 5, 5);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",monto,0,Main.C1.SaldoID5);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",0,monto,Main.C2.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 10) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C3, monto, 5, 1);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",monto,0,Main.C1.SaldoID5);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 11) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C3, monto, 5, 2);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",monto,0,Main.C1.SaldoID5);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",0,monto,Main.C3.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 12) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C3, monto, 5, 3);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",monto,0,Main.C1.SaldoID5);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",0,monto,Main.C3.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 13) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C3, monto, 5, 4);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",monto,0,Main.C1.SaldoID5);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",0,monto,Main.C3.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 14) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C3, monto, 5, 5);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",monto,0,Main.C1.SaldoID5);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",0,monto,Main.C3.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 15) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C4, monto, 5, 1);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",monto,0,Main.C1.SaldoID5);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 16) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C4, monto, 5, 2);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",monto,0,Main.C1.SaldoID5);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",0,monto,Main.C4.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 17) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C4, monto, 5, 3);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",monto,0,Main.C1.SaldoID5);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",0,monto,Main.C4.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 18) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C4, monto, 5, 4);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",monto,0,Main.C1.SaldoID5);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",0,monto,Main.C4.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 19) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C4, monto, 5, 5);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",monto,0,Main.C1.SaldoID5);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",0,monto,Main.C4.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 20) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C5, monto, 5, 1);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",monto,0,Main.C1.SaldoID5);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 21) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C5, monto, 5, 2);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",monto,0,Main.C1.SaldoID5);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",0,monto,Main.C5.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 22) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C5, monto, 5, 3);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",monto,0,Main.C1.SaldoID5);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",0,monto,Main.C5.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 23) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C5, monto, 5, 4);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",monto,0,Main.C1.SaldoID5);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",0,monto,Main.C5.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 24) {
                                            c.TransferenciaDeFondos(Main.C1, Main.C5, monto, 5, 5);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",monto,0,Main.C1.SaldoID5);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",0,monto,Main.C5.SaldoID5);
                                        }
                                        JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    break;
                                case (5):
                                    if(Main.C2.SaldoID1<monto){
                                        JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                    }else {
                                        if (cuentaDestinoBox.getSelectedIndex() == 0) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C1, monto, 1, 1);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",monto,0,Main.C2.SaldoID1);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 1) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C1, monto, 1, 2);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",monto,0,Main.C2.SaldoID1);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",0,monto,Main.C1.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 2) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C1, monto, 1, 3);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",monto,0,Main.C2.SaldoID1);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",0,monto,Main.C1.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 3) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C1, monto, 1, 4);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",monto,0,Main.C2.SaldoID1);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",0,monto,Main.C1.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 4) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C1, monto, 1, 5);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",monto,0,Main.C2.SaldoID1);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",0,monto,Main.C1.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 5) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C2, monto, 1, 1);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",monto,0,Main.C2.SaldoID1);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 6) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C2, monto, 1, 2);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",monto,0,Main.C2.SaldoID1);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",0,monto,Main.C2.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 7) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C2, monto, 1, 3);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",monto,0,Main.C2.SaldoID1);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",0,monto,Main.C2.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 8) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C2, monto, 1, 4);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",monto,0,Main.C2.SaldoID1);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",0,monto,Main.C2.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 9) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C2, monto, 1, 5);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",monto,0,Main.C2.SaldoID1);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",0,monto,Main.C2.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 10) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C3, monto, 1, 1);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",monto,0,Main.C2.SaldoID1);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 11) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C3, monto, 1, 2);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",monto,0,Main.C2.SaldoID1);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",0,monto,Main.C3.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 12) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C3, monto, 1, 3);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",monto,0,Main.C2.SaldoID1);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",0,monto,Main.C3.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 13) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C3, monto, 1, 4);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",monto,0,Main.C2.SaldoID1);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",0,monto,Main.C3.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 14) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C3, monto, 1, 5);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",monto,0,Main.C2.SaldoID1);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",0,monto,Main.C3.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 15) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C4, monto, 1, 1);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",monto,0,Main.C2.SaldoID1);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 16) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C4, monto, 1, 2);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",monto,0,Main.C2.SaldoID1);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",0,monto,Main.C4.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 17) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C4, monto, 1, 3);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",monto,0,Main.C2.SaldoID1);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",0,monto,Main.C4.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 18) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C4, monto, 1, 4);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",monto,0,Main.C2.SaldoID1);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",0,monto,Main.C4.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 19) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C4, monto, 1, 5);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",monto,0,Main.C2.SaldoID1);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",0,monto,Main.C4.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 20) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C5, monto, 1, 1);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",monto,0,Main.C2.SaldoID1);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 21) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C5, monto, 1, 2);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",monto,0,Main.C2.SaldoID1);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",0,monto,Main.C5.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 22) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C5, monto, 1, 3);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",monto,0,Main.C2.SaldoID1);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",0,monto,Main.C5.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 23) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C5, monto, 1, 4);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",monto,0,Main.C2.SaldoID1);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",0,monto,Main.C5.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 24) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C5, monto, 1, 5);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",monto,0,Main.C2.SaldoID1);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",0,monto,Main.C5.SaldoID5);
                                        }
                                        JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    break;
                                case(6):
                                    if(Main.C2.SaldoID2<monto){
                                        JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                    }else {
                                        if (cuentaDestinoBox.getSelectedIndex() == 0) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C1, monto, 2, 1);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",monto,0,Main.C2.SaldoID2);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 1) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C1, monto, 2, 2);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",monto,0,Main.C2.SaldoID2);
                                            q.LlenarTrCliente1(Main.C1.ID2,"Transferencia",0,monto,Main.C1.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 2) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C1, monto, 2, 3);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",monto,0,Main.C2.SaldoID2);
                                            q.LlenarTrCliente1(Main.C1.ID3,"Transferencia",0,monto,Main.C1.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 3) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C1, monto, 2, 4);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",monto,0,Main.C2.SaldoID2);
                                            q.LlenarTrCliente1(Main.C1.ID4,"Transferencia",0,monto,Main.C1.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 4) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C1, monto, 2, 5);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",monto,0,Main.C2.SaldoID2);
                                            q.LlenarTrCliente1(Main.C1.ID5,"Transferencia",0,monto,Main.C1.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 5) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C2, monto, 2, 1);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",monto,0,Main.C2.SaldoID2);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 6) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C2, monto, 2, 2);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",monto,0,Main.C2.SaldoID2);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",0,monto,Main.C2.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 7) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C2, monto, 2, 3);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",monto,0,Main.C2.SaldoID2);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 8) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C2, monto, 1, 4);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",monto,0,Main.C2.SaldoID2);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 9) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C2, monto, 2, 5);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",monto,0,Main.C2.SaldoID2);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 10) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C3, monto, 2, 1);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",monto,0,Main.C2.SaldoID2);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 11) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C3, monto, 2, 2);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",monto,0,Main.C2.SaldoID2);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 12) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C3, monto, 2, 3);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",monto,0,Main.C2.SaldoID2);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 13) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C3, monto, 2, 4);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",monto,0,Main.C2.SaldoID2);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 14) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C3, monto, 2, 5);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",monto,0,Main.C2.SaldoID2);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 15) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C4, monto, 2, 1);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",monto,0,Main.C2.SaldoID2);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 16) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C4, monto, 2, 2);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",monto,0,Main.C2.SaldoID2);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 17) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C4, monto, 2, 3);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",monto,0,Main.C2.SaldoID2);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 18) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C4, monto, 2, 4);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",monto,0,Main.C2.SaldoID2);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID4);

                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 19) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C4, monto, 2, 5);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",monto,0,Main.C2.SaldoID2);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID5);

                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 20) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C5, monto, 2, 1);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",monto,0,Main.C2.SaldoID2);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 21) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C5, monto, 2, 2);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",monto,0,Main.C2.SaldoID2);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 22) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C5, monto, 2, 3);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",monto,0,Main.C2.SaldoID2);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 23) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C5, monto, 2, 4);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",monto,0,Main.C2.SaldoID2);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 24) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C5, monto, 2, 5);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",monto,0,Main.C2.SaldoID2);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID5);
                                        }
                                        JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    break;
                                case (7):
                                    if(Main.C2.SaldoID3<monto){
                                        JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                    }else {
                                        if (cuentaDestinoBox.getSelectedIndex() == 0) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C1, monto, 3, 1);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",monto,0,Main.C2.SaldoID3);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 1) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C1, monto, 3, 2);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",monto,0,Main.C2.SaldoID3);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 2) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C1, monto, 3, 3);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",monto,0,Main.C2.SaldoID3);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 3) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C1, monto, 3, 4);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",monto,0,Main.C2.SaldoID3);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 4) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C1, monto, 3, 5);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",monto,0,Main.C2.SaldoID3);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 5) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C2, monto, 3, 1);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",monto,0,Main.C2.SaldoID3);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 6) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C2, monto, 3, 2);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",monto,0,Main.C2.SaldoID3);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 7) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C2, monto, 3, 3);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",monto,0,Main.C2.SaldoID3);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID3);

                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 8) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C2, monto, 3, 4);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",monto,0,Main.C2.SaldoID3);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 9) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C2, monto, 3, 5);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",monto,0,Main.C2.SaldoID3);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 10) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C3, monto, 3, 1);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",monto,0,Main.C2.SaldoID3);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 11) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C3, monto, 3, 2);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",monto,0,Main.C2.SaldoID3);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 12) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C3, monto, 3, 3);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",monto,0,Main.C2.SaldoID3);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 13) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C3, monto, 3, 4);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",monto,0,Main.C2.SaldoID3);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 14) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C3, monto, 3, 5);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",monto,0,Main.C2.SaldoID3);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 15) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C4, monto, 3, 1);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",monto,0,Main.C2.SaldoID3);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 16) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C4, monto, 3, 2);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",monto,0,Main.C2.SaldoID3);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 17) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C4, monto, 3, 3);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",monto,0,Main.C2.SaldoID3);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 18) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C4, monto, 3, 4);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",monto,0,Main.C2.SaldoID3);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 19) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C4, monto, 3, 5);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",monto,0,Main.C2.SaldoID3);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 20) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C5, monto, 3, 1);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",monto,0,Main.C2.SaldoID3);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 21) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C5, monto, 3, 2);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",monto,0,Main.C2.SaldoID3);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 22) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C5, monto, 3, 3);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",monto,0,Main.C2.SaldoID3);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 23) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C5, monto, 3, 4);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",monto,0,Main.C2.SaldoID3);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID4);
                                        }

                                        if (cuentaDestinoBox.getSelectedIndex() == 24) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C5, monto, 3, 5);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",monto,0,Main.C2.SaldoID3);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID5);
                                        }
                                        JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    break;
                                case(8):
                                    if(Main.C2.SaldoID4<monto){
                                        JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                    }else {
                                        if (cuentaDestinoBox.getSelectedIndex() == 0) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C1, monto, 4, 1);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",monto,0,Main.C2.SaldoID4);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 1) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C1, monto, 4, 2);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",monto,0,Main.C2.SaldoID4);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 2) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C1, monto, 4, 3);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",monto,0,Main.C2.SaldoID4);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 3) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C1, monto, 4, 4);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",monto,0,Main.C2.SaldoID4);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 4) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C1, monto, 4, 5);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",monto,0,Main.C2.SaldoID4);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 5) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C2, monto, 4, 1);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",monto,0,Main.C2.SaldoID4);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 6) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C2, monto, 4, 2);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",monto,0,Main.C2.SaldoID4);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 7) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C2, monto, 4, 3);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",monto,0,Main.C2.SaldoID4);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 8) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C2, monto, 4, 4);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",monto,0,Main.C2.SaldoID4);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 9) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C2, monto, 4, 5);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",monto,0,Main.C2.SaldoID4);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 10) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C3, monto, 4, 1);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",monto,0,Main.C2.SaldoID4);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 11) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C3, monto, 4, 2);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",monto,0,Main.C2.SaldoID4);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 12) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C3, monto, 4, 3);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",monto,0,Main.C2.SaldoID4);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 13) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C3, monto, 4, 4);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",monto,0,Main.C2.SaldoID4);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 14) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C3, monto, 4, 5);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",monto,0,Main.C2.SaldoID4);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 15) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C4, monto, 4, 1);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",monto,0,Main.C2.SaldoID4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 16) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C4, monto, 4, 2);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",monto,0,Main.C2.SaldoID4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 17) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C4, monto, 4, 3);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",monto,0,Main.C2.SaldoID4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 18) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C4, monto, 4, 4);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",monto,0,Main.C2.SaldoID4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 19) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C4, monto, 4, 5);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",monto,0,Main.C2.SaldoID4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 20) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C5, monto, 4, 1);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",monto,0,Main.C2.SaldoID4);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 21) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C5, monto, 4, 2);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",monto,0,Main.C2.SaldoID4);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 22) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C5, monto, 4, 3);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",monto,0,Main.C2.SaldoID4);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 23) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C5, monto, 4, 4);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",monto,0,Main.C2.SaldoID4);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 24) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C5, monto, 4, 5);
                                            q.LlenarTrCliente2(Main.C2.ID4,"Transferencia",monto,0,Main.C2.SaldoID4);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID5);
                                        }
                                        JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    break;
                                case(9):
                                    if(Main.C2.SaldoID5<monto){
                                        JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                    }else {
                                        if (cuentaDestinoBox.getSelectedIndex() == 0) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C1, monto, 5, 1);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",monto,0,Main.C2.SaldoID5);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 1) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C1, monto, 5, 2);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",monto,0,Main.C2.SaldoID5);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 2) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C1, monto, 5, 3);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",monto,0,Main.C2.SaldoID5);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 3) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C1, monto, 5, 4);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",monto,0,Main.C2.SaldoID5);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 4) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C1, monto, 5, 5);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",monto,0,Main.C2.SaldoID5);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 5) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C2, monto, 5, 1);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",monto,0,Main.C2.SaldoID5);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 6) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C2, monto, 5, 2);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",monto,0,Main.C2.SaldoID5);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 7) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C2, monto, 5, 3);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",monto,0,Main.C2.SaldoID5);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 8) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C2, monto, 5, 4);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",monto,0,Main.C2.SaldoID5);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 9) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C2, monto, 5, 5);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",monto,0,Main.C2.SaldoID5);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 10) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C3, monto, 5, 1);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",monto,0,Main.C2.SaldoID5);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 11) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C3, monto, 5, 2);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",monto,0,Main.C2.SaldoID5);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 12) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C3, monto, 5, 3);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",monto,0,Main.C2.SaldoID5);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 13) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C3, monto, 5, 4);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",monto,0,Main.C2.SaldoID5);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 14) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C3, monto, 5, 5);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",monto,0,Main.C2.SaldoID5);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 15) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C4, monto, 5, 1);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",monto,0,Main.C2.SaldoID5);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 16) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C4, monto, 5, 2);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",monto,0,Main.C2.SaldoID5);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 17) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C4, monto, 5, 3);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",monto,0,Main.C2.SaldoID5);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 18) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C4, monto, 5, 4);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",monto,0,Main.C2.SaldoID5);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 19) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C4, monto, 5, 5);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",monto,0,Main.C2.SaldoID5);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 20) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C5, monto, 5, 1);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",monto,0,Main.C2.SaldoID5);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 21) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C5, monto, 5, 2);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",monto,0,Main.C2.SaldoID5);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 22) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C5, monto, 5, 3);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",monto,0,Main.C2.SaldoID5);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 23) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C5, monto, 5, 4);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",monto,0,Main.C2.SaldoID5);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 24) {
                                            c.TransferenciaDeFondos(Main.C2, Main.C5, monto, 5, 5);
                                            q.LlenarTrCliente2(Main.C2.ID5,"Transferencia",monto,0,Main.C2.SaldoID5);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID5);
                                        }
                                        JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    break;
                                case (10):
                                    if(Main.C3.SaldoID1<monto){
                                        JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                    }else {
                                        if (cuentaDestinoBox.getSelectedIndex() == 0) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C1, monto, 1, 1);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",monto,0,Main.C3.SaldoID1);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 1) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C1, monto, 1, 2);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",monto,0,Main.C3.SaldoID1);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 2) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C1, monto, 1, 3);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",monto,0,Main.C3.SaldoID1);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 3) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C1, monto, 1, 4);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",monto,0,Main.C3.SaldoID1);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 4) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C1, monto, 1, 5);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",monto,0,Main.C3.SaldoID1);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 5) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C2, monto, 1, 1);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",monto,0,Main.C3.SaldoID1);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 6) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C2, monto, 1, 2);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",monto,0,Main.C3.SaldoID1);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 7) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C2, monto, 1, 3);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",monto,0,Main.C3.SaldoID1);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 8) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C2, monto, 1, 4);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",monto,0,Main.C3.SaldoID1);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 9) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C2, monto, 1, 5);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",monto,0,Main.C3.SaldoID1);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 10) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C3, monto, 1, 1);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",monto,0,Main.C3.SaldoID1);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID1);

                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 11) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C3, monto, 1, 2);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",monto,0,Main.C3.SaldoID1);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 12) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C3, monto, 1, 3);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",monto,0,Main.C3.SaldoID1);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 13) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C3, monto, 1, 4);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",monto,0,Main.C3.SaldoID1);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 14) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C3, monto, 1, 5);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",monto,0,Main.C3.SaldoID1);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 15) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C4, monto, 1, 1);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",monto,0,Main.C3.SaldoID1);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 16) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C4, monto, 1, 2);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",monto,0,Main.C3.SaldoID1);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 17) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C4, monto, 1, 3);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",monto,0,Main.C3.SaldoID1);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 18) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C4, monto, 1, 4);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",monto,0,Main.C3.SaldoID1);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 19) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C4, monto, 1, 5);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",monto,0,Main.C3.SaldoID1);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 20) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C5, monto, 1, 1);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",monto,0,Main.C3.SaldoID1);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 21) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C5, monto, 1, 2);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",monto,0,Main.C3.SaldoID1);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 22) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C5, monto, 1, 3);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",monto,0,Main.C3.SaldoID1);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 23) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C5, monto, 1, 4);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",monto,0,Main.C3.SaldoID1);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 24) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C5, monto, 1, 5);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",monto,0,Main.C3.SaldoID1);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID5);
                                        }
                                        JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    break;
                                case(11):
                                    if(Main.C3.SaldoID2<monto){
                                        JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                    }else {
                                        if (cuentaDestinoBox.getSelectedIndex() == 0) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C1, monto, 2, 1);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",monto,0,Main.C3.SaldoID2);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 1) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C1, monto, 2, 2);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",monto,0,Main.C3.SaldoID2);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 2) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C1, monto, 2, 3);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",monto,0,Main.C3.SaldoID2);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 3) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C1, monto, 2, 4);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",monto,0,Main.C3.SaldoID2);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 4) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C1, monto, 2, 5);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",monto,0,Main.C3.SaldoID2);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 5) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C2, monto, 2, 1);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",monto,0,Main.C3.SaldoID2);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 6) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C2, monto, 2, 2);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",monto,0,Main.C3.SaldoID2);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 7) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C2, monto, 2, 3);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",monto,0,Main.C3.SaldoID2);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 8) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C2, monto, 1, 4);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",monto,0,Main.C3.SaldoID2);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 9) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C2, monto, 2, 5);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",monto,0,Main.C3.SaldoID2);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 10) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C3, monto, 2, 1);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",monto,0,Main.C3.SaldoID2);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 11) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C3, monto, 2, 2);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",monto,0,Main.C3.SaldoID2);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 12) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C3, monto, 2, 3);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",monto,0,Main.C3.SaldoID2);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 13) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C3, monto, 2, 4);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",monto,0,Main.C3.SaldoID2);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 14) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C3, monto, 2, 5);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",monto,0,Main.C3.SaldoID2);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 15) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C4, monto, 2, 1);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",monto,0,Main.C3.SaldoID2);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 16) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C4, monto, 2, 2);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",monto,0,Main.C3.SaldoID2);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 17) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C4, monto, 2, 3);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",monto,0,Main.C3.SaldoID2);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 18) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C4, monto, 2, 4);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",monto,0,Main.C3.SaldoID2);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 19) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C4, monto, 2, 5);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",monto,0,Main.C3.SaldoID2);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 20) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C5, monto, 2, 1);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",monto,0,Main.C3.SaldoID2);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 21) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C5, monto, 2, 2);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",monto,0,Main.C3.SaldoID2);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 22) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C5, monto, 2, 3);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",monto,0,Main.C3.SaldoID2);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 23) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C5, monto, 2, 4);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",monto,0,Main.C3.SaldoID2);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 24) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C5, monto, 2, 5);
                                            q.LlenarTrCliente3(Main.C3.ID2,"Transferencia",monto,0,Main.C3.SaldoID2);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID5);

                                        }
                                        JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    break;
                                case (12):
                                    if(Main.C3.SaldoID3<monto){
                                        JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                    }else {
                                        if (cuentaDestinoBox.getSelectedIndex() == 0) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C1, monto, 3, 1);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",monto,0,Main.C3.SaldoID3);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 1) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C1, monto, 3, 2);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",monto,0,Main.C3.SaldoID3);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 2) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C1, monto, 3, 3);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",monto,0,Main.C3.SaldoID3);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 3) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C1, monto, 3, 4);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",monto,0,Main.C3.SaldoID3);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 4) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C1, monto, 3, 5);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",monto,0,Main.C3.SaldoID3);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 5) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C2, monto, 3, 1);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",monto,0,Main.C3.SaldoID3);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 6) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C2, monto, 3, 2);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",monto,0,Main.C3.SaldoID3);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 7) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C2, monto, 3, 3);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",monto,0,Main.C3.SaldoID3);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 8) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C2, monto, 3, 4);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",monto,0,Main.C3.SaldoID3);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 9) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C2, monto, 3, 5);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",monto,0,Main.C3.SaldoID3);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 10) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C3, monto, 3, 1);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",monto,0,Main.C3.SaldoID3);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 11) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C3, monto, 3, 2);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",monto,0,Main.C3.SaldoID3);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 12) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C3, monto, 3, 3);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",monto,0,Main.C3.SaldoID3);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 13) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C3, monto, 3, 4);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",monto,0,Main.C3.SaldoID3);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 14) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C3, monto, 3, 5);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",monto,0,Main.C3.SaldoID3);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 15) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C4, monto, 3, 1);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",monto,0,Main.C3.SaldoID3);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 16) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C4, monto, 3, 2);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",monto,0,Main.C3.SaldoID3);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 17) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C4, monto, 3, 3);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",monto,0,Main.C3.SaldoID3);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 18) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C4, monto, 3, 4);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",monto,0,Main.C3.SaldoID3);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 19) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C4, monto, 3, 5);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",monto,0,Main.C3.SaldoID3);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 20) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C5, monto, 3, 1);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",monto,0,Main.C3.SaldoID3);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 21) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C5, monto, 3, 2);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",monto,0,Main.C3.SaldoID3);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 22) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C5, monto, 3, 3);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",monto,0,Main.C3.SaldoID3);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 23) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C5, monto, 3, 4);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",monto,0,Main.C3.SaldoID3);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 24) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C5, monto, 3, 5);
                                            q.LlenarTrCliente3(Main.C3.ID3,"Transferencia",monto,0,Main.C3.SaldoID3);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID5);
                                        }
                                        JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    break;
                                case(13):
                                    if(Main.C3.SaldoID4<monto){
                                        JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                    }else {
                                        if (cuentaDestinoBox.getSelectedIndex() == 0) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C1, monto, 4, 1);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",monto,0,Main.C3.SaldoID4);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 1) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C1, monto, 4, 2);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",monto,0,Main.C3.SaldoID4);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 2) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C1, monto, 4, 3);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",monto,0,Main.C3.SaldoID4);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 3) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C1, monto, 4, 4);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",monto,0,Main.C3.SaldoID4);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 4) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C1, monto, 4, 5);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",monto,0,Main.C3.SaldoID4);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 5) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C2, monto, 4, 1);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",monto,0,Main.C3.SaldoID4);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 6) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C2, monto, 4, 2);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",monto,0,Main.C3.SaldoID4);
                                            q.LlenarTrCliente2(Main.C2.ID2,"Transferencia",0,monto,Main.C2.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 7) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C2, monto, 4, 3);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",monto,0,Main.C3.SaldoID4);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 8) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C2, monto, 4, 4);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",monto,0,Main.C3.SaldoID4);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 9) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C2, monto, 4, 5);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",monto,0,Main.C3.SaldoID4);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 10) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C3, monto, 4, 1);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",monto,0,Main.C3.SaldoID4);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 11) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C3, monto, 4, 2);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",monto,0,Main.C3.SaldoID4);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 12) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C3, monto, 4, 3);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",monto,0,Main.C3.SaldoID4);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 13) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C3, monto, 4, 4);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",monto,0,Main.C3.SaldoID4);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 14) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C3, monto, 4, 5);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",monto,0,Main.C3.SaldoID4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 15) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C4, monto, 4, 1);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",monto,0,Main.C3.SaldoID4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 16) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C4, monto, 4, 2);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",monto,0,Main.C3.SaldoID4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 17) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C4, monto, 4, 3);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",monto,0,Main.C3.SaldoID4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 18) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C4, monto, 4, 4);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",monto,0,Main.C3.SaldoID4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 19) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C4, monto, 4, 5);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",monto,0,Main.C3.SaldoID4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 20) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C5, monto, 4, 1);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",monto,0,Main.C3.SaldoID4);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 21) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C5, monto, 4, 2);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",monto,0,Main.C3.SaldoID4);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 22) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C5, monto, 4, 3);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",monto,0,Main.C3.SaldoID4);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 23) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C5, monto, 4, 4);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",monto,0,Main.C3.SaldoID4);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 24) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C5, monto, 4, 5);
                                            q.LlenarTrCliente3(Main.C3.ID4,"Transferencia",monto,0,Main.C3.SaldoID4);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID5);
                                        }
                                        JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    break;
                                case(14):
                                    if(Main.C3.SaldoID5<monto){
                                        JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                    }else {
                                        if (cuentaDestinoBox.getSelectedIndex() == 0) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C1, monto, 5, 1);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",monto,0,Main.C3.SaldoID5);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 1) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C1, monto, 5, 2);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",monto,0,Main.C3.SaldoID5);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 2) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C1, monto, 5, 3);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",monto,0,Main.C3.SaldoID5);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 3) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C1, monto, 5, 4);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",monto,0,Main.C3.SaldoID5);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 4) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C1, monto, 5, 5);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",monto,0,Main.C3.SaldoID5);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 5) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C2, monto, 5, 1);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",monto,0,Main.C3.SaldoID5);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 6) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C2, monto, 5, 2);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",monto,0,Main.C3.SaldoID5);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 7) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C2, monto, 5, 3);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",monto,0,Main.C3.SaldoID5);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 8) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C2, monto, 5, 4);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",monto,0,Main.C3.SaldoID5);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 9) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C2, monto, 5, 5);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",monto,0,Main.C3.SaldoID5);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 10) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C3, monto, 5, 1);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",monto,0,Main.C3.SaldoID5);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 11) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C3, monto, 5, 2);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",monto,0,Main.C3.SaldoID5);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 12) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C3, monto, 5, 3);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",monto,0,Main.C3.SaldoID5);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 13) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C3, monto, 5, 4);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",monto,0,Main.C3.SaldoID5);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 14) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C3, monto, 5, 5);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",monto,0,Main.C3.SaldoID5);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 15) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C4, monto, 5, 1);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",monto,0,Main.C3.SaldoID5);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 16) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C4, monto, 5, 2);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",monto,0,Main.C3.SaldoID5);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 17) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C4, monto, 5, 3);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",monto,0,Main.C3.SaldoID5);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 18) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C4, monto, 5, 4);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",monto,0,Main.C3.SaldoID5);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 19) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C4, monto, 5, 5);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",monto,0,Main.C3.SaldoID5);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 20) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C5, monto, 5, 1);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",monto,0,Main.C3.SaldoID5);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 21) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C5, monto, 5, 2);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",monto,0,Main.C3.SaldoID5);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 22) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C5, monto, 5, 3);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",monto,0,Main.C3.SaldoID5);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 23) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C5, monto, 5, 4);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",monto,0,Main.C3.SaldoID5);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 24) {
                                            c.TransferenciaDeFondos(Main.C3, Main.C5, monto, 5, 5);
                                            q.LlenarTrCliente3(Main.C3.ID5,"Transferencia",monto,0,Main.C3.SaldoID5);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID5);
                                        }
                                        JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    break;
                                case (15):
                                    if(Main.C4.SaldoID1<monto){
                                        JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                    }else {
                                        if (cuentaDestinoBox.getSelectedIndex() == 0) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C1, monto, 1, 1);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",monto,0,Main.C4.SaldoID1);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 1) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C1, monto, 1, 2);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",monto,0,Main.C4.SaldoID1);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 2) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C1, monto, 1, 3);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",monto,0,Main.C4.SaldoID1);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 3) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C1, monto, 1, 4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",monto,0,Main.C4.SaldoID1);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 4) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C1, monto, 1, 5);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",monto,0,Main.C4.SaldoID1);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 5) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C2, monto, 1, 1);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",monto,0,Main.C4.SaldoID1);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 6) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C2, monto, 1, 2);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",monto,0,Main.C4.SaldoID1);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 7) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C2, monto, 1, 3);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",monto,0,Main.C4.SaldoID1);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 8) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C2, monto, 1, 4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",monto,0,Main.C4.SaldoID1);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 9) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C2, monto, 1, 5);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",monto,0,Main.C4.SaldoID1);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 10) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C3, monto, 1, 1);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",monto,0,Main.C4.SaldoID1);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 11) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C3, monto, 1, 2);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",monto,0,Main.C4.SaldoID1);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 12) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C3, monto, 1, 3);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",monto,0,Main.C4.SaldoID1);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 13) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C3, monto, 1, 4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",monto,0,Main.C4.SaldoID1);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 14) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C3, monto, 1, 5);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",monto,0,Main.C4.SaldoID1);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 15) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C4, monto, 1, 1);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",monto,0,Main.C4.SaldoID1);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 16) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C4, monto, 1, 2);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",monto,0,Main.C4.SaldoID1);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 17) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C4, monto, 1, 3);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",monto,0,Main.C4.SaldoID1);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 18) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C4, monto, 1, 4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",monto,0,Main.C4.SaldoID1);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 19) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C4, monto, 1, 5);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",monto,0,Main.C4.SaldoID1);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 20) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C5, monto, 1, 1);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",monto,0,Main.C4.SaldoID1);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 21) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C5, monto, 1, 2);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",monto,0,Main.C4.SaldoID1);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 22) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C5, monto, 1, 3);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",monto,0,Main.C4.SaldoID1);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 23) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C5, monto, 1, 4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",monto,0,Main.C4.SaldoID1);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 24) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C5, monto, 1, 5);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",monto,0,Main.C4.SaldoID1);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID5);
                                        }
                                        JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    break;
                                case(16):
                                    if(Main.C4.SaldoID2<monto){
                                        JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                    }else {
                                        if (cuentaDestinoBox.getSelectedIndex() == 0) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C1, monto, 2, 1);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",monto,0,Main.C4.SaldoID2);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 1) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C1, monto, 2, 2);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",monto,0,Main.C4.SaldoID2);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 2) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C1, monto, 2, 3);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",monto,0,Main.C4.SaldoID2);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 3) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C1, monto, 2, 4);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",monto,0,Main.C4.SaldoID2);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 4) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C1, monto, 2, 5);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",monto,0,Main.C4.SaldoID2);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 5) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C2, monto, 2, 1);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",monto,0,Main.C4.SaldoID2);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 6) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C2, monto, 2, 2);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",monto,0,Main.C4.SaldoID2);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 7) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C2, monto, 2, 3);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",monto,0,Main.C4.SaldoID2);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 8) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C2, monto, 1, 4);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",monto,0,Main.C4.SaldoID2);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 9) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C2, monto, 2, 5);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",monto,0,Main.C4.SaldoID2);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 10) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C3, monto, 2, 1);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",monto,0,Main.C4.SaldoID2);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 11) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C3, monto, 2, 2);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",monto,0,Main.C4.SaldoID2);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 12) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C3, monto, 2, 3);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",monto,0,Main.C4.SaldoID2);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 13) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C3, monto, 2, 4);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",monto,0,Main.C4.SaldoID2);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 14) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C3, monto, 2, 5);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",monto,0,Main.C4.SaldoID2);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 15) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C4, monto, 2, 1);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",monto,0,Main.C4.SaldoID2);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 16) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C4, monto, 2, 2);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",monto,0,Main.C4.SaldoID2);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 17) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C4, monto, 2, 3);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",monto,0,Main.C4.SaldoID2);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 18) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C4, monto, 2, 4);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",monto,0,Main.C4.SaldoID2);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 19) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C4, monto, 2, 5);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",monto,0,Main.C4.SaldoID2);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 20) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C5, monto, 2, 1);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",monto,0,Main.C4.SaldoID2);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 21) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C5, monto, 2, 2);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",monto,0,Main.C4.SaldoID2);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 22) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C5, monto, 2, 3);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",monto,0,Main.C4.SaldoID2);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 23) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C5, monto, 2, 4);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",monto,0,Main.C4.SaldoID2);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 24) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C5, monto, 2, 5);
                                            q.LlenarTrCliente4(Main.C4.ID2,"Transferencia",monto,0,Main.C4.SaldoID2);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID5);
                                        }
                                        JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    break;
                                case (17):
                                    if(Main.C4.SaldoID3<monto){
                                        JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                    }else {
                                        if (cuentaDestinoBox.getSelectedIndex() == 0) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C1, monto, 3, 1);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",monto,0,Main.C4.SaldoID3);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 1) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C1, monto, 3, 2);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",monto,0,Main.C4.SaldoID3);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 2) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C1, monto, 3, 3);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",monto,0,Main.C4.SaldoID3);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 3) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C1, monto, 3, 4);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",monto,0,Main.C4.SaldoID3);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 4) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C1, monto, 3, 5);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",monto,0,Main.C4.SaldoID3);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 5) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C2, monto, 3, 1);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",monto,0,Main.C4.SaldoID3);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 6) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C2, monto, 3, 2);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",monto,0,Main.C4.SaldoID3);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 7) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C2, monto, 3, 3);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",monto,0,Main.C4.SaldoID3);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 8) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C2, monto, 3, 4);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",monto,0,Main.C4.SaldoID3);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 9) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C2, monto, 3, 5);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",monto,0,Main.C4.SaldoID3);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 10) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C3, monto, 3, 1);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",monto,0,Main.C4.SaldoID3);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 11) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C3, monto, 3, 2);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",monto,0,Main.C4.SaldoID3);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 12) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C3, monto, 3, 3);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",monto,0,Main.C4.SaldoID3);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 13) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C3, monto, 3, 4);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",monto,0,Main.C4.SaldoID3);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 14) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C3, monto, 3, 5);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",monto,0,Main.C4.SaldoID3);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 15) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C4, monto, 3, 1);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",monto,0,Main.C4.SaldoID3);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 16) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C4, monto, 3, 2);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",monto,0,Main.C4.SaldoID3);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 17) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C4, monto, 3, 3);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",monto,0,Main.C4.SaldoID3);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 18) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C4, monto, 3, 4);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",monto,0,Main.C4.SaldoID3);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 19) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C4, monto, 3, 5);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",monto,0,Main.C4.SaldoID3);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 20) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C5, monto, 3, 1);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",monto,0,Main.C4.SaldoID3);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 21) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C5, monto, 3, 2);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",monto,0,Main.C4.SaldoID3);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 22) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C5, monto, 3, 3);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",monto,0,Main.C4.SaldoID3);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 23) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C5, monto, 3, 4);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",monto,0,Main.C4.SaldoID3);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 24) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C5, monto, 3, 5);
                                            q.LlenarTrCliente4(Main.C4.ID3,"Transferencia",monto,0,Main.C4.SaldoID3);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID5);
                                        }
                                        JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    break;
                                case(18):
                                    if(Main.C4.SaldoID4<monto){
                                        JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                    }else {
                                        if (cuentaDestinoBox.getSelectedIndex() == 0) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C1, monto, 4, 1);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",monto,0,Main.C4.SaldoID4);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 1) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C1, monto, 4, 2);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",monto,0,Main.C4.SaldoID4);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 2) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C1, monto, 4, 3);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",monto,0,Main.C4.SaldoID4);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 3) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C1, monto, 4, 4);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",monto,0,Main.C4.SaldoID4);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 4) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C1, monto, 4, 5);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",monto,0,Main.C4.SaldoID4);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 5) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C2, monto, 4, 1);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",monto,0,Main.C4.SaldoID4);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 6) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C2, monto, 4, 2);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",monto,0,Main.C4.SaldoID4);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 7) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C2, monto, 4, 3);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",monto,0,Main.C4.SaldoID4);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 8) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C2, monto, 4, 4);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",monto,0,Main.C4.SaldoID4);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 9) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C2, monto, 4, 5);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",monto,0,Main.C4.SaldoID4);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 10) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C3, monto, 4, 1);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",monto,0,Main.C4.SaldoID4);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 11) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C3, monto, 4, 2);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",monto,0,Main.C4.SaldoID4);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 12) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C3, monto, 4, 3);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",monto,0,Main.C4.SaldoID4);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 13) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C3, monto, 4, 4);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",monto,0,Main.C4.SaldoID4);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 14) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C3, monto, 4, 5);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",monto,0,Main.C4.SaldoID4);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 15) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C4, monto, 4, 1);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",monto,0,Main.C4.SaldoID4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 16) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C4, monto, 4, 2);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",monto,0,Main.C4.SaldoID4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 17) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C4, monto, 4, 3);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",monto,0,Main.C4.SaldoID4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 18) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C4, monto, 4, 4);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",monto,0,Main.C4.SaldoID4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 19) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C4, monto, 4, 5);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",monto,0,Main.C4.SaldoID4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 20) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C5, monto, 4, 1);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",monto,0,Main.C4.SaldoID4);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 21) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C5, monto, 4, 2);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",monto,0,Main.C4.SaldoID4);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 22) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C5, monto, 4, 3);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",monto,0,Main.C4.SaldoID4);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 23) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C5, monto, 4, 4);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",monto,0,Main.C4.SaldoID4);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 24) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C5, monto, 4, 5);
                                            q.LlenarTrCliente4(Main.C4.ID4,"Transferencia",monto,0,Main.C4.SaldoID4);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID5);
                                        }
                                        JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    break;
                                case(19):
                                    if(Main.C4.SaldoID5<monto){
                                        JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                    }else {
                                        if (cuentaDestinoBox.getSelectedIndex() == 0) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C1, monto, 5, 1);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",monto,0,Main.C4.SaldoID5);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 1) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C1, monto, 5, 2);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",monto,0,Main.C4.SaldoID5);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 2) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C1, monto, 5, 3);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",monto,0,Main.C4.SaldoID5);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 3) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C1, monto, 5, 4);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",monto,0,Main.C4.SaldoID5);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 4) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C1, monto, 5, 5);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",monto,0,Main.C4.SaldoID5);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 5) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C2, monto, 5, 1);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",monto,0,Main.C4.SaldoID5);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 6) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C2, monto, 5, 2);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",monto,0,Main.C4.SaldoID5);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 7) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C2, monto, 5, 3);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",monto,0,Main.C4.SaldoID5);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 8) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C2, monto, 5, 4);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",monto,0,Main.C4.SaldoID5);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 9) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C2, monto, 5, 5);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",monto,0,Main.C4.SaldoID5);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 10) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C3, monto, 5, 1);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",monto,0,Main.C4.SaldoID5);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 11) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C3, monto, 5, 2);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",monto,0,Main.C4.SaldoID5);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 12) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C3, monto, 5, 3);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",monto,0,Main.C4.SaldoID5);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 13) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C3, monto, 5, 4);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",monto,0,Main.C4.SaldoID5);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 14) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C3, monto, 5, 5);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",monto,0,Main.C4.SaldoID5);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 15) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C4, monto, 5, 1);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",monto,0,Main.C4.SaldoID5);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 16) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C4, monto, 5, 2);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",monto,0,Main.C4.SaldoID5);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 17) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C4, monto, 5, 3);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",monto,0,Main.C4.SaldoID5);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 18) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C4, monto, 5, 4);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",monto,0,Main.C4.SaldoID5);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 19) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C4, monto, 5, 5);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",monto,0,Main.C4.SaldoID5);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 20) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C5, monto, 5, 1);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",monto,0,Main.C4.SaldoID5);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 21) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C5, monto, 5, 2);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",monto,0,Main.C4.SaldoID5);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 22) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C5, monto, 5, 3);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",monto,0,Main.C4.SaldoID5);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 23) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C5, monto, 5, 4);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",monto,0,Main.C4.SaldoID5);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 24) {
                                            c.TransferenciaDeFondos(Main.C4, Main.C5, monto, 5, 5);
                                            q.LlenarTrCliente4(Main.C4.ID5,"Transferencia",monto,0,Main.C4.SaldoID5);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID5);
                                        }
                                        JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    break;
                                case (20):
                                    if(Main.C5.SaldoID1<monto){
                                        JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                    }else {
                                        if (cuentaDestinoBox.getSelectedIndex() == 0) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C1, monto, 1, 1);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",monto,0,Main.C5.SaldoID1);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 1) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C1, monto, 1, 2);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",monto,0,Main.C5.SaldoID1);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 2) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C1, monto, 1, 3);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",monto,0,Main.C5.SaldoID1);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 3) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C1, monto, 1, 4);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",monto,0,Main.C5.SaldoID1);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 4) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C1, monto, 1, 5);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",monto,0,Main.C5.SaldoID1);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 5) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C2, monto, 1, 1);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",monto,0,Main.C5.SaldoID1);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 6) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C2, monto, 1, 2);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",monto,0,Main.C5.SaldoID1);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 7) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C2, monto, 1, 3);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",monto,0,Main.C5.SaldoID1);
                                            q.LlenarTrCliente2(Main.C2.ID3,"Transferencia",0,monto,Main.C2.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 8) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C2, monto, 1, 4);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",monto,0,Main.C5.SaldoID1);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 9) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C2, monto, 1, 5);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",monto,0,Main.C5.SaldoID1);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 10) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C3, monto, 1, 1);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",monto,0,Main.C5.SaldoID1);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 11) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C3, monto, 1, 2);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",monto,0,Main.C5.SaldoID1);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 12) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C3, monto, 1, 3);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",monto,0,Main.C5.SaldoID1);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 13) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C3, monto, 1, 4);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",monto,0,Main.C5.SaldoID1);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 14) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C3, monto, 1, 5);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",monto,0,Main.C5.SaldoID1);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 15) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C4, monto, 1, 1);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",monto,0,Main.C5.SaldoID1);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 16) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C4, monto, 1, 2);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",monto,0,Main.C5.SaldoID1);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 17) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C4, monto, 1, 3);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",monto,0,Main.C5.SaldoID1);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 18) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C4, monto, 1, 4);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",monto,0,Main.C5.SaldoID1);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 19) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C4, monto, 1, 5);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",monto,0,Main.C5.SaldoID1);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 20) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C5, monto, 1, 1);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",monto,0,Main.C5.SaldoID1);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 21) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C5, monto, 1, 2);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",monto,0,Main.C5.SaldoID1);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 22) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C5, monto, 1, 3);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",monto,0,Main.C5.SaldoID1);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 23) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C5, monto, 1, 4);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",monto,0,Main.C5.SaldoID1);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 24) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C5, monto, 1, 5);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",monto,0,Main.C5.SaldoID1);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID5);
                                        }
                                        JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    break;
                                case(21):
                                    if(Main.C5.SaldoID2<monto){
                                        JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                    }else {
                                        if (cuentaDestinoBox.getSelectedIndex() == 0) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C1, monto, 2, 1);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",monto,0,Main.C5.SaldoID2);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 1) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C1, monto, 2, 2);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",monto,0,Main.C5.SaldoID2);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID2);

                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 2) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C1, monto, 2, 3);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",monto,0,Main.C5.SaldoID2);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 3) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C1, monto, 2, 4);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",monto,0,Main.C5.SaldoID2);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 4) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C1, monto, 2, 5);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",monto,0,Main.C5.SaldoID2);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 5) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C2, monto, 2, 1);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",monto,0,Main.C5.SaldoID2);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 6) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C2, monto, 2, 2);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",monto,0,Main.C5.SaldoID2);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 7) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C2, monto, 2, 3);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",monto,0,Main.C5.SaldoID2);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 8) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C2, monto, 1, 4);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",monto,0,Main.C5.SaldoID2);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 9) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C2, monto, 2, 5);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",monto,0,Main.C5.SaldoID2);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 10) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C3, monto, 2, 1);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",monto,0,Main.C5.SaldoID2);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 11) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C3, monto, 2, 2);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",monto,0,Main.C5.SaldoID2);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 12) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C3, monto, 2, 3);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",monto,0,Main.C5.SaldoID2);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 13) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C3, monto, 2, 4);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",monto,0,Main.C5.SaldoID2);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 14) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C3, monto, 2, 5);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",monto,0,Main.C5.SaldoID2);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 15) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C4, monto, 2, 1);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",monto,0,Main.C5.SaldoID2);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 16) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C4, monto, 2, 2);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",monto,0,Main.C5.SaldoID2);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 17) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C4, monto, 2, 3);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",monto,0,Main.C5.SaldoID2);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 18) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C4, monto, 2, 4);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",monto,0,Main.C5.SaldoID2);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 19) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C4, monto, 2, 5);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",monto,0,Main.C5.SaldoID2);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 20) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C5, monto, 2, 1);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",monto,0,Main.C5.SaldoID2);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 21) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C5, monto, 2, 2);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",monto,0,Main.C5.SaldoID2);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 22) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C5, monto, 2, 3);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",monto,0,Main.C5.SaldoID2);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 23) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C5, monto, 2, 4);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",monto,0,Main.C5.SaldoID2);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 24) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C5, monto, 2, 5);
                                            q.LlenarTrCliente5(Main.C5.ID2,"Transferencia",monto,0,Main.C5.SaldoID2);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID5);
                                        }
                                        JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    break;
                                case (22):
                                    if(Main.C5.SaldoID3<monto){
                                        JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                    }else {
                                        if (cuentaDestinoBox.getSelectedIndex() == 0) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C1, monto, 3, 1);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",monto,0,Main.C5.SaldoID3);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 1) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C1, monto, 3, 2);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",monto,0,Main.C5.SaldoID3);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 2) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C1, monto, 3, 3);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",monto,0,Main.C5.SaldoID3);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 3) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C1, monto, 3, 4);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",monto,0,Main.C5.SaldoID3);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 4) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C1, monto, 3, 5);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",monto,0,Main.C5.SaldoID3);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 5) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C2, monto, 3, 1);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",monto,0,Main.C5.SaldoID3);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 6) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C2, monto, 3, 2);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",monto,0,Main.C5.SaldoID3);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 7) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C2, monto, 3, 3);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",monto,0,Main.C5.SaldoID3);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 8) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C2, monto, 3, 4);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",monto,0,Main.C5.SaldoID3);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 9) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C2, monto, 3, 5);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",monto,0,Main.C5.SaldoID3);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 10) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C3, monto, 3, 1);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",monto,0,Main.C5.SaldoID3);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 11) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C3, monto, 3, 2);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",monto,0,Main.C5.SaldoID3);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 12) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C3, monto, 3, 3);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",monto,0,Main.C5.SaldoID3);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 13) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C3, monto, 3, 4);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",monto,0,Main.C5.SaldoID3);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 14) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C3, monto, 3, 5);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",monto,0,Main.C5.SaldoID3);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 15) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C4, monto, 3, 1);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",monto,0,Main.C5.SaldoID3);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 16) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C4, monto, 3, 2);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",monto,0,Main.C5.SaldoID3);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 17) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C4, monto, 3, 3);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",monto,0,Main.C5.SaldoID3);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 18) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C4, monto, 3, 4);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",monto,0,Main.C5.SaldoID3);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 19) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C4, monto, 3, 5);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",monto,0,Main.C5.SaldoID3);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 20) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C5, monto, 3, 1);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",monto,0,Main.C5.SaldoID3);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 21) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C5, monto, 3, 2);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",monto,0,Main.C5.SaldoID3);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 22) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C5, monto, 3, 3);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",monto,0,Main.C5.SaldoID3);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 23) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C5, monto, 3, 4);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",monto,0,Main.C5.SaldoID3);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 24) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C5, monto, 3, 5);
                                            q.LlenarTrCliente5(Main.C5.ID3,"Transferencia",monto,0,Main.C5.SaldoID3);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID5);
                                        }
                                        JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    break;
                                case(23):
                                    if(Main.C5.SaldoID4<monto){
                                        JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                    }else {
                                        if (cuentaDestinoBox.getSelectedIndex() == 0) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C1, monto, 4, 1);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",monto,0,Main.C5.SaldoID4);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 1) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C1, monto, 4, 2);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",monto,0,Main.C5.SaldoID4);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 2) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C1, monto, 4, 3);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",monto,0,Main.C5.SaldoID4);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 3) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C1, monto, 4, 4);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",monto,0,Main.C5.SaldoID4);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 4) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C1, monto, 4, 5);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",monto,0,Main.C5.SaldoID4);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 5) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C2, monto, 4, 1);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",monto,0,Main.C5.SaldoID4);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 6) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C2, monto, 4, 2);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",monto,0,Main.C5.SaldoID4);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 7) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C2, monto, 4, 3);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",monto,0,Main.C5.SaldoID4);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 8) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C2, monto, 4, 4);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",monto,0,Main.C5.SaldoID4);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 9) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C2, monto, 4, 5);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",monto,0,Main.C5.SaldoID4);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 10) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C3, monto, 4, 1);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",monto,0,Main.C5.SaldoID4);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 11) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C3, monto, 4, 2);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",monto,0,Main.C5.SaldoID4);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 12) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C3, monto, 4, 3);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",monto,0,Main.C5.SaldoID4);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 13) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C3, monto, 4, 4);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",monto,0,Main.C5.SaldoID4);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 14) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C3, monto, 4, 5);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",monto,0,Main.C5.SaldoID4);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 15) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C4, monto, 4, 1);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",monto,0,Main.C5.SaldoID4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 16) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C4, monto, 4, 2);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",monto,0,Main.C5.SaldoID4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 17) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C4, monto, 4, 3);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",monto,0,Main.C5.SaldoID4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 18) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C4, monto, 4, 4);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",monto,0,Main.C5.SaldoID4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 19) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C4, monto, 4, 5);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",monto,0,Main.C5.SaldoID4);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 20) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C5, monto, 4, 1);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",monto,0,Main.C5.SaldoID4);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 21) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C5, monto, 4, 2);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",monto,0,Main.C5.SaldoID4);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 22) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C5, monto, 4, 3);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",monto,0,Main.C5.SaldoID4);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 23) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C5, monto, 4, 4);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",monto,0,Main.C5.SaldoID4);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 24) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C5, monto, 4, 5);
                                            q.LlenarTrCliente5(Main.C5.ID4,"Transferencia",monto,0,Main.C5.SaldoID4);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID5);
                                        }
                                        JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    break;
                                case(24):
                                    if(Main.C5.SaldoID5<monto){
                                        JOptionPane.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                                    }else {
                                        if (cuentaDestinoBox.getSelectedIndex() == 0) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C1, monto, 5, 1);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",monto,0,Main.C5.SaldoID5);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 1) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C1, monto, 5, 2);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",monto,0,Main.C5.SaldoID5);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 2) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C1, monto, 5, 3);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",monto,0,Main.C5.SaldoID5);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 3) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C1, monto, 5, 4);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",monto,0,Main.C5.SaldoID5);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 4) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C1, monto, 5, 5);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",monto,0,Main.C5.SaldoID5);
                                            q.LlenarTrCliente1(Main.C1.ID1,"Transferencia",0,monto,Main.C1.SaldoID5);;
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 5) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C2, monto, 5, 1);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",monto,0,Main.C5.SaldoID5);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 6) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C2, monto, 5, 2);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",monto,0,Main.C5.SaldoID5);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 7) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C2, monto, 5, 3);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",monto,0,Main.C5.SaldoID5);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 8) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C2, monto, 5, 4);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",monto,0,Main.C5.SaldoID5);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 9) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C2, monto, 5, 5);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",monto,0,Main.C5.SaldoID5);
                                            q.LlenarTrCliente2(Main.C2.ID1,"Transferencia",0,monto,Main.C2.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 10) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C3, monto, 5, 1);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",monto,0,Main.C5.SaldoID5);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 11) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C3, monto, 5, 2);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",monto,0,Main.C5.SaldoID5);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 12) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C3, monto, 5, 3);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",monto,0,Main.C5.SaldoID5);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 13) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C3, monto, 5, 4);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",monto,0,Main.C5.SaldoID5);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 14) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C3, monto, 5, 5);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",monto,0,Main.C5.SaldoID5);
                                            q.LlenarTrCliente3(Main.C3.ID1,"Transferencia",0,monto,Main.C3.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 15) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C4, monto, 5, 1);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",monto,0,Main.C5.SaldoID5);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 16) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C4, monto, 5, 2);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",monto,0,Main.C5.SaldoID5);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 17) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C4, monto, 5, 3);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",monto,0,Main.C5.SaldoID5);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 18) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C4, monto, 5, 4);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",monto,0,Main.C5.SaldoID5);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 19) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C4, monto, 5, 5);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",monto,0,Main.C5.SaldoID5);
                                            q.LlenarTrCliente4(Main.C4.ID1,"Transferencia",0,monto,Main.C4.SaldoID5);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 20) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C5, monto, 5, 1);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",monto,0,Main.C5.SaldoID5);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID1);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 21) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C5, monto, 5, 2);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",monto,0,Main.C5.SaldoID5);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID2);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 22) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C5, monto, 5, 3);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",monto,0,Main.C5.SaldoID5);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID3);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 23) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C5, monto, 5, 4);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",monto,0,Main.C5.SaldoID5);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID4);
                                        }
                                        if (cuentaDestinoBox.getSelectedIndex() == 24) {
                                            c.TransferenciaDeFondos(Main.C5, Main.C5, monto, 5, 5);
                                            q.LlenarTrCliente5(Main.C5.ID5,"Transferencia",monto,0,Main.C5.SaldoID5);
                                            q.LlenarTrCliente5(Main.C5.ID1,"Transferencia",0,monto,Main.C5.SaldoID5);
                                        }
                                        JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    break;






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
