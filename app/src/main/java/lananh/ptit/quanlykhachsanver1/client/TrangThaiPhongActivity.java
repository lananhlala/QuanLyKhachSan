package lananh.ptit.quanlykhachsanver1.client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import lananh.ptit.quanlykhachsanver1.Database;
import lananh.ptit.quanlykhachsanver1.R;
import lananh.ptit.quanlykhachsanver1.RentHistory;
import lananh.ptit.quanlykhachsanver1.RentHistoryAdapter;
import lananh.ptit.quanlykhachsanver1.Room;

public class TrangThaiPhongActivity extends AppCompatActivity {
    private TextView tvDetail, tvSoP, tvLoaiP, tvGiaP, tvStatus;
    private Button btChoThue, btXemLS;
    private ListView lvLSthue;
    private Database database;
    ArrayList<RentHistory> listRent;
    RentHistoryAdapter rentHistoryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_thai_phong);
        tvDetail = findViewById(R.id.tvDetail);
        tvSoP = findViewById(R.id.tvSoP);
        tvLoaiP = findViewById(R.id.tvLoaiP);
        tvGiaP = findViewById(R.id.tvGiaP);
        tvStatus = findViewById(R.id.tvStatus);
        btChoThue = findViewById(R.id.btChoThue);
        btXemLS = findViewById(R.id.btXemLS);
        lvLSthue = findViewById(R.id.lvLSthue);
        final String soP = getIntent().getStringExtra("soP");
        database = new Database(this, "qlks", null, 1);
        final Room r = database.getRoomByNumber(Integer.parseInt(soP));
        if(r==null){
            Toast.makeText(TrangThaiPhongActivity.this,"NULL",Toast.LENGTH_SHORT).show();
        }
        if(r!=null){
            tvSoP.setText("Số phòng: "+soP);
            tvLoaiP.setText(r.getLoaiP());
            tvGiaP.setText("Giá phòng: "+ r.getGiaP() + " VND/h");
            tvStatus.setText(r.getTrangthaiP());
            if(r.getTrangthaiP().equals("Trạng thái: Trống")){
                btChoThue.setVisibility(View.VISIBLE);
                btChoThue.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TrangThaiPhongActivity.this, ThuePhongActivity.class);
                        intent.putExtra("soP",soP);
                        intent.putExtra("giaP",Integer.toString(r.getGiaP()));
                        startActivity(intent);
                    }
                });
            }
            else if(r.getTrangthaiP().equals("Trạng thái: Bận")){
                btChoThue.setVisibility(View.VISIBLE);
                btChoThue.setText("Trả phòng");
                btChoThue.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TrangThaiPhongActivity.this, TraPhongActivity.class);
                        intent.putExtra("soP",soP);
                        intent.putExtra("giaP",Integer.toString(r.getGiaP()));
                        startActivity(intent);
                    }
                });
            }
            btXemLS.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lvLSthue.setVisibility(View.VISIBLE);
                    listRent = new ArrayList<>();
                    Cursor c = database.getData("SELECT * FROM lichsuthue WHERE soP = " + soP + " ORDER BY id DESC");
                    while (c.moveToNext()){
                        RentHistory r = new RentHistory();
                        r.setSoP(c.getInt(1));
                        r.setGiaP(c.getInt(2));
                        r.setGioVao(c.getString(3));
                        r.setGioRa(c.getString(4));
                        r.setThanhTien(c.getInt(5));
                        listRent.add(r);
                    }
                    rentHistoryAdapter = new RentHistoryAdapter(TrangThaiPhongActivity.this,R.layout.a_history,listRent);
                    lvLSthue.setAdapter(rentHistoryAdapter);
                }
            });
        }
    }
}