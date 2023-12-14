package com.dog.infra.endereco.ibge.internal;


import com.dog.infra.endereco.ibge.Distrito;

public abstract class DistritoObject implements Distrito {

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Distrito that) {
            return codigoIbge() == that.codigoIbge();
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return Integer.hashCode(codigoIbge());
    }

    @Override
    public String toString() {
        return String.format("(%d) %s (%s)", codigoIbge(), nome(), municipio());
    }
}
