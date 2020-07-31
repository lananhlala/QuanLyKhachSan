package lananh.ptit.thithuqlks.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import lananh.ptit.thithuqlks.Database;
import lananh.ptit.thithuqlks.R;

public class AdminHomeActivity extends AppCompatActivity {
    private Button btAdd;
    private Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        btAdd = findViewById(R.id.btThemP);
        database = new Database(this, "qlks",null,1);
        database.init(this);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHomeActivity.this, ThemPhongActivity.class);
                startActivity(intent);
            }
        });
    }
}