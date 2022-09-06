import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame{
    DisplayFrames d = new DisplayFrames();
    public JPanel loginPanel;
    private JPanel nLoginPanel;
    private JLabel encabezadoLogin;
    private JPanel nwLoginPanel;
    private JPasswordField textPassWord;
    private JTextField textUsuario;
    private JButton ingresarBtn;
    private JButton regresarBtn;

    boolean mostrar = true;

    public void setRegresarBtn(JButton regresarBtn) {
        this.setFocusable(false);
    }
    public void setIngresarBtn(JButton ingresarBtn) {
        this.setFocusable(false);
    }

    public LoginFrame (){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(loginPanel);
        ingresarBtn.setFocusable(false);
        regresarBtn.setFocusable(false);
        ingresarBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));
        regresarBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.black));


        ingresarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textUsuario.getText().equals("administrador") && textPassWord.getText().equals("202113539")){
                    d.PantallaCharacter(mostrar);
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Datos incorrectos!", "Error", JOptionPane.ERROR_MESSAGE);
                    textUsuario.setText(null);
                    textPassWord.setText(null);

                }

            }
        });
        regresarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textUsuario.setText(null);
                textPassWord.setText(null);
                d.PantallaInicio();
                dispose();

            }
        });
    }








}
