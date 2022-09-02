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
                if(comboBoxAux.getSelectedIndex()==0 && Main.cliente1.Nombre != null && Main.cuentasCl1<5){
                    switch (Main.cuentasCl1) {
                        case 0 -> {
                            Main.C1.ID1 = random.nextInt(100000) + 1;
                            Main.cuentasCl1++;
                            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);

                        }
                        case 1 -> {
                            do {
                                Main.C1.ID2 = random.nextInt(100000) + 1;
                            } while (Main.C1.ID2 == Main.C1.ID1);
                            Main.cuentasCl1++;
                            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);

                        }
                        case 2 -> {
                            do {
                                Main.C1.ID3 = random.nextInt(100000) + 1;
                            } while (Main.C1.ID3 == Main.C1.ID1 || Main.C1.ID3 == Main.C1.ID2);
                            Main.cuentasCl1++;
                            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);

                        }
                        case 3 -> {
                            do {
                                Main.C1.ID4 = random.nextInt(100000) + 1;
                            } while (Main.C1.ID4 == Main.C1.ID1 || Main.C1.ID4 == Main.C1.ID2 || Main.C1.ID4 == Main.C1.ID3);
                            Main.cuentasCl1++;
                            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);

                        }
                        case 4 -> {
                            do {
                                Main.C1.ID5 = random.nextInt(100000) + 1;
                            } while (Main.C1.ID5 == Main.C1.ID1 || Main.C1.ID5 == Main.C1.ID2 || Main.C1.ID5 == Main.C1.ID3 || Main.C1.ID5 == Main.C1.ID4);
                            Main.cuentasCl1++;
                            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);

                        }
                    }
                }else { JOptionPane.showMessageDialog(null, "No es Posible crear más cuentas para el cliente seleccionado.", "Advertencia", JOptionPane.WARNING_MESSAGE);   }

                if(comboBoxAux.getSelectedIndex()==1 && Main.cliente2.Nombre != null && Main.cuentasCl2<5){
                    switch (Main.cuentasCl2) {
                        case 0 -> {
                            Main.C2.ID1 = random.nextInt(100000) + 1;
                            Main.cuentasCl2++;
                            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        }
                        case 1 -> {
                            do {
                                Main.C2.ID2 = random.nextInt(100000) + 1;
                            } while (Main.C2.ID2 == Main.C2.ID1);
                            Main.cuentasCl2++;
                            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        }
                        case 2 -> {
                            do {
                                Main.C2.ID3 = random.nextInt(100000) + 1;
                            } while (Main.C2.ID3 == Main.C2.ID1 || Main.C2.ID3 == Main.C2.ID2);
                            Main.cuentasCl2++;
                            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        }
                        case 3 -> {
                            do {
                                Main.C2.ID4 = random.nextInt(100000) + 1;
                            } while (Main.C2.ID4 == Main.C2.ID1 || Main.C2.ID4 == Main.C2.ID2 || Main.C2.ID4 == Main.C2.ID3);
                            Main.cuentasCl2++;
                            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        }
                        case 4 -> {
                            do {
                                Main.C2.ID5 = random.nextInt(100000) + 1;
                            } while (Main.C2.ID5 == Main.C2.ID1 || Main.C2.ID5 == Main.C2.ID2 || Main.C2.ID5 == Main.C2.ID3 || Main.C2.ID5 == Main.C2.ID4);
                            Main.cuentasCl2++;
                            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }

                if(comboBoxAux.getSelectedIndex()==2 && Main.cliente3.Nombre != null && Main.cuentasCl3<6){
                    switch (Main.cuentasCl3) {
                        case 0 -> {
                            Main.C3.ID1 = random.nextInt(100000) + 1;
                            Main.cuentasCl3++;
                            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        }
                        case 1 -> {
                            do {
                                Main.C3.ID2 = random.nextInt(100000) + 1;
                            } while (Main.C3.ID2 == Main.C3.ID1);
                            Main.cuentasCl3++;
                            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        }
                        case 2 -> {
                            do {
                                Main.C3.ID3 = random.nextInt(100000) + 1;
                            } while (Main.C3.ID3 == Main.C3.ID1 || Main.C3.ID3 == Main.C3.ID2);
                            Main.cuentasCl3++;
                            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        }
                        case 3 -> {
                            do {
                                Main.C3.ID4 = random.nextInt(100000) + 1;
                            } while (Main.C3.ID4 == Main.C3.ID1 || Main.C3.ID4 == Main.C3.ID2 || Main.C3.ID4 == Main.C3.ID3);
                            Main.cuentasCl3++;
                            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        }
                        case 4 -> {
                            do {
                                Main.C3.ID5 = random.nextInt(100000) + 1;
                            } while (Main.C3.ID5 == Main.C3.ID1 || Main.C3.ID5 == Main.C3.ID2 || Main.C3.ID5 == Main.C3.ID3 || Main.C3.ID5 == Main.C3.ID4);
                            Main.cuentasCl3++;
                            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }

                if(comboBoxAux.getSelectedIndex()==3 && Main.cliente4.Nombre != null && Main.cuentasCl4<5){
                    switch (Main.cuentasCl4) {
                        case 0 -> {
                            Main.C4.ID1 = random.nextInt(100000) + 1;
                            Main.cuentasCl4++;
                            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        }
                        case 1 -> {
                            do {
                                Main.C4.ID2 = random.nextInt(100000) + 1;
                            } while (Main.C4.ID2 == Main.C4.ID1);
                            Main.cuentasCl4++;
                            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        }
                        case 2 -> {
                            do {
                                Main.C4.ID3 = random.nextInt(100000) + 1;
                            } while (Main.C4.ID3 == Main.C4.ID1 || Main.C4.ID3 == Main.C4.ID2);
                            Main.cuentasCl4++;
                            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        }
                        case 3 -> {
                            do {
                                Main.C4.ID4 = random.nextInt(100000) + 1;
                            } while (Main.C4.ID4 == Main.C4.ID1 || Main.C4.ID4 == Main.C4.ID2 || Main.C4.ID4 == Main.C4.ID3);
                            Main.cuentasCl4++;
                            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        }
                        case 4 -> {
                            do {
                                Main.C4.ID5 = random.nextInt(100000) + 1;
                            } while (Main.C4.ID5 == Main.C4.ID1 || Main.C4.ID5 == Main.C4.ID2 || Main.C4.ID5 == Main.C4.ID3 || Main.C4.ID5 == Main.C4.ID4);
                            Main.cuentasCl4++;
                            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }

                if(comboBoxAux.getSelectedIndex()==4 && Main.cliente5.Nombre != null && Main.cuentasCl5<5){
                    switch (Main.cuentasCl5) {
                        case 0 -> {
                            Main.C5.ID1 = random.nextInt(100000) + 1;
                            Main.cuentasCl5++;
                            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        }
                        case 1 -> {
                            do {
                                Main.C5.ID2 = random.nextInt(100000) + 1;
                            } while (Main.C5.ID2 == Main.C5.ID1);
                            Main.cuentasCl5++;
                            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        }
                        case 2 -> {
                            do {
                                Main.C5.ID3 = random.nextInt(100000) + 1;
                            } while (Main.C5.ID3 == Main.C5.ID1 || Main.C5.ID3 == Main.C5.ID2);
                            Main.cuentasCl5++;
                            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        }
                        case 3 -> {
                            do {
                                Main.C5.ID4 = random.nextInt(100000) + 1;
                            } while (Main.C5.ID4 == Main.C5.ID1 || Main.C5.ID4 == Main.C5.ID2 || Main.C5.ID4 == Main.C5.ID3);
                            Main.cuentasCl5++;
                            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        }
                        case 4 -> {
                            do {
                                Main.C5.ID5 = random.nextInt(100000) + 1;
                            } while (Main.C5.ID5 == Main.C5.ID1 || Main.C5.ID5 == Main.C5.ID2 || Main.C5.ID5 == Main.C5.ID3 || Main.C5.ID5 == Main.C5.ID4);
                            Main.cuentasCl5++;
                            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
                if(Main.cuentasCl1>5||Main.cuentasCl2>5||Main.cuentasCl3>5||Main.cuentasCl4>5||Main.cuentasCl5>5){
                    JOptionPane.showMessageDialog(null, "No es Posible crear más cuentas para el cliente seleccionado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
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
