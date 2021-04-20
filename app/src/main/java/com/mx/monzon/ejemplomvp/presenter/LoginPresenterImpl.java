package com.mx.monzon.ejemplomvp.presenter;

import android.os.Handler;
import android.os.Looper;

import com.mx.monzon.ejemplomvp.model.IUser;
import com.mx.monzon.ejemplomvp.model.to.User;
import com.mx.monzon.ejemplomvp.view.ILoginView;

public class LoginPresenterImpl implements ILoginPresenter{
    ILoginView view;
    IUser user;
    Handler handler;

    public LoginPresenterImpl(ILoginView view) {
        this.view = view;
        user = new User();
        handler = new Handler(Looper.getMainLooper());
    }
/*
    public LoginPresenterImpl() {
        //Este es un constructor vacio.. para instanciar sin envío de datos
    }*/

    @Override
    public void clear() {
        view.clear();
    }

    @Override
    public void Login(String name, String password) {
        boolean isLoginSucces = true;
        final int code =  user.checkUserValidity(name, password);
        if(code!=0)
            isLoginSucces = false;
        final boolean result = isLoginSucces;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                view.showResultLogin(result, code);
            }
        },500);
    }

    @Override
    public void setProgressBarVisibility(int visibility) {
        view.showSpinner(visibility);
    }
}
