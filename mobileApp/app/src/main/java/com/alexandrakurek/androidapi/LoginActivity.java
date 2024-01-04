package com.alexandrakurek.androidapi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alexandrakurek.androidapi.services.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.Username);
        passwordEditText = findViewById(R.id.Password);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogin();
            }
        });
    }
    private void performLogin(){
        Log.d("LoginActivity", "Próba logowania");
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://localhost:8080/login")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserService apiInterface = retrofit.create(UserService.class);

        Call<LoginResponse> call = apiInterface.loginUser(new LoginRequest(username,password));
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful() && response.body() != null){
                    LoginResponse loginResponse = response.body();

                    //Sprawdzenie czy odpowiedź zawiera token.
                    if(loginResponse.getToken() != null && !loginResponse.getToken().isEmpty()){
                        //zapisanie tokena do SharedPreference lub przekazanie go do innej aktywności
                        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("token", loginResponse.getToken());
                        editor.apply();
                        //Przejście do innej aktywności po pomyślnym logowaniu
                        Intent intent = new Intent(LoginActivity.this, NextActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // Obsługa sytuacji, gdy logowanie nie powiodło się (brak tokenu, błędne dane)
                        Toast.makeText(LoginActivity.this,"Logowanie nieudane", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    //Odpowiedź nie jest pomyślna
                    Toast.makeText(LoginActivity.this, "Błąd logowania", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Błąd połączenia: " + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
