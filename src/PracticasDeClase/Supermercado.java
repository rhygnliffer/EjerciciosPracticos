package PracticasDeClase;

import java.util.ArrayList;

// Trabajo realizado por José Gabriel Britez y Matias Geymonat



public class Supermercado {
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Roque", "Piedra", 6060606,2);
        Caja caja3 = new Caja(empleado1, 3);

        Tools.imprimir("El cliente entro en el supermercado");
        Tools.imprimir("El cliente esta paseando");

        Cliente cliente = new Cliente("Juan", "Perez", 12345678, true);
        cliente.cargar_carrito("zanahoras", 100, 10);
        cliente.cargar_carrito("cervezas", 1200, 1000);

        cliente.pagar(caja3.get_caja());

    }
}

class Tools{
    public static void imprimir(String mensaje){
        System.out.println(mensaje);
    }
}



class Humane {

    private String nombre;
    private String apellido;
    private int dni;

    public Humane(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public String toString() {
        return "Nombre: " + this.nombre + "\nApellido: " + this.apellido + "\nDNI: " + this.dni;
    }

}

class Empleado extends Humane {

    private double sueldo;

    public Empleado(String nombre, String apellido, int dni, double sueldo) {
        super(nombre, apellido, dni);
        this.sueldo = sueldo;
    }

    public String toString() {
        return "\n" + super.toString() + "\nSueldo: " + this.sueldo;
    }
}

class Caja {
    private Empleado empleado;
    private int nroCaja;

    public Caja(Empleado empleado, int nroCaja) {
        this.empleado = empleado;
        this.nroCaja = nroCaja;
    }

    public String toString() {
        return this.empleado.toString() + "\nNro de caja: " + this.nroCaja;
    }
    public int get_caja(){
        return this.nroCaja;
    }

}

class Cliente extends Humane {
    private ArrayList<Producto> carrito = new ArrayList<>();
    private boolean mayorista;

    public Cliente(String nombre, String apellido, int dni, boolean mayorista) {
        super(nombre, apellido, dni);
        this.mayorista = mayorista;
    }

    public String toString() {
        return "\n" + super.toString() + "\nMayorista: " + this.mayorista;
    }

    public void cargar_carrito(String nombre, double precio, int cantidad){
        Producto new_producto = new Producto(nombre, precio, cantidad);
        Tools.imprimir("Se cargó " + new_producto.get_cantidad() + "  " + new_producto.get_nombre());
        carrito.add(new_producto);
    }

    public void pagar(int nro_caja){
        Trans nueva_trans = new Trans(this.carrito, nro_caja);
        nueva_trans.ver_trans();
    }


}

class Producto{
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String nombre, double precio, int cantidad){
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String ver_Producto(){
        String mensaje = "Nombre: " + this.nombre + "       Precio: "+ this.precio + "      Cantidad" + this.cantidad;
        return  mensaje;
    }

    public String get_nombre(){
        return this.nombre;
    }
    public int get_cantidad(){
        return this.cantidad;
    }
    public double get_precio(){
        return this.precio;
    }


}

class Trans {
    private int nro_caja;
    private  double total;
    private ArrayList<Producto> productos = new ArrayList<>();

    public Trans(ArrayList<Producto> productos, int caja){
        this.productos = productos;
        this.nro_caja = caja;
    }
    public void set_nro(int numero){
        this.nro_caja = numero;
    }

    public void ver_trans(){
        Tools.imprimir("====================================");
        Tools.imprimir("TICKET DE COMPRA");
        Tools.imprimir("====================================");
        Tools.imprimir("");
        Tools.imprimir("Nro de caja: " + this.nro_caja);
        Tools.imprimir("");
        Tools.imprimir("Productos Comprados");
        for ( Producto producto : this.productos) {
            this.total = this.total  + producto.get_precio();
            Tools.imprimir(producto.get_nombre() + " " + producto.get_cantidad());
        }

        Tools.imprimir("El total es: $" + this.total  );
        Tools.imprimir("====================================");
    }



}