package lananh.ptit.thithuqlks.client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import lananh.ptit.thithuqlks.Database;
import lananh.ptit.thithuqlks.R;
import lananh.ptit.thithuqlks.Room;

public class ChiTietPhongActivity extends AppCompatActivity {
    private TextView tvSoP, tvGiaP, tvTrangthai, tvLoaiP;
    private Button btEvent;
    private Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_phong);
        tvSoP = findViewById(R.id.tvSoP);
        tvGiaP = findViewById(R.id.tvGiaP);
        tvLoaiP = findViewById(R.id.tvLoaiP);
        tvTrangthai = findViewById(R.id.tvTrangthai);
        btEvent = findViewById(R.id.btEvent);
        database = new Database(this, "qlks", null, 1);
        final int soP = Integer.parseInt(getIntent().getStringExtra("soP"));
        final Room r = database.getRoom(soP);
        tvSoP.setText(Integer.toString(r.getSoP()));
        tvGiaP.setText(Integer.toString(r.getGiaP()));
        tvLoaiP.setText(r.getLoaiP());
        tvTrangthai.setText(r.getTrangthai());
        if (r.getTrangthai().equals("Trang thai: Trong")){
            btEvent.setText("Cho thuê phòng");
            btEvent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    database.queryData("UPDATE  room SET trangthai = 'Trang thai: Ban' WHERE soP = "+soP );
                    Toast.makeText(ChiTietPhongActivity.this,"Cho thue thanh cong", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ChiTietPhongActivity.this, ClientHomeActivity.class);
                    startActivity(intent);
                }
            });
        }
        else {
            btEvent.setText("Trả phòng");
            btEvent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    database.queryData("UPDATE  room SET trangthai = 'Trang thai: Trong' WHERE soP = "+soP );
                    Toast.makeText(ChiTietPhongActivity.this,"Tra phong thanh cong", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ChiTietPhongActivity.this, ClientHomeActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}