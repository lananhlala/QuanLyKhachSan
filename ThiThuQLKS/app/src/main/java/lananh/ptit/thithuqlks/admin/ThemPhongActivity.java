package lananh.ptit.thithuqlks.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import lananh.ptit.thithuqlks.Database;
import lananh.ptit.thithuqlks.R;
import lananh.ptit.thithuqlks.Room;

public class ThemPhongActivity extends AppCompatActivity {
    private EditText etSoP, etTang, etLoaiP, etGiaP;
    private Button btAdd;
    private Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_phong);
        etSoP = findViewById(R.id.etSoP);
        etTang = findViewById(R.id.etTang);
        etLoaiP = findViewById(R.id.etLoai);
        etGiaP = findViewById(R.id.etGiaP);
        btAdd = findViewById(R.id.btThemP);
        database = new Database(this, "qlks",null, 1);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soP = Integer.parseInt(etSoP.getText().toString());
                int tang = Integer.parseInt(etTang.getText().toString());
                String loaiP = etLoaiP.getText().toString();
                int giaP = Integer.parseInt(etGiaP.getText().toString());
                Room r = new Room(soP, tang, loaiP, giaP);
                database.insertRoom(r);
                Toast.makeText(ThemPhongActivity.this, "Them thanh cong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}