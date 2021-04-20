package com.mx.monzon.ejemplomvp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mx.monzon.ejemplomvp.R;
import com.mx.monzon.ejemplomvp.presenter.ILoginPresenter;
import com.mx.monzon.ejemplomvp.presenter.LoginPresenterImpl;

public class LoginActivity extends AppCompatActivity implements ILoginView{

    private EditText editName, editPassword;
    private Button btnClear, btnAccept;
    private ProgressBar progressBar;
    private ILoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editTextTextPersonName);
        editPassword = findViewById(R.id.editTextTextPassword);
        btnClear = findViewById(R.id.btn_clean);
        btnAccept = findViewById(R.id.btn_accept);
        progressBar = findViewById(R.id.progress_barr);

        presenter = new LoginPresenterImpl(this);
        presenter.setProgressBarVisibility(View.INVISIBLE);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clear();
            }
        });
        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setProgressBarVisibility(View.VISIBLE);
                btnAccept.setEnabled(false);
                presenter.Login(editName.getText().toString(), editPassword.getText().toString());
            }
        });
    }

    @Override
    public void showSpinner(int show) {
        progressBar.setVisibility(show);
    }

    @Override
    public void showResultLogin(Boolean result, int code) {
        presenter.setProgressBarVisibility(View.INVISIBLE);
        btnAccept.setEnabled(true);
        if(result) {
            Intent intent = new Intent(this, PrincipalActivity.class);
            startActivity(intent);
        }
        else
            showMessage("Te hace falta completar los datos");
    }

    @Override
    public void clear() {
        editPassword.setText("");
        editName.setText("");
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}