package Teoria;

public class Clase09092024 {
    public static void main(String[] args) {
        Cuenta c1 = new Cuenta("Juan Perez", 10.00);
        c1.ingresar(20.00);
        c1.retirar(40.00);
    }
}


class Cuenta{
    //Atributos
    private String titular;
    private double cantidad;
    
    // Constructores
    public Cuenta(String titular, double cantidad){
        this.cantidad = cantidad;
        this.titular = titular;
    }

    public Cuenta(String titular){
        this.titular = titular;
    }


    //Setters y Getters
    public double getCantidad() {
        return cantidad;
    }

    public String getTitular() {
        return titular;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    // Métodos

    public void ingresar(double cantidad){
        if (cantidad < 1) {
            System.out.println("No se pudo realizar la operación.");
        } else {
            this.cantidad = this.cantidad + cantidad;
            System.out.println("El monto se ingresó correctamente, su saldo actual es de $" + this.cantidad);
        }
    }

    public void retirar(double cantidad){
        if (cantidad > this.cantidad){
            this.cantidad = 0;
        } else {
            this.cantidad = this.cantidad - cantidad;
        }

        System.out.println("Se realizó la operación el saldo actual es de $" + this.cantidad);
    }

}