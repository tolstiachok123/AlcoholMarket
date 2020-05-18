package com.am.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private String name;
    private String surname;
    private String mail;
    private String phone;
    private String password;

}
