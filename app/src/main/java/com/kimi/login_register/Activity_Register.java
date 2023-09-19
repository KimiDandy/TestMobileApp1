package com.kimi.login_register;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Activity_Register extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText tanggal;
    DatePickerDialog datePickerDialog;
    SimpleDateFormat dateFormatter;

    private EditText rgusername, rgpassword;
    private Button register;

    private TextView txlogin;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        rgusername = findViewById(R.id.rgusername);
        rgpassword = findViewById(R.id.rgpassword);
        register = findViewById(R.id.register);
        txlogin = findViewById(R.id.txlogin);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.setUsername(rgusername.getText().toString());
                MainActivity.setPassword(rgpassword.getText().toString());
                Intent login = new Intent(Activity_Register.this, MainActivity.class);
                startActivity(login);
                Toast.makeText(Activity_Register.this, "Login berhasil", Toast.LENGTH_SHORT).show();

            }
        });

        txlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(Activity_Register.this, MainActivity.class);
                startActivity(login);
            }
        });


        Spinner spinner = findViewById(R.id.gender);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        tanggal = findViewById(R.id.txTanggal);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });

    }

    private void showDateDialog() {
        Calendar calender = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, month, dayOfMonth);
                tanggal.setText(dateFormatter.format(newDate.getTime()));
            }
        }, calender.get(Calendar.YEAR), calender.get(Calendar.MONTH), calender.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        String text = parent.getItemAtPosition(position).toString();
//        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}