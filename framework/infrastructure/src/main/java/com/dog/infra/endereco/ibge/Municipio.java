package com.dog.infra.endereco.ibge;

public interface Municipio extends Comparable<Municipio> {
    int codigoIbge();

    String nome();

    default Uf uf() {
        return switch (codigoIbge() / 100_000) {
            case 11 -> Uf.preValidada("RO");
            case 12 -> Uf.preValidada("AC");
            case 13 -> Uf.preValidada("AM");
            case 14 -> Uf.preValidada("RR");
            case 15 -> Uf.preValidada("PA");
            case 16 -> Uf.preValidada("AP");
            case 17 -> Uf.preValidada("TO");
            case 21 -> Uf.preValidada("MA");
            case 22 -> Uf.preValidada("PI");
            case 23 -> Uf.preValidada("CE");
            case 24 -> Uf.preValidada("RN");
            case 25 -> Uf.preValidada("PB");
            case 26 -> Uf.preValidada("PE");
            case 27 -> Uf.preValidada("AL");
            case 28 -> Uf.preValidada("SE");
            case 29 -> Uf.preValidada("BA");
            case 31 -> Uf.preValidada("MG");
            case 32 -> Uf.preValidada("ES");
            case 33 -> Uf.preValidada("RJ");
            case 35 -> Uf.preValidada("SP");
            case 41 -> Uf.preValidada("PR");
            case 42 -> Uf.preValidada("SC");
            case 43 -> Uf.preValidada("RS");
            case 50 -> Uf.preValidada("MS");
            case 51 -> Uf.preValidada("MT");
            case 52 -> Uf.preValidada("GO");
            case 53 -> Uf.preValidada("DF");
            default -> throw new IllegalStateException();
        };
    }

    default boolean capital() {
        return codigoIbge() == uf().codigoIbgeCapital();
    }

    @Override
    default int compareTo(Municipio o) {
        int result = uf().sigla().compareTo(o.uf().sigla());
        if (result == 0) {
            result = Integer.compare(codigoIbge(), o.codigoIbge());
        }
        return result;
    }
}
