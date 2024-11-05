package com.example.cw;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import java.util.List;

public class Register extends AppCompatActivity {

    private Spinner roleSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button register = findViewById(R.id.btnRegister);
        Button login = findViewById(R.id.btntextLogin);
        roleSpinner = findViewById(R.id.spinner);

        populateRoleSpinner();


        register.setOnClickListener(v -> {

            String selectedProgram = roleSpinner.getSelectedItem().toString();

            if (selectedProgram.equals("Select the role")) {
                // Show an error or prompt to select a valid role
                Toast.makeText(Register.this, "Please select a valid role", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(Register.this, Home_Passenger.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(v -> {
            Intent intent = new Intent(Register.this, MainActivity.class);
            startActivity(intent);
        });

    }

    private void populateRoleSpinner() {
        RoleList programList = new RoleList();
        List<String> programs = programList.getRoles();

        programs.add(0, "Select the role");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, programs);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roleSpinner.setAdapter(adapter);

        roleSpinner.setSelection(0);

    }
}
