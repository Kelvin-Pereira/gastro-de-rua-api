package com.dog.usecase.type.auth;

public record AuthenticationRequest(String email,
                                    String password) { }
