package com.example.hanifluhur.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hanifluhur.myapplication.R;

import static android.text.Html.fromHtml;

public class LoginActivity extends AppCompatActivity {

    //Mendeklarasikan EditText
    EditText editTextEmail;
    EditText editTextPassword;

    //Memanggil SessionManagent Activity
    SessionManagement sessionManagement;

    //Declaration TextInputLayout
    TextInputLayout textInputLayoutEmail;
    TextInputLayout textInputLayoutPassword;

    //Mendeklarasikan Button
    Button buttonLogin;

    //Mendeklarasikan SqlHelper
    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sqliteHelper = new SqliteHelper(this); //Membuat fungsi baru sqlitehelper
        initCreateAccountTextView(); //Memanggil fuction init initCreateAccountTextView()
        initViews(); //Memanggil fuction init initViews()

        sessionManagement = new SessionManagement(this); ////Membuat fungsi baru sessionmanagement
        if (sessionManagement.isLoggedIn()) {
            goToActivity();
        }

        //setel event klik tombol login
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user, pass;
                user = editTextEmail.getText().toString();
                pass = editTextPassword.getText().toString();
                if (user.matches("") || user.trim().isEmpty() || pass.matches("") || pass.trim().isEmpty()){
                    Toast.makeText(LoginActivity.this, "Username dan Password tidak boleh kosong atau berisi spasi !", Toast.LENGTH_LONG).show();
                    return;
                }else {
                    sessionManagement.createLoginSession(user, pass);
                    goToActivity();
                }

                /*//Check user input is correct or not
                if (validate()) {

                    //Get values from EditText fields
                    String Email = editTextEmail.getText().toString();
                    String Password = editTextPassword.getText().toString();

                    //Authenticate user
                    User currentUser = sqliteHelper.Authenticate(new User(null, null, Email, Password));

                    //Check Authentication is successful or not
                    if (currentUser != null) {
                        Snackbar.make(buttonLogin, "Sukses Login!", Snackbar.LENGTH_LONG).show();

                        //User Logged in Successfully Launch You home screen activity
                        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();

                    } else {

                        //User Logged in Failed
                        Snackbar.make(buttonLogin, "Gagal Login , Coba Kembali", Snackbar.LENGTH_LONG).show();

                    }
                }*/
            }
        });
    }


    // metode ini digunakan untuk mengatur Buat akun TextView text dan klik event (warna maltipal)
    // untuk TextView namun tidak didukung di Xml jadi saya telah melakukannya secara terprogram)
    private void initCreateAccountTextView() {
        TextView textViewCreateAccount = (TextView) findViewById(R.id.textViewCreateAccount);
        textViewCreateAccount.setText(fromHtml("<font color='#ffffff'>Belum Punya Akun?. </font><font color='#0c0099'>Daftar Disini</font>"));
        textViewCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }


    // metode ini digunakan untuk menghubungkan tampilan XML ke Objeknya
    private void initViews() {
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);

    }

    /*//This method is for handling fromHtml method deprecation
    @SuppressWarnings("deprecation")
    public static Spanned fromHtml(String html) {
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        return result;
    }

    //This method is used to validate input given by user
    public boolean validate() {
        boolean valid = false;

        //Get values from EditText fields
        String Email = editTextEmail.getText().toString();
        String Password = editTextPassword.getText().toString();

        //Handling validation for Email field
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid = false;
            textInputLayoutEmail.setError("Masukkan email yang valid");
        } else {
            valid = true;
            textInputLayoutEmail.setError(null);
        }

        //Handling validation for Password field
        if (Password.isEmpty()) {
            valid = false;
            textInputLayoutPassword.setError("Masukkan password yang valid");
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
    }*/

    //Membuat method baru bernama gotoactivity
    private void goToActivity () {
        Intent mIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(mIntent);
    }
}