package com.mx.monzon.ejemplomvp.presenter;

public interface ILoginPresenter {

    void clear();
    void Login(String nombre, String contra);
    void setProgressBarVisibility(int visibility);
}
