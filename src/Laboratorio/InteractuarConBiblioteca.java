package Laboratorio;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Laboratorio.Herr;

public class InteractuarConBiblioteca {
    public static void main(String[] args){

    }
}

class Libro{
    private String nombre;
    private String autor;
    private int anio_publicacion;

    public Libro(String nombre, String autor, int anio_publicacion){
        this.nombre = nombre;
        this.autor = autor;
        this.anio_publicacion = anio_publicacion;
    }


    public int getanio_publicacion() {
        return anio_publicacion;
    }
    
    public String get_nombre() {
        return nombre;
    }
    public String get_autor() {
        return autor;
    }

    public void set_anio_publicacio(int anio_publicacion){
        this.anio_publicacion = anio_publicacion;
    }

    public void set_autor(String autor){
        this.autor = autor;
    }

    public void set_nombre(String nombre){
        this.nombre = nombre;
    }




    @Override
    public String toString() {
        String mensaje = "Nombre: " + this.nombre +
                         "   Autor: " + this.autor + 
                         "   Año: " + this.anio_publicacion;

        return mensaje;
    }
}

class Biblioteca {
    private String nombre;
    private ArrayList<Libro> libros = new ArrayList <>();
  
    public Biblioteca(String nombre, ArrayList<Libro> libros){
      this.nombre = nombre;
      this.libros = libros;
    }



    public void agregar_libro(String nombre, String autor, int ano){
        Libro nuevo_libro = new Libro(nombre, autor, ano);
        this.libros.add(nuevo_libro);
        Herr.imprimir_salto("Se agregó el libro");
    }


    public int buscar(String nombre){
        int indice = -1;
        for (Libro libro : libros) {
            if (libro.get_nombre().equals(nombre)){
                indice = this.libros.indexOf(libro);
            }
        }
        return indice;
    }

    public void buscar_imprimir_resultado(String nombre){
        int resultado = buscar(nombre);
        String oracion = (resultado != -1)? "Se encontró el libro en la posición " + (resultado + 1):"No se encontró el libro en la lista";
        Herr.imprimir_salto(oracion);
    }

    public void eliminar_libro(String nombre){
        int indice = buscar(nombre);
    
        if (indice != -1){
            this.libros.remove(indice);
            Herr.imprimir("Se eliminó el libro");
        } else {
            Herr.imprimir("No se pudo eliminar el libro");
        }

    }


    public void listar_libros(){
        Herr.imprimir_salto("Lista DE LIBROS");
        Herr.linea();
        Herr.poner_espacios(2);
        for (Libro libro : this.libros) {
            Herr.imprimir_salto(libro.toString());
            Herr.poner_espacios(1);
        }
    }


    public void ordenar_alfabeticamente(){
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<Libro> libros_ordenados = new ArrayList<>();
        for (Libro libro : this.libros) {
            nombres.add(libro.get_nombre());
        }
        Collections.sort(nombres);

        for (String nombre : nombres) {
            for (Libro libro : this.libros) {
                if (libro.get_nombre().equals(nombre)) {
                    libros_ordenados.add(libro);
                    break;
                }
            }
        }

        this.libros = libros_ordenados;
        Herr.imprimir("Los libros se ordenaron mágicamente");
    }

    public void editar_por_indice(int indice, String nombre, String autor, int anio){
        boolean se_puede = indice >= 0  &&  indice < this.libros.size();
        if (se_puede) {
          Libro nuevo_libro = new Libro(nombre, autor, anio);
          this.libros.set(indice, nuevo_libro);
        } else {
          Herr.imprimir_salto("No se pudo realizar la acción");;
        }
    }

    public void menu(){
        Herr.imprimir_salto("Biblioteca " + this.nombre);
        Herr.linea_doble();
        Herr.imprimir_salto("MENÚ DE OPCIONES");
        Herr.linea_doble();
        Herr.imprimir_salto("1. Agregar libro");
        Herr.imprimir_salto("2. Buscar libro");
        Herr.imprimir_salto("3. Eliminar libro");
        Herr.imprimir_salto("4. Listar libros");
        Herr.imprimir_salto("5. Ordenar los libros alfabeticamente");
        Herr.imprimir_salto("6. Editar libro indicando indice");
        Herr.imprimir_salto("7. Salir");
        Herr.linea_doble();
    }

    public void ciclo(){
        int opcion;
        Scanner s = new Scanner(System.in);

        do{
        menu();
        Herr.imprimir("Elija una opción");
        opcion = s.nextInt();
        switch (opcion) {
            case 1:
                String nombre;
                String autor;
                int anio_publicacion;
                Herr.imprimir_salto("Ingrese el nombre del libro");
                nombre = s.nextLine();
                Herr.imprimir_salto("Escriba el nombre del autor");
                autor = s.nextLine();
                Herr.imprimir_salto("En qué año se publico?");
                anio_publicacion = s.nextInt();
                agregar_libro(nombre, autor, anio_publicacion);
                break;
            case 2:
                
            default:
                Herr.imprimir_salto("Opción inválida");
                break;
        }
        } while (opcion != 7);
    }


}