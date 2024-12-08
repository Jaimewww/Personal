package Controller.Util;
public class ZonasHorarias {
    public enum zonas_horarias {
        AMERICADELNORTE(12,2.75f),
        AMERICACENTRAL(15, 1.89f),
        AMERICADELSUR(18, 1.60f),
        EUROPA(19, 3.5f),
        ASIA(23, 4.5f),
        AFRICA(25, 3.1f),
        OCEANIA(29, 3f),
        RESTOMUNDO(31, 6f);

        public final int clave;
        public final float costo;

        zonas_horarias(int clave, float costo) {
            this.clave = clave;
            this.costo = costo;
        }
        public int getClave(){
            return clave;
        }

        public float getCosto(){
            return costo;
        }
    }
}
