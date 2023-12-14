package com.dog.infra.endereco.ibge;

public interface Distrito extends Comparable<Distrito> {

    int codigoIbge();

    String nome();

    Municipio municipio();

    @Override
    default int compareTo(Distrito d) {
        int result = municipio().compareTo(d.municipio());
        if (result == 0) {
            result = Integer.compare(codigoIbge(), d.codigoIbge());
        }
        return result;
    }

}
