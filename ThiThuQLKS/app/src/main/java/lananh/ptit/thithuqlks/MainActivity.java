package lananh.ptit.thithuqlks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import lananh.ptit.thithuqlks.admin.AdminHomeActivity;
import lananh.ptit.thithuqlks.client.ClientHomeActivity;

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
        btNoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ClientHomeActivity.class);
                startActivity(intent);
            }
        });
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etUser.getText().toString().equals("admin") && etPass.getText().toString().equals("admin123")){
                    Intent intent = new Intent(MainActivity.this, AdminHomeActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}