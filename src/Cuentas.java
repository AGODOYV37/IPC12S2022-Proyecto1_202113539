public class Cuentas{
    Clientes cliente;

    double SaldoID1;
    double SaldoID2;
    double SaldoID3;
    double SaldoID4;
    double SaldoID5;
     int ID1;
     int ID2;
     int ID3;
     int ID4;
     int ID5;

    public Cuentas(Clientes cliente) {
        this.cliente = cliente;
    }
    public  Cuentas(){

    }


    public void TransferenciaDeFondos(Cuentas cuentaOrigen, Cuentas cuentaDestino, double montoTr,int IdOrigen,int IdDestino){

        switch (IdOrigen){
            case(1):
                cuentaOrigen.SaldoID1=cuentaOrigen.SaldoID1-montoTr;
                break;
            case(2):
                cuentaOrigen.SaldoID2=cuentaOrigen.SaldoID2-montoTr;
                break;
            case (3):
                cuentaOrigen.SaldoID3=cuentaOrigen.SaldoID3-montoTr;
            case (4):
                cuentaOrigen.SaldoID4=cuentaOrigen.SaldoID4-montoTr;
                break;
            case (5):
                cuentaOrigen.SaldoID5=cuentaOrigen.SaldoID5-montoTr;
                break;

        }

        switch (IdDestino){
            case(1):
                cuentaDestino.SaldoID1= cuentaDestino.SaldoID1+montoTr;
                break;
            case (2):
                cuentaDestino.SaldoID2= cuentaDestino.SaldoID2+montoTr;
                break;
            case (3):
                cuentaDestino.SaldoID3= cuentaDestino.SaldoID3+montoTr;
                break;
            case (4):
                cuentaDestino.SaldoID4= cuentaDestino.SaldoID4+montoTr;
                break;
            case (5):
                cuentaDestino.SaldoID5= cuentaDestino.SaldoID5+montoTr;
                break;

        }





    }

}

