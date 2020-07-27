package com.letuku.service;

import lombok.Data;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
@Data
public class MySession implements Serializable {

    private String email;
}
