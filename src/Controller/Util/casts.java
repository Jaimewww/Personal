package Controller.Util;

public class casts {
    public static int transformStringInt(String num) {
        int resp = 0;
        if(validador.validarInt(num)) {
            resp = Integer.parseInt(num);
        }
        return resp;
    }

    public static float transformStringFloat(String num) {
        float resp = 0.0f;
        if(validador.validarFloat(num)) {
            resp = Float.parseFloat(num);
        }
        return resp;
    }
}
