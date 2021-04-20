package com.mx.monzon.ejemplomvp.model.to;

import com.mx.monzon.ejemplomvp.model.IUser;

public class User implements IUser {
    String nombre;
    String password;

    public User() {
    }

    public User(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int checkUserValidity(String name, String password) {
        if (name==null||password==null||name.equals("")||password.equals("")){
            return -1;
        }
        return 0;
    }
}
