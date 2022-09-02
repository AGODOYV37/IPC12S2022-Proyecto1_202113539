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
        comboBox1.setModel(comboBoxAux.getModel());

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
                        JOptionPane.showMessageDialog(null, "El monto debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                    }else {

                        switch (comboBox1.getSelectedIndex()){
                            case (0):
                                if(Main.C1.ID1==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{
                                    Main.C1.SaldoID1=Main.C1.SaldoID1+monto;
                                    c.LlenarTrCliente1(Main.C1.ID1,"Depósito",0,monto,Main.C1.SaldoID1);
                                    monto=0;
                                    JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);

                                }
                                break;

                            case(1):
                                if(Main.C1.ID2==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{
                                    Main.C1.SaldoID2=Main.C1.SaldoID2+monto;
                                    c.LlenarTrCliente1(Main.C1.ID2,"Depósito",0,monto,Main.C1.SaldoID2);
                                    monto=0;
                                    JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;
                            case (2):
                                if(Main.C1.ID3==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{
                                    Main.C1.SaldoID3=Main.C1.SaldoID3+monto;
                                    c.LlenarTrCliente1(Main.C1.ID3,"Depósito",0,monto,Main.C1.SaldoID3);
                                    monto=0;
                                    JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;
                            case(3):
                                if(Main.C1.ID4==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{
                                    Main.C1.SaldoID4=Main.C1.SaldoID4+monto;
                                    c.LlenarTrCliente1(Main.C1.ID4,"Depósito",0,monto,Main.C1.SaldoID4);
                                    monto=0;
                                    JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;
                            case (4):
                                if(Main.C1.ID5==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{
                                    Main.C1.SaldoID5=Main.C1.SaldoID5+monto;
                                    c.LlenarTrCliente1(Main.C1.ID5,"Depósito",0,monto,Main.C1.SaldoID5);
                                    monto=0;
                                    JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;
                            case(5):
                                if(Main.C2.ID1==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{
                                    Main.C2.SaldoID1=Main.C2.SaldoID1+monto;
                                    c.LlenarTrCliente1(Main.C2.ID1,"Depósito",0,monto,Main.C2.SaldoID1);
                                    monto=0;
                                    JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;
                            case (6):
                                if(Main.C2.ID2==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{
                                    Main.C2.SaldoID2=Main.C2.SaldoID2+monto;
                                    c.LlenarTrCliente1(Main.C2.ID2,"Depósito",0,monto,Main.C2.SaldoID2);
                                    monto=0;
                                    JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;
                            case (7):
                                if(Main.C2.ID3==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{
                                    Main.C2.SaldoID3=Main.C2.SaldoID3+monto;
                                    c.LlenarTrCliente1(Main.C2.ID3,"Depósito",0,monto,Main.C2.SaldoID3);
                                    monto=0;
                                    JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;
                            case (8):
                                if(Main.C2.ID4==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{
                                    Main.C2.SaldoID4=Main.C2.SaldoID4+monto;
                                    c.LlenarTrCliente1(Main.C2.ID4,"Depósito",0,monto,Main.C2.SaldoID4);
                                    monto=0;
                                    JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;

                            case (9):
                                if(Main.C2.ID5==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{
                                    Main.C2.SaldoID5=Main.C2.SaldoID5+monto;
                                    c.LlenarTrCliente1(Main.C2.ID5,"Depósito",0,monto,Main.C2.SaldoID5);
                                    monto=0;
                                    JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;
                            case (10):
                                if(Main.C3.ID1==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{
                                    Main.C3.SaldoID1=Main.C3.SaldoID1+monto;
                                    c.LlenarTrCliente1(Main.C3.ID1,"Depósito",0,monto,Main.C3.SaldoID1);
                                    monto=0;
                                    JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;

                            case (11):
                                if(Main.C3.ID2==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{
                                    Main.C3.SaldoID2=Main.C3.SaldoID2+monto;
                                    c.LlenarTrCliente1(Main.C3.ID2,"Depósito",0,monto,Main.C3.SaldoID2);
                                    monto=0;
                                    JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;

                            case (12):
                                if(Main.C3.ID3==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{
                                    Main.C3.SaldoID3=Main.C3.SaldoID3+monto;
                                    c.LlenarTrCliente1(Main.C3.ID3,"Depósito",0,monto,Main.C3.SaldoID3);
                                    monto=0;
                                    JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;
                            case (13):
                                if(Main.C3.ID4==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{
                                    Main.C3.SaldoID4=Main.C3.SaldoID4+monto;
                                    c.LlenarTrCliente1(Main.C3.ID4,"Depósito",0,monto,Main.C3.SaldoID4);
                                    monto=0;
                                    JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;

                            case (14):
                                if(Main.C3.ID5==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{
                                    Main.C3.SaldoID5=Main.C3.SaldoID5+monto;
                                    c.LlenarTrCliente1(Main.C3.ID5,"Depósito",0,monto,Main.C3.SaldoID5);
                                    monto=0;
                                    JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;

                            case (15):
                                if(Main.C4.ID1==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{
                                    Main.C4.SaldoID1=Main.C4.SaldoID1+monto;
                                    c.LlenarTrCliente1(Main.C4.ID1,"Depósito",0,monto,Main.C4.SaldoID1);
                                    monto=0;
                                    JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;
                            case (16):
                                if(Main.C4.ID2==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{
                                    Main.C4.SaldoID2=Main.C4.SaldoID2+monto;
                                    c.LlenarTrCliente1(Main.C4.ID2,"Depósito",0,monto,Main.C4.SaldoID2);
                                    monto=0;
                                    JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;

                            case (17):
                                if(Main.C4.ID3==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{
                                    Main.C4.SaldoID3=Main.C4.SaldoID3+monto;
                                    c.LlenarTrCliente1(Main.C4.ID3,"Depósito",0,monto,Main.C4.SaldoID3);
                                    monto=0;
                                    JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;

                            case(18):
                                if(Main.C4.ID4==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{
                                    Main.C4.SaldoID4=Main.C4.SaldoID4+monto;
                                    c.LlenarTrCliente1(Main.C4.ID4,"Depósito",0,monto,Main.C4.SaldoID4);
                                    monto=0;
                                    JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;
                            case (19):
                                if(Main.C4.ID5==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{
                                    Main.C4.SaldoID5=Main.C4.SaldoID5+monto;
                                    c.LlenarTrCliente1(Main.C4.ID5,"Depósito",0,monto,Main.C4.SaldoID5);
                                    monto=0;
                                    JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;
                            case(20):
                                if(Main.C5.ID1==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{
                                    Main.C5.SaldoID1=Main.C4.SaldoID1+monto;
                                    c.LlenarTrCliente1(Main.C5.ID1,"Depósito",0,monto,Main.C5.SaldoID1);
                                    monto=0;
                                    JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;
                            case (21):
                                if(Main.C5.ID2==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{
                                    Main.C5.SaldoID2=Main.C4.SaldoID2+monto;
                                    c.LlenarTrCliente1(Main.C5.ID2,"Depósito",0,monto,Main.C5.SaldoID2);
                                    monto=0;
                                    JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;
                            case (22):
                                if(Main.C5.ID3==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{
                                    Main.C5.SaldoID3=Main.C4.SaldoID3+monto;
                                    c.LlenarTrCliente1(Main.C5.ID3,"Depósito",0,monto,Main.C5.SaldoID3);
                                    monto=0;
                                    JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;
                            case (23):
                                if(Main.C5.ID4==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{
                                    Main.C5.SaldoID4=Main.C4.SaldoID4+monto;
                                    c.LlenarTrCliente1(Main.C5.ID4,"Depósito",0,monto,Main.C5.SaldoID4);
                                    monto=0;
                                    JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;
                            case (24):
                                if(Main.C5.ID5==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{
                                    Main.C5.SaldoID5=Main.C4.SaldoID5+monto;
                                    c.LlenarTrCliente1(Main.C5.ID5,"Depósito",0,monto,Main.C5.SaldoID5);
                                    monto=0;
                                    JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;
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
