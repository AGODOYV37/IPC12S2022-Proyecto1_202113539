import java.util.Random;

public class Cuentas {
    public Clientes cliente;

    public double Saldo;

    public String ID;


    Random random = new Random();


    public Cuentas(Clientes cliente) {
        this.cliente = cliente;
    }

    public Cuentas() {

    }

    public String GenerarID() {
        boolean cuentaRepetida = true;
        String IdCuenta;
        do {

            int d1 = random.nextInt(10);
            int d2 = random.nextInt(10);
            int d3 = random.nextInt(10);
            int d4 = random.nextInt(10);
            int d5 = random.nextInt(10);
            int d6 = random.nextInt(10);
            int cuentasR = 0;
            IdCuenta = String.valueOf(d1) + String.valueOf(d2) + String.valueOf(d3) + String.valueOf(d4) + String.valueOf(d5) + String.valueOf(d6);
            for (int i = 0; i < Main.arrayCuentas.length; i++) {
                if (IdCuenta.equals(Main.arrayCuentas[i])) {
                    cuentasR++;
                }
            }
            if (cuentasR == 0) {
                cuentaRepetida = false;
            }

        } while (cuentaRepetida);

     return IdCuenta;
    }












}

