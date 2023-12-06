package com.dog.core.correios.strict;


import com.dog.arquitetura.lang.annotation.Nullable;
import com.dog.core.correios.*;
import com.dog.core.ibge.DistritoSearchApi;
import com.dog.core.ibge.Municipio;
import com.dog.core.ibge.Distrito;
import com.dog.core.ibge.MunicipioSearchApi;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.function.Function;


@RequiredArgsConstructor
public final class EnderecoApiStrict implements EnderecoApi {
    private final LogradouroSearchApi logradouroSearchApi;
    private final MunicipioSearchApi municipioSearchApi;
    private final DistritoSearchApi distritoSearchApi;

    @Override
    public Logradouro logradouroAproximado(Cep cep) {
        return logradouroSearchApi.logradouroAproximado(cep);
    }

    @Override
    public Optional<Logradouro> logradouroExato(Cep cep) {
        return logradouroSearchApi.logradouroExato(cep);
    }

    @Override
    public Optional<Endereco> enderecoConfiavel(Cep cep,
                                                String logradouro,
                                                String numero,
                                                String bairro,
                                                @Nullable String distrito,
                                                @Nullable String complemento) {
        return logradouroSearchApi.logradouroExato(cep)
                .map(logr -> logr.accept(new EnderecoConfiavelVisitor(distritoValido(distrito),
                        logradouro,
                        numero,
                        bairro,
                        complemento)));
    }

    @Override
    public Endereco enderecoSuspeito(Cep cep,
                                     String logradouro,
                                     String numero,
                                     String bairro,
                                     int municipio,
                                     @Nullable String distrito,
                                     @Nullable String complemento) {
        return enderecoConfiavel(cep, logradouro, numero, bairro, distrito, complemento)
                .orElseGet(() -> new EnderecoStrict(cep,
                        logradouro,
                        bairro,
                        numero,
                        complemento,
                        municipioSearchApi.comCodigo(municipio).orElseThrow(),
                        distrito,
                        true));
    }

    private Function<Municipio, String> distritoValido(@Nullable String distritoSuspeito) {
        if (distritoSuspeito == null) return municipio -> null;
        return municipio -> distritoSearchApi.comNome(distritoSuspeito, municipio.codigoIbge())
                .map(Distrito::nome)
                .orElse

                        (null);
    }

}
