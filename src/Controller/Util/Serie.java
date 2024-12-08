package Controller.Util;

public class Serie {
    String serieFinal;
    int numeroElementos, cont, fibonacci0 = 0, fibonacci1 = 1, fibonacci_aux, impar, exponentePar, contSigno, cicloSigno;
    float suma;

    public Serie() {
        serieFinal = "";
        numeroElementos = 0;
    }

    public void setNumeroElementos(int numeroElementos) {
        this.numeroElementos = numeroElementos;
    }

    public int getNumeroElementos() {
        return numeroElementos;
    }

    public void run() {
        Menu menu = new Menu();
        setNumeroElementos(menu.readInteger("Ingrese el número de elementos que se quiere generar: "));
        generarSerie(getNumeroElementos());
    }

    public void generarSerie(int numeroElementos) {
        cont = 1;
        contSigno = 0;
        cicloSigno = 0;
        suma = 0;
        String signo = "+";
        impar = 1;
        exponentePar = 2;

        for (int i = 0; i < numeroElementos; i++) {
            if(cont == 2){
                fibonacci_aux = 1;
            }else{
                fibonacci_aux = fibonacci1+fibonacci0;
                fibonacci0 = fibonacci1;
                fibonacci1 = fibonacci_aux;
            }

            if (cicloSigno == 0 || cicloSigno == 1) {
                signo = "+";
                suma += (float) Math.pow(((double) fibonacci_aux /impar), exponentePar);
                cicloSigno++;
            } else if (cicloSigno == 2 || cicloSigno == 3) {
                signo = "-";
                suma-= (float) Math.pow(((double) fibonacci_aux /impar), exponentePar);
                cicloSigno++;
            }

            if (cicloSigno == 4) {
                cicloSigno = 0;
            }

            serieFinal += signo + "(" + fibonacci_aux + "/" + impar + ")" + "^" + exponentePar;
            cont++;
            impar += 2;
            exponentePar += 2;
        }

        System.out.println(serieFinal+" = "+suma);
    }
}
