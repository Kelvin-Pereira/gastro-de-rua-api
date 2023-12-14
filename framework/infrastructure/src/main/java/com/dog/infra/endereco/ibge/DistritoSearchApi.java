package com.dog.infra.endereco.ibge;

import com.dog.arquitetura.lang.Strings;

import java.util.Collection;
import java.util.Optional;

public interface DistritoSearchApi {

    Collection<Distrito> todos(int municipio);

    Optional<Distrito> comCodigo(int codigoIbge);

    default Optional<Distrito> comNome(String distrito, int municipio) {
        Collection<Distrito> todos = todos(municipio);
        if (todos.isEmpty()) return Optional.empty();
        String input = Strings.normalize(distrito);
        return todos.stream()
                .filter(d -> Strings.normalize(d.nome()).equals(input))
                .findAny();
    }

    default boolean existe(String distrito, int municipio) {
        return comNome(distrito, municipio).isPresent();
    }

}
