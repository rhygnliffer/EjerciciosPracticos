package Laboratorio;

public class Herr {
    public static void imprimir(String contenido){
        System.out.print(contenido);
    }

    public static void imprimir_salto(String contenido){
        System.out.println(contenido);
    }

    public static void linea(){
        imprimir_salto("----------------------------------");
    }

    public static void linea_doble(){
        imprimir_salto("==================================");
    }

    public static void poner_espacios(int numero){
        for (int i = 0; i < numero; i++) {
            imprimir_salto("");
        }
    }


}
