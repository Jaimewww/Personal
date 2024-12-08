package Controller.Util;
public class validador {
    public static boolean validarInt(String numero) {
        boolean intisValid;
        int numeroLenght = numero.length();
        int i = 0;
        do {
            char c = numero.charAt(i);
            if (Character.isDigit(c)) {
                intisValid = true;
            } else {
                intisValid = false;
                break;
            }
            i++;
        } while (i < numeroLenght);
        return intisValid;
    }

    public static boolean validarFloat(String numero) {
        boolean doubleisValid = false;
        int numeroLenght = numero.length();
        int i = 0, dotCount = 0;
        do {
            char c = numero.charAt(i);
            if (Character.isDigit(c)) {
                doubleisValid = true;
            } else if(numero.charAt(i) == '.' && dotCount < 1) {
                dotCount++;
            } else{
                doubleisValid = false;
                break;
            }
            i++;
        } while (i < numeroLenght);
        return doubleisValid;
    }
}