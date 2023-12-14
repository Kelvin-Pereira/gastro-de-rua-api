package com.dog.infra.endereco.correios;

import com.dog.arquitetura.brasil.Cep;
import com.dog.infra.endereco.ibge.Municipio;
import com.dog.infra.endereco.ibge.Uf;

public interface Logradouro {

    Cep cep();

    <T> T accept(LogradouroVisitor<T> visitor);

    interface FaixaDeUf extends Logradouro {
        Uf uf();

        @Override
        default <T> T accept(LogradouroVisitor<T> visitor) {
            return visitor.visit(this);
        }
    }

    interface FaixaDeMunicipio extends Logradouro {
        Municipio municipio();

        @Override
        default <T> T accept(LogradouroVisitor<T> visitor) {
            return visitor.visit(this);
        }
    }

    interface FaixaDeBairro extends FaixaDeMunicipio {
        String bairro();

        @Override
        default <T> T accept(LogradouroVisitor<T> visitor) {
            return visitor.visit(this);
        }
    }

    interface Completo extends FaixaDeBairro {
        String logradouro();

        @Override
        default <T> T accept(LogradouroVisitor<T> visitor) {
            return visitor.visit(this);
        }
    }

}
