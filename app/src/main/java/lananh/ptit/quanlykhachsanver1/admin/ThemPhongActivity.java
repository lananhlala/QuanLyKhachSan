package lananh.ptit.quanlykhachsanver1.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import lananh.ptit.quanlykhachsanver1.Database;
import lananh.ptit.quanlykhachsanver1.R;
import lananh.ptit.quanlykhachsanver1.Room;

public class ThemPhongActivity extends AppCompatActivity {
    private TextView tvThemP;
    private EditText etSoP, etTang, etLoaiP, etGiaP;
    private Button btAdd;
    private Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_phong);
        tvThemP = findViewById(R.id.tvThemP);
        etSoP = findViewById(R.id.etSoP);
        etTang = findViewById(R.id.etTang);
        etLoaiP = findViewById(R.id.etLoaiP);
        etGiaP = findViewById(R.id.etGiaP);
        btAdd = findViewById(R.id.btAdd);
        database = new Database(this,"qlks", null, 1);
        database.init(this);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soP = Integer.parseInt(etSoP.getText().toString());
                int tangP = Integer.parseInt(etTang.getText().toString());
                String loaiP = etLoaiP.getText().toString();
                int giaP = Integer.parseInt(etGiaP.getText().toString());
                Room r = new Room(soP,loaiP,giaP,tangP);
                database.insertRoom(r);
                Toast.makeText(ThemPhongActivity.this, "Thêm thành công",Toast.LENGTH_SHORT).show();
                etSoP.setText("");
                etTang.setText("");
                etGiaP.setText("");
                etLoaiP.setText("");
            }
        });
    }
}