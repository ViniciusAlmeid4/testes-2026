package com.example;

public class Main {
    public static void main(String[] args) {
        
        CalculadoraFrete calculadoraFrete = new CalculadoraFrete();

        double frete1 = calculadoraFrete.calcular(22, false);
        double frete2 = calculadoraFrete.calcular(219, false);
        double frete3 = calculadoraFrete.calcular(57, true);
    }
}