import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearFrame extends JFrame  {


    boolean mostrar = true;
    boolean noMostrar=false;

    Main m = new Main();
    Clientes cliente1 = new Clientes();
    Clientes cliente2 = new Clientes();
    Clientes cliente3 = new Clientes();
    Clientes cliente4 = new Clientes();
    Clientes cliente5 = new Clientes();
    public  String [] arrayClientes = new String[5];
    public int contClientes=0;

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
                    if (textCUI.getText().equals(cliente1.getCUI())||textCUI.getText().equals(cliente2.getCUI())||textCUI.getText().equals(cliente3.getCUI())||textCUI.getText().equals(cliente4.getCUI())||textCUI.getText().equals(cliente5.getCUI())){
                        JOptionPane.showMessageDialog(null, "No se pueden crear clientes con CUI duplicados. El Cui ingresado ya existe en el sistema.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }else{
                        contClientes++;
                        if(contClientes>=6){
                            maxClientes=true;
                        }

                        switch (contClientes){

                            case 1:
                                cliente1.setCUI(textCUI.getText());
                                cliente1.setNombre(textNombre.getText());
                                cliente1.setApellido(textApellido.getText());
                                m.setCliente1(cliente1);
                                arrayClientes[0]=cliente1.CUI+" - "+cliente1.Nombre+" "+cliente1.Apellido;
                                JOptionPane.showMessageDialog(null, "Cliente creado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                break;

                            case 2:
                                cliente2.setCUI(textCUI.getText());
                                cliente2.setNombre(textNombre.getText());
                                cliente2.setApellido(textApellido.getText());
                                m.setCliente2(cliente2);
                                arrayClientes[1]=cliente2.CUI+" - "+cliente2.Nombre+" "+cliente2.Apellido;
                                JOptionPane.showMessageDialog(null, "Cliente creado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                break;

                            case 3:
                                cliente3.setCUI(textCUI.getText());
                                cliente3.setNombre(textNombre.getText());
                                cliente3.setApellido(textApellido.getText());
                                m.setCliente3(cliente3);
                                arrayClientes[2]=cliente3.CUI+" - "+cliente3.Nombre+" "+cliente3.Apellido;
                                JOptionPane.showMessageDialog(null, "Cliente creado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                break;

                            case 4:
                                cliente4.setCUI(textCUI.getText());
                                cliente4.setNombre(textNombre.getText());
                                cliente4.setApellido(textApellido.getText());
                                m.setCliente4(cliente4);
                                arrayClientes[3]=cliente4.CUI+" - "+cliente4.Nombre+" "+cliente4.Apellido;
                                JOptionPane.showMessageDialog(null, "Cliente creado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                                break;

                            case 5:
                                cliente5.setCUI(textCUI.getText());
                                cliente5.setNombre(textNombre.getText());
                                cliente5.setApellido(textApellido.getText());
                                m.setCliente5(cliente5);
                                arrayClientes[4]=cliente5.CUI+" - "+cliente5.Nombre+" "+cliente5.Apellido;
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
                m.PasarClientes(cliente1,cliente2,cliente3,cliente4,cliente5);
                dispose();

            }
        });

    }












    }




