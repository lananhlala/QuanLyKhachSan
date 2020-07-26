package lananh.ptit.quanlykhachsanver1.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import lananh.ptit.quanlykhachsanver1.R;

public class AdminHomeActivity extends AppCompatActivity {
    private Button btQLtang, btQLphong, btThemP, btThongKe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        btQLtang = findViewById(R.id.btQLtang);
        btQLphong = findViewById(R.id.btQLphong);
        btThemP = findViewById(R.id.btThemP);
        btThongKe = findViewById(R.id.btThongKe);
        btThemP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHomeActivity.this, ThemPhongActivity.class);
                startActivity(intent);
            }
        });
        btQLphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHomeActivity.this, QuanLyPhongActivity.class);
                startActivity(intent);
            }
        });
        btQLtang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHomeActivity.this, QuanLyTangActivity.class);
                startActivity(intent);
            }
        });
    }
}