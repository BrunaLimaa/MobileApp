package com.example.fastfashion_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fastfashion_app.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterUser extends AppCompatActivity {

    EditText editEmail;
    EditText editName;
    EditText editPassword;


    Button record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        record = findViewById(R.id.btn_record);

        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postUser();
            }
        });
    }

    private void postUser() {
        editEmail = findViewById(R.id.edit_user_email);
        editName = findViewById(R.id.edit_user_name);
        editPassword = findViewById(R.id.edit_user_password);
        String email = editEmail.getText().toString();
        String name = editName.getText().toString();
        String password = editPassword.getText().toString();


        Call<ResultsPost> call = RetrofitClient.getInstance().getMyApi().postUser(email, name, password);
        call.enqueue(new Callback<ResultsPost>() {
            @Override
            public void onResponse(Call<ResultsPost> call, Response<ResultsPost> response) {
                ResultsPost resultsPost =  response.body();
                Toast.makeText(getApplicationContext(), "Usuário cadastrado com sucesso!", Toast.LENGTH_LONG).show();
            }
            @Override
            public void onFailure(Call<ResultsPost> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Ocorreu um erro", Toast.LENGTH_LONG).show();
            }
        });
    }

}