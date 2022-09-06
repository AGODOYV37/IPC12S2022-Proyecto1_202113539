import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class CrearTransaccion {
    public static int  ContTr1;
    public static int  ContTr2;
    public static int  ContTr3;
    public static int  ContTr4;
    public static int  ContTr5;
    Date Fecha = new Date();
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    String fechaStr = df.format(Fecha);
    Random random = new Random();







  public void LlenarTrCliente(int op,String Detalle, double Debito, double Credito, double SaldoDisponible){
        switch (op){
            case (1):
                if(ContTr1<20){
                    Main.JtCliente1[0]=String.valueOf(GenerarID());
                    Main.JtCliente1[1]=String.valueOf(fechaStr);
                    Main.JtCliente1[2]=String.valueOf(Detalle);
                    Main.JtCliente1[3]=String.valueOf(Debito);
                    Main.JtCliente1[4]=String.valueOf(Credito);
                    Main.JtCliente1[5]=String.valueOf(SaldoDisponible);


                    Main.modeloCl1.addRow(Main.JtCliente1);


                    ContTr1++;

                }
                break;
            case (2):
                if(ContTr2<20){
                    Main.JtCliente2[0]=String.valueOf(GenerarID());
                    Main.JtCliente2[1]=String.valueOf(fechaStr);
                    Main.JtCliente2[2]=String.valueOf(Detalle);
                    Main.JtCliente2[3]=String.valueOf(Debito);
                    Main.JtCliente2[4]=String.valueOf(Credito);
                    Main.JtCliente2[5]=String.valueOf(SaldoDisponible);


                    Main.modeloCl2.addRow(Main.JtCliente2);


                    ContTr2++;

                }
                break;
            case (3):
                if(ContTr3<20){
                    Main.JtCliente3[0]=String.valueOf(GenerarID());
                    Main.JtCliente3[1]=String.valueOf(fechaStr);
                    Main.JtCliente3[2]=String.valueOf(Detalle);
                    Main.JtCliente3[3]=String.valueOf(Debito);
                    Main.JtCliente3[4]=String.valueOf(Credito);
                    Main.JtCliente3[5]=String.valueOf(SaldoDisponible);


                    Main.modeloCl3.addRow(Main.JtCliente3);


                    ContTr3++;

                }
                break;
            case (4):
                if(ContTr4<20){
                    Main.JtCliente4[0]=String.valueOf(GenerarID());
                    Main.JtCliente4[1]=String.valueOf(fechaStr);
                    Main.JtCliente4[2]=String.valueOf(Detalle);
                    Main.JtCliente4[3]=String.valueOf(Debito);
                    Main.JtCliente4[4]=String.valueOf(Credito);
                    Main.JtCliente4[5]=String.valueOf(SaldoDisponible);


                    Main.modeloCl4.addRow(Main.JtCliente4);


                    ContTr4++;

                }
                break;
            case (5):
                if(ContTr5<20){
                    Main.JtCliente5[0]=String.valueOf(GenerarID());
                    Main.JtCliente5[1]=String.valueOf(fechaStr);
                    Main.JtCliente5[2]=String.valueOf(Detalle);
                    Main.JtCliente5[3]=String.valueOf(Debito);
                    Main.JtCliente5[4]=String.valueOf(Credito);
                    Main.JtCliente5[5]=String.valueOf(SaldoDisponible);


                    Main.modeloCl5.addRow(Main.JtCliente4);


                    ContTr5++;

                }
                break;





        }



  }

    public String GenerarID() {
        boolean cuentaRepetida = true;
        String IdCuenta;


            int d1 = random.nextInt(10);
            int d2 = random.nextInt(10);
            int d3 = random.nextInt(10);
            int d4 = random.nextInt(10);
            int d5 = random.nextInt(10);
            int d6 = random.nextInt(10);
            int cuentasR = 0;
            IdCuenta = String.valueOf(d1) + String.valueOf(d2) + String.valueOf(d3) + String.valueOf(d4) + String.valueOf(d5) + String.valueOf(d6);



        return IdCuenta;
    }






    }





