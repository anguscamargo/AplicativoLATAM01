package com.example.latam.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.latam.daos.UserDAO;
import com.example.latam.models.User;
import com.example.pets.R;

public class LoginActivity extends AppCompatActivity {
    private EditText editLogin, editPassword;
    private User user;
    private UserDAO userDAO = new UserDAO(this);
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        editLogin = findViewById(R.id.editLogin);
        editPassword = findViewById(R.id.editPassword);
    }

    public void Check() {
//        TODO sistema de consulta de um user que retorna um objeto user
//         será usado para a validação de acesso
        user = userDAO.findByCPF(Long.parseLong(editLogin.getText().toString()));

        if (editLogin.getText().toString().equals("admin") && editPassword.getText().toString().equals("1234")) {
            Toast.makeText(this, "Success Login", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainMenuActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(this, "Failed Login", Toast.LENGTH_SHORT).show();
        }
    }

    public void back(View view) {
        startActivity(new Intent(this, StartActivity.class));
    }
}
