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
    boolean mostrar = true;


    public PagarServicioFrame (){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pagarServicioPanel);
        aceptarSerBtn.setFocusable(false);
        aceptarSerBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));
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
        comboBoxCuenta.setModel(comboBoxAux.getModel());
        String[] arrayAux2={"Luz eléctrica","Agua","Servicio telefónico"};
        comboBoxAux2 = new JComboBox(arrayAux2);
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
                try{
                    monto = Double.parseDouble(montoText.getText());
                    montoText.setText(null);
                    if(monto<=0.0){
                        JOptionPane.showMessageDialog(null, "El monto del pago debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                    }else {

                        switch (comboBoxCuenta.getSelectedIndex()){
                            case (0):
                                if(Main.C1.ID1==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{

                                    if(Main.C1.SaldoID1<monto){
                                        JOptionPane.showMessageDialog(null, "la cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                                    }else {
                                        Main.C1.SaldoID1 = Main.C1.SaldoID1 - monto;
                                        monto = 0;
                                        JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                break;

                            case(1):
                                if(Main.C1.ID2==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{

                                    if(Main.C1.SaldoID2<monto){
                                        JOptionPane.showMessageDialog(null, "la cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                                    }else {
                                        Main.C1.SaldoID2 = Main.C1.SaldoID2 - monto;
                                        monto = 0;
                                        JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                break;

                            case (2):
                                if(Main.C1.ID3==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{

                                    if(Main.C1.SaldoID3<monto){
                                        JOptionPane.showMessageDialog(null, "la cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                                    }else {
                                        Main.C1.SaldoID3 = Main.C1.SaldoID3 - monto;
                                        monto = 0;
                                        JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                break;

                            case(3):
                                if(Main.C1.ID4==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{

                                    if(Main.C1.SaldoID4<monto){
                                        JOptionPane.showMessageDialog(null, "la cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                                    }else {
                                        Main.C1.SaldoID4 = Main.C1.SaldoID4 - monto;
                                        monto = 0;
                                        JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                break;

                            case (4):
                                if(Main.C1.ID5==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{

                                    if(Main.C1.SaldoID5<monto){
                                        JOptionPane.showMessageDialog(null, "la cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                                    }else {
                                        Main.C1.SaldoID5 = Main.C1.SaldoID5 - monto;
                                        monto = 0;
                                        JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                break;

                            case(5):
                                if(Main.C2.ID1==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{

                                    if(Main.C2.SaldoID1<monto){
                                        JOptionPane.showMessageDialog(null, "la cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                                    }else {
                                        Main.C2.SaldoID1 = Main.C2.SaldoID1 - monto;
                                        monto = 0;
                                        JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                break;

                            case (6):
                                if(Main.C2.ID2==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{

                                    if(Main.C2.SaldoID2<monto){
                                        JOptionPane.showMessageDialog(null, "la cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                                    }else {
                                        Main.C2.SaldoID2 = Main.C2.SaldoID2 - monto;
                                        monto = 0;
                                        JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                break;

                            case (7):
                                if(Main.C2.ID3==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{

                                    if(Main.C2.SaldoID3<monto){
                                        JOptionPane.showMessageDialog(null, "la cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                                    }else {
                                        Main.C2.SaldoID3 = Main.C2.SaldoID3 - monto;
                                        monto = 0;
                                        JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                break;

                            case (8):
                                if(Main.C2.ID4==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{

                                    if(Main.C2.SaldoID4<monto){
                                        JOptionPane.showMessageDialog(null, "la cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                                    }else {
                                        Main.C2.SaldoID4 = Main.C2.SaldoID4 - monto;
                                        monto = 0;
                                        JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                break;


                            case (9):
                                if(Main.C2.ID5==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{

                                    if(Main.C2.SaldoID5<monto){
                                        JOptionPane.showMessageDialog(null, "la cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                                    }else {
                                        Main.C2.SaldoID5 = Main.C2.SaldoID5 - monto;
                                        monto = 0;
                                        JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                break;

                            case (10):
                                if(Main.C3.ID1==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{

                                    if(Main.C3.SaldoID1<monto){
                                        JOptionPane.showMessageDialog(null, "la cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                                    }else {
                                        Main.C3.SaldoID1 = Main.C3.SaldoID1 - monto;
                                        monto = 0;
                                        JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                break;


                            case (11):
                                if(Main.C3.ID2==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{

                                    if(Main.C3.SaldoID2<monto){
                                        JOptionPane.showMessageDialog(null, "la cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                                    }else {
                                        Main.C3.SaldoID2 = Main.C3.SaldoID2 - monto;
                                        monto = 0;
                                        JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                break;


                            case (12):
                                if(Main.C3.ID3==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{

                                    if(Main.C3.SaldoID3<monto){
                                        JOptionPane.showMessageDialog(null, "la cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                                    }else {
                                        Main.C3.SaldoID3 = Main.C3.SaldoID3 - monto;
                                        monto = 0;
                                        JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                break;

                            case (13):
                                if(Main.C3.ID4==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{

                                    if(Main.C3.SaldoID4<monto){
                                        JOptionPane.showMessageDialog(null, "la cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                                    }else {
                                        Main.C3.SaldoID4 = Main.C3.SaldoID4 - monto;
                                        monto = 0;
                                        JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                break;


                            case (14):
                                if(Main.C3.ID5==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{

                                    if(Main.C3.SaldoID5<monto){
                                        JOptionPane.showMessageDialog(null, "la cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                                    }else {
                                        Main.C3.SaldoID5 = Main.C3.SaldoID5 - monto;
                                        monto = 0;
                                        JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                break;


                            case (15):
                                if(Main.C4.ID1==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{

                                    if(Main.C4.SaldoID1<monto){
                                        JOptionPane.showMessageDialog(null, "la cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                                    }else {
                                        Main.C4.SaldoID1 = Main.C4.SaldoID1 - monto;
                                        monto = 0;
                                        JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                break;

                            case (16):
                                if(Main.C4.ID2==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{

                                    if(Main.C4.SaldoID2<monto){
                                        JOptionPane.showMessageDialog(null, "la cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                                    }else {
                                        Main.C4.SaldoID2 = Main.C4.SaldoID2 - monto;
                                        monto = 0;
                                        JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                break;


                            case (17):
                                if(Main.C4.ID3==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{

                                    if(Main.C4.SaldoID3<monto){
                                        JOptionPane.showMessageDialog(null, "la cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                                    }else {
                                        Main.C4.SaldoID3 = Main.C4.SaldoID3 - monto;
                                        monto = 0;
                                        JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);;
                                    }
                                }
                                break;


                            case(18):
                                if(Main.C4.ID4==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{

                                    if(Main.C4.SaldoID4<monto){
                                        JOptionPane.showMessageDialog(null, "la cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                                    }else {
                                        Main.C4.SaldoID4 = Main.C4.SaldoID4 - monto;
                                        monto = 0;
                                        JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                break;

                            case (19):
                                if(Main.C4.ID5==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{

                                    if(Main.C4.SaldoID5<monto){
                                        JOptionPane.showMessageDialog(null, "la cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                                    }else {
                                        Main.C4.SaldoID5 = Main.C4.SaldoID5 - monto;
                                        monto = 0;
                                        JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);;
                                    }
                                }
                                break;

                            case(20):
                                if(Main.C5.ID1==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{

                                    if(Main.C5.SaldoID1<monto){
                                        JOptionPane.showMessageDialog(null, "la cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                                    }else {
                                        Main.C5.SaldoID1 = Main.C5.SaldoID1 - monto;
                                        monto = 0;
                                        JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                break;

                            case (21):
                                if(Main.C5.ID2==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{

                                    if(Main.C5.SaldoID2<monto){
                                        JOptionPane.showMessageDialog(null, "la cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                                    }else {
                                        Main.C5.SaldoID2 = Main.C5.SaldoID2 - monto;
                                        monto = 0;
                                        JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                break;

                            case (22):
                                if(Main.C5.ID3==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{

                                    if(Main.C5.SaldoID3<monto){
                                        JOptionPane.showMessageDialog(null, "la cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                                    }else {
                                        Main.C5.SaldoID3 = Main.C5.SaldoID3 - monto;
                                        monto = 0;
                                        JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                break;

                            case (23):
                                if(Main.C5.ID4==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{

                                    if(Main.C5.SaldoID4<monto){
                                        JOptionPane.showMessageDialog(null, "la cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                                    }else {
                                        Main.C5.SaldoID4 = Main.C5.SaldoID4 - monto;
                                        monto = 0;
                                        JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                break;

                            case (24):
                                if(Main.C5.ID5==0){

                                    JOptionPane.showMessageDialog(null, "No hay ninguna cuenta seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{

                                    if(Main.C5.SaldoID5<monto){
                                        JOptionPane.showMessageDialog(null, "la cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);

                                    }else {
                                        Main.C5.SaldoID5 = Main.C5.SaldoID5 - monto;
                                        monto = 0;
                                        JOptionPane.showMessageDialog(null, "Pago realizado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                break;

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



