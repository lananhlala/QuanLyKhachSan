package lananh.ptit.quanlykhachsanver1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import lananh.ptit.quanlykhachsanver1.admin.AdminHomeActivity;
import lananh.ptit.quanlykhachsanver1.client.ClientHomeActivity;

public class MainActivity extends AppCompatActivity {
    private TextView tvLogin;
    private EditText etUser, etPass;
    private Button btLogin, btNoLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLogin = findViewById(R.id.tvLogin);
        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);
        btLogin = findViewById(R.id.btLogin);
        btNoLogin = findViewById(R.id.btNoLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etUser.getText().toString();
                String pass = etPass.getText().toString();
                if(user.equals("admin") && pass.equals("admin123")){
                    Intent intent = new Intent(MainActivity.this, AdminHomeActivity.class);
                    startActivity(intent);
                }
            }
        });
        btNoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ClientHomeActivity.class);
                startActivity(intent);
            }
        });
    }

}