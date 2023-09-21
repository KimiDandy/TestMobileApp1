package com.kimi.login_register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.kimi.login_register.R;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kimi.login_register.fragment.FragmentLogin;
import com.kimi.login_register.fragment.FragmentMahasiswa;
import com.kimi.login_register.fragment.FragmentNegara;

public class Activity_mainDashboard extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FragmentNegara fragmentNegara = new FragmentNegara();
    FragmentMahasiswa fragmentMahasiswa = new FragmentMahasiswa();
    FragmentLogin fragmentLogin = new FragmentLogin();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);

        getSupportFragmentManager().beginTransaction().add(R.id.baseFragment, fragmentNegara).commit();
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                int itemId = item.getItemId();
                if (itemId == R.id.action_fragment_negara) {
                    selectedFragment = fragmentNegara;
                } else if (itemId == R.id.action_fragment_mahasiswa) {
                    selectedFragment = fragmentMahasiswa;
                } else if (itemId == R.id.action_fragment_login) {
                    selectedFragment = fragmentLogin;
                }

                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.baseFragment, selectedFragment).commit();
                }
                return true;
            }
        });


        // Set the icon size for each menu item
        setIconSize(R.id.action_fragment_negara, 48); // Adjust the size as needed
        setIconSize(R.id.action_fragment_mahasiswa, 48);
        setIconSize(R.id.action_fragment_login, 48);
    }

    // Function to set the icon size for a menu item
    private void setIconSize(int menuItemId, int iconSize) {
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.findItem(menuItemId);
        if (menuItem != null) {
            Drawable icon = menuItem.getIcon();
            if (icon != null) {
                icon.setBounds(0, 0, iconSize, iconSize);
                menuItem.setIcon(icon);
            }
        }
    }

}
