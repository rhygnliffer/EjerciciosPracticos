package Laboratorio;

public class OtroSupermercado {
    public static void main(String[] args) {
        
    }
}

abstract class Persona {
    private String nombre_apellido;
    private int dni;
    
    public Persona(String nombre_apellido, int dni){
        this.dni = dni;
        this.nombre_apellido = nombre_apellido;
    }

    public int get_dni() {
        return dni;
    }
    public String get_nombre_apellido() {
        return nombre_apellido;
    }
}

abstract class Empleado extends Persona{
    private int cant_horas;
    private double sueldo;

    public Empleado(String nombre_apellido, int dni, int cant_horas, double sueldo){
        super(nombre_apellido, dni);
        this.sueldo = sueldo;
        this.cant_horas = cant_horas;

    }

    public double get_sueldo(){
        return this.sueldo;
    }
}


class Cliente extends Persona{
    private boolean mayorista;
    private int nro_socio;

    public Cliente(String nombre_apellido, int dni, int nro_socio, boolean mayorista){
        super(nombre_apellido, dni);
        this.mayorista = mayorista;
        this.nro_socio = nro_socio;

    }
}

class Seguridad extends Persona{
    private String sector;

    public Seguridad(String nombre_apellido, int dni, String sector){
        super(nombre_apellido, dni);
        this.sector = sector;

    }
}


class Supervisor extends Empleado{
    private String sector;
    private int personas_a_cargo;


    public Supervisor(String nombre_apellido, int dni, int cant_horas, double sueldo, String sector, int personas_a_cargo){
        super(nombre_apellido, dni, cant_horas, sueldo);
        this.personas_a_cargo = personas_a_cargo;
        this.sector = sector;

    }

}


class Cajero extends Empleado{
    private int nro_caja;

    public Cajero(String nombre_apellido, int dni, int cant_horas, double sueldo, int nro_caja){
        super(nombre_apellido, dni, cant_horas, sueldo);
        this.nro_caja = nro_caja;

    }

}



interface Informes {
    abstract void ver_sueldo();
    abstract void ver_particularidades();
    
}




