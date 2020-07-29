package lananh.ptit.quanlykhachsanver1.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import lananh.ptit.quanlykhachsanver1.Database;
import lananh.ptit.quanlykhachsanver1.DoanhThu;
import lananh.ptit.quanlykhachsanver1.DoanhThuAdapter;
import lananh.ptit.quanlykhachsanver1.R;

public class ThongKeActivity extends AppCompatActivity {
    private Button btThongke;
    private ListView lvDoanhthu;
    private Database database;
    private DoanhThuAdapter doanhThuAdapter;
    private ArrayList<DoanhThu> doanhThus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);
        btThongke = findViewById(R.id.btThongKe);
        lvDoanhthu = findViewById(R.id.lvThongKe);
        database = new Database(ThongKeActivity.this, "qlks",null,1);
        doanhThus = database.thongKeDoanhThu();
        doanhThuAdapter = new DoanhThuAdapter(ThongKeActivity.this, R.layout.a_thongke, doanhThus);
        btThongke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvDoanhthu.setAdapter(doanhThuAdapter);
            }
        });
    }
}