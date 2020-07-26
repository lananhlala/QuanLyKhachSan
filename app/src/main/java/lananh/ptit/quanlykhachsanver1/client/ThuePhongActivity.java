package lananh.ptit.quanlykhachsanver1.client;

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

public class ThuePhongActivity extends AppCompatActivity {
    private TextView tvThue, tvP, tvGiaP;
    private EditText etGioVao;
    private Button btThue;
    private Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thue_phong);
        database = new Database(this, "qlks",null, 1);
        tvThue = findViewById(R.id.tvThue);
        tvP = findViewById(R.id.tvP);
        tvGiaP = findViewById(R.id.tvGiaP);
        etGioVao = findViewById(R.id.etGioVao);
        btThue = findViewById(R.id.btSave);
        final int soP = Integer.parseInt(getIntent().getStringExtra("soP"));
        final int giaP = Integer.parseInt(getIntent().getStringExtra("giaP"));
        tvP.setText("Số Phòng " + Integer.toString(soP));
        tvGiaP.setText("Giá phòng " + Float.toString(giaP)+" VNĐ/h");
        btThue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gioVao = etGioVao.getText().toString();
                // không kịp check validate
                database.queryData(String.format("INSERT INTO lichsuthue VALUES (null, %s, %s, '%s', null, null)", soP, giaP, gioVao));
                database.queryData("UPDATE room SET trangthaiP = 'Trạng thái: Bận' WHERE soP = " + soP);
                Toast.makeText(ThuePhongActivity.this,"Cho Thuê Thành Công",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ThuePhongActivity.this, ClientHomeActivity.class);
                startActivity(intent);
            }
        });
    }
}