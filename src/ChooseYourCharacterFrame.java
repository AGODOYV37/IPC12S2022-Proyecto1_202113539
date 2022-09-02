import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseYourCharacterFrame extends JFrame {


    boolean mostrar=true;
    boolean noMostrar=false;
    Main m = new Main();
    private JPanel panel1;
    private JButton crearClienteBtn;
    private JButton crearCuentaBtn;
    private JButton verClientesBtn;
    private JButton depositoCuentaBtn;
    private JButton transferenciaBtn;
    private JButton pagarServicioBtn;
    private JButton historialBtn;
    private JPanel characterPanel;

    DisplayFrames d = new DisplayFrames();



    public Clientes cliente1 = new Clientes();
    public Clientes cliente2 = new Clientes();
    public Clientes cliente3 = new Clientes();
    public Clientes cliente4 = new Clientes();
    public Clientes cliente5 = new Clientes();



    public ChooseYourCharacterFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);

        crearClienteBtn.setFocusable(false);
        crearClienteBtn.setFocusable(false);
        crearClienteBtn.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        crearClienteBtn.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));

        crearCuentaBtn.setFocusable(false);
        crearCuentaBtn.setFocusable(false);
        crearCuentaBtn.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        crearCuentaBtn.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));

        verClientesBtn.setFocusable(false);
        verClientesBtn.setFocusable(false);
        verClientesBtn.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        verClientesBtn.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));

        depositoCuentaBtn.setFocusable(false);
        depositoCuentaBtn.setFocusable(false);
        depositoCuentaBtn.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        depositoCuentaBtn.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));

        transferenciaBtn.setFocusable(false);
        transferenciaBtn.setFocusable(false);
        transferenciaBtn.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        transferenciaBtn.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));

        pagarServicioBtn.setFocusable(false);
        pagarServicioBtn.setFocusable(false);
        pagarServicioBtn.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        pagarServicioBtn.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));

        historialBtn.setFocusable(false);
        historialBtn.setFocusable(false);
        historialBtn.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        historialBtn.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));


        crearClienteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.PantallaCrearCliente(mostrar);
                dispose();
            }
        });
        crearCuentaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.PantallaSelCliente(mostrar);
                dispose();

            }
        });
        verClientesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.PantallaVerClientes(mostrar);
                dispose();
            }
        });
        depositoCuentaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.PantallaDepositarCuenta();
                dispose();
            }
        });
        transferenciaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.PantallaTransferenciaCuenta();
                dispose();
            }
        });


        pagarServicioBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.PantallaPagarServicio();
                dispose();
            }
        });
        historialBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.PantallaHistorial();
                dispose();
            }
        });
    }
}
