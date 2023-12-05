package com.dog.arquitetura;

public final class HttpException extends RuntimeException {
    public final int statusCode;

    /**
     * @param statusCode 4xx ou 5xx
     */
    public HttpException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public static HttpException autenticacaoRequerida() {
        return new HttpException("AUTENTICAO_REQUERIDA", 401);
    }

    public static HttpException privilegiosInsuficientes() {
        return new HttpException("PRIVILEGIOS_INSUFICIENTES", 403);
    }

    public static HttpException naoPermitido() {
        return badRequest("NAO_PERMITIDO");
    }

    public static HttpException badRequest(String message) {
        return new HttpException(message, 400);
    }

    public static HttpException bug(String message) {
        return new HttpException(message, 500);
    }
}
