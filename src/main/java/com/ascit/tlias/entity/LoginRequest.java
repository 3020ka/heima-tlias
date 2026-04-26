package com.ascit.tlias.entity;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
