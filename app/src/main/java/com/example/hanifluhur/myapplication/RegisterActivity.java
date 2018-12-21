package com.example.hanifluhur.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hanifluhur.myapplication.R;

/**
 * Created by amardeep on 10/26/2017.
 */

public class RegisterActivity extends AppCompatActivity {

    //Mendeklarasikan EditTexts
    EditText editTextUserName;
    EditText editTextEmail;
    EditText editTextPassword;

    //Mendeklarasikan TextInputLayout
    TextInputLayout textInputLayoutUserName;
    TextInputLayout textInputLayoutEmail;
    TextInputLayout textInputLayoutPassword;

    //Mendeklarasikan Button
    Button buttonRegister;

    //Mendeklarasikan SqliteHelper
    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sqliteHelper = new SqliteHelper(this);
        initTextViewLogin();
        initViews();
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    String UserName = editTextUserName.getText().toString();
                    String Email = editTextEmail.getText().toString();
                    String Password = editTextPassword.getText().toString();

                        // Periksa di basis data apakah ada pengguna yang terkait dengan email ini
                    if (!sqliteHelper.isEmailExists(Email)) {

                        // Email tidak ada sekarang tambahkan pengguna baru ke database
                        sqliteHelper.addUser(new User(null, UserName, Email, Password));
                        Snackbar.make(buttonRegister, "Pengguna berhasil dibuat! Silahkan masuk ", Snackbar.LENGTH_LONG).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                finish();
                            }
                        }, Snackbar.LENGTH_LONG);
                    }else {


                        // Email ada dengan masukan email disediakan sehingga menunjukkan kesalahan pengguna sudah ada
                        Snackbar.make(buttonRegister, "Pengguna sudah ada dengan email yang sama ", Snackbar.LENGTH_LONG).show();
                    }


                }
            }
        });
    }

    // metode ini digunakan untuk mengatur acara klik TextView Login
    private void initTextViewLogin() {
        TextView textViewLogin = (TextView) findViewById(R.id.textViewLogin);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    // metode ini digunakan untuk menghubungkan tampilan XML ke Objeknya
    private void initViews() {
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputLayoutUserName = (TextInputLayout) findViewById(R.id.textInputLayoutUserName);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);

    }


    // Metode ini digunakan untuk memvalidasi masukan yang diberikan oleh pengguna
    public boolean validate() {
        boolean valid = false;

        // Dapatkan nilai dari bidang EditText
        String UserName = editTextUserName.getText().toString();
        String Email = editTextEmail.getText().toString();
        String Password = editTextPassword.getText().toString();


        // Penanganan validasi untuk bidang UserName
        if (UserName.isEmpty()) {
            valid = false;
            textInputLayoutUserName.setError("Masukkan username yang valid!");
        } else {
            if (UserName.length() > 5) {
                valid = true;
                textInputLayoutUserName.setError(null);
            } else {
                valid = false;
                textInputLayoutUserName.setError("Username terlalu pendek!");
            }
        }

        // Penanganan validasi untuk bidang Email
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid = false;
            textInputLayoutEmail.setError("Masukkan email yang valid!");
        } else {
            valid = true;
            textInputLayoutEmail.setError(null);
        }

        //// Penanganan validasi untuk bidang Password
        if (Password.isEmpty()) {
            valid = false;
            textInputLayoutPassword.setError("Masukkan password yang valid!");
        } else {
            if (Password.length() > 5) {
                valid = true;
                textInputLayoutPassword.setError(null);
            } else {
                valid = false;
                textInputLayoutPassword.setError("Password terlalu pendek!");
            }
        }


        return valid;
    }
}
