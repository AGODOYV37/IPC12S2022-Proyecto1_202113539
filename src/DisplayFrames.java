import javax.swing.*;

public class DisplayFrames {






    public void PantallaCharacter(boolean mostrar) {

        JFrame frame1 = new ChooseYourCharacterFrame();
        ImageIcon icon = new ImageIcon("icono.png");
        frame1.setVisible(mostrar);
        frame1.setSize(500, 800);
        frame1.setTitle("Opciones");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        frame1.setIconImage(icon.getImage());

    }


    public void PantallaCrearCliente(boolean mostrar){

        JFrame frame2 = new CrearFrame();
        ImageIcon icon = new ImageIcon("icono.png");
        frame2.setVisible(mostrar);
        frame2.setSize(500, 800);
        frame2.setTitle("Opciones");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setResizable(false);
        frame2.setIconImage(icon.getImage());

    }

    public void PantallaSelCliente(boolean mostrar){

        JFrame frame2 = new MenuSelClientes();
        ImageIcon icon = new ImageIcon("icono.png");
        frame2.setVisible(mostrar);
        frame2.setSize(500, 250);
        frame2.setTitle("Crear cuenta");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setResizable(false);
        frame2.setIconImage(icon.getImage());

    }

    public void PantallaVerClientes(boolean mostrar) {

        JFrame frame1 = new VerClientesFrame("Menu Tabla Clientes");
        ImageIcon icon = new ImageIcon("icono.png");
        frame1.setVisible(mostrar);
        frame1.setSize(800, 600);
        frame1.setTitle("Ver clientes");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        frame1.setIconImage(icon.getImage());


    }

    public void PantallaDepositarCuenta() {

        JFrame frame1 = new DepositoFrame();
        ImageIcon icon = new ImageIcon("icono.png");
        frame1.setVisible(true);
        frame1.setSize(400, 400);
        frame1.setTitle("Depositar a cuenta");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        frame1.setIconImage(icon.getImage());


    }

    public void PantallaTransferenciaCuenta() {

        JFrame frame1 = new TransferenciaFrame();
        ImageIcon icon = new ImageIcon("icono.png");
        frame1.setVisible(true);
        frame1.setSize(400, 500);
        frame1.setTitle("Transferencia entre cuentas");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        frame1.setIconImage(icon.getImage());


    }

    public void PantallaPagarServicio() {

        JFrame frame1 = new PagarServicioFrame();
        ImageIcon icon = new ImageIcon("icono.png");
        frame1.setVisible(true);
        frame1.setSize(400, 500);
        frame1.setTitle("Pagar servicio");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        frame1.setIconImage(icon.getImage());


    }

    public void PantallaHistorial() {

        JFrame frame1 = new HistorialFrame();
        ImageIcon icon = new ImageIcon("icono.png");
        frame1.setVisible(true);
        frame1.setSize(900, 300);
        frame1.setTitle("Historial de transacciones");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        frame1.setIconImage(icon.getImage());


    }






}

