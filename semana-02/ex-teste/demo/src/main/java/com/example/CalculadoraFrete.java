package com.example;

public class CalculadoraFrete {

    public double calcular(double valorCompra, boolean clientePremium) {
        if(valorCompra >= 200) {
            return 0.0;
        }
        if(clientePremium) {
            return 0.0;
        }
        return 20;
    }

}