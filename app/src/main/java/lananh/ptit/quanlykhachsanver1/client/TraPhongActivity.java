package lananh.ptit.quanlykhachsanver1.client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import lananh.ptit.quanlykhachsanver1.Database;
import lananh.ptit.quanlykhachsanver1.R;
import lananh.ptit.quanlykhachsanver1.RentHistory;
import lananh.ptit.quanlykhachsanver1.Room;

public class TraPhongActivity extends AppCompatActivity {
    private TextView tvTra, tvP, tvGiaP, tvGioVao;
    private EditText etGioRa;
    private Button btTra;
    private Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tra_phong);
        database = new Database(this, "qlks",null, 1);
        tvTra = findViewById(R.id.tvTra);
        tvP = findViewById(R.id.tvP);
        tvGiaP = findViewById(R.id.tvGiaP);
        tvGioVao = findViewById(R.id.tvGioVao);
        etGioRa = findViewById(R.id.etGioRa); // copy layout nen loan
        btTra = findViewById(R.id.btTra);
        final int soP = Integer.parseInt(getIntent().getStringExtra("soP"));
        final int giaP = Integer.parseInt(getIntent().getStringExtra("giaP"));
        tvP.setText("Phòng " + Integer.toString(soP));
        tvGiaP.setText("Giá phòng " + Float.toString(giaP) + " VNĐ/h");
        RentHistory rh = database.getRoomBusy(soP);
        if (rh!=null){
            final String gioVao = rh.getGioVao();
            tvGioVao.setText("Giờ vào " + gioVao);
            btTra.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String gioRa = etGioRa.getText().toString();
                    Cursor c1 = database.getData(String.format("SELECT CAST((julianday('%s') - julianday('%s'))*24 AS real)  AS TimeOffInHours FROM lichsuthue",gioRa,gioVao));
                    if (c1.moveToNext()){
                        int time = (int) c1.getFloat(0);
//                        Toast.makeText(CheckoutRoomActivity.this,time,Toast.LENGTH_SHORT).show();
                        int Total = time * giaP;
                        database.queryData("UPDATE lichsuthue SET gioRa = '"+gioRa+"', thanhTien ="+ Total+" WHERE soP = "+soP+" AND gioRa IS null");
                        database.queryData("UPDATE room SET trangthaiP = 'Trạng thái: Trống' WHERE soP = "+soP);
                        Toast.makeText(TraPhongActivity.this,"Tiền phòng của em là "+Total+" VNĐ",Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(TraPhongActivity.this,"Trả phòng thành công",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(TraPhongActivity.this, ClientHomeActivity.class);
                    startActivity(intent);
                }
            });
        }
        else {
            Toast.makeText(TraPhongActivity.this,"ERROR",Toast.LENGTH_SHORT).show();
        }
    }
}