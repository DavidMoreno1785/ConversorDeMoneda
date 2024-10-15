package com.alura.challenge;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ObtenerConversion conversion = new ObtenerConversion();
        Divisa divisa;
        enum CodigosDivisas {
            USD,
            ARS,
            BRL,
            COP
        }


        int opcion = 0;
        while (opcion != 7) {
            System.out.print("""
                    =======================================
                    Bienvenido al conversor de Divisas
                    
                    
                    1. Dólar[USD] ==> Peso Argentino[ARS]
                    2. Peso Argentino[ARS] ==> Dólar[USD]
                    3. Dólar[USD] ==> Real Brasileño[BRL]
                    4. Real Brasileño[BRL] ==> Dólar[USD]
                    5. Dólar[USD] ==> Peso Colombiano[COP]
                    6. Peso Colombiano[COP] ==> Dólar[USD]
                    7. Salir
                    
                    
                    =======================================
                    
                    Seleccione una opción:
                    """);


            try {

                opcion = teclado.nextInt();
                if (opcion != 7) {
                    System.out.print("\nIngrese la candidad a convertir: ");

                    double cantidad = teclado.nextDouble();

                    divisa = switch (opcion) {
                        case 1 ->
                                conversion.convertir(String.valueOf(CodigosDivisas.USD), String.valueOf(CodigosDivisas.ARS), cantidad);
                        case 2 ->
                                conversion.convertir(String.valueOf(CodigosDivisas.ARS), String.valueOf(CodigosDivisas.USD), cantidad);
                        case 3 ->
                                conversion.convertir(String.valueOf(CodigosDivisas.USD), String.valueOf(CodigosDivisas.BRL), cantidad);
                        case 4 ->
                                conversion.convertir(String.valueOf(CodigosDivisas.BRL), String.valueOf(CodigosDivisas.USD), cantidad);
                        case 5 ->
                                conversion.convertir(String.valueOf(CodigosDivisas.USD), String.valueOf(CodigosDivisas.COP), cantidad);
                        default ->
                                conversion.convertir(String.valueOf(CodigosDivisas.COP), String.valueOf(CodigosDivisas.USD), cantidad);
                    };

                    System.out.println(cantidad + " " + divisa.base_code() + " equivale a: " + divisa.conversion_result() + " " + divisa.target_code());

                }
            } catch (Exception e) {
                throw  new RuntimeException("Opcion invalida");

            }

            teclado.close();
        }
    }
}
