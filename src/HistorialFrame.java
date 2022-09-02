import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HistorialFrame extends JFrame{
    private JPanel historialTrPanel;
    private JTextField textField1;
    private JButton mostrarTrBtn;
    private JTable tablaHistorial;
    private JButton volverBtn;
    DisplayFrames d = new DisplayFrames();
    boolean mostrar = true;

    public HistorialFrame (){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(historialTrPanel);
        mostrarTrBtn.setFocusable(false);
        mostrarTrBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));
        volverBtn.setFocusable(false);
        volverBtn.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.black));

        String[]f1 = {"0000","00/00/00 00:00","-------","0.00","0.00","0.00"};
        String[]f2 = {"0000","00/00/00 00:00","-------","0.00","0.00","0.00"};
        String[]f3 = {"0000","00/00/00 00:00","-------","0.00","0.00","0.00"};
        String[]f4 = {"0000","00/00/00 00:00","-------","0.00","0.00","0.00"};




        DefaultTableModel modelo1 = new DefaultTableModel();
        modelo1.addColumn("ID");
        modelo1.addColumn("Fecha");
        modelo1.addColumn("Detalle");
        modelo1.addColumn("Débito");
        modelo1.addColumn("Crédito");
        modelo1.addColumn("Saldo disponible");
        modelo1.addRow(f1);
        modelo1.addRow(f2);
        modelo1.addRow(f3);
        modelo1.addRow(f4);



        tablaHistorial.setModel(Main.modeloCl1);


        volverBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.PantallaCharacter(mostrar);
                dispose();
            }
        });
    }
}
