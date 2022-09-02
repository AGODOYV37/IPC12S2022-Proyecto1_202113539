import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class CrearTransaccion {
    public static int  ContTr1;
    public static int  ContTr2;
    public static int  ContTr3;
    public static int  ContTr4;
    public static int  ContTr5;
    Date Fecha;








  public void LlenarTrCliente1(int ID, String Detalle, double Debito, double Credito, double SaldoDisponible){

        if(ContTr1<20){
            Main.JtCliente1[0]=String.valueOf(ID);
            Main.JtCliente1[1]=String.valueOf(Fecha);
            Main.JtCliente1[2]=String.valueOf(Detalle);
            Main.JtCliente1[3]=String.valueOf(Debito);
            Main.JtCliente1[4]=String.valueOf(Credito);
            Main.JtCliente1[5]=String.valueOf(SaldoDisponible);


            Main.modeloCl1.addRow(Main.JtCliente1);


            ContTr1++;

        }


  }

    public void LlenarTrCliente2(int ID, String Detalle, double Debito, double Credito, double SaldoDisponible){

        if(ContTr1<20){
            Main.JtCliente2[0]=String.valueOf(ID);
            Main.JtCliente2[1]=String.valueOf(Fecha);
            Main.JtCliente2[2]=String.valueOf(Detalle);
            Main.JtCliente2[3]=String.valueOf(Debito);
            Main.JtCliente2[4]=String.valueOf(Credito);
            Main.JtCliente2[5]=String.valueOf(SaldoDisponible);


            Main.modeloCl2.addRow(Main.JtCliente2);


            ContTr2++;

        }


    }

    public void LlenarTrCliente3(int ID, String Detalle, double Debito, double Credito, double SaldoDisponible){

        if(ContTr1<20){
            Main.JtCliente3[0]=String.valueOf(ID);
            Main.JtCliente3[1]=String.valueOf(Fecha);
            Main.JtCliente3[2]=String.valueOf(Detalle);
            Main.JtCliente3[3]=String.valueOf(Debito);
            Main.JtCliente3[4]=String.valueOf(Credito);
            Main.JtCliente3[5]=String.valueOf(SaldoDisponible);


            Main.modeloCl3.addRow(Main.JtCliente3);


            ContTr3++;

        }


    }

    public void LlenarTrCliente4(int ID, String Detalle, double Debito, double Credito, double SaldoDisponible){

        if(ContTr1<20){
            Main.JtCliente4[0]=String.valueOf(ID);
            Main.JtCliente4[1]=String.valueOf(Fecha);
            Main.JtCliente4[2]=String.valueOf(Detalle);
            Main.JtCliente4[3]=String.valueOf(Debito);
            Main.JtCliente4[4]=String.valueOf(Credito);
            Main.JtCliente4[5]=String.valueOf(SaldoDisponible);


            Main.modeloCl4.addRow(Main.JtCliente4);


            ContTr4++;

        }


    }

    public void LlenarTrCliente5(int ID, String Detalle, double Debito, double Credito, double SaldoDisponible){

        if(ContTr1<20){
            Main.JtCliente5[0]=String.valueOf(ID);
            Main.JtCliente5[1]=String.valueOf(Fecha);
            Main.JtCliente5[2]=String.valueOf(Detalle);
            Main.JtCliente5[3]=String.valueOf(Debito);
            Main.JtCliente5[4]=String.valueOf(Credito);
            Main.JtCliente5[5]=String.valueOf(SaldoDisponible);


            Main.modeloCl5.addRow(Main.JtCliente5);


            ContTr5++;

        }


    }

}
