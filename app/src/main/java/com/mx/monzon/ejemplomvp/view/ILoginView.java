package com.mx.monzon.ejemplomvp.view;

public interface ILoginView {

    void showSpinner(int show);
    void showResultLogin(Boolean result, int code);
    void showMessage(String message);
    void clear();
}
