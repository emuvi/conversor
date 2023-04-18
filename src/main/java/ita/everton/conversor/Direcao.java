package ita.everton.conversor;

import java.util.Objects;

public enum Direcao {
    CelsiusParaFahrenheit,
    FahrenheitParaCelsius;
    
    public static Direcao from(String string) {
        for (Direcao value : Direcao.values()) {
            if (Objects.equals(value.toString(), string)) {
                return value;
            }
        }
        return null;
    }
    
}
