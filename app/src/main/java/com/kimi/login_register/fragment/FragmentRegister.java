package com.kimi.login_register.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.kimi.login_register.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FragmentRegister extends Fragment implements AdapterView.OnItemSelectedListener{
    EditText tanggal;
    DatePickerDialog datePickerDialog;
    SimpleDateFormat dateFormatter;

    private EditText rgusername, rgpassword;
    private Button register;

    private TextView txlogin;
    View view;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register, container, false);
        rgusername = view.findViewById(R.id.rgusername);
        rgpassword = view.findViewById(R.id.rgpassword);
        register = view.findViewById(R.id.register);
        txlogin = view.findViewById(R.id.txlogin);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentLogin.setUsername(rgusername.getText().toString());
                FragmentLogin.setPassword(rgpassword.getText().toString());
                getFragmentManager().beginTransaction().replace(R.id.baseFragment, new FragmentLogin()).commit();
                Toast.makeText(getContext(), "Login berhasil", Toast.LENGTH_SHORT).show();

            }
        });

        txlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.baseFragment, new FragmentLogin()).commit();
            }
        });


        Spinner spinner = view.findViewById(R.id.gender);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        tanggal = view.findViewById(R.id.txTanggal);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });
        return view;
    }
    private void showDateDialog() {
        Calendar calender = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, month, dayOfMonth);
                tanggal.setText(dateFormatter.format(newDate.getTime()));
            }
        }, calender.get(Calendar.YEAR), calender.get(Calendar.MONTH), calender.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }


    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }
    public void onNothingSelected(AdapterView<?> parent) {

    }
}