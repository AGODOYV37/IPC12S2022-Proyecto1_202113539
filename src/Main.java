import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Main {

    public void setCliente1(Clientes cliente1) {
        Main.cliente1 = cliente1;
    }

    public void setCliente2(Clientes cliente2) {
        Main.cliente2 = cliente2;
    }

    public void setCliente3(Clientes cliente3) {
        Main.cliente3 = cliente3;
    }

    public void setCliente4(Clientes cliente4) {
        Main.cliente4 = cliente4;
    }

    public void setCliente5(Clientes cliente5) {
        Main.cliente5 = cliente5;
    }
    public static int cuentasCl1;
    public static int cuentasCl2;
    public static int cuentasCl3;
    public static int cuentasCl4;
    public static int cuentasCl5;
    /*
    public static int cl1CuentaId1;
    public static int cl1CuentaId2;
    public static int cl1CuentaId3;
    public static int cl1CuentaId4;
    public static int cl1CuentaId5;
    public static int cl2CuentaId1;
    public static int cl2CuentaId2;
    public static int cl2CuentaId3;
    public static int cl2CuentaId4;
    public static int cl2CuentaId5;
    public static int cl3CuentaId1;
    public static int cl3CuentaId2;
    public static int cl3CuentaId3;
    public static int cl3CuentaId4;
    public static int cl3CuentaId5;
    public static int cl4CuentaId1;
    public static int cl4CuentaId2;
    public static int cl4CuentaId3;
    public static int cl4CuentaId4;
    public static int cl4CuentaId5;
    public static int cl5CuentaId1;
    public static int cl5CuentaId2;
    public static int cl5CuentaId3;
    public static int cl5CuentaId4;
    public static int cl5CuentaId5;
    */

    public static Clientes cliente1 = new Clientes();
    public static Clientes cliente2 = new Clientes();
    public static Clientes cliente3 = new Clientes();
    public static Clientes cliente4 = new Clientes();
    public static Clientes cliente5 = new Clientes();
    public static Cuentas C1 = new Cuentas(cliente1);
    public static Cuentas C2 = new Cuentas(cliente2);
    public static Cuentas C3 = new Cuentas(cliente3);
    public static Cuentas C4 = new Cuentas(cliente4);
    public static Cuentas C5 = new Cuentas(cliente5);
    public static Cuentas[] arrayCuentas = {C1,C2,C3,C4,C5};

    public static DefaultTableModel modeloCl1 = new DefaultTableModel();
    public static DefaultTableModel modeloCl2 = new DefaultTableModel();
    public static DefaultTableModel modeloCl3 = new DefaultTableModel();
    public static DefaultTableModel modeloCl4 = new DefaultTableModel();
    public static DefaultTableModel modeloCl5 = new DefaultTableModel();
    public static String [] JtCliente1 = new String[6];
    public static String [] JtCliente2 = new String[6];
    public static String [] JtCliente3 = new String[6];
    public static String [] JtCliente4 = new String[6];
    public static String [] JtCliente5 = new String[6];


    public void PasarClientes(Clientes cl1,Clientes cl2,Clientes cl3,Clientes cl4,Clientes cl5){
        cliente1=cl1;
        cliente2=cl2;
        cliente3=cl3;
        cliente4=cl4;
        cliente5=cl5;

    }
    public static void main(String[] args) {
        modeloCl1.addColumn("ID");
        modeloCl1.addColumn("Fecha");
        modeloCl1.addColumn("Detalle");
        modeloCl1.addColumn("Débito");
        modeloCl1.addColumn("Crédito");
        modeloCl1.addColumn("Saldo disponible");
        boolean mostrar=true;
        boolean noMostrar=false;
        DisplayFrames d = new DisplayFrames();
        d.PantallaCharacter(mostrar);










    }
}
