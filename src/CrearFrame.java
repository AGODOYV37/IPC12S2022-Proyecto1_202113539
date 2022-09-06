import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearFrame extends JFrame  {


    boolean mostrar = true;
    boolean noMostrar=false;

    Main m = new Main();
    public  String [] arrayClientes = new String[5];


    DisplayFrames d = new DisplayFrames();

    public boolean maxClientes=false;
    public JPanel crearClientePanel;
    public JTextField textCUI;
    public JTextField textNombre;
    public JTextField textApellido;
    public JButton crearBtn;
    private JButton volverBtn;



    public CrearFrame (){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(crearClientePanel);
        crearBtn.setFocusable(false);
        crearBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));
        volverBtn.setFocusable(false);
        volverBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));
        textCUI.setHorizontalAlignment(JTextField.CENTER);
        textApellido.setHorizontalAlignment(JTextField.CENTER);
        textNombre.setHorizontalAlignment(JTextField.CENTER);

        crearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (textCUI.getText().isEmpty()||textNombre.getText().isEmpty()||textApellido.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);

                }else {
                    if (textCUI.getText().equals(Main.cliente1.getCUI())||textCUI.getText().equals(Main.cliente2.getCUI())||textCUI.getText().equals(Main.cliente3.getCUI())||textCUI.getText().equals(Main.cliente4.getCUI())||textCUI.getText().equals(Main.cliente5.getCUI())){
                        JOptionPane.showMessageDialog(null, "No se pueden crear clientes con CUI duplicados. El Cui ingresado ya existe en el sistema.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }else{
                        Main.contClientes++;
                        if(Main.contClientes>=6){
                            maxClientes=true;
                        }

                        switch (Main.contClientes){

                            case 1:
                                Main.cliente1.setCUI(textCUI.getText());
                                Main.cliente1.setNombre(textNombre.getText());
                                Main.cliente1.setApellido(textApellido.getText());
                                JOptionPane.showMessageDialog(null, "Cliente creado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                break;

                            case 2:
                                Main.cliente2.setCUI(textCUI.getText());
                                Main.cliente2.setNombre(textNombre.getText());
                                Main. cliente2.setApellido(textApellido.getText());
                                JOptionPane.showMessageDialog(null, "Cliente creado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                break;

                            case 3:
                                Main.cliente3.setCUI(textCUI.getText());
                                Main.cliente3.setNombre(textNombre.getText());
                                Main.cliente3.setApellido(textApellido.getText());
                                JOptionPane.showMessageDialog(null, "Cliente creado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                break;

                            case 4:
                                Main.cliente4.setCUI(textCUI.getText());
                                Main.cliente4.setNombre(textNombre.getText());
                                Main.cliente4.setApellido(textApellido.getText());
                                JOptionPane.showMessageDialog(null, "Cliente creado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                break;

                            case 5:
                                Main.cliente5.setCUI(textCUI.getText());
                                Main.cliente5.setNombre(textNombre.getText());
                                Main.cliente5.setApellido(textApellido.getText());
                                JOptionPane.showMessageDialog(null, "Cliente creado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                break;




                        }


                        textCUI.setText(null);
                        textApellido.setText(null);
                        textNombre.setText(null);

                    }

                }


                if (maxClientes){
                    JOptionPane.showMessageDialog(null, "No es posible crear más clientes.", "Advertencia", JOptionPane.WARNING_MESSAGE);
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




