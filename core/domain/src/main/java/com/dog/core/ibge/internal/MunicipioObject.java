package com.dog.core.ibge.internal;


import com.dog.core.ibge.Municipio;

public abstract class MunicipioObject implements Municipio {

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Municipio that) {
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
        return String.format("(%d) %s-%s", codigoIbge(), nome(), uf().sigla());
    }
}
