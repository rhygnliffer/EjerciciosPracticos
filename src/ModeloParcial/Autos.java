package ModeloParcial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Autos {
    public static void menu(){
        System.out.println("==================================");
        System.out.println("MENÚ DE OPCIONES");
        System.out.println("==================================");
        System.out.println("1. Agregar auto");
        System.out.println("2. Buscar auto");
        System.out.println("3. Eliminar auto");
        System.out.println("4. Listar autos");
        System.out.println("5. Ordenar autos alfabeticamente");
        System.out.println("6. Editar auto indicando indice");
        imprimir_con_salto("7. Limpiar pantalla");
        System.out.println("8. Salir");
        System.out.println("==================================");
    }

    public static void agregar(ArrayList<String> lista, String auto){
        lista.add(auto);
        System.out.println("Se agregó el auto  " +  auto);
    }


    public static void buscar(ArrayList<String> lista, String auto){
        int indice = lista.indexOf(auto);
        String oracion = (indice != -1)? "Se encontró en la posición" + (indice + 1):"No se encontró el auto en la lista";
        System.out.println(oracion);
    }


    public static void eliminar(ArrayList<String> lista, String auto){
        String  elminado = (lista.remove(auto))? "Se eliminó el auto": "No se pudo eliminar el auto";
        System.out.println(elminado);
    }



    public static void listar(ArrayList<String> lista){
        System.out.println("Lista de autos");
        System.out.println("");
        for (String auto : lista) {
            System.out.print(auto + "   ");
        }
        System.out.println("");
    }

    public static void ordenar(ArrayList<String> lista_autos){
        Collections.sort(lista_autos);
        System.out.println("Se ordenaron los autos");
    }
    public static void editar_por_indice(ArrayList<String> lista, int indice, String nombre){
        boolean se_puede = indice >= 0  &&  indice < lista.size();
        if (se_puede) {
            lista.set(indice, nombre);
            System.out.println("Se modifico el auto");
        } else {
            System.out.println("No se pudo realizar la acción");
        }
    }

    public static void ciclo(ArrayList<String> lista){
        int opcion;
        Scanner l = new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        String palabra;
        do {
            menu();
            System.out.println("Elija un opción");
            opcion = l.nextInt();
            switch (opcion) {
                case 1:
                    imprimir_con_salto("Ingrese el auto que desea agregar");
                    palabra = s.nextLine();
                    agregar(lista, palabra);
                    break;
                case 2:
                    imprimir_con_salto("Ingrese el auto que desea buscar");
                    palabra = s.nextLine();
                    buscar(lista, palabra);
                    break;
                case 3:
                    imprimir_con_salto("Ingrese el nombre del auto que desea eliminar");
                    palabra = s.nextLine();
                    eliminar(lista, palabra);
                    break;
                case 4:
                    listar(lista);
                    break;
                case 5:
                    ordenar(lista);
                    break;
                case 6:
                    imprimir_con_salto("Ingrese que palabra la posicion que desea cambiar");
                    int valor = l.nextInt() - 1;
                    imprimir_con_salto("Ingrese el nuevo nombre");
                    palabra = s.nextLine();
                    editar_por_indice(lista, valor, palabra);
                    break;
                case 7:
                    LimpiarPantalla();
                    break;
                case 8:
                    LimpiarPantalla();
                    imprimir_con_salto("Adiós");
                    break;
                default:
                    imprimir_con_salto("No existe esa opción");;
                    break;
            }
        } while (opcion != 8);
        s.close();
        l.close();
    }


    public static void imprimir_con_salto(String contenido){
        System.out.println(contenido);
    }
    public static void LimpiarPantalla() {
        System.out.print("\u001b[2J\u001b[H");
        System.out.flush();
    }


    public static void main(String[] args) {
        ArrayList<String> autos = new ArrayList<>();
        try {
            ciclo(autos);
        } catch (InputMismatchException e) {
            imprimir_con_salto("Ingresó un dato incorrecto");
        }
        
    }
}
