package com.dog.usecase.utils.functions;

import java.io.IOException;

public interface BiConsumerIOException<T, U> {

    void accept(T t, U u) throws IOException;

}
