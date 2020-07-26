package lananh.ptit.quanlykhachsanver1.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import lananh.ptit.quanlykhachsanver1.Database;
import lananh.ptit.quanlykhachsanver1.R;
import lananh.ptit.quanlykhachsanver1.Room;

public class ChiTietPhongActivity extends AppCompatActivity {
    private TextView tvSoP;
    private EditText etLoaiP, etGiaP;
    private Button btUpdate, btDelete;
    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_phong);
        tvSoP = findViewById(R.id.tvSoP);
        etLoaiP = findViewById(R.id.etLoaiP);
        etGiaP = findViewById(R.id.etGiaP);
        btUpdate = findViewById(R.id.btUpdate);
        btDelete = findViewById(R.id.btDelete);
        database = new Database(ChiTietPhongActivity.this, "qlks", null, 1);
        final int soP = Integer.parseInt(getIntent().getStringExtra("soP"));
        Room r = database.getRoomByNumber(soP);
        tvSoP.setText("Phòng số "+r.getSoP());
        etLoaiP.setText(r.getLoaiP());
        etGiaP.setText(Integer.toString(r.getGiaP()));
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loaiP = etLoaiP.getText().toString();
                int giaP = Integer.parseInt(etGiaP.getText().toString());
                database.queryData(String.format("UPDATE room SET loaiP = '%s', giaP = %s WHERE soP=%s",loaiP,giaP,soP));
                Toast.makeText(ChiTietPhongActivity.this,"Cập nhât thành công",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ChiTietPhongActivity.this, QuanLyPhongActivity.class);
                startActivity(intent);
            }
        });
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.queryData(String.format("DELETE FROM room WHERE soP=%s",soP));
                Toast.makeText(ChiTietPhongActivity.this,"Xoá thành công",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ChiTietPhongActivity.this, QuanLyPhongActivity.class);
                startActivity(intent);
            }
        });
    }
}