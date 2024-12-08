package Controller.Util;

public class ServAguaPotable {
    Cliente cliente = new Cliente();
    float taxAlcantarillado, recolectBasura, procesamientoDatos, totalConsumo, consumoBase;
    public ServAguaPotable(){
        taxAlcantarillado = 0.35f;
        recolectBasura = 0.75f;
        procesamientoDatos = 0.5f;
        totalConsumo = 0;
        consumoBase = 3;
    }

    public enum rangosVal {
        RANGO1(0, 15, 0),
        RANGO2(15, 25, 0.1f),
        RANGO3(25, 40, 0.2f),
        RANGO4(40, 60, 0.3f),
        RANGO5(60, Float.POSITIVE_INFINITY, 0.35f);

        private final float base;
        private final float max;
        private final float extra;

        rangosVal(float base, float max, float extra) {
            this.base = base;
            this.extra = extra;
            this.max = max;
        }

        public float getBase() {
            return base;
        }

        public float getExtra() {
            return extra;
        }
        public float getMax() {
            return max;
        }
    }

    public void run(){
        Menu menu = new Menu();
        cliente.setNombre(menu.readString("Ingrese su nombre: "));
        cliente.setEdad(menu.readInteger("Ingrese su edad: "));
        cliente.setPorcentajeDiscapacidad(menu.readFloat("Ingrese su porcentaje de discapacidad (0 en caso de no tener discapacidad): "));
        float inputmCubicos = menu.readFloat("Ingrese el numero de metros cubicos consumidos: ");
        calcularConsumo(inputmCubicos);
        utilCondiciones(inputmCubicos, cliente.getPorcentajeDiscapacidad());
        System.out.println("---Reporte del Servicio de Agua Potable---");
        System.out.println("Nombre: "+cliente.getNombre());
        System.out.println("Edad: "+cliente.getEdad());
        System.out.println("Porcentaje de discapacidad: "+cliente.getPorcentajeDiscapacidad());
        System.out.println("El total a cancelar es de $"+totalConsumo);
    }

    public void calcularConsumo(float mCubicos) {
        float consumo = 0;
        for (rangosVal rango : rangosVal.values()) {
            if (mCubicos <= 0) break;
            float metrosEnRango = Math.min(mCubicos, rango.getMax() - rango.getBase());
            if (metrosEnRango > 0) {
                consumo += metrosEnRango * rango.getExtra();
                mCubicos -= metrosEnRango;
            }
        }
        totalConsumo = consumoBase + consumo;
    }

    public void utilCondiciones(float mCubicos, float porcentajeDiscapacidad){
        totalConsumo+=(totalConsumo*taxAlcantarillado)+recolectBasura+procesamientoDatos;
        if(cliente.getEdad()>60){
            if(mCubicos<=15){
                totalConsumo -= consumoBase*0.5f;
            }else{
                totalConsumo -= consumoBase*0.3f;
            }
        }
        if(porcentajeDiscapacidad>0){
            totalConsumo -= 3*(porcentajeDiscapacidad/100);
        }
    }
}
