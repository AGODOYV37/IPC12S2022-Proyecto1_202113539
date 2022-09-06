import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{

    DisplayFrames d = new DisplayFrames();
    public JPanel homePanel;
    public JLabel encabezadoH;
    public JPanel homeL;
    public JPanel homeR;
    public JLabel userPic;
    public JButton loginBtn;

    public void setLoginBtn(JButton loginBtn) {
        this.setFocusable(false);
    }




    public JButton aboutBtn;

    public void setAboutBtn(JButton aboutBtn) {
        this.setFocusable(false);
    }

    public MainFrame (){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(homePanel);
    aboutBtn.setFocusable(false);
    loginBtn.setFocusable(false);
    aboutBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.black));
    loginBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.black));


        aboutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Ángel Andrés Godoy Valdéz, 202113539 ", "About", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.PantallaLogin();
                dispose();
            }
        });
    }


}
