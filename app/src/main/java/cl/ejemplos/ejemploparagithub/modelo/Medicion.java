package cl.ejemplos.ejemploparagithub.modelo;

public class Medicion {
    private int iden;
    private String fecha;
    private int val;

    public Medicion() {
    }

    public Medicion(int iden, String fecha, int val) {
        this.iden = iden;
        this.fecha = fecha;
        this.val = val;
    }

    public int getIden() {
        return iden;
    }

    public void setIden(int iden) {
        this.iden = iden;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Medicion{" +
                "iden=" + iden +
                ", fecha='" + fecha + '\'' +
                ", val=" + val +
                '}';
    }
}
